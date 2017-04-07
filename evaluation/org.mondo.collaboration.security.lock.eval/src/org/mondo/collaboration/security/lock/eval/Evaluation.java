package org.mondo.collaboration.security.lock.eval;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.simulation.ExecuteOperationWrapper;
import org.mondo.collaboration.security.lock.eval.simulation.LockRequestWrapper;
import org.mondo.collaboration.security.lock.eval.simulation.Simulation;
import org.mondo.collaboration.security.lock.eval.user.UserType;

import com.google.common.collect.Lists;

public class Evaluation {

	
	private static HashMap<String, String> mainArgs;
	public final static Simulation simulation = new Simulation();
	private static List<Integer> uniqueIdentifiers;

	public static void main(String[] args) throws InterruptedException, InvocationTargetException, IncQueryException {
		processArgs(args);
		
		System.out.println("Type,Fragment,Deep,User,Accepted,Declined");
		
		if(mainArgs.containsKey("F") && mainArgs.containsKey("D") && mainArgs.containsKey("U")) {
			for(int i = 0; i < R(); i++) {
				Configuration.initiateTimings(U());
				
				ObjectBasedLockingEvaluation.main(args);
				PropertyBasedLockingEvaluation.main(args);
				FileBasedLockingEvaluation.main(args);
			}
		} else {
			int[] users = {3,9};
			int[] fragments = {15};
			int[] deeps = {3,18};
			int   repeat = 10;
			
			mainArgs.put("Max", String.valueOf(users[users.length-1]));
			
			for(int f = 0; f < fragments.length; f++)
				for(int d = 0; d < deeps.length; d++) {
					reinitBindings();
					for(int u = 0; u < users.length; u++)
						if(f < u) continue;
						else  {
							for(int i = 0; i < repeat; i++) {
								if(fragments[f] < users[u]) break;
								
								mainArgs.put("F", String.valueOf(fragments[f]));
								mainArgs.put("D", String.valueOf(deeps[d]));
								mainArgs.put("U", String.valueOf(users[u]));
								
								Configuration.initiateTimings(U());
								
								ObjectBasedLockingEvaluation.main(args);
								PropertyBasedLockingEvaluation.main(args);
								FileBasedLockingEvaluation.main(args);
							}
						}
				}
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
			if(args[i].trim().startsWith("-R"))
				mainArgs.put("R",args[i+1]);
		}		
	}
	
	protected static void simulate(List<UserType> users) {
		Evaluation.simulation.clear();
		
		for (UserType user : users) {
			List<Double> timings = Configuration.Timings.get(user.getName());
			Iterator<Double> iterator = timings.iterator();
			Double lastTime = .0;
			while(iterator.hasNext()) {
				Double waitTime = iterator.next();
				Evaluation.simulation.addWrapper(new LockRequestWrapper(user, lastTime + waitTime));
				Double execTime = iterator.next();
				Evaluation.simulation.addWrapper(new ExecuteOperationWrapper(user, lastTime + waitTime + execTime));
				lastTime = lastTime + waitTime + execTime;
			}
		}
		
		Evaluation.simulation.simulate();
	}
	
	protected static void reinitBindings() {
		uniqueIdentifiers = Lists.newArrayList();
		for(int i = 1; i <= Max(); i++) uniqueIdentifiers.add(new Integer(i));
		Collections.shuffle(uniqueIdentifiers);
	}
	
	protected static int getUniqueBinding(int i) {
		return uniqueIdentifiers.get(i-1).intValue();
	}
	
	protected static int F() {
		return Integer.valueOf(mainArgs.get("F"));
	}
	
	protected static int Max() {
		return Integer.valueOf(mainArgs.get("Max"));
	}
	
	protected static int D() {
		return Integer.valueOf(mainArgs.get("D"));
	}
	
	protected static int U() {
		return Integer.valueOf(mainArgs.get("U"));
	}
	
	protected static int R() {
		return Integer.valueOf(mainArgs.get("R"));
	}
	
	protected static String Model() {
		return String.format(System.getProperty("user.dir").replace("lock.eval", "generator")+"/instances/model-%04d-%04d-%04d.xmi".replace('/', File.separatorChar), F(), D(), Max());
	}
}
