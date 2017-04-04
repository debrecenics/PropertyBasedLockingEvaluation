package org.mondo.collaboration.security.lock.eval;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.mondo.collaboration.security.lock.eval.lock.FileBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.UserType;
import org.mondo.collaboration.security.lock.eval.user.fbl.UserTypeBFBL;
import org.mondo.collaboration.security.lock.eval.user.fbl.UserTypeDFBL;
import org.mondo.collaboration.security.lock.eval.user.fbl.UserTypeMFBL;

import com.google.common.collect.Lists;

import wt.WtFactory;
import wt.WtPackage;

public class FileBasedLockingEvaluation extends Evaluation {

	public static void main(String[] args) throws InterruptedException {
		
		FileBasedLocker locker = new FileBasedLocker();
		
		WtFactory.eINSTANCE.eClass();
		WtPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());		
		Configuration.domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
	    ResourceSet rset = Configuration.domain.getResourceSet();
	    Resource resource = rset.getResource(URI.createFileURI(Model()), true);
		
		List<UserType> users = Lists.newArrayList();
		for(int i = 1; i <= U(); i++) {
			int bind = i%U() == 0 ? U() : i%U();
			UserType user = new UserTypeMFBL(resource, "cycle."+bind, locker).init();
			user.setName("userM"+i);
			users.add(user);
		}
		for(int i = 1; i <= U(); i++) {
			int bind = i%U() == 0 ? U() : i%U();
			UserType user = new UserTypeBFBL(resource, "type."+bind, locker).init();
			user.setName("userB"+i);
			users.add(user);
		}
		for(int i = 1; i <= U(); i++) {
			int bind = i%U() == 0 ? U() : i%U();
			UserType user = new UserTypeDFBL(resource, "vendor."+bind, locker).init();
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
		
		System.out.println(F() + ";" + D() + ";" + U() + ";" + accepted + ";" + declined);
	}
}
