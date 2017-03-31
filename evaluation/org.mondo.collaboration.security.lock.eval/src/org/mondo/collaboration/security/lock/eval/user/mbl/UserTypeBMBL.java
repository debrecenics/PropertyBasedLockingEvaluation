package org.mondo.collaboration.security.lock.eval.user.mbl;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.emf.EMFScope;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.ModelBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserTypeB;
import org.mondo.collaboration.security.query.LockBMatch;
import org.mondo.collaboration.security.query.LockBMatcher;

import com.google.common.collect.Sets;

import wt.Module;
import wt.Signal;

public class UserTypeBMBL extends UserTypeB {

	private ModelBasedLocker locker;
	private Set<String> identifiers = Sets.newHashSet();

	public UserTypeBMBL(Resource model, String type, ModelBasedLocker locker) {
		super(model, type);
		this.locker = locker;
	}
	
	@Override
	public boolean doAcquireLock() {
		
		IncQueryEngine engine;
		try {
			engine = IncQueryEngine.on(new EMFScope(model));
			LockBMatcher matcher = LockBMatcher.on(engine);
			LockBMatch filter = matcher.newEmptyMatch();
			filter.setType(type);
			
			for (Signal signal : matcher.getAllValuesOfsignal(filter)) {
				identifiers.add(signal.getId());
				identifiers.add(((Module) signal.eContainer()).getId());
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
