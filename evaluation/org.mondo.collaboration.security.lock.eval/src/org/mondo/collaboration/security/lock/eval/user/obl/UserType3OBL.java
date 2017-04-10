package org.mondo.collaboration.security.lock.eval.user.obl;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.ObjectBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserType3;
import org.mondo.collaboration.security.query.LockOp3Match;
import org.mondo.collaboration.security.query.LockOp3Matcher;

import com.google.common.collect.Sets;

import wt.Signal;

public class UserType3OBL extends UserType3 {

	private ObjectBasedLocker locker;
	private Set<Object> identifiers = Sets.newHashSet();

	public UserType3OBL(Resource model, String cycle, ObjectBasedLocker locker) {
		super(model, cycle);
		this.locker = locker;
	}
	
	@Override
	protected boolean doAcquireLock() {
		
		try {
			LockOp3Matcher matcher = LockOp3Matcher.on(engine);
			LockOp3Match filter = matcher.newEmptyMatch();
			filter.setCycle(cycle);
			
			for (Signal signal : matcher.getAllValuesOfsignal(filter)) {
				identifiers.add(signal);
				identifiers.add(signal.eContainer());
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
