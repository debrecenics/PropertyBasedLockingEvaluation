package org.mondo.collaboration.security.lock.eval.simulation;

import org.mondo.collaboration.security.lock.eval.user.UserType;

public class ExecuteOperationWrapper extends AbstractWrapper {

	private UserType type;
	
	public ExecuteOperationWrapper(UserType type, double time) {
		super(time);
		this.type = type;
	}

	public void execute() {
		type.operate();
		type.releaseLock();
	}
	
}
