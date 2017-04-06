package org.mondo.collaboration.security.lock.eval.simulation;

import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;

public class Simulation {

	List<AbstractWrapper> queue = Lists.newArrayList();
	
	public void addWrapper(AbstractWrapper wrapper) {
		queue.add(wrapper);
	}
	
	public void simulate() {
		sortQueue();
		for (AbstractWrapper wrapper : queue) {
			wrapper.execute();
		}
	}
	
	public void clear() {
		queue.clear();
	}
	
	private void sortQueue() {
		queue.sort(new Comparator<AbstractWrapper>() {

			@Override
			public int compare(AbstractWrapper o1, AbstractWrapper o2) {
				if (o1.getTime() < o2.getTime())
					return -1;
				if (o1.getTime() > o2.getTime())
					return 1;
				return 0;
				
			}
		});
	}
}
