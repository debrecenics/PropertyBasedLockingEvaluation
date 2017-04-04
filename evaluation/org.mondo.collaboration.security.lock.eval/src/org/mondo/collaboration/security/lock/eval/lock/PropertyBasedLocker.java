package org.mondo.collaboration.security.lock.eval.lock;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.patternlanguage.emf.specification.SpecificationBuilder;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.base.api.BaseIndexOptions;
import org.eclipse.incquery.runtime.emf.EMFScope;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lens.arbiter.LockArbiter;
import org.mondo.collaboration.security.lens.arbiter.LockArbiter.LockMonitoringSession;
import org.mondo.collaboration.security.lens.arbiter.SecurityArbiter;
import org.mondo.collaboration.security.macl.xtext.mondoAccessControlLanguage.Policy;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.PropertyBasedLockingModel;

public class PropertyBasedLocker {

	private LockArbiter lockArbiter;
	private PropertyBasedLockingModel lockingModel;
	private DummySecurityArbiter secArbiter;

	public PropertyBasedLocker() {
		// TODO Auto-generated constructor stub
	}
	
	public void init(PropertyBasedLockingModel lockingModel, Resource model) throws IncQueryException {
		this.secArbiter = new DummySecurityArbiter(model);
		this.lockArbiter = new LockArbiter(secArbiter, lockingModel);
		this.lockingModel = lockingModel;
	}
	
	
	public LockMonitoringSession addUser(String username) {
		return lockArbiter.openSession(username);
	}
	
	public void reinitializeWith(PropertyBasedLockingModel lockingModel) throws IncQueryException {
		this.lockingModel = lockingModel;
		secArbiter.reinitialize();
		lockArbiter.reinitializeWith(lockingModel);
	}
	
	public PropertyBasedLockingModel getLockingModel() {
		return lockingModel;
	}
	
	public LockArbiter getLockArbiter() {
		return lockArbiter;
	}
	
	private static class DummySecurityArbiter extends SecurityArbiter {
		
		private AdvancedIncQueryEngine policyQueryEngine;
		private Resource model;
		private BaseIndexOptions indexOptions;
		private SpecificationBuilder specBuilder;
		
		public DummySecurityArbiter(Resource model) throws IncQueryException {
			super(null, null, null, null);
			this.model = model;
			this.indexOptions = new BaseIndexOptions();
			reinitialize();
		}
		
		@Override
		public void reinitializeWith(Policy policy) throws IncQueryException {
			if(model != null)
				reinitialize();
		}
		
		@Override
		public void reinitializeWith(Resource policy) throws IncQueryException {
			if(model != null)
				reinitialize();
		}

		private void reinitialize() throws IncQueryException {
			if (policyQueryEngine != null) 
				policyQueryEngine.wipe();
			else 
				policyQueryEngine = AdvancedIncQueryEngine.createUnmanagedEngine(
						new EMFScope(this.model, this.indexOptions));
			this.specBuilder = new SpecificationBuilder();
		}
		
		@Override
		public AdvancedIncQueryEngine getPolicyQueryEngine() {
			return policyQueryEngine;
		}
		
		@Override
		public SpecificationBuilder getSpecBuilder() {
			return specBuilder;
		}
	
	}
	
}
