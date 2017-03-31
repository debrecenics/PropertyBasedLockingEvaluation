package org.mondo.collaboration.security.generator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

	public static void main(String[] args) throws Exception {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());		
		generateModels();
	}
	
	public static void generateModels() throws Exception {
		int[] users = {3};
		int[] sizes = {3};
		
		for(int u = 0; u < users.length; u++)
			for(int s = 0; s < sizes.length; s++) {
			Composite model = ModelGenerator.generate(sizes[s], users[u]);
			save(	String.format(System.getProperty("user.dir") + "/instances/model-%04d-%04d.xmi".replace('/', File.separatorChar), sizes[s], users[u]), 
					model);
			
			CharSequence yed = calculateYed(model);
			save(	String.format(System.getProperty("user.dir") + "/instances/model-%04d-%04d.gml".replace('/', File.separatorChar), sizes[s], users[u]), 
					yed);
			}
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
