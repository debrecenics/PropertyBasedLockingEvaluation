package org.mondo.collaboration.security.lock.eval.user.fbl;

import org.eclipse.emf.ecore.EObject;

public class UtilityFBL {

	public static EObject getFragment(EObject object) {
		if(object.eContainer() == null) 
			return null;
		EObject parent = object.eContainer();
		if(parent.eContainer() == null) 
			return parent;
		return getFragment(parent);
	}
	
}
