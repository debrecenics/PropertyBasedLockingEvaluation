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
import org.mondo.collaboration.security.query.LockCHelperMatch;
import org.mondo.collaboration.security.query.LockCHelperMatcher;

/**
 * A pattern-specific query specification that can instantiate LockCHelperMatcher in a type-safe way.
 * 
 * @see LockCHelperMatcher
 * @see LockCHelperMatch
 * 
 */
@SuppressWarnings("all")
public final class LockCHelperQuerySpecification extends BaseGeneratedEMFQuerySpecification<LockCHelperMatcher> {
  private LockCHelperQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static LockCHelperQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected LockCHelperMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return LockCHelperMatcher.on(engine);
  }
  
  @Override
  public LockCHelperMatch newEmptyMatch() {
    return LockCHelperMatch.newEmptyMatch();
  }
  
  @Override
  public LockCHelperMatch newMatch(final Object... parameters) {
    return LockCHelperMatch.newMatch((wt.Signal) parameters[0], (java.lang.String) parameters[1], (wt.Control) parameters[2], (wt.Module) parameters[3]);
  }
  
  private static class LazyHolder {
    private final static LockCHelperQuerySpecification INSTANCE = make();
    
    public static LockCHelperQuerySpecification make() {
      return new LockCHelperQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static LockCHelperQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.mondo.collaboration.security.query.lockCHelper";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("signal","vendor","provider","consumer");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("signal", "wt.Signal"),new PParameter("vendor", "java.lang.String"),new PParameter("provider", "wt.Control"),new PParameter("consumer", "wt.Module"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_signal = body.getOrCreateVariableByName("signal");
      		PVariable var_vendor = body.getOrCreateVariableByName("vendor");
      		PVariable var_provider = body.getOrCreateVariableByName("provider");
      		PVariable var_consumer = body.getOrCreateVariableByName("consumer");
      		PVariable var_composite = body.getOrCreateVariableByName("composite");
      		new TypeConstraint(body, new FlatTuple(var_signal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Signal")));
      		new TypeConstraint(body, new FlatTuple(var_provider), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      		new TypeConstraint(body, new FlatTuple(var_consumer), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Module")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_signal, "signal"),
      		   new ExportedParameter(body, var_vendor, "vendor"),
      		   new ExportedParameter(body, var_provider, "provider"),
      		   new ExportedParameter(body, var_consumer, "consumer")
      		));
      		// 	Composite.vendor(composite,vendor)
      		new TypeConstraint(body, new FlatTuple(var_composite), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Composite")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_composite, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Composite", "vendor")));
      		new Equality(body, var__virtual_0_, var_vendor);
      		// 	Composite.submodules(composite,provider)
      		new TypeConstraint(body, new FlatTuple(var_composite), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Composite")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_composite, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Composite", "submodules")));
      		new Equality(body, var__virtual_1_, var_provider);
      		// 	Control.provides(provider, signal)
      		new TypeConstraint(body, new FlatTuple(var_provider), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_provider, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Module", "provides")));
      		new Equality(body, var__virtual_2_, var_signal);
      		// 	Module.consumes(consumer, signal)
      		new TypeConstraint(body, new FlatTuple(var_consumer), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Module")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_consumer, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Module", "consumes")));
      		new Equality(body, var__virtual_3_, var_signal);
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
