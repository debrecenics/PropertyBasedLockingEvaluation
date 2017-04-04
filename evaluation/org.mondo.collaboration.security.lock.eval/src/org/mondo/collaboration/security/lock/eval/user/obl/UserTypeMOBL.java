package org.mondo.collaboration.security.lock.eval.user.obl;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.ObjectBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserTypeM;
import org.mondo.collaboration.security.query.LockAHelperMatch;
import org.mondo.collaboration.security.query.LockAHelperMatcher;

import com.google.common.collect.Sets;

import wt.Control;
import wt.Signal;

public class UserTypeMOBL extends UserTypeM {

	private ObjectBasedLocker locker;
	private Set<String> identifiers = Sets.newHashSet();

	public UserTypeMOBL(Resource model, String cycle, ObjectBasedLocker locker) {
		super(model, cycle);
		this.locker = locker;
	}
	
	@Override
	protected boolean doAcquireLock() {
		
		try {
			LockAHelperMatcher matcher = LockAHelperMatcher.on(engine);
			LockAHelperMatch filter = matcher.newEmptyMatch();
			filter.setCycle(cycle);
			
			for (Control control : matcher.getAllValuesOfctrl(filter)) {
				identifiers.add(control.getId());
			}
			
			for (Signal signal : matcher.getAllValuesOfsignal(filter)) {
				identifiers.add(signal.getId());
			}
			
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
		
		return locker.acquireLock(identifiers, getName());
	}
	
	@Override
	protected void doReleaseLock() {
		locker.releaseLock(identifiers, getName());
		identifiers.clear();
	}

	
}
