package org.mondo.collaboration.security.lock.eval.user;


import java.util.logging.Logger;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.emf.EMFScope;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.Configuration;

public abstract class UserType extends Thread {

	public enum Direction {
		FORWARD, BACKWARD
	}

	protected final Resource model;
	protected IncQueryEngine engine;
	protected Direction dir = Direction.FORWARD;
	private Logger logger;
	
	public UserType(Resource model) {
		this.model = model;
		this.logger = Logger.getGlobal();
		
	}
	
	public UserType init() {
		try {
			this.engine = IncQueryEngine.on(new EMFScope(model));
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	protected boolean acquireLock() {
		synchronized (engine) {
			return doAcquireLock();
		}
	}
	
	protected void releaseLock() {
		synchronized (engine) {
			doReleaseLock();
		}
	}

	protected void operate() {
		synchronized (engine) {
			doOperations();
		}
	}
	
	public abstract boolean doAcquireLock();
	
	public abstract void doReleaseLock();

	public void doOperations() { updateDirection(); }
	
	protected void updateDirection() {
		if (dir == Direction.FORWARD)
			dir = Direction.BACKWARD;
		else
			dir = Direction.FORWARD;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < Configuration.Operations; i++) {
			try{
				Thread.sleep(nextWaitTime());
				if(acquireLock()) {
					logger.info(String.format("Granted to User: %s", getName()));
					operate();
					Thread.sleep(nextWaitTime() / 2);
					logger.info(String.format("Executed by: %s", getName()));
					releaseLock();	
					logger.info(String.format("Released by: %s", getName()));
				} else 	{
					logger.info(String.format("Declined: %s", getName()));
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private long nextWaitTime() {
		return (long) (Configuration.Distribution.getNext()*1000);
	}
	
}
