package org.mondo.collaboration.security.lock.eval;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

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
import org.mondo.collaboration.security.lock.eval.user.pbl.UserTypeAPBL;
import org.mondo.collaboration.security.lock.eval.user.pbl.UserTypeBPBL;
import org.mondo.collaboration.security.macl.xtext.AccessControlLanguageStandaloneSetup;
import org.mondo.collaboration.security.mpbl.xtext.MondoPropertyBasedLockingStandaloneSetup;

import wt.Cycle;
import wt.Module;
import wt.Signal;
import wt.WtFactory;
import wt.WtPackage;

public class PropertyBasedEvaluation {
	
	public static void main(String[] args) throws IncQueryException, InvocationTargetException, InterruptedException {
		
		String path = String.format("C:/Work/Eclipse/Models17-locking/workspace/org.mondo.collaboration.security.generator/instances/model-%04d-%04d.xmi".replace('/', File.separatorChar), Configuration.MODEL_SIZE, Configuration.VENDOR_SIZE);
		
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
		
		for(int i = 1; i <= Configuration.TypeA; i++) {
			URI front = URI.createFileURI(String.format("C:/Work/Eclipse/Models17-locking/workspace/org.mondo.collaboration.security.generator/instances/model-%04d-%04d-front-%s.xmi".replace('/', File.separatorChar), Configuration.MODEL_SIZE, Configuration.VENDOR_SIZE, "userA"+i));
			Thread userA1 = new UserTypeAPBL(session, Cycle.get(i), "userB"+i, front).init();
			userA1.setName("userA"+i);
			userA1.start();	
		}
		for(int i = 1; i <= Configuration.TypeB; i++) {
			URI front = URI.createFileURI(String.format("C:/Work/Eclipse/Models17-locking/workspace/org.mondo.collaboration.security.generator/instances/model-%04d-%04d-front-%s.xmi".replace('/', File.separatorChar), Configuration.MODEL_SIZE, Configuration.VENDOR_SIZE, "userB"+i));
			Thread userB1 = new UserTypeBPBL(session, "type."+(i%Configuration.VENDOR_SIZE), "userB"+i, front).init();
			userB1.setName("userB"+i);
			userB1.start();
		}
		for(int i = 1; i <= Configuration.TypeC; i++) {
			URI front = URI.createFileURI(String.format("C:/Work/Eclipse/Models17-locking/workspace/org.mondo.collaboration.security.generator/instances/model-%04d-%04d-front-%s.xmi".replace('/', File.separatorChar), Configuration.MODEL_SIZE, Configuration.VENDOR_SIZE, "userC"+i));
			Thread userB1 = new UserTypeBPBL(session, "vendor."+(i%Configuration.VENDOR_SIZE), "userB"+i, front).init();
			userB1.setName("userC"+i);
			userB1.start();
		}
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
