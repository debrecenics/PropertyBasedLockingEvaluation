package org.mondo.collaboration.security.generator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.mondo.collaboration.security.generator.model.ModelGenerator;

import com.google.common.collect.Lists;

import wt.Composite;
import wt.Module;
import wt.Signal;

public class Generators {

	private static HashMap<String, String> mainArgs;

	public static void main(String[] args) throws Exception {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());	
		processArgs(args);
		if(mainArgs.containsKey("F") && mainArgs.containsKey("D") && mainArgs.containsKey("U")) {
			generateModel(F(), D(), U());
		} else {
			generateModels();
		}
	}
	
	protected static void processArgs(String[] args) {
		mainArgs = new HashMap<String,String>();

		for(int i=0;i<args.length;i++){
			if(args[i].trim().startsWith("-F"))
				mainArgs.put("F",args[i+1]);
			if(args[i].trim().startsWith("-D"))
				mainArgs.put("D",args[i+1]);
			if(args[i].trim().startsWith("-U"))
				mainArgs.put("U",args[i+1]);
		}		
	}
	
	protected static int F() {
		return Integer.valueOf(mainArgs.get("F"));
	}
	
	protected static int D() {
		return Integer.valueOf(mainArgs.get("D"));
	}
	
	protected static int U() {
		return Integer.valueOf(mainArgs.get("U"));
	}
	
	public static void generateModels() throws Exception {
		int[] users = {1,3,6,9};
		int[] fragments = {1,3,6,9,12,15,18};
		int[] deeps = {1,3,6,9,12,15,18};
		
		for(int u = 0; u < users.length; u++)
			for(int f = 0; f < fragments.length; f++) 
				for(int d = 0; d < deeps.length; d++) {
					generateModel(fragments[f], deeps[d], users[u]);
				}
	}
	
	private static void generateModel(int f, int d, int u) throws Exception {
		Composite model = ModelGenerator.generate(f,d,u);
		save(	String.format(System.getProperty("user.dir") + "/instances/model-%04d-%04d-%04d.xmi".replace('/', File.separatorChar), f,d,u), 
				model);
		
		CharSequence yed = calculateYed(model);
		save(	String.format(System.getProperty("user.dir") + "/instances/model-%04d-%04d-%04d.gml".replace('/', File.separatorChar), f,d,u), 
				yed);
	}
	
	private static CharSequence calculateYed(Composite model) {
		Model2Yed yed = new Model2Yed();
		List<EObject> objects = Lists.newArrayList(model.eAllContents());
		objects.add(model);
		CharSequence sequence = yed.transform(objects);
		return sequence;
	}
	
	private static void save(String path, Composite model) throws IOException {
		ResourceSet rset = new ResourceSetImpl();
		Resource resource = rset.createResource(URI.createFileURI(path));
		resource.getContents().add(model);
		TreeIterator<EObject> iterator = resource.getAllContents();
		int i = 0;
		while (iterator.hasNext()) {
			EObject eObject = (EObject) iterator.next();
			if(eObject instanceof Module) {
				Module module = (Module) eObject;
				module.setId(String.valueOf(i++));
			} else if (eObject instanceof Signal) {
				Signal signal = (Signal) eObject;
				signal.setId(String.valueOf(i++));
			} else {
				throw new IllegalArgumentException();
			}
		}
		resource.save(null);
	}
	
	public static void save(String path, CharSequence sequence) throws Exception {
		try(  PrintWriter out = new PrintWriter( path )  ){
		    out.println( sequence.toString() );
		}
	}
}
