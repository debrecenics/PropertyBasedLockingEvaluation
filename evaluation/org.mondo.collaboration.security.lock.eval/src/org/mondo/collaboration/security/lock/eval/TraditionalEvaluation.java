package org.mondo.collaboration.security.lock.eval;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.mondo.collaboration.security.lock.eval.lock.TraditionalLocker;
import org.mondo.collaboration.security.lock.eval.user.trd.UserTypeATRD;
import org.mondo.collaboration.security.lock.eval.user.trd.UserTypeBTRD;

import wt.Cycle;
import wt.WtFactory;
import wt.WtPackage;

public class TraditionalEvaluation {

	public static void main(String[] args) throws InterruptedException {
		
		TraditionalLocker locker = new TraditionalLocker();
		
		String path = String.format("../org.mondo.collaboration.security.generator/instances/model-%04d-%04d.xmi".replace('/', File.separatorChar), Configuration.MODEL_SIZE, Configuration.VENDOR_SIZE);
		
		WtFactory.eINSTANCE.eClass();
		WtPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());		
		ResourceSet rset = new ResourceSetImpl();
		Resource resource = rset.getResource(URI.createFileURI(path), true);
		resource.eAdapters().add(new TraditionalLocker.LockAdapter(locker));
		
		for(int i = 1; i <= Configuration.TypeA; i++) {
			Thread userA1 = new UserTypeATRD(resource, Cycle.get(i), locker).init();
			userA1.setName("userA"+i);
			userA1.start();	
		}
		for(int i = 1; i <= Configuration.TypeB; i++) {
			Thread userB1 = new UserTypeBTRD(resource, "type."+(i%Configuration.VENDOR_SIZE), locker).init();
			userB1.setName("userB"+i);
			userB1.start();
		}
		for(int i = 1; i <= Configuration.TypeC; i++) {
			Thread userB1 = new UserTypeBTRD(resource, "vendor."+(i%Configuration.VENDOR_SIZE), locker).init();
			userB1.setName("userC"+i);
			userB1.start();
		}
		
	}
	
}
