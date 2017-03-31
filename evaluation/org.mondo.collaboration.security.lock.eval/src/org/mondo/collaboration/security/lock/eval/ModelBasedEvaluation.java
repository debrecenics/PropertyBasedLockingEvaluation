package org.mondo.collaboration.security.lock.eval;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.mondo.collaboration.security.lock.eval.lock.ModelBasedLocker;
import org.mondo.collaboration.security.lock.eval.user.mbl.UserTypeAMBL;
import org.mondo.collaboration.security.lock.eval.user.mbl.UserTypeBMBL;

import wt.Cycle;
import wt.WtFactory;
import wt.WtPackage;

public class ModelBasedEvaluation {

	
	public static void main(String[] args) throws InterruptedException {
		ModelBasedLocker locker = new ModelBasedLocker();
		
		String path = String.format("../org.mondo.collaboration.security.generator/instances/model-%04d-%04d.xmi".replace('/', File.separatorChar), Configuration.MODEL_SIZE, Configuration.VENDOR_SIZE);
		
		WtFactory.eINSTANCE.eClass();
		WtPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());		
		ResourceSet rset = new ResourceSetImpl();
		Resource resource = rset.getResource(URI.createFileURI(path), true);
		
		for(int i = 1; i <= Configuration.TypeA; i++) {
			Thread userA1 = new UserTypeAMBL(resource, Cycle.get(i), locker).init();
			userA1.setName("userA"+i);
			userA1.start();	
		}
		for(int i = 1; i <= Configuration.TypeB; i++) {
			Thread userB1 = new UserTypeBMBL(resource, "type."+(i%Configuration.VENDOR_SIZE), locker).init();
			userB1.setName("userB"+i);
			userB1.start();
		}
		for(int i = 1; i <= Configuration.TypeC; i++) {
			Thread userB1 = new UserTypeBMBL(resource, "vendor."+(i%Configuration.VENDOR_SIZE), locker).init();
			userB1.setName("userC"+i);
			userB1.start();
		}
	}
}
