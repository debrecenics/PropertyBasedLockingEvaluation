package org.mondo.collaboration.security.lock.eval.lock;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class FileBasedLocker {

	private final Map<Object, String> lock = Maps.newHashMap();

	public boolean acquireLock(Set<Object> identifiers, String user) {
		HashSet<Object> intersection = Sets.newHashSet(identifiers);
		if (intersection.removeAll(lock.keySet())) {
			return false;
		}

		for (Object id : identifiers) {
			lock.put(id, user);
		}
		if(identifiers.isEmpty()) {
			return false;	
		}
		return true;
		
	}

	public void releaseLock(Set<Object> identifiers, String user) {
		for (Object id : identifiers) {
			if (lock.get(id).equals(user)) {
				lock.remove(id);
			}
		}
	}

}
