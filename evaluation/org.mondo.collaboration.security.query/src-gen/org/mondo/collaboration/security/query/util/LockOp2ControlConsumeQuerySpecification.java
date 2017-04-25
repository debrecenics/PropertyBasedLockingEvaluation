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
import org.mondo.collaboration.security.query.LockOp2ControlConsumeMatch;
import org.mondo.collaboration.security.query.LockOp2ControlConsumeMatcher;
import org.mondo.collaboration.security.query.util.ContainedByQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate LockOp2ControlConsumeMatcher in a type-safe way.
 * 
 * @see LockOp2ControlConsumeMatcher
 * @see LockOp2ControlConsumeMatch
 * 
 */
@SuppressWarnings("all")
public final class LockOp2ControlConsumeQuerySpecification extends BaseGeneratedEMFQuerySpecification<LockOp2ControlConsumeMatcher> {
  private LockOp2ControlConsumeQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static LockOp2ControlConsumeQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected LockOp2ControlConsumeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return LockOp2ControlConsumeMatcher.on(engine);
  }
  
  @Override
  public LockOp2ControlConsumeMatch newEmptyMatch() {
    return LockOp2ControlConsumeMatch.newEmptyMatch();
  }
  
  @Override
  public LockOp2ControlConsumeMatch newMatch(final Object... parameters) {
    return LockOp2ControlConsumeMatch.newMatch((java.lang.String) parameters[0], (wt.Control) parameters[1], (wt.Signal) parameters[2], (wt.Composite) parameters[3]);
  }
  
  private static class LazyHolder {
    private final static LockOp2ControlConsumeQuerySpecification INSTANCE = make();
    
    public static LockOp2ControlConsumeQuerySpecification make() {
      return new LockOp2ControlConsumeQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static LockOp2ControlConsumeQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.mondo.collaboration.security.query.lockOp2ControlConsume";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("vendor","object","signal","composite");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("vendor", "java.lang.String"),new PParameter("object", "wt.Control"),new PParameter("signal", "wt.Signal"),new PParameter("composite", "wt.Composite"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_vendor = body.getOrCreateVariableByName("vendor");
      		PVariable var_object = body.getOrCreateVariableByName("object");
      		PVariable var_signal = body.getOrCreateVariableByName("signal");
      		PVariable var_composite = body.getOrCreateVariableByName("composite");
      		new TypeConstraint(body, new FlatTuple(var_signal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Signal")));
      		new TypeConstraint(body, new FlatTuple(var_composite), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Composite")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_vendor, "vendor"),
      		   new ExportedParameter(body, var_object, "object"),
      		   new ExportedParameter(body, var_signal, "signal"),
      		   new ExportedParameter(body, var_composite, "composite")
      		));
      		// 	Composite.vendor(composite,vendor)
      		new TypeConstraint(body, new FlatTuple(var_composite), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Composite")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_composite, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Composite", "vendor")));
      		new Equality(body, var__virtual_0_, var_vendor);
      		// 	find containedBy+(composite,object)
      		new BinaryTransitiveClosure(body, new FlatTuple(var_composite, var_object), ContainedByQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Control.consumes(object, signal)
      		new TypeConstraint(body, new FlatTuple(var_object), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_object, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Module", "consumes")));
      		new Equality(body, var__virtual_1_, var_signal);
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
