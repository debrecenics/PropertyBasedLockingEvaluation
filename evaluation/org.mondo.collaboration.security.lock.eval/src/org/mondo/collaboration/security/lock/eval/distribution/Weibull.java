package org.mondo.collaboration.security.lock.eval.distribution;

import org.apache.commons.math3.distribution.WeibullDistribution;
import org.apache.commons.math3.random.JDKRandomGenerator;

public class Weibull implements IDistribution {

	
    private JDKRandomGenerator rand;
    private WeibullDistribution distribution;
    
	public Weibull(double shape, double scale) {
    	this.rand = new JDKRandomGenerator();
        this.distribution= new WeibullDistribution(rand, shape, scale, WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
    }
    
	@Override
	public double getNext() {
		return distribution.sample();
	}

}
