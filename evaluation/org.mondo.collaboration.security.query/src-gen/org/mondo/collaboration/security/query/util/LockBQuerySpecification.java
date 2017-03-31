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
import org.mondo.collaboration.security.query.LockBMatch;
import org.mondo.collaboration.security.query.LockBMatcher;

/**
 * A pattern-specific query specification that can instantiate LockBMatcher in a type-safe way.
 * 
 * @see LockBMatcher
 * @see LockBMatch
 * 
 */
@SuppressWarnings("all")
public final class LockBQuerySpecification extends BaseGeneratedEMFQuerySpecification<LockBMatcher> {
  private LockBQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static LockBQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected LockBMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return LockBMatcher.on(engine);
  }
  
  @Override
  public LockBMatch newEmptyMatch() {
    return LockBMatch.newEmptyMatch();
  }
  
  @Override
  public LockBMatch newMatch(final Object... parameters) {
    return LockBMatch.newMatch((wt.Signal) parameters[0], (java.lang.String) parameters[1], (wt.Module) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static LockBQuerySpecification INSTANCE = make();
    
    public static LockBQuerySpecification make() {
      return new LockBQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static LockBQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.mondo.collaboration.security.query.lockB";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("signal","type","module");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("signal", "wt.Signal"),new PParameter("type", "java.lang.String"),new PParameter("module", "wt.Module"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_signal = body.getOrCreateVariableByName("signal");
      		PVariable var_type = body.getOrCreateVariableByName("type");
      		PVariable var_module = body.getOrCreateVariableByName("module");
      		PVariable var_ctrl = body.getOrCreateVariableByName("ctrl");
      		new TypeConstraint(body, new FlatTuple(var_signal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Signal")));
      		new TypeConstraint(body, new FlatTuple(var_module), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Module")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_signal, "signal"),
      		   new ExportedParameter(body, var_type, "type"),
      		   new ExportedParameter(body, var_module, "module")
      		));
      		// 	Control.type(ctrl, type)
      		new TypeConstraint(body, new FlatTuple(var_ctrl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_ctrl, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Control", "type")));
      		new Equality(body, var__virtual_0_, var_type);
      		// 	Control.provides(ctrl, signal)
      		new TypeConstraint(body, new FlatTuple(var_ctrl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_ctrl, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Module", "provides")));
      		new Equality(body, var__virtual_1_, var_signal);
      		// 	Module.consumes(module, signal)
      		new TypeConstraint(body, new FlatTuple(var_module), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Module")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_module, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Module", "consumes")));
      		new Equality(body, var__virtual_2_, var_signal);
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
