package org.mondo.collaboration.security.lock.eval.user.pbl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.modelobfuscator.util.StringObfuscator;
import org.mondo.collaboration.security.lens.bx.AbortReason.DenialReason;
import org.mondo.collaboration.security.lens.bx.online.OnlineCollaborationSession;
import org.mondo.collaboration.security.lens.bx.online.OnlineCollaborationSession.Leg;
import org.mondo.collaboration.security.lock.eval.user.UserTypeC;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.Lock;

import com.google.common.collect.Maps;

public class UserTypeCPBL extends UserTypeC {

	private Leg leg;
	private OnlineCollaborationSession session;
	private Lock lock;

	private UserTypeCPBL(Leg leg, String vendor, URI frontConfinementUri) {
		super(leg.getFrontResourceSet().getResource(frontConfinementUri, true), vendor);
		this.leg = leg;
	}
	
	@SuppressWarnings("deprecation")
	public UserTypeCPBL(OnlineCollaborationSession session, String vendor, String name, URI frontConfinementUri) throws InvocationTargetException {
		this(session.new Leg(name, new StringObfuscator("c", "c"), true, new ResourceSetImpl(), frontConfinementUri), vendor, frontConfinementUri);
		this.session = session;
		this.lock = UtilityClass.buildLock(name,"lockB", buildBindings(), session);
	}
	
	private Map<String,String> buildBindings() {
		Map<String,String> bindings = Maps.newHashMap();
		bindings.put("vendor", vendor);
		return bindings;
	}

	@Override
	public boolean doAcquireLock() {
		try {
			UtilityClass.acquireLock(session, lock);
			return true;
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void doOperations() {
		super.doOperations();
		DenialReason reason = leg.trySubmitModification();
		if(reason != null) {
			setDeclined(getDeclined() + 1);
		} else {
			setAccepted(getAccepted() + 1);
		}
	}
	
	@Override
	public void doReleaseLock() {
		try {
			UtilityClass.releaseLock(session, lock);
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void operate() {
		synchronized (session) {
			doOperations();
		}
	}
	
	@Override
	protected boolean acquireLock() {
		synchronized (session) {
			return doAcquireLock();	
		}
	}
	
	@Override
	protected void releaseLock() {
		synchronized (session) {
			doReleaseLock();
		}
	}
	
}
