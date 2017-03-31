package org.mondo.collaboration.security.lock.eval.user;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.LockCHelperMatch;
import org.mondo.collaboration.security.query.LockCHelperMatcher;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import wt.Control;
import wt.Module;
import wt.Signal;

public abstract class UserTypeC extends UserType {

	protected final String vendor;
	protected Table<Control,Module,Signal> removed = HashBasedTable.create();
	
	public UserTypeC(Resource model, String vendor) {
		super(model);
		this.vendor = vendor;
	}
	
	@Override
	public void doOperations() {
		try {
				LockCHelperMatcher matcher = LockCHelperMatcher.on(engine);
				LockCHelperMatch filter = matcher.newEmptyMatch();
				filter.setVendor(vendor);
				
				if(dir == Direction.FORWARD) {
					matcher.forEachMatch(filter, new IMatchProcessor<LockCHelperMatch>() {

						@Override
						public void process(LockCHelperMatch match) {
							removed.put(match.getProvider(), match.getConsumer(), match.getSignal());
						}
					});
					
					for (Signal signal : removed.values()) {
						EcoreUtil.delete(signal);
					}
				} else if(dir == Direction.BACKWARD) {
					for (Control provider : removed.rowKeySet()) {
						for (Module consumer : removed.columnKeySet()) {
							Signal signal = removed.get(provider, consumer);
							if(!provider.getProvides().contains(signal))
								provider.getProvides().add(signal);
							if(!consumer.getConsumes().contains(signal))
								consumer.getConsumes().add(signal);
							
						}
					}
				}
			
		} catch (IncQueryException e) {
			e.printStackTrace();
		}		
		super.doOperations();
	}
}
