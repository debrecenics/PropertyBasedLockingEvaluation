package org.mondo.collaboration.security.lock.eval.user.obl;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.ObjectBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserTypeTest;
import org.mondo.collaboration.security.query.LockOp1Match;
import org.mondo.collaboration.security.query.LockOp1Matcher;

import com.google.common.collect.Sets;

public class UserType1OBL extends UserTypeTest {

	private ObjectBasedLocker locker;
	private Set<Object> identifiers = Sets.newHashSet();

	public UserType1OBL(Resource model, String type, ObjectBasedLocker locker) {
		super(model, type);
		this.locker = locker;
	}
	
	@Override
	protected boolean doAcquireLock() {
		
		try {
			LockOp1Matcher matcher = LockOp1Matcher.on(engine);
			LockOp1Match filter = matcher.newEmptyMatch();
			filter.setType(type);
			
			for (LockOp1Match match : matcher.getAllMatches(filter)) {
				identifiers.add(match.getSignal());
				identifiers.add(match.getCtrl1());
				identifiers.add(match.getCtrl2());
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
