package org.mondo.collaboration.security.query.util;

import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.incquery.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.mondo.collaboration.security.query.LockCMatch;
import org.mondo.collaboration.security.query.LockCMatcher;

/**
 * A pattern-specific query specification that can instantiate LockCMatcher in a type-safe way.
 * 
 * @see LockCMatcher
 * @see LockCMatch
 * 
 */
@SuppressWarnings("all")
public final class LockCQuerySpecification extends BaseGeneratedEMFQuerySpecification<LockCMatcher> {
  private LockCQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static LockCQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected LockCMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return LockCMatcher.on(engine);
  }
  
  @Override
  public LockCMatch newEmptyMatch() {
    return LockCMatch.newEmptyMatch();
  }
  
  @Override
  public LockCMatch newMatch(final Object... parameters) {
    return LockCMatch.newMatch((wt.Signal) parameters[0], (java.lang.String) parameters[1], (java.lang.Integer) parameters[2], (java.lang.String) parameters[3]);
  }
  
  private static class LazyHolder {
    private final static LockCQuerySpecification INSTANCE = make();
    
    public static LockCQuerySpecification make() {
      return new LockCQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static LockCQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.mondo.collaboration.security.query.lockC";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("signal","vendor","frequency","id");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("signal", "wt.Signal"),new PParameter("vendor", "java.lang.String"),new PParameter("frequency", "java.lang.Integer"),new PParameter("id", "java.lang.String"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_signal = body.getOrCreateVariableByName("signal");
      		PVariable var_vendor = body.getOrCreateVariableByName("vendor");
      		PVariable var_frequency = body.getOrCreateVariableByName("frequency");
      		PVariable var_id = body.getOrCreateVariableByName("id");
      		PVariable var_composite = body.getOrCreateVariableByName("composite");
      		PVariable var_control = body.getOrCreateVariableByName("control");
      		new TypeConstraint(body, new FlatTuple(var_signal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Signal")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_signal, "signal"),
      		   new ExportedParameter(body, var_vendor, "vendor"),
      		   new ExportedParameter(body, var_frequency, "frequency"),
      		   new ExportedParameter(body, var_id, "id")
      		));
      		// 	Composite.vendor(composite,vendor)
      		new TypeConstraint(body, new FlatTuple(var_composite), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Composite")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_composite, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Composite", "vendor")));
      		new Equality(body, var__virtual_0_, var_vendor);
      		// 	Composite.submodules(composite,control)
      		new TypeConstraint(body, new FlatTuple(var_composite), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Composite")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_composite, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Composite", "submodules")));
      		new Equality(body, var__virtual_1_, var_control);
      		// 	Control.provides(control, signal)
      		new TypeConstraint(body, new FlatTuple(var_control), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_control, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Module", "provides")));
      		new Equality(body, var__virtual_2_, var_signal);
      		// 	Signal.id(signal, id)
      		new TypeConstraint(body, new FlatTuple(var_signal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Signal")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_signal, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Signal", "id")));
      		new Equality(body, var__virtual_3_, var_id);
      		// 	Signal.frequency(signal, frequency)
      		new TypeConstraint(body, new FlatTuple(var_signal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Signal")));
      		PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      		new TypeConstraint(body, new FlatTuple(var_signal, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Signal", "frequency")));
      		new Equality(body, var__virtual_4_, var_frequency);
      		bodies.add(body);
      	}
      	// to silence compiler error
      	if (false) throw new IncQueryException("Never", "happens");
      } catch (IncQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
