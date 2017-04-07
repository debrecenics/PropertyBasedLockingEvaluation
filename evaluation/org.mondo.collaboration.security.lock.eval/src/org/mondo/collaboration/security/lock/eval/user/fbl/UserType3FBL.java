package org.mondo.collaboration.security.lock.eval.user.fbl;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.FileBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserType3;
import org.mondo.collaboration.security.query.LockOp3HelperMatch;
import org.mondo.collaboration.security.query.LockOp3HelperMatcher;

import com.google.common.collect.Sets;

import wt.Control;

public class UserType3FBL extends UserType3 {

	private FileBasedLocker locker;
	private Set<String> identifiers = Sets.newHashSet();

	public UserType3FBL(Resource model, String cycle, FileBasedLocker locker) {
		super(model, cycle);
		this.locker = locker;
	}
	
	@Override
	protected boolean doAcquireLock() {
		
		try {
			LockOp3HelperMatcher matcher = LockOp3HelperMatcher.on(engine);
			LockOp3HelperMatch filter = matcher.newEmptyMatch();
			filter.setCycle(cycle);
			
			for (Control control : matcher.getAllValuesOfctrl(filter)) {
				identifiers.add(EcoreUtil.getURI(control).fragment().split("/@")[1]);
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
