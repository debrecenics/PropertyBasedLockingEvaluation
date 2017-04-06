package org.mondo.collaboration.security.lock.eval.user.pbl;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lens.arbiter.LockArbiter.LockMonitoringSession;
import org.mondo.collaboration.security.lock.eval.lock.PropertyBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserTypeB;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.Lock;

import com.google.common.collect.Maps;

public class UserTypeBPBL extends UserTypeB {

	private Lock lock;
	private PropertyBasedLocker locker;

	public UserTypeBPBL(PropertyBasedLocker locker, Resource model, String type, String name) {
		super(model, type);
		this.locker = locker;
		this.lock = UtilityClass.buildLock(name,"lockB", buildBindings(), locker);
	}
	
	private Map<String,String> buildBindings() {
		Map<String,String> bindings = Maps.newHashMap();
		bindings.put("type", type);
		return bindings;
	}

	@Override
	protected boolean doAcquireLock() {
		try {
			return UtilityClass.acquireLock(locker, lock);
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	protected boolean doOperations() {
		LockMonitoringSession session = locker.addUser(getName());
		super.doOperations();
		if(session.getAnyLockViolation() != null) {
			return false;
		} else {
			return true;
		}
		
	}
	
	@Override
	protected void doReleaseLock() {
		try {
			UtilityClass.releaseLock(locker, lock);
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}	
}
