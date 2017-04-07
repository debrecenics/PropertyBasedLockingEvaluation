package org.mondo.collaboration.security.lock.eval.user.obl;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.ObjectBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserType2;
import org.mondo.collaboration.security.query.LockOp2Match;
import org.mondo.collaboration.security.query.LockOp2Matcher;

import com.google.common.collect.Sets;

import wt.Control;

public class UserType2OBL extends UserType2 {

	private ObjectBasedLocker locker;
	private Set<String> identifiers = Sets.newHashSet();

	public UserType2OBL(Resource model, String type, ObjectBasedLocker locker) {
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
		for(Control provider : newSignals.keySet())
			identifiers.add(provider.getId());
	}

	private void lockForward() {
		
		try {
			LockOp2Matcher matcher = LockOp2Matcher.on(engine);
			LockOp2Match filter = matcher.newEmptyMatch();
			filter.setVendor(vendor);
			
			matcher.forEachMatch(filter, new IMatchProcessor<LockOp2Match>() {
	
				@Override
				public void process(LockOp2Match match) {
					identifiers.add(match.getControl().getId());
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
