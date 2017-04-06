package org.mondo.collaboration.security.lock.eval.user.obl;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.ObjectBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserTypeD;
import org.mondo.collaboration.security.query.LockCHelperMatch;
import org.mondo.collaboration.security.query.LockCHelperMatcher;

import com.google.common.collect.Sets;

import wt.Control;

public class UserTypeDOBL extends UserTypeD {

	private ObjectBasedLocker locker;
	private Set<String> identifiers = Sets.newHashSet();

	public UserTypeDOBL(Resource model, String type, ObjectBasedLocker locker) {
		super(model, type);
		this.locker = locker;
	}
	
	@Override
	protected boolean doAcquireLock() {
		if(dir == Direction.FORWARD)
			lockForward();
		else
			lockBackward();
		
		return locker.acquireLock(identifiers, getName());
	}

	private void lockBackward() {
		for(Control provider : newSignals.rowKeySet())
			identifiers.add(provider.getId());
//		for(Module consumer : newSignals.columnKeySet())
//			identifiers.add(consumer.getId());
	}

	private void lockForward() {
		
		try {
			LockCHelperMatcher matcher = LockCHelperMatcher.on(engine);
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
	protected void doReleaseLock() {
		locker.releaseLock(identifiers, getName());
		identifiers.clear();
	}
	
}
