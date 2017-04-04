package org.mondo.collaboration.security.lock.eval.user.fbl;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.FileBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserTypeM;
import org.mondo.collaboration.security.query.LockAHelperMatch;
import org.mondo.collaboration.security.query.LockAHelperMatcher;

import com.google.common.collect.Sets;

import wt.Control;
import wt.Signal;

public class UserTypeMFBL extends UserTypeM {

	private FileBasedLocker locker;
	private Set<String> identifiers = Sets.newHashSet();

	public UserTypeMFBL(Resource model, String cycle, FileBasedLocker locker) {
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
				identifiers.add(EcoreUtil.getURI(control).fragment().split("/@")[1]);
			}
			
			for (Signal signal : matcher.getAllValuesOfsignal(filter)) {
				identifiers.add(EcoreUtil.getURI(signal).fragment().split("/@")[1]);
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
