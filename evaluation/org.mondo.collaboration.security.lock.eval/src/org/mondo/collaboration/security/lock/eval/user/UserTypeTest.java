package org.mondo.collaboration.security.lock.eval.user;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.LockOp1Match;
import org.mondo.collaboration.security.query.LockOp1Matcher;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import wt.Control;
import wt.SgnlType;
import wt.Signal;
import wt.WtFactory;

public abstract class UserTypeTest extends UserType {

	protected final String type;

	protected Map<Control,Signal> newSignals = Maps.newHashMap();
	protected Map<Control,Signal> consumeSignals = Maps.newHashMap();
	
	public UserTypeTest(Resource model, String type) {
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
			
			if(dir == Direction.FORWARD) {
				matcher.forEachMatch(filter, new IMatchProcessor<LockOp1Match>() {
					@Override
					public void process(LockOp1Match match) {
						Signal signal = WtFactory.eINSTANCE.createSignal();
						signal.setType(SgnlType.TEST);
						
						match.getCtrl1().getProvides().add(signal);	
						match.getCtrl1().getConsumes().add(match.getSignal());
						newSignals.put(match.getCtrl1(), signal);
						consumeSignals.put(match.getCtrl1(), match.getSignal());
					}
				});
			} else if(dir == Direction.BACKWARD) {
				for(Control control : newSignals.keySet()) {
					control.getConsumes().remove(consumeSignals.get(control));
					control.getProvides().remove(newSignals.get(control));
				}
				newSignals.clear();
				consumeSignals.clear();
			}
		} catch (IncQueryException e) {
			e.printStackTrace();
		}		
		return super.doOperations();		
	}
}
