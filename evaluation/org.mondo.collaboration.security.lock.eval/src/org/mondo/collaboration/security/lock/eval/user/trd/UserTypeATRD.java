package org.mondo.collaboration.security.lock.eval.user.trd;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.emf.EMFScope;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.TraditionalLocker;
import org.mondo.collaboration.security.lock.eval.user.UserTypeA;
import org.mondo.collaboration.security.query.LockAHelperMatch;
import org.mondo.collaboration.security.query.LockAHelperMatcher;

import com.google.common.collect.Sets;

import wt.Control;
import wt.Cycle;
import wt.Signal;

public class UserTypeATRD extends UserTypeA {

	private TraditionalLocker locker;
	private Set<String> identifiers = Sets.newHashSet();

	public UserTypeATRD(Resource model, Cycle cycle, TraditionalLocker locker) {
		super(model, cycle);
		this.locker = locker;
	}
	
	@Override
	public boolean doAcquireLock() {
		
		IncQueryEngine engine;
		try {
			engine = IncQueryEngine.on(new EMFScope(model));
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
	public void doReleaseLock() {
		locker.releaseLock(identifiers, getName());
		identifiers.clear();
	}
	
}
