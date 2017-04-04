package org.mondo.collaboration.security.generator.model;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.google.common.collect.Lists;

import wt.Composite;
import wt.Control;
import wt.Signal;
import wt.WtFactory;

public class ModelGenerator {

	static List<Integer> cycle = Lists.newArrayList();
//	static List<Integer> vendor = Lists.newArrayList();
	static List<Integer> type = Lists.newArrayList();
	
	private static int getNext(List<Integer> list, int vendors) {
		if(list.isEmpty()) {
			for(int i = 1; i <= vendors; list.add(new Integer(i)), i++);
			Collections.shuffle(list);
		}
		return list.get(0);
	}
	
	
	public static Composite generate(int size, int vendors, int deep) {
		Composite root = WtFactory.eINSTANCE.createComposite();
//		root.setId("root");
		root.setVendor("vendor.root");
		for (int submodule = 1; submodule <= size; submodule++) {
			createSubmodule(root, submodule, vendors, deep, 1);
		}
		return root;
	}

	private static void createSubmodule(Composite root, int submodule, int vendors, int maxDeep, int currentDeep) {
		Composite composite = WtFactory.eINSTANCE.createComposite();
//		composite.setId(String.format("submodule.%d.%d", submodule, 1));
		composite.setVendor(String.format("vendor.%d", submodule%vendors+1));

		createContainer(submodule, vendors, composite, 2, 1);
		createContainer(submodule, vendors, composite, 3, 2);
		createContainer(submodule, vendors, composite, 4, 1);
		
		root.getSubmodules().add(composite);
		
		if(maxDeep != currentDeep)
			createSubmodule(composite, submodule, vendors, maxDeep, currentDeep+1);
	}

	private static void createContainer(int submodule, int vendors, Composite composite, int id, int ctrls) {
		Composite container = WtFactory.eINSTANCE.createComposite();
//		container.setId(String.format("container.%d.%d", submodule, id));
		container.setVendor(String.format("vendor.%d", submodule%vendors+1));
		
		for(int i = 0; i < ctrls; i++)	createControlUnits(container, submodule, i, vendors);
		
		composite.getSubmodules().add(container);
	}

	private static void createControlUnits(Composite container, int submodule, int i, int vendors) {
		Control control = WtFactory.eINSTANCE.createControl();
//		control.setId(String.format("control.%d.%d.%d", submodule, id, i));
		control.setCycle(String.format("cycle.%d", getNext(cycle,vendors)));
		cycle.remove(0);
		control.setType(String.format("type.%d", getNext(type,vendors)));
		type.remove(0);
		
		createSignals(container, control, submodule, i);
		
		container.getSubmodules().add(control);			
	}

	private static void createSignals(Composite container, Control control, int submodule, int i) {
		Signal signal = WtFactory.eINSTANCE.createSignal();
//		signal.setId(String.format("signal.%d.%d.%d", submodule, id, i));
		signal.setFrequency(ThreadLocalRandom.current().nextInt(1, 11));
		
		control.getProvides().add(signal);
		container.getConsumes().add(signal);		
	}
}
