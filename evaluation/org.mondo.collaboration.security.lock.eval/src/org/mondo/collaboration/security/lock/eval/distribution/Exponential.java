package org.mondo.collaboration.security.lock.eval.distribution;

import org.apache.commons.math3.distribution.ExponentialDistribution;
import org.apache.commons.math3.random.JDKRandomGenerator;

public class Exponential implements IDistribution {

	private JDKRandomGenerator rand;
    private ExponentialDistribution distribution;
    
	public Exponential(double mean) {
    	this.rand = new JDKRandomGenerator();
        this.distribution = new ExponentialDistribution(rand, mean);
    }
    
	@Override
	public double getNext() {
		return distribution.sample();
	}

}
