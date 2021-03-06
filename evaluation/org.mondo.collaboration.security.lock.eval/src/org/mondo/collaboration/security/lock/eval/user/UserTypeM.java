package org.mondo.collaboration.security.lock.eval.user;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.LockAMatch;
import org.mondo.collaboration.security.query.LockAMatcher;

public abstract class UserTypeM extends UserType {

	protected String cycle;

	public UserTypeM(Resource model, String cycle) {
		super(model);
		this.cycle = cycle;
	}
	
	@Override
	protected boolean doOperations() {
		try {
			LockAMatcher matcher = LockAMatcher.on(engine);
			LockAMatch filter = matcher.newEmptyMatch();
			filter.setCycle(cycle);
			
			matcher.forEachMatch(filter, new IMatchProcessor<LockAMatch>() {

				@Override
				public void process(LockAMatch match) {
					if(dir == Direction.FORWARD)
						match.getSignal().setFrequency(match.getSignal().getFrequency() * 2);
					else
						match.getSignal().setFrequency(match.getSignal().getFrequency() / 2);					
				}
			});				
		
//			System.out.println(String.format("%s updated the following signals: %s", getName(), matcher.getAllValuesOfsignal(filter).toString()));
		} catch (IncQueryException e) {
			e.printStackTrace();
		}		
		return super.doOperations();
	}
}
