package org.mondo.collaboration.security.lock.eval;

import org.mondo.collaboration.security.lock.eval.distribution.Exponential;
import org.mondo.collaboration.security.lock.eval.distribution.IDistribution;

public class Configuration {

	public static IDistribution Distribution = new Exponential(0.2);
	public static int Operations = 10;
	
	public static int TypeA = 3;
	public static int TypeB = 5;
	public static int TypeC = 5;
	
	public static int MODEL_SIZE = 3;
	public static int VENDOR_SIZE = 3;
	
}
