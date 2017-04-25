package org.mondo.collaboration.security.lock.eval.user.fbl;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.FileBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserTypeMaintenance;
import org.mondo.collaboration.security.query.LockOp3Match;
import org.mondo.collaboration.security.query.LockOp3Matcher;

import com.google.common.collect.Sets;

public class UserType3FBL extends UserTypeMaintenance {

	private FileBasedLocker locker;
	private Set<Object> identifiers = Sets.newHashSet();

	public UserType3FBL(Resource model, String cycle, FileBasedLocker locker) {
		super(model, cycle);
		this.locker = locker;
	}
	
	@Override
	protected boolean doAcquireLock() {
		
		try {
			LockOp3Matcher matcher = LockOp3Matcher.on(engine);
			LockOp3Match filter = matcher.newEmptyMatch();
			filter.setCycle(cycle);
			
			for (LockOp3Match match : matcher.getAllMatches(filter)) {
				identifiers.add(UtilityFBL.getFragment(match.getSignal()));
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
