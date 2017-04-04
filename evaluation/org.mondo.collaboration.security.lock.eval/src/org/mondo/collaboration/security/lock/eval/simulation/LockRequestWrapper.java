package org.mondo.collaboration.security.lock.eval.simulation;

import org.mondo.collaboration.security.lock.eval.user.UserType;

public class LockRequestWrapper extends AbstractWrapper {

	private UserType type;

	public LockRequestWrapper(UserType type, double time) {
		super(time);
		this.type = type;
	}
	
	@Override
	public void execute() {
		type.requestLock();
	}
	
}
