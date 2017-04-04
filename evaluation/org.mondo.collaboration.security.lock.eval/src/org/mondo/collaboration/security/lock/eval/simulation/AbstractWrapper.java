package org.mondo.collaboration.security.lock.eval.simulation;

public abstract class AbstractWrapper {

	private double time;

	public AbstractWrapper(double time) {
		this.time = time;
	}
	
	public abstract void execute();
	
	public double getTime() {
		return time;
	}
}
