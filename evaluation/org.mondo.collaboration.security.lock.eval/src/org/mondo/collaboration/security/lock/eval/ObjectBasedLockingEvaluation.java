package org.mondo.collaboration.security.lock.eval;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.mondo.collaboration.security.lock.eval.lock.ObjectBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserType;
import org.mondo.collaboration.security.lock.eval.user.obl.UserType1OBL;
import org.mondo.collaboration.security.lock.eval.user.obl.UserType2OBL;
import org.mondo.collaboration.security.lock.eval.user.obl.UserType3OBL;

import com.google.common.collect.Lists;

import wt.WtFactory;
import wt.WtPackage;

public class ObjectBasedLockingEvaluation extends Evaluation {

	
	static double ratio;

	public static void main(String[] args) throws InterruptedException {
		ObjectBasedLocker locker = new ObjectBasedLocker();
		
		WtFactory.eINSTANCE.eClass();
		WtPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());		

		Configuration.domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
	    ResourceSet rset = Configuration.domain.getResourceSet();
	    Resource resource = rset.getResource(URI.createFileURI(Model()), true);
		
		List<UserType> users = Lists.newArrayList();
		for(int i = 1; i <= U(); i++) {
			char bind = getUniqueBinding(i,"t");
			UserType user = new UserType1OBL(resource, "type"+bind, locker).init();
			user.setName("userT"+i);
			users.add(user);
		}
		for(int i = 1; i <= U(); i++) {
			char bind = getUniqueBinding(i,"v");
			UserType user = new UserType2OBL(resource, "vendor"+bind, locker).init();
			user.setName("userR"+i);
			users.add(user);
		}
		for(int i = 1; i <= U(); i++) {
			char bind = getUniqueBinding(i,"c");
			UserType user = new UserType3OBL(resource, "cycle"+bind, locker).init();
			user.setName("userM"+i);
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
		//System.out.println("O," + F() + "," + D() + "," + U() + "," + accepted + "," + declined);
	}
}
