package org.mondo.collaboration.security.lock.eval.user.pbl;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lens.arbiter.LockArbiter.LockMonitoringSession;
import org.mondo.collaboration.security.lock.eval.lock.PropertyBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserTypeReplace;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.Lock;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class UserTypeReplacePBL extends UserTypeReplace {

	private Lock lock;
	private PropertyBasedLocker locker;
	private ArrayList<Lock> locks;

	public UserTypeReplacePBL(PropertyBasedLocker locker, Resource model, String vendor, String name) {
		super(model, vendor);
		this.locker = locker;
		locks = Lists.newArrayList(
				UtilityClass.buildLock(name,"lockOp2", buildBindings(), locker),
				UtilityClass.buildLock(name,"lockOp2ControlCycle", buildBindings(), locker),
				UtilityClass.buildLock(name,"lockOp2ControlType", buildBindings(), locker),
				UtilityClass.buildLock(name,"lockOp2ControlProvide", buildBindings(), locker),
				UtilityClass.buildLock(name,"lockOp2ControlConsume", buildBindings(), locker),
				UtilityClass.buildLock(name,"lockOp2SignalFrequency", buildBindings(), locker));
		
	}

	private Map<String,String> buildBindings() {
		Map<String,String> bindings = Maps.newHashMap();
		bindings.put("vendor", vendor);
		return bindings;
	}

	@Override
	protected boolean doAcquireLock() {
		try {
			
			for (Lock lock : locks) {
				UtilityClass.acquireLock(locker, lock);
			}
			return true;
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
			for (Lock lock : locks) {
				UtilityClass.releaseLock(locker, lock);
			}
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}	
	
}
