package org.mondo.collaboration.security.lock.eval.user.fbl;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.FileBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserType1;
import org.mondo.collaboration.security.query.LockOp1HelperMatch;
import org.mondo.collaboration.security.query.LockOp1HelperMatcher;

import com.google.common.collect.Sets;

import wt.Composite;

public class UserType1FBL extends UserType1 {

	private FileBasedLocker locker;
	private Set<Object> identifiers = Sets.newHashSet();

	public UserType1FBL(Resource model, String type, FileBasedLocker locker) {
		super(model, type);
		this.locker = locker;
	}
	
	@Override
	protected boolean doAcquireLock() {
		
		try {
			LockOp1HelperMatcher matcher = LockOp1HelperMatcher.on(engine);
			LockOp1HelperMatch filter = matcher.newEmptyMatch();
			filter.setType(type);
			
			for (Composite root : matcher.getAllValuesOffragment(filter)) {
				identifiers.add(root);
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
