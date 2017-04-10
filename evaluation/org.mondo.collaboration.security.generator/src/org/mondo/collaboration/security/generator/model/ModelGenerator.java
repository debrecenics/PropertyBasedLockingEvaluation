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

	public static final char[] ABC = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	
	public static Composite generate(int fragmentSize, int userSize, int deepSize) {
		Composite root = WtFactory.eINSTANCE.createComposite();
		root.setVendor("vendor.root");
		for (int currentFragment = 0; currentFragment < fragmentSize; currentFragment++) {
			createfragment(root, currentFragment, userSize, deepSize, 0);
		}
		return root;
	}

	private static void createfragment(Composite root, int currentFragment, int userSize, int deepSize, int currentDeep) {
		Iterator<Character> vendorIterator = vendorMap.get(currentFragment).get(currentDeep).iterator();
		Iterator<Character> cycleIterator = cycleMap.get(currentFragment).get(currentDeep).iterator();
		Iterator<Character> typeIterator = typeMap.get(currentFragment).get(currentDeep).iterator();
		
		Composite composite = WtFactory.eINSTANCE.createComposite();
		composite.setVendor(String.format("vendor%c", vendorIterator.next()));

		createContainer(currentFragment, userSize, composite, 1, vendorIterator, cycleIterator, typeIterator);
		createContainer(currentFragment, userSize, composite, 2, vendorIterator, cycleIterator, typeIterator);
		createContainer(currentFragment, userSize, composite, 1, vendorIterator, cycleIterator, typeIterator);
		
		root.getSubmodules().add(composite);
		
		if(deepSize > currentDeep+1)
			createfragment(composite, currentFragment, userSize, deepSize, currentDeep+1);
	}

	private static void createContainer(int currentFragment, int userSize, Composite composite, int noControls, Iterator<Character> vendorIterator, Iterator<Character> cycleIterator, Iterator<Character> typeIterator ) {
		Composite container = WtFactory.eINSTANCE.createComposite();
		container.setVendor(String.format("vendor%c", vendorIterator.next()));
		for(int i = 0; i < noControls; i++)	createControlUnits(container, cycleIterator, typeIterator);
		composite.getSubmodules().add(container);
	}

	private static void createControlUnits(Composite container, Iterator<Character> cycleIterator, Iterator<Character> typeIterator) {
		Control control = WtFactory.eINSTANCE.createControl();
		control.setCycle(String.format("cycle%c", cycleIterator.next()));
		control.setType(String.format("type%c", typeIterator.next()));
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
	static List<     List< List<Character>>>  cycleMap = Lists.newArrayList();
	static List<     List< List<Character>>>  typeMap = Lists.newArrayList();
	static List<     List< List<Character>>>  vendorMap = Lists.newArrayList();
	
	public static void preGenerateAttributes(int maxD, int maxF, int maxU) {
		cycleMap.clear(); typeMap.clear();
		cycleMap = raffleValues(maxD, maxF, maxU);
		typeMap = raffleValues(maxD, maxF, maxU);
		vendorMap = raffleValues(maxD, maxF, maxU);
	}


	private static List<List<List<Character>>> raffleValues(int maxD, int maxF, int maxU) {
		List<List<List<Character>>> fragmentList = Lists.newArrayList();
		for(int fragment = 0; fragment < maxF; fragment++) {
			List<List<Character>> deepList = Lists.newArrayList();
			for(int deep = 0; deep < maxD; deep++) {
				List<Character> list = Lists.newArrayList();
				for(int u = 1; u <= maxU; list.add(new Character(ABC[u])), u++);
				Collections.shuffle(list);
				
				List<Character> coreList = Lists.newArrayList();
				for(int i = 0; i < 5; i++) {
					coreList.add(list.get(i));
				}
				deepList.add(coreList);
			}
			fragmentList.add(deepList);
		}
		return fragmentList;
	}
}
