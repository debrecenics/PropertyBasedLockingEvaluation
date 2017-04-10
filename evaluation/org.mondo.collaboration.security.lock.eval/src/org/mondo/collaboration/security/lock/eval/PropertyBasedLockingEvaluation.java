package org.mondo.collaboration.security.lock.eval;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.incquery.patternlanguage.emf.EMFPatternLanguageStandaloneSetup;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.lock.PropertyBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserType;
import org.mondo.collaboration.security.lock.eval.user.pbl.UserType1PBL;
import org.mondo.collaboration.security.lock.eval.user.pbl.UserType2PBL;
import org.mondo.collaboration.security.lock.eval.user.pbl.UserType3PBL;
import org.mondo.collaboration.security.macl.xtext.AccessControlLanguageStandaloneSetup;
import org.mondo.collaboration.security.mpbl.xtext.MondoPropertyBasedLockingStandaloneSetup;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.PropertyBasedLockingModel;

import com.google.common.collect.Lists;

import wt.WtFactory;
import wt.WtPackage;

public class PropertyBasedLockingEvaluation extends Evaluation {
	
	static double ratio;
	
	public static void main(String[] args) throws IncQueryException, InvocationTargetException, InterruptedException {
		
		EMFPatternLanguageStandaloneSetup.doSetup();
		AccessControlLanguageStandaloneSetup.doSetup();
		MondoPropertyBasedLockingStandaloneSetup.doSetup();
		
		WtFactory.eINSTANCE.eClass();
		WtPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());		
		

		Configuration.domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
	    ResourceSet rset = Configuration.domain.getResourceSet();
	    Resource resource = rset.getResource(URI.createFileURI(Model()), true);
		URI lockFileUri = URI.createFileURI(System.getProperty("user.dir")+"/src/org/mondo/collaboration/security/lock/eval/user/pbl/locks.mpbl");
		URI queryFileUri = URI.createFileURI(System.getProperty("user.dir").replace("lock.eval", "query")+"/src/org/mondo/collaboration/security/query/lockQueries.eiq");
		ResourceSet lockResourceSet = new ResourceSetImpl();
		{
			lockResourceSet.getResource(queryFileUri, true);
			lockResourceSet.getResource(lockFileUri, true);
		}
		
		PropertyBasedLocker locker = new PropertyBasedLocker();
		locker.init((PropertyBasedLockingModel) lockResourceSet.getResource(lockFileUri, true).getContents().get(0), resource);
		
		
		
		List<UserType> users = Lists.newArrayList();
		for(int i = 1; i <= U(); i++) {
			char bind = getUniqueBinding(i,"c");
			UserType user = new UserType3PBL(locker, resource, "cycle"+bind, "userM"+i).init();
			user.setName("userM"+i);
			users.add(user);
		}
		for(int i = 1; i <= U(); i++) {
			char bind = getUniqueBinding(i,"t");
			UserType user = new UserType1PBL(locker, resource, "type"+bind, "userB"+i).init();
			user.setName("userB"+i);
			users.add(user);
		}
		for(int i = 1; i <= U(); i++) {
			char bind = getUniqueBinding(i,"v");
			UserType user = new UserType2PBL(locker, resource, "vendor"+bind, "userD"+i).init();
			user.setName("userD"+i);
			users.add(user);
		}
		
		simulate(users);
		
		int declined = 0;
		int accepted = 0;
		for (UserType user : users) {
			declined += user.getDeclined();
			accepted += user.getAccepted();
		}
		ratio = (double) accepted / (double)(accepted + declined);
//		System.out.println("P," + F() + "," + D() + "," + U() + "," + accepted + "," + declined);
	}
}
