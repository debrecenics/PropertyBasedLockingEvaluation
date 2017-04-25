package org.mondo.collaboration.security.lock.eval.user.fbl;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.FileBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserTypeReplace;
import org.mondo.collaboration.security.query.LockOp2Match;
import org.mondo.collaboration.security.query.LockOp2Matcher;

import com.google.common.collect.Sets;

public class UserType2FBL extends UserTypeReplace {

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
			LockOp2Matcher matcher = LockOp2Matcher.on(engine);
			LockOp2Match filter = matcher.newEmptyMatch();
			filter.setVendor(vendor);
			
			for(LockOp2Match match : matcher.getAllMatches(filter)) {
				identifiers.add(UtilityFBL.getFragment((EObject)match.getObject()));
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
