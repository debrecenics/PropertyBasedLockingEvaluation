package org.mondo.collaboration.security.lock.eval;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.patternlanguage.emf.EMFPatternLanguageStandaloneSetup;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lens.bx.online.OnlineCollaborationSession;
import org.mondo.collaboration.security.lens.correspondence.EObjectCorrespondence.UniqueIDScheme;
import org.mondo.collaboration.security.lens.correspondence.EObjectCorrespondence.UniqueIDSchemeFactory;
import org.mondo.collaboration.security.lock.eval.user.UserType;
import org.mondo.collaboration.security.lock.eval.user.pbl.UserTypeAPBL;
import org.mondo.collaboration.security.lock.eval.user.pbl.UserTypeBPBL;
import org.mondo.collaboration.security.macl.xtext.AccessControlLanguageStandaloneSetup;
import org.mondo.collaboration.security.mpbl.xtext.MondoPropertyBasedLockingStandaloneSetup;

import com.google.common.collect.Lists;

import wt.Module;
import wt.Signal;
import wt.WtFactory;
import wt.WtPackage;

public class PropertyBasedEvaluation {
	
	public static void main(String[] args) throws IncQueryException, InvocationTargetException, InterruptedException {
		
		String path = String.format("C:/Work/Eclipse/Models17-locking/workspace/org.mondo.collaboration.security.generator/instances/model-%04d-%04d-%04d.xmi".replace('/', File.separatorChar), Configuration.MODEL_SIZE, Configuration.DEEP_SIZE, Configuration.VENDOR_SIZE);
		
		EMFPatternLanguageStandaloneSetup.doSetup();
		AccessControlLanguageStandaloneSetup.doSetup();
		MondoPropertyBasedLockingStandaloneSetup.doSetup();
		
		OnlineCollaborationSession.AUTO_SAVE = false;
		
		WtFactory.eINSTANCE.eClass();
		WtPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());		
		
		URI goldConfinementUri = URI.createFileURI(path);
		URI ruleFileUri = URI.createFileURI("C:/Work/Eclipse/Models17-locking/workspace/org.mondo.collaboration.security.lock.eval/src/org/mondo/collaboration/security/lock/eval/user/pbl/rules.macl");
		URI lockFileUri = URI.createFileURI("C:/Work/Eclipse/Models17-locking/workspace/org.mondo.collaboration.security.lock.eval/src/org/mondo/collaboration/security/lock/eval/user/pbl/locks.mpbl");
		URI queryFileUri = URI.createFileURI("C:/Work/Eclipse/Models17-locking/workspace/org.mondo.collaboration.security.query/src/org/mondo/collaboration/security/query/lockQueries.eiq");
		ResourceSet goldResourceSet = new ResourceSetImpl();
		{
			goldResourceSet.getResource(goldConfinementUri, true);
		}
		ResourceSet policyResourceSet = new ResourceSetImpl();
		{
			policyResourceSet.getResource(queryFileUri, true);
			policyResourceSet.getResource(ruleFileUri, true);
		}
		ResourceSet lockResourceSet = new ResourceSetImpl();
		{
			lockResourceSet.getResource(queryFileUri, true);
			lockResourceSet.getResource(lockFileUri, true);
		}
		
		OnlineCollaborationSession session = new OnlineCollaborationSession(
				goldConfinementUri, 
				goldResourceSet, 
				new UniqueIDSchemeFactoryImplementation(), 
				policyResourceSet.getResource(ruleFileUri, true), 
				lockResourceSet.getResource(lockFileUri, true), "super", "dummy_password");	
		
		List<UserType> users = Lists.newArrayList();
		for(int i = 1; i <= Configuration.TypeA; i++) {
			URI front = URI.createFileURI(String.format("C:/Work/Eclipse/Models17-locking/workspace/org.mondo.collaboration.security.generator/instances/model-%04d-%04d-front-%s.xmi".replace('/', File.separatorChar), Configuration.MODEL_SIZE, Configuration.VENDOR_SIZE, "userA"+i));
			UserType user = new UserTypeAPBL(session, "cycle."+(i%Configuration.VENDOR_SIZE), "userA"+i, front).init();
			user.setName("userA"+i);
			user.start();
			users.add(user);
		}
		for(int i = 1; i <= Configuration.TypeB; i++) {
			URI front = URI.createFileURI(String.format("C:/Work/Eclipse/Models17-locking/workspace/org.mondo.collaboration.security.generator/instances/model-%04d-%04d-front-%s.xmi".replace('/', File.separatorChar), Configuration.MODEL_SIZE, Configuration.VENDOR_SIZE, "userB"+i));
			UserType user = new UserTypeBPBL(session, "type."+(i%Configuration.VENDOR_SIZE), "userB"+i, front).init();
			user.setName("userB"+i);
			user.start();
			users.add(user);
			}
		for(int i = 1; i <= Configuration.TypeC; i++) {
			URI front = URI.createFileURI(String.format("C:/Work/Eclipse/Models17-locking/workspace/org.mondo.collaboration.security.generator/instances/model-%04d-%04d-front-%s.xmi".replace('/', File.separatorChar), Configuration.MODEL_SIZE, Configuration.VENDOR_SIZE, "userC"+i));
			UserType user = new UserTypeBPBL(session, "vendor."+(i%Configuration.VENDOR_SIZE), "userC"+i, front).init();
			user.setName("userC"+i);
			user.start();
			users.add(user);
		}
		
		int declined = 0;
		int accepted = 0;
		for (UserType user : users) {
			user.join();
			declined += user.getDeclined();
			accepted += user.getAccepted();
		}
		
		Logger.getGlobal().info(String.format("Accepted: %d Declined %d", accepted, declined));
	}
	
	private static final class UniqueIDSchemeFactoryImplementation implements UniqueIDSchemeFactory {
		@Override
		public UniqueIDScheme apply(URI arg0) {
			return new UniqueIDScheme() {
				
				@Override
				public Object apply(EObject arg0) {
					if(arg0 instanceof Module) {
						Module module = (Module) arg0;
						return module.getId();
					}
					else if(arg0 instanceof Signal) {
						Signal signal = (Signal) arg0;
						return signal.getId();
					}
					return null;
				}
				
				@Override
				public void setUniqueId(EObject target, Object uniqueId) {
					
				}
				
				@Override
				public Object generateUniqueId(EObject input, Set<Object> reserved) {
					return null;
				}
			};
		}
	}
	
}
