package org.mondo.collaboration.security.lock.eval.simulation;

import org.mondo.collaboration.security.lock.eval.user.UserType;

public class ReleaseLockOperationWrapper extends AbstractWrapper {

	private UserType type;
	
	public ReleaseLockOperationWrapper(UserType type, double time) {
		super(time);
		this.type = type;
	}

	public void execute() {
		type.operate();
		type.releaseLock();
	}
	
}
