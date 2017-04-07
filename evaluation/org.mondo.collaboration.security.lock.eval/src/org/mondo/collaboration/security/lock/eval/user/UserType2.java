package org.mondo.collaboration.security.lock.eval.user;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.LockOp2Match;
import org.mondo.collaboration.security.query.LockOp2Matcher;

import com.google.common.collect.Maps;

import wt.Control;
import wt.SgnlType;
import wt.Signal;
import wt.WtFactory;

public abstract class UserType2 extends UserType {

	protected final String vendor;
	protected Map<Control,Signal> newSignals = Maps.newHashMap();
	
	public UserType2(Resource model, String vendor) {
		super(model);
		this.vendor = vendor;
	}
	
	@Override
	protected boolean doOperations() {
		try {
				LockOp2Matcher matcher = LockOp2Matcher.on(engine);
				LockOp2Match filter = matcher.newEmptyMatch();
				filter.setVendor(vendor);
				
				if(dir == Direction.FORWARD) {
					matcher.forEachMatch(filter, new IMatchProcessor<LockOp2Match>() {
						@Override
						public void process(LockOp2Match match) {
							Signal signal = WtFactory.eINSTANCE.createSignal();
							signal.setType(SgnlType.TEST);
							match.getControl().getProvides().add(signal);							
							newSignals.put(match.getControl(), signal);
						}
					});
				} else if(dir == Direction.BACKWARD) {
					for(Control control : newSignals.keySet()) {
						Signal signal = newSignals.get(control);
						control.getConsumes().remove(signal);
					}
					newSignals.clear();
				}
			
		} catch (IncQueryException e) {
			e.printStackTrace();
		}		
		return super.doOperations();
	}
}
