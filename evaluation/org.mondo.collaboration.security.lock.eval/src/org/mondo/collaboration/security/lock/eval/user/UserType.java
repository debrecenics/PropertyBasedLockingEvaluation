package org.mondo.collaboration.security.lock.eval.user;


import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.emf.EMFScope;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.Configuration;

public abstract class UserType {

	private int declined = 0;
	private int accepted = 0;
	
	private String name;
	
	private boolean lockGranted = false;
	
	private final class RecordingCommandExtension extends RecordingCommand {
		public boolean lockViolated = false;

		private RecordingCommandExtension(TransactionalEditingDomain domain) {
			super(domain);
		}

		@Override
		protected void doExecute() {
			lockViolated = !doOperations();
		}
	}

	public enum Direction {
		FORWARD, BACKWARD
	}

	protected final Resource model;
	protected IncQueryEngine engine;
	protected Direction dir = Direction.FORWARD;
	
	public UserType(Resource model) {
		this.model = model;
	}
	
	public UserType init() {
		try {
			this.engine = IncQueryEngine.on(new EMFScope(model));
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public final boolean requestLock() {
		lockGranted = doAcquireLock();
		if(!lockGranted)
			setDeclined(getDeclined() + 1);
		
		return lockGranted;
	}
	
	public final void releaseLock() {
		if(lockGranted) {
			doReleaseLock();
			lockGranted = false;
		}
	}
	
	public final boolean operate() {
		if(!lockGranted) return false;
		
		RecordingCommandExtension command = new RecordingCommandExtension(Configuration.domain);
		Configuration.domain.getCommandStack().execute(command);
		if(command.lockViolated) {
			setDeclined(getDeclined() + 1);
			Configuration.domain.getCommandStack().undo();
			return false;
		} else {
			setAccepted(getAccepted() + 1);
			return true;
		}
	}
	
	protected abstract boolean doAcquireLock();
	
	protected abstract void doReleaseLock();

	protected boolean doOperations() { updateDirection(); return true; }
	
	protected void updateDirection() {
		if (dir == Direction.FORWARD)
			dir = Direction.BACKWARD;
		else
			dir = Direction.FORWARD;
	}
	
	public int getDeclined() {
		return declined;
	}

	protected void setDeclined(int declined) {
		this.declined = declined;
	}

	public int getAccepted() {
		return accepted;
	}

	protected void setAccepted(int accepted) {
		this.accepted = accepted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
