package org.mondo.collaboration.security.lock.eval.user.obl;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.ObjectBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserType2;
import org.mondo.collaboration.security.query.LockOp2HelperMatch;
import org.mondo.collaboration.security.query.LockOp2HelperMatcher;

import com.google.common.collect.Sets;

import wt.Control;

public class UserType2OBL extends UserType2 {

	private ObjectBasedLocker locker;
	private Set<Object> identifiers = Sets.newHashSet();

	public UserType2OBL(Resource model, String vendor, ObjectBasedLocker locker) {
		super(model, vendor);
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
		lockForward();
		for(Control control : newSignals.keySet()) {
			identifiers.add(newSignals.get(control));
		}
	}

	private void lockForward() {
		
		try {
			LockOp2HelperMatcher matcher = LockOp2HelperMatcher.on(engine);
			LockOp2HelperMatch filter = matcher.newEmptyMatch();
			filter.setVendor(vendor);
			
			matcher.forEachMatch(filter, new IMatchProcessor<LockOp2HelperMatch>() {
	
				@Override
				public void process(LockOp2HelperMatch match) {
					identifiers.add(match.getControl());
					identifiers.add(match.getComposite());
					for(EObject container = match.getControl().eContainer(); container != match.getComposite(); container = container.eContainer()) identifiers.add(container);
					
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
