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
import org.mondo.collaboration.security.query.LockAHelperMatch;
import org.mondo.collaboration.security.query.LockAHelperMatcher;

/**
 * A pattern-specific query specification that can instantiate LockAHelperMatcher in a type-safe way.
 * 
 * @see LockAHelperMatcher
 * @see LockAHelperMatch
 * 
 */
@SuppressWarnings("all")
public final class LockAHelperQuerySpecification extends BaseGeneratedEMFQuerySpecification<LockAHelperMatcher> {
  private LockAHelperQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static LockAHelperQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected LockAHelperMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return LockAHelperMatcher.on(engine);
  }
  
  @Override
  public LockAHelperMatch newEmptyMatch() {
    return LockAHelperMatch.newEmptyMatch();
  }
  
  @Override
  public LockAHelperMatch newMatch(final Object... parameters) {
    return LockAHelperMatch.newMatch((wt.Signal) parameters[0], (java.lang.String) parameters[1], (java.lang.Integer) parameters[2], (wt.Control) parameters[3]);
  }
  
  private static class LazyHolder {
    private final static LockAHelperQuerySpecification INSTANCE = make();
    
    public static LockAHelperQuerySpecification make() {
      return new LockAHelperQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static LockAHelperQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.mondo.collaboration.security.query.lockAHelper";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("signal","cycle","value","ctrl");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("signal", "wt.Signal"),new PParameter("cycle", "java.lang.String"),new PParameter("value", "java.lang.Integer"),new PParameter("ctrl", "wt.Control"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_signal = body.getOrCreateVariableByName("signal");
      		PVariable var_cycle = body.getOrCreateVariableByName("cycle");
      		PVariable var_value = body.getOrCreateVariableByName("value");
      		PVariable var_ctrl = body.getOrCreateVariableByName("ctrl");
      		new TypeConstraint(body, new FlatTuple(var_signal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Signal")));
      		new TypeConstraint(body, new FlatTuple(var_ctrl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_signal, "signal"),
      		   new ExportedParameter(body, var_cycle, "cycle"),
      		   new ExportedParameter(body, var_value, "value"),
      		   new ExportedParameter(body, var_ctrl, "ctrl")
      		));
      		// 	Control.cycle(ctrl, cycle)
      		new TypeConstraint(body, new FlatTuple(var_ctrl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_ctrl, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Control", "cycle")));
      		new Equality(body, var__virtual_0_, var_cycle);
      		// 	Control.provides(ctrl, signal)
      		new TypeConstraint(body, new FlatTuple(var_ctrl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_ctrl, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Module", "provides")));
      		new Equality(body, var__virtual_1_, var_signal);
      		// 	Signal.frequency(signal, value)
      		new TypeConstraint(body, new FlatTuple(var_signal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Signal")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_signal, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Signal", "frequency")));
      		new Equality(body, var__virtual_2_, var_value);
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
