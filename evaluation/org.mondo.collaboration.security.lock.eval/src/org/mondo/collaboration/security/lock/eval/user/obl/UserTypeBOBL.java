package org.mondo.collaboration.security.lock.eval.user.obl;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.ObjectBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserTypeB;
import org.mondo.collaboration.security.query.LockBMatch;
import org.mondo.collaboration.security.query.LockBMatcher;

import com.google.common.collect.Sets;

import wt.Module;
import wt.Signal;

public class UserTypeBOBL extends UserTypeB {

	private ObjectBasedLocker locker;
	private Set<String> identifiers = Sets.newHashSet();

	public UserTypeBOBL(Resource model, String type, ObjectBasedLocker locker) {
		super(model, type);
		this.locker = locker;
	}
	
	@Override
	protected boolean doAcquireLock() {
		
		try {
			LockBMatcher matcher = LockBMatcher.on(engine);
			LockBMatch filter = matcher.newEmptyMatch();
			filter.setType(type);
			
			for (Signal signal : matcher.getAllValuesOfsignal(filter)) {
				identifiers.add(signal.getId());
				identifiers.add(((Module) signal.eContainer()).getId());
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
