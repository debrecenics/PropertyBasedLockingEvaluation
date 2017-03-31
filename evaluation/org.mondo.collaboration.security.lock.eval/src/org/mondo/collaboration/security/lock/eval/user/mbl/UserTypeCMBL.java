package org.mondo.collaboration.security.lock.eval.user.mbl;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.emf.EMFScope;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.ModelBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserTypeC;
import org.mondo.collaboration.security.query.LockCHelperMatch;
import org.mondo.collaboration.security.query.LockCHelperMatcher;

import com.google.common.collect.Sets;

import wt.Control;
import wt.Module;

public class UserTypeCMBL extends UserTypeC {

	private ModelBasedLocker locker;
	private Set<String> identifiers = Sets.newHashSet();

	public UserTypeCMBL(Resource model, String type, ModelBasedLocker locker) {
		super(model, type);
		this.locker = locker;
	}
	
	@Override
	public boolean doAcquireLock() {
		
		
			if(dir == Direction.FORWARD)
				lockForward();
			else
				lockBackward();
		
		return locker.acquireLock(identifiers, getName());
	}

	private void lockBackward() {
		for(Control provider : removed.rowKeySet())
			identifiers.add(provider.getId());
		for(Module consumer : removed.columnKeySet())
			identifiers.add(consumer.getId());
	}

	private void lockForward() {
		
		IncQueryEngine engine;
		try {
			engine = IncQueryEngine.on(new EMFScope(model));LockCHelperMatcher matcher = LockCHelperMatcher.on(engine);
			LockCHelperMatch filter = matcher.newEmptyMatch();
			filter.setVendor(vendor);
			
			matcher.forEachMatch(filter, new IMatchProcessor<LockCHelperMatch>() {
	
				@Override
				public void process(LockCHelperMatch match) {
					identifiers.add(match.getSignal().getId());
					identifiers.add(match.getConsumer().getId());
					identifiers.add(match.getProvider().getId());
				}
			});
			
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}
		
	
	@Override
	public void doReleaseLock() {
		locker.releaseLock(identifiers, getName());
		identifiers.clear();
	}
	
}
