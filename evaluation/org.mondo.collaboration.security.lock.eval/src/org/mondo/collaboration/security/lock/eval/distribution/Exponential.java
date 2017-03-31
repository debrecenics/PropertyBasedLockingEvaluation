package org.mondo.collaboration.security.lock.eval.distribution;

import java.util.Random;

public class Exponential implements IDistribution {

	private Random rand = new Random();
	private double lambda;
	
	public Exponential(double lambda) {
		this.lambda = lambda;
	}
	
	@Override
	public double getNext() {
	    return  Math.log(1-rand.nextDouble())/(-lambda);
	}

}
