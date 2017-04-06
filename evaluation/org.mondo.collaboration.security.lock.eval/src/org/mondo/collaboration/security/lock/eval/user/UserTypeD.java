package org.mondo.collaboration.security.lock.eval.user;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.LockCHelperMatch;
import org.mondo.collaboration.security.query.LockCHelperMatcher;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import wt.Control;
import wt.Module;
import wt.SgnlType;
import wt.Signal;
import wt.WtFactory;

public abstract class UserTypeD extends UserType {

	protected final String vendor;
	protected Table<Control,Module,Signal> newSignals = HashBasedTable.create();
	
	public UserTypeD(Resource model, String vendor) {
		super(model);
		this.vendor = vendor;
	}
	
	@Override
	protected boolean doOperations() {
		try {
				LockCHelperMatcher matcher = LockCHelperMatcher.on(engine);
				LockCHelperMatch filter = matcher.newEmptyMatch();
				filter.setVendor(vendor);
				
				if(dir == Direction.FORWARD) {
					matcher.forEachMatch(filter, new IMatchProcessor<LockCHelperMatch>() {
						@Override
						public void process(LockCHelperMatch match) {
							Signal signal = WtFactory.eINSTANCE.createSignal();
							signal.setType(SgnlType.TEST);
							match.getProvider().getProvides().add(signal);							
							match.getConsumer().getConsumes().add(signal);	
							newSignals.put(match.getProvider(), match.getConsumer(), signal);
						}
					});
				} else if(dir == Direction.BACKWARD) {
					for (Control provider : newSignals.rowKeySet()) {
						for (Module consumer : newSignals.columnKeySet()) {
							Signal signal = newSignals.get(provider, consumer);
							if(signal != null) {
								if(!provider.getProvides().contains(signal))
									provider.getProvides().remove(signal);
								if(!consumer.getConsumes().contains(signal))
									consumer.getConsumes().remove(signal);
							}
						}
					}
				}
			
		} catch (IncQueryException e) {
			e.printStackTrace();
		}		
		return super.doOperations();
	}
}
