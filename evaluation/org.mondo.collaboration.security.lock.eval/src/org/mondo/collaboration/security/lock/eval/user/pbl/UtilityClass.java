package org.mondo.collaboration.security.lock.eval.user.pbl;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.PropertyBasedLocker;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.Binding;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.Lock;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.MondoPropertyBasedLockingFactory;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.PropertyBasedLockingModel;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.Role;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.User;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.ValueBind;

public class UtilityClass {

	public static Lock buildLock(String name, String pattern, Map<String,String> bindings, PropertyBasedLocker locker) {
		Lock lock = MondoPropertyBasedLockingFactory.eINSTANCE.createLock();
		lock.setOwner(getUser(name, locker));
		lock.setPattern(getPattern(pattern, locker));
		for (String param : bindings.keySet()) {
			Binding binding = MondoPropertyBasedLockingFactory.eINSTANCE.createBinding();
			binding.setParam(getPattern(pattern, locker).getParameters().stream().filter((var) -> var.getName().equals(param)).findFirst().get());
			ValueBind valueBind = MondoPropertyBasedLockingFactory.eINSTANCE.createValueBind();
			valueBind.setValue(bindings.get(param));
			binding.setValue(valueBind);
			lock.getBindings().add(binding);
		}
		return lock;
	}

	private static Pattern getPattern(String patternName, PropertyBasedLocker locker) {
		Resource queryResource = locker.getLockingModel().eResource().getResourceSet().getResources().get(0);
		EObject eObject = queryResource.getContents().get(0);
		PatternModel patternModel = (PatternModel) eObject;
		for (Pattern pattern : patternModel.getPatterns()) {
			if(pattern.getName().equals(patternName))
				return pattern;
		}
		return null;
	}

	private static User getUser(String name, PropertyBasedLocker locker) {
		PropertyBasedLockingModel lockModel = locker.getLockingModel();
		for (Role role : lockModel.getRoles()) {
			if(role instanceof User) {
				User user = (User) role;
				if(user.getName().equals(name));
					return user;
			}
		}
		return null;
	}
	
	public static void acquireLock(PropertyBasedLocker locker, Lock lock) throws IncQueryException {
		PropertyBasedLockingModel lockModel = locker.getLockingModel();
		lockModel.getLocks().add(lock);
		locker.reinitializeWith(lockModel);
//		System.out.println(String.format("%s acquired locks for %s", lock.getOwner().getName(), lock.getPattern().getName()));
	}

	public static void releaseLock(PropertyBasedLocker locker, Lock lock) throws IncQueryException {
		PropertyBasedLockingModel lockModel = locker.getLockingModel();
		lockModel.getLocks().remove(lock);
		locker.reinitializeWith(lockModel);
		//		System.out.println(String.format("%s released locks for %s", lock.getOwner().getName(), lock.getPattern().getName()));
	}
	
}
