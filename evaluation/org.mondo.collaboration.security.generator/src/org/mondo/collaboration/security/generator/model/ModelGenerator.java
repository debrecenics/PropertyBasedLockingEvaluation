package org.mondo.collaboration.security.generator.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.google.common.collect.Lists;

import wt.Composite;
import wt.Control;
import wt.Signal;
import wt.WtFactory;

public class ModelGenerator {

	public static final String[] ABC = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	public static final String DUMMY = "Dummy";
	
	static Iterator<String> vendorIterator;// = vendorMap.iterator();
	static Iterator<String> cycleIterator;// = cycleMap.iterator();
	static Iterator<String> typeIterator;// = typeMap.iterator();
	
	public static Composite generate(int fragmentSize, int userSize, int deepSize) {
		Composite root = WtFactory.eINSTANCE.createComposite();
		root.setVendor("vendor.root");
		
		vendorIterator = vendorMap.iterator();
		cycleIterator = cycleMap.iterator();
		typeIterator = typeMap.iterator();
		
		
		for (int currentFragment = 0; currentFragment < fragmentSize; currentFragment++) {
			createfragment(root, currentFragment, userSize, deepSize, 0);
		}
		return root;
	}

	private static void createfragment(Composite root, int currentFragment, int userSize, int deepSize, int currentDeep) {
		
		Composite composite = WtFactory.eINSTANCE.createComposite();
		composite.setVendor(String.format("vendor%s", vendorIterator.next()));

		createContainer(currentFragment, userSize, composite, 1, vendorIterator, cycleIterator, typeIterator);
		createContainer(currentFragment, userSize, composite, 2, vendorIterator, cycleIterator, typeIterator);
		createContainer(currentFragment, userSize, composite, 1, vendorIterator, cycleIterator, typeIterator);
		
		root.getSubmodules().add(composite);
		
		if(deepSize > currentDeep+1)
			createfragment(composite, currentFragment, userSize, deepSize, currentDeep+1);
	}

	private static void createContainer(int currentFragment, int userSize, Composite composite, int noControls, Iterator<String> vendorIterator, Iterator<String> cycleIterator, Iterator<String> typeIterator ) {
		Composite container = WtFactory.eINSTANCE.createComposite();
		container.setVendor(String.format("vendor%s", vendorIterator.next()));
		for(int i = 0; i < noControls; i++)	createControlUnits(container, cycleIterator, typeIterator);
		composite.getSubmodules().add(container);
	}

	private static void createControlUnits(Composite container, Iterator<String> cycleIterator, Iterator<String> typeIterator) {
		Control control = WtFactory.eINSTANCE.createControl();
		control.setCycle(String.format("cycle%s", cycleIterator.next()));
		control.setType(String.format("type%s", typeIterator.next()));
		createSignals(container, control);
		container.getSubmodules().add(control);			
	}

	private static void createSignals(Composite container, Control control) {
		Signal signal = WtFactory.eINSTANCE.createSignal();
		signal.setFrequency(ThreadLocalRandom.current().nextInt(1, 11));
		
		control.getProvides().add(signal);
		container.getConsumes().add(signal);		
	}
    //	   Fragment  Deep  Structure
	static List<String> cycleMap = Lists.newArrayList();
	static List<String> typeMap = Lists.newArrayList();
	static List<String> vendorMap = Lists.newArrayList();
	
	public static void preGenerateAttributes(int maxD, int maxF, int maxU) {
		cycleMap.clear(); typeMap.clear();
		cycleMap = raffleValues(maxD, maxF, maxU,4);
		typeMap = raffleValues(maxD, maxF, maxU,4);
		vendorMap = raffleValues(maxD, maxF, maxU,4);
	}


	private static List<String> raffleValues(int maxD, int maxF, int maxU, int multiplier) {
		List<String> list = Lists.newArrayList();
		for(int u = 1; u <= maxU; list.add(new String(ABC[u])), u++);
		for(int u = 1; u <= maxU; list.add(new String(ABC[u])), u++);
		for(int u = 1; u <= maxU; list.add(new String(ABC[u])), u++);
		for(int u = 1; u <= maxU; list.add(new String(ABC[u])), u++);
		
		while(list.size() < maxD * maxF * multiplier) {
			list.add(DUMMY);
		}
		
//		for(int fragment = 0; fragment < maxF; fragment++) {
//			List<List<String>> deepList = Lists.newArrayList();
//			for(int deep = 0; deep < maxD; deep++) {
//				List<String> list = Lists.newArrayList();
//				for(int u = 1; u <= maxU; list.add(new String(ABC[u])), u++);
//				Collections.shuffle(list);
//				
//				List<String> coreList = Lists.newArrayList();
//				for(int i = 0; i < 5; i++) {
//					coreList.add(list.get(i));
//				}
//				deepList.add(coreList);
//			}
//			fragmentList.add(deepList);
//		}
		Collections.shuffle(list);
		return list;
	}
}
