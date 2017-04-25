package org.mondo.collaboration.security.lock.eval.user;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.LockOp2Match;
import org.mondo.collaboration.security.query.LockOp2Matcher;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import wt.Composite;
import wt.Control;
import wt.Signal;

public abstract class UserTypeReplace extends UserType {

	protected final String vendor;
	protected List<Composite> list = Lists.newArrayList();
	protected Map<Signal,Control> map = Maps.newHashMap();
	
	public UserTypeReplace(Resource model, String vendor) {
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
							Composite composite = match.getComposite();
							list.add(composite);
							for(TreeIterator<EObject> iterator = composite.eAllContents(); iterator.hasNext();) {
								EObject eObject = iterator.next();
								if(eObject instanceof Control) {
									Control control = (Control) eObject;
									for (Signal signal : control.getProvides()) {
										signal.setFrequency(signal.getFrequency() * 2);
										if(control.getConsumes().contains(signal)) {
											control.getConsumes().remove(signal);
										} else {
											control.getConsumes().add(signal);
										}
										map.put(signal, control);
									}
								}
							}
						}
					});
				} else if(dir == Direction.BACKWARD) {
					for(Signal signal : map.keySet()) {
						signal.setFrequency(signal.getFrequency() * 2);
						
						Control control = map.get(signal);
						if(control.getConsumes().contains(signal)) {
							control.getConsumes().remove(signal);
						} else {
							control.getConsumes().add(signal);
						}
					}
					list.clear();
				}
			
		} catch (IncQueryException e) {
			e.printStackTrace();
		}		
		return super.doOperations();
	}
}
