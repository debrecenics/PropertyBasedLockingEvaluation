package org.mondo.collaboration.security.lock.eval;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.stat.descriptive.rank.Median;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lock.eval.simulation.ExecuteOperationWrapper;
import org.mondo.collaboration.security.lock.eval.simulation.LockRequestWrapper;
import org.mondo.collaboration.security.lock.eval.simulation.Simulation;
import org.mondo.collaboration.security.lock.eval.user.UserType;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Evaluation {

	private static HashMap<String, String> mainArgs;
	public final static Simulation simulation = new Simulation();
	private static Map<String, List<Character>> uniqueIdentifiers;

	public static final char[] ABC = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	
	public static void main(String[] args) throws InterruptedException, InvocationTargetException, IncQueryException {
		processArgs(args);

		System.out.println("Type,Fragment,Deep,User,Accepted,Declined");

		DecimalFormat df = new DecimalFormat("0.000");

		if (mainArgs.containsKey("F") && mainArgs.containsKey("D") && mainArgs.containsKey("U")) {
			for (int i = 0; i < R(); i++) {
				Configuration.initiateTimings(U());

				ObjectBasedLockingEvaluation.main(args);
				PropertyBasedLockingEvaluation.main(args);
				FileBasedLockingEvaluation.main(args);
			}
		} else {
			int[] users = {3, 9, 12 };
			int[] fragments = {3, 12, 18};
			int[] deeps = {3, 9, 12};
			int repeat = 10;

			mainArgs.put("Max", "12");

			Configuration.initiateTimings(Max());
			reinitBindings(Max());

			for (int f = 0; f < fragments.length; f++) {
				for (int d = 0; d < deeps.length; d++) {
					for (int u = 0; u < users.length; u++) {
						List<Double> objectBased = Lists.newArrayList();
						List<Double> propertyBased = Lists.newArrayList();
						List<Double> fileBased = Lists.newArrayList();
						for (int i = 0; i < repeat; i++) {

							mainArgs.put("F", String.valueOf(fragments[f]));
							mainArgs.put("D", String.valueOf(deeps[d]));
							mainArgs.put("U", String.valueOf(users[u]));

							Configuration.initiateTimings(U());

							ObjectBasedLockingEvaluation.main(args);
							PropertyBasedLockingEvaluation.main(args);
							FileBasedLockingEvaluation.main(args);

							Double ob = new Double(ObjectBasedLockingEvaluation.ratio);
							objectBased.add(ob);
							Double pb = new Double(PropertyBasedLockingEvaluation.ratio);
							propertyBased.add(pb);
							Double fb = new Double(FileBasedLockingEvaluation.ratio);
							fileBased.add(fb);

//							System.out.println((i + 1) + "," + F() + "," + D() + "," + U() + ","
//									+ df.format(ob).replace(',', '.') + "," + df.format(pb).replace(',', '.') + ","
//									+ df.format(fb).replace(',', '.'));

						}
						Median median = new Median();
						double ob = median.evaluate(objectBased.stream().mapToDouble(x -> x).toArray());
						double pb = median.evaluate(propertyBased.stream().mapToDouble(x -> x).toArray());
						double fb = median.evaluate(fileBased.stream().mapToDouble(x -> x).toArray());

						System.out.println("M," + F() + "," + D() + "," + U() + "," + df.format(ob).replace(',', '.')
								+ "," + df.format(pb).replace(',', '.') + "," + df.format(fb).replace(',', '.'));
					}
				}
			}
		}
	}

	protected static void processArgs(String[] args) {
		mainArgs = new HashMap<String, String>();

		for (int i = 0; i < args.length; i++) {
			if (args[i].trim().startsWith("-F"))
				mainArgs.put("F", args[i + 1]);
			if (args[i].trim().startsWith("-D"))
				mainArgs.put("D", args[i + 1]);
			if (args[i].trim().startsWith("-U"))
				mainArgs.put("U", args[i + 1]);
			if (args[i].trim().startsWith("-R"))
				mainArgs.put("R", args[i + 1]);
		}
	}

	protected static void simulate(List<UserType> users) {
		Evaluation.simulation.clear();

		for (UserType user : users) {
			List<Double> timings = Configuration.Timings.get(user.getName());
			Iterator<Double> iterator = timings.iterator();
			Double lastTime = .0;
			while (iterator.hasNext()) {
				Double waitTime = iterator.next();
				Evaluation.simulation.addWrapper(new LockRequestWrapper(user, lastTime + waitTime));
				Double execTime = iterator.next();
				Evaluation.simulation.addWrapper(new ExecuteOperationWrapper(user, lastTime + waitTime + execTime));
				lastTime = lastTime + waitTime + execTime;
			}
		}

		Evaluation.simulation.simulate();
	}

	protected static void reinitBindings(int u) {
		uniqueIdentifiers = Maps.newHashMap();
		String[] types = { "v", "c", "t" };
		for (int i = 0; i < types.length; i++) {
			List<Character> list = Lists.newArrayList();
			for (int value = 1; value <= u; value++) {
				list.add(new Character(ABC[value]));
			}
			Collections.shuffle(list);
			uniqueIdentifiers.put(types[i], list);
		}
	}

	protected static char getUniqueBinding(int i, String type) {
		return uniqueIdentifiers.get(type).get(i - 1).charValue();
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
		return String.format(System.getProperty("user.dir").replace("lock.eval", "generator")
				+ "/instances/model-%04d-%04d-%04d.xmi".replace('/', File.separatorChar), F(), D(), Max());
	}
}
