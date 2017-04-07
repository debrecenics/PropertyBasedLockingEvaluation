package org.mondo.collaboration.security.lock.eval.user;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.LockOp1Match;
import org.mondo.collaboration.security.query.LockOp1Matcher;

import com.google.common.collect.Lists;

import wt.Control;
import wt.Signal;

public abstract class UserType1 extends UserType {

	protected final String type;
	
	public UserType1(Resource model, String type) {
		super(model);
		this.type = type;
	}
	
	@Override
	protected boolean doOperations() {
		try {
			LockOp1Matcher matcher = LockOp1Matcher.on(engine);
			LockOp1Match filter = matcher.newEmptyMatch();
			filter.setType(type);
			
			List<Signal> signals = Lists.newArrayList();
			signals.addAll(matcher.getAllValuesOfsignal(filter));
			
			for(int i = 0; i < signals.size(); i++) {
				Signal currentSignal = signals.get(i);
				Control nextControl = null;
				if(i+1 == signals.size()) {
					nextControl = (Control) signals.get(0).eContainer();
				} else {
					nextControl = (Control) signals.get(i+1).eContainer();
				}
				
				if(dir == Direction.FORWARD) {
					nextControl.getConsumes().add(currentSignal);
				} else {
					nextControl.getConsumes().remove(currentSignal);
				}
			}
		} catch (IncQueryException e) {
			e.printStackTrace();
		}		
		return super.doOperations();		
	}
}
