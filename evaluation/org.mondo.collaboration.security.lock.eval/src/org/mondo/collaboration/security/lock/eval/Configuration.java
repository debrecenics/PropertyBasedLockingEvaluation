package org.mondo.collaboration.security.lock.eval;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.mondo.collaboration.security.lock.eval.distribution.Exponential;
import org.mondo.collaboration.security.lock.eval.distribution.IDistribution;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Configuration {

	public static final String EXEC = "exec";
	public static final String WAIT = "wait";

	public static TransactionalEditingDomain domain;
	public static Map<String, List<Double>> Timings; 
	
	public static int Days = 10;
	
	public static int WaitMeanB =  24; //h
	public static int WaitMeanD =  12; //h
	public static int WaitMeanM =  4; //h
	
	public static int ExecMeanB =  3; //h
	public static int ExecMeanD =  2; //h
	public static int ExecMeanM =  1; //h
	
	public static void initiateTimings(int size) {
		Timings = Maps.newHashMap();
		populateTimingsTable(Timings,WaitMeanB,ExecMeanB,size,"B");
		populateTimingsTable(Timings,WaitMeanD,ExecMeanD,size,"D");
		populateTimingsTable(Timings,WaitMeanM,ExecMeanM,size,"M");
	}

	private static void populateTimingsTable(Map<String, List<Double>> table, int waitMean, int execMean, int size, String name) {
		Exponential distributionWait = new Exponential(waitMean);
		Exponential distributionExec = new Exponential(execMean);
		for (int i = 1; i <= size; i++) {
			String username = "user"+name+i;
			populateTimingsList(table, username, (24 / (waitMean+execMean)) * Days, distributionWait, distributionExec);
		}
	}

	private static void populateTimingsList(Map<String, List<Double>> table, String username, int operations, IDistribution distributionWait, IDistribution distributionExec) {
		List<Double> list = Lists.newArrayList();
		for (int i = 0; i < operations; i++) {
			list.add(distributionWait.getNext());
			list.add(distributionExec.getNext());
		}
		table.put(username, list);
	}
	
}
