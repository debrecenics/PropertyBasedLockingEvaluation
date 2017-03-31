package org.mondo.collaboration.security.generator.model;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.google.common.collect.Lists;

import wt.Composite;
import wt.Control;
import wt.Cycle;
import wt.Signal;
import wt.WtFactory;

public class ModelGenerator {

	public static Composite generate(int size, int vendors) {
		Composite root = WtFactory.eINSTANCE.createComposite();
//		root.setId("root");
		root.setVendor("vendor.root");
		for (int submodule = 1; submodule <= size; submodule++) {
			createSubmodule(root, submodule, vendors);
		}
		return root;
	}

	private static void createSubmodule(Composite root, int submodule, int vendors) {
		Composite composite = WtFactory.eINSTANCE.createComposite();
//		composite.setId(String.format("submodule.%d.%d", submodule, 1));
		composite.setVendor(String.format("vendor.%d", submodule%vendors+1));

		List<Cycle> cycles = Lists.newArrayList(Cycle.LOW, Cycle.LOW, Cycle.HIGH, Cycle.MEDIUM);
		Collections.shuffle(cycles);
		
		createContainer(submodule, vendors, composite, 2, 1, cycles);
		createContainer(submodule, vendors, composite, 3, 2, cycles);
		createContainer(submodule, vendors, composite, 4, 1, cycles);
		
		
		root.getSubmodules().add(composite);
	}

	private static void createContainer(int submodule, int vendors, Composite composite, int id, int ctrls, List<Cycle> cycles) {
		Composite container = WtFactory.eINSTANCE.createComposite();
//		container.setId(String.format("container.%d.%d", submodule, id));
		container.setVendor(String.format("vendor.%d", ((submodule-1)*3+id)%vendors+1));
		
		for(int i = 0; i < ctrls; i++)	createControlUnits(container, submodule, i, cycles, vendors);
		
		composite.getSubmodules().add(container);
	}

	private static void createControlUnits(Composite container, int submodule, int i, List<Cycle> cycles, int vendors) {
		Control control = WtFactory.eINSTANCE.createControl();
//		control.setId(String.format("control.%d.%d.%d", submodule, id, i));
		control.setCycle(cycles.get(0));
		control.setType(String.format("type.%d", vendors-(((submodule-1)*4+i)%vendors)));
		cycles.remove(0);
		
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
