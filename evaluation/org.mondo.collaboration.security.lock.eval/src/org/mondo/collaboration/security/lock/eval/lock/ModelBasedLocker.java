package org.mondo.collaboration.security.lock.eval.lock;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import wt.Module;
import wt.Signal;

public class ModelBasedLocker {

	private final Map<String,String> lock = Maps.newHashMap();
	
	public boolean acquireLock(Set<String> identifiers, String user) {
		synchronized (lock) {
			HashSet<String> intersection = Sets.newHashSet(identifiers);
			intersection.retainAll(lock.keySet());
			
			if(!intersection.isEmpty()) {
//				System.out.println("Lock is rejected");
				return false; // At least one element is locked
			}
			
			for (String id : identifiers) {
				lock.put(id, user);
			}
//			System.out.println(String.format("%s acquired locks for %s", user, identifiers.toString()));
			return true;
		}
	}
	
	public void releaseLock(Set<String> identifiers, String user) {
		synchronized (lock) {
			for (String id : identifiers) {
				if(lock.get(id).equals(user)) {
					lock.remove(id);
				}
			}
//			System.out.println(String.format("%s released locks for %s", user, identifiers.toString()));
		}
	}
	
	public static class LockAdapter extends EContentAdapter {
		
		boolean skip = false;
		private ModelBasedLocker locker;
		
		public LockAdapter(ModelBasedLocker locker) {
			this.locker = locker;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public void notifyChanged(Notification msg) {
			super.notifyChanged(msg);
			
			if(skip) {
				skip = false;
				return;
			}
			
			String user = Thread.currentThread().getName();
			Object notifier = msg.getNotifier();
			String id = null;
			if(notifier instanceof Signal) {
				Signal signal = (Signal) notifier;
				id = signal.getId();
			} else if (notifier instanceof Module) {
				Module module = (Module) notifier;
				id = module.getId();
			} else {
				throw new ClassCastException();
			}
			if(locker.lock.get(id) == null || !locker.lock.get(id).equals(user)) {
//				System.out.println("Conflict is occured");
				EObject eobj = (EObject) notifier;
				EStructuralFeature feature = (EStructuralFeature) msg.getFeature();
				if(feature.isMany()) {
					if(msg.getEventType() == Notification.REMOVE)
						((EList<Object>) eobj.eGet(feature)).add(msg.getOldValue());
					if(msg.getEventType() == Notification.ADD)
						((EList<Object>) eobj.eGet(feature)).remove(msg.getNewValue());
				} else {
					eobj.eSet(feature, msg.getOldValue());
				}
				
			}
		}
	}
}
