package org.mondo.collaboration.security.lock.eval.user.fbl;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.FileBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserTypeD;
import org.mondo.collaboration.security.query.LockCHelperMatch;
import org.mondo.collaboration.security.query.LockCHelperMatcher;

import com.google.common.collect.Sets;

import wt.Control;
import wt.Module;

public class UserTypeDFBL extends UserTypeD {

	private FileBasedLocker locker;
	private Set<String> identifiers = Sets.newHashSet();

	public UserTypeDFBL(Resource model, String type, FileBasedLocker locker) {
		super(model, type);
		this.locker = locker;
	}
	
	@Override
	protected boolean doAcquireLock() {
			if(dir == Direction.FORWARD)
				lockForward();
			else
				lockBackward();
		
		return locker.acquireLock(identifiers, getName());
	}

	private void lockBackward() {
		for(Control provider : newSignals.rowKeySet())
			identifiers.add(EcoreUtil.getURI(provider).fragment().split("/@")[1]);
		for(Module consumer : newSignals.columnKeySet())
			identifiers.add(EcoreUtil.getURI(consumer).fragment().split("/@")[1]);
	}

	private void lockForward() {
		
		try {
			LockCHelperMatcher matcher = LockCHelperMatcher.on(engine);
			LockCHelperMatch filter = matcher.newEmptyMatch();
			filter.setVendor(vendor);
			
			matcher.forEachMatch(filter, new IMatchProcessor<LockCHelperMatch>() {
	
				@Override
				public void process(LockCHelperMatch match) {
					identifiers.add(EcoreUtil.getURI(match.getSignal()).fragment().split("/@")[1]);
					identifiers.add(EcoreUtil.getURI(match.getConsumer()).fragment().split("/@")[1]);
					identifiers.add(EcoreUtil.getURI(match.getProvider()).fragment().split("/@")[1]);
				}
			});
			
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
