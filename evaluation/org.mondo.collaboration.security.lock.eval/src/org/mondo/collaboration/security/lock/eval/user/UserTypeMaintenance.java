package org.mondo.collaboration.security.lock.eval.user;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.LockOp3Match;
import org.mondo.collaboration.security.query.LockOp3Matcher;

public abstract class UserTypeMaintenance extends UserType {

	protected String cycle;

	public UserTypeMaintenance(Resource model, String cycle) {
		super(model);
		this.cycle = cycle;
	}
	
	@Override
	protected boolean doOperations() {
		try {
			LockOp3Matcher matcher = LockOp3Matcher.on(engine);
			LockOp3Match filter = matcher.newEmptyMatch();
			filter.setCycle(cycle);
			
			matcher.forEachMatch(filter, new IMatchProcessor<LockOp3Match>() {

				@Override
				public void process(LockOp3Match match) {
					if(dir == Direction.FORWARD)
						match.getSignal().setFrequency(match.getSignal().getFrequency() * 2);
					else
						match.getSignal().setFrequency(match.getSignal().getFrequency() / 2);					
				}
			});
		} catch (IncQueryException e) {
			e.printStackTrace();
		}		
		return super.doOperations();
	}
}
