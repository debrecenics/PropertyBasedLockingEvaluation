package org.mondo.collaboration.security.lock.eval.user.obl;

import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.ObjectBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserTypeReplace;
import org.mondo.collaboration.security.lock.eval.user.fbl.UtilityFBL;
import org.mondo.collaboration.security.query.LockOp2Match;
import org.mondo.collaboration.security.query.LockOp2Matcher;

import com.google.common.collect.Sets;

import wt.Composite;

public class UserType2OBL extends UserTypeReplace {

	private ObjectBasedLocker locker;
	private Set<Object> identifiers = Sets.newHashSet();

	public UserType2OBL(Resource model, String vendor, ObjectBasedLocker locker) {
		super(model, vendor);
		this.locker = locker;
	}
	
	@Override
	protected boolean doAcquireLock() {
		if(dir == Direction.FORWARD)
			lockForward();
		else
			lockBackward();
		
		return locker.acquireLock(identifiers, getName());
	}

	private void lockBackward() {
		lockForward();
		for(Composite composite : list) {
				if(composite.eContainer() != null) {
					identifiers.add(composite.eContainer());
				}
				identifiers.add(composite);
				TreeIterator<EObject> eAllContents = composite.eAllContents();
				while (eAllContents.hasNext()) {
					identifiers.add(eAllContents.next());
				}				
		}
	}

	private void lockForward() {
		
		try {
			LockOp2Matcher matcher = LockOp2Matcher.on(engine);
			LockOp2Match filter = matcher.newEmptyMatch();
			filter.setVendor(vendor);
			
			matcher.forEachMatch(filter, new IMatchProcessor<LockOp2Match>() {
	
				@Override
				public void process(LockOp2Match match) {
					identifiers.add(match.getObject());
					identifiers.add(match.getComposite());
					for(EObject container = ((EObject)match.getObject()).eContainer(); container != UtilityFBL.getFragment(match.getComposite()); container = container.eContainer()) identifiers.add(container);
					
				}
			});
			
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}
		
	
	@Override
	protected void doReleaseLock() {
		locker.releaseLock(identifiers, getName());
		identifiers.clear();
	}
	
}
