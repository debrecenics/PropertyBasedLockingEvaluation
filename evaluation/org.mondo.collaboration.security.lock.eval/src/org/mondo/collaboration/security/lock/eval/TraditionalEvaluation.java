package org.mondo.collaboration.security.lock.eval;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.mondo.collaboration.security.lock.eval.lock.TraditionalLocker;
import org.mondo.collaboration.security.lock.eval.user.UserType;
import org.mondo.collaboration.security.lock.eval.user.trd.UserTypeATRD;
import org.mondo.collaboration.security.lock.eval.user.trd.UserTypeBTRD;

import com.google.common.collect.Lists;

import wt.WtFactory;
import wt.WtPackage;

public class TraditionalEvaluation {

	public static void main(String[] args) throws InterruptedException {
		
		TraditionalLocker locker = new TraditionalLocker();
		
		String path = String.format("../org.mondo.collaboration.security.generator/instances/model-%04d-%04d.xmi".replace('/', File.separatorChar), Configuration.MODEL_SIZE, Configuration.DEEP_SIZE, Configuration.VENDOR_SIZE);
		
		WtFactory.eINSTANCE.eClass();
		WtPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());		
		ResourceSet rset = new ResourceSetImpl();
		Resource resource = rset.getResource(URI.createFileURI(path), true);
		resource.eAdapters().add(new TraditionalLocker.LockAdapter(locker));
		
		List<UserType> users = Lists.newArrayList();
		for(int i = 1; i <= Configuration.TypeA; i++) {
			UserType user = new UserTypeATRD(resource, "cycle."+(i%Configuration.VENDOR_SIZE), locker).init();
			user.setName("userA"+i);
			user.start();
			users.add(user);
		}
		for(int i = 1; i <= Configuration.TypeB; i++) {
			UserType user = new UserTypeBTRD(resource, "type."+(i%Configuration.VENDOR_SIZE), locker).init();
			user.setName("userB"+i);
			user.start();
			users.add(user);
		}
		for(int i = 1; i <= Configuration.TypeC; i++) {
			UserType user = new UserTypeBTRD(resource, "vendor."+(i%Configuration.VENDOR_SIZE), locker).init();
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
}
