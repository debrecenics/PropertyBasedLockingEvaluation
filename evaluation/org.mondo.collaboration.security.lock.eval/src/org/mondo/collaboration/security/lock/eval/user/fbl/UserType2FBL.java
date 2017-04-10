package org.mondo.collaboration.security.lock.eval.user.fbl;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.FileBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserType2;
import org.mondo.collaboration.security.query.LockOp2HelperMatch;
import org.mondo.collaboration.security.query.LockOp2HelperMatcher;

import com.google.common.collect.Sets;

import wt.Composite;

public class UserType2FBL extends UserType2 {

	private FileBasedLocker locker;
	private Set<Object> identifiers = Sets.newHashSet();
	private Set<Object> roots = Sets.newHashSet();

	public UserType2FBL(Resource model, String type, FileBasedLocker locker) {
		super(model, type);
		this.locker = locker;
	}
	
	@Override
	protected boolean doAcquireLock() {
			if(dir == Direction.FORWARD) {
				lockForward();
				roots.addAll(identifiers);
			}
			else {
				lockBackward();
				roots.clear();
			}
		
		return locker.acquireLock(identifiers, getName());
	}

	private void lockBackward() {
		for(Object composite : roots)
			identifiers.add(composite);
	}

	private void lockForward() {
		
		try {
			LockOp2HelperMatcher matcher = LockOp2HelperMatcher.on(engine);
			LockOp2HelperMatch filter = matcher.newEmptyMatch();
			filter.setVendor(vendor);
			
			for(Composite root : matcher.getAllValuesOffragment(filter)) {
				identifiers.add(root);
			}
			
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
