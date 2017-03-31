package org.mondo.collaboration.security.lock.eval.user.pbl;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lens.bx.online.OnlineCollaborationSession;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.Binding;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.Lock;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.MondoPropertyBasedLockingFactory;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.PropertyBasedLockingModel;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.Role;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.User;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.ValueBind;

public class UtilityClass {

	public static Lock buildLock(String name, String pattern, Map<String,String> bindings, OnlineCollaborationSession session) {
		Lock lock = MondoPropertyBasedLockingFactory.eINSTANCE.createLock();
		lock.setOwner(getUser(name, session));
		lock.setPattern(getPattern(pattern,session));
		for (String param : bindings.keySet()) {
			Binding binding = MondoPropertyBasedLockingFactory.eINSTANCE.createBinding();
			binding.setParam(getPattern(pattern, session).getParameters().stream().filter((var) -> var.getName().equals(param)).findFirst().get());
			ValueBind valueBind = MondoPropertyBasedLockingFactory.eINSTANCE.createValueBind();
			valueBind.setValue(bindings.get(param));
			binding.setValue(valueBind);
			lock.getBindings().add(binding);
		}
		return lock;
	}

	private static Pattern getPattern(String patternName, OnlineCollaborationSession session) {
		Resource queryResource = session.getLockResource().getResourceSet().getResources().get(0);
		EObject eObject = queryResource.getContents().get(0);
		PatternModel patternModel = (PatternModel) eObject;
		for (Pattern pattern : patternModel.getPatterns()) {
			if(pattern.getName().equals(patternName))
				return pattern;
		}
		return null;
	}

	private static User getUser(String name, OnlineCollaborationSession session) {
		EObject eObject = session.getLockResource().getContents().get(0);
		PropertyBasedLockingModel lockModel = (PropertyBasedLockingModel) eObject;
		for (Role role : lockModel.getRoles()) {
			if(role instanceof User) {
				User user = (User) role;
				if(user.getName().equals(name));
					return user;
			}
		}
		return null;
	}
	
	public static void acquireLock(OnlineCollaborationSession session, Lock lock) throws IncQueryException {
		EObject eObject = session.getLockResource().getContents().get(0);
		PropertyBasedLockingModel lockModel = (PropertyBasedLockingModel) eObject;
		lockModel.getLocks().add(lock);
		session.reinitializeWith(session.getPolicyResource(), session.getLockResource());
		System.out.println(String.format("%s acquired locks for %s", lock.getOwner().getName(), lock.getPattern().getName()));
	}

	public static void releaseLock(OnlineCollaborationSession session, Lock lock) throws IncQueryException {
		EObject eObject = session.getLockResource().getContents().get(0);
		PropertyBasedLockingModel lockModel = (PropertyBasedLockingModel) eObject;
		lockModel.getLocks().remove(lock);
		session.reinitializeWith(session.getPolicyResource(), session.getLockResource());
		System.out.println(String.format("%s released locks for %s", lock.getOwner().getName(), lock.getPattern().getName()));
	}
	
}
