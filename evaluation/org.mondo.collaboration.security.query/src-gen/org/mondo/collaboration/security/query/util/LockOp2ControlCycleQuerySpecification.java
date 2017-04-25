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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.BinaryTransitiveClosure;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.mondo.collaboration.security.query.LockOp2ControlCycleMatch;
import org.mondo.collaboration.security.query.LockOp2ControlCycleMatcher;
import org.mondo.collaboration.security.query.util.ContainedByQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate LockOp2ControlCycleMatcher in a type-safe way.
 * 
 * @see LockOp2ControlCycleMatcher
 * @see LockOp2ControlCycleMatch
 * 
 */
@SuppressWarnings("all")
public final class LockOp2ControlCycleQuerySpecification extends BaseGeneratedEMFQuerySpecification<LockOp2ControlCycleMatcher> {
  private LockOp2ControlCycleQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static LockOp2ControlCycleQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected LockOp2ControlCycleMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return LockOp2ControlCycleMatcher.on(engine);
  }
  
  @Override
  public LockOp2ControlCycleMatch newEmptyMatch() {
    return LockOp2ControlCycleMatch.newEmptyMatch();
  }
  
  @Override
  public LockOp2ControlCycleMatch newMatch(final Object... parameters) {
    return LockOp2ControlCycleMatch.newMatch((java.lang.String) parameters[0], (wt.Control) parameters[1], (java.lang.String) parameters[2], (wt.Composite) parameters[3]);
  }
  
  private static class LazyHolder {
    private final static LockOp2ControlCycleQuerySpecification INSTANCE = make();
    
    public static LockOp2ControlCycleQuerySpecification make() {
      return new LockOp2ControlCycleQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static LockOp2ControlCycleQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.mondo.collaboration.security.query.lockOp2ControlCycle";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("vendor","object","cycle","composite");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("vendor", "java.lang.String"),new PParameter("object", "wt.Control"),new PParameter("cycle", "java.lang.String"),new PParameter("composite", "wt.Composite"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_vendor = body.getOrCreateVariableByName("vendor");
      		PVariable var_object = body.getOrCreateVariableByName("object");
      		PVariable var_cycle = body.getOrCreateVariableByName("cycle");
      		PVariable var_composite = body.getOrCreateVariableByName("composite");
      		new TypeConstraint(body, new FlatTuple(var_composite), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Composite")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_vendor, "vendor"),
      		   new ExportedParameter(body, var_object, "object"),
      		   new ExportedParameter(body, var_cycle, "cycle"),
      		   new ExportedParameter(body, var_composite, "composite")
      		));
      		// 	Composite.vendor(composite,vendor)
      		new TypeConstraint(body, new FlatTuple(var_composite), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Composite")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_composite, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Composite", "vendor")));
      		new Equality(body, var__virtual_0_, var_vendor);
      		// 	find containedBy+(composite,object)
      		new BinaryTransitiveClosure(body, new FlatTuple(var_composite, var_object), ContainedByQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Control.cycle(object, cycle)
      		new TypeConstraint(body, new FlatTuple(var_object), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_object, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Control", "cycle")));
      		new Equality(body, var__virtual_1_, var_cycle);
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
