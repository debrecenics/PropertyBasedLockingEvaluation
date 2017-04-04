package org.mondo.collaboration.security.lock.eval.user.fbl;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.FileBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserTypeB;
import org.mondo.collaboration.security.query.LockBMatch;
import org.mondo.collaboration.security.query.LockBMatcher;

import com.google.common.collect.Sets;

import wt.Signal;

public class UserTypeBFBL extends UserTypeB {

	private FileBasedLocker locker;
	private Set<String> identifiers = Sets.newHashSet();

	public UserTypeBFBL(Resource model, String type, FileBasedLocker locker) {
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
				identifiers.add(EcoreUtil.getURI(signal).fragment().split("/@")[1]);
				identifiers.add(EcoreUtil.getURI(signal.eContainer()).fragment().split("/@")[1]);
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
