package org.mondo.collaboration.security.lock.eval.lock;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class FileBasedLocker {

	private final Map<String, String> lock = Maps.newHashMap();

	public boolean acquireLock(Set<String> identifiers, String user) {
		HashSet<String> intersection = Sets.newHashSet(identifiers);
		if (intersection.removeAll(lock.keySet())) {
			return false;
		}

		for (String id : identifiers) {
			lock.put(id, user);
		}
		return true;
	}

	public void releaseLock(Set<String> identifiers, String user) {
		for (String id : identifiers) {
			if (lock.get(id).equals(user)) {
				lock.remove(id);
			}
		}
	}

}
