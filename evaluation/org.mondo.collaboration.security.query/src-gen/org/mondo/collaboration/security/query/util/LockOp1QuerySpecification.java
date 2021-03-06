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
import org.mondo.collaboration.security.query.LockOp1Match;
import org.mondo.collaboration.security.query.LockOp1Matcher;

/**
 * A pattern-specific query specification that can instantiate LockOp1Matcher in a type-safe way.
 * 
 * @see LockOp1Matcher
 * @see LockOp1Match
 * 
 */
@SuppressWarnings("all")
public final class LockOp1QuerySpecification extends BaseGeneratedEMFQuerySpecification<LockOp1Matcher> {
  private LockOp1QuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static LockOp1QuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected LockOp1Matcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return LockOp1Matcher.on(engine);
  }
  
  @Override
  public LockOp1Match newEmptyMatch() {
    return LockOp1Match.newEmptyMatch();
  }
  
  @Override
  public LockOp1Match newMatch(final Object... parameters) {
    return LockOp1Match.newMatch((wt.Control) parameters[0], (wt.Signal) parameters[1], (wt.Control) parameters[2], (java.lang.String) parameters[3]);
  }
  
  private static class LazyHolder {
    private final static LockOp1QuerySpecification INSTANCE = make();
    
    public static LockOp1QuerySpecification make() {
      return new LockOp1QuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static LockOp1QuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.mondo.collaboration.security.query.lockOp1";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("ctrl1","signal","ctrl2","type");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("ctrl1", "wt.Control"),new PParameter("signal", "wt.Signal"),new PParameter("ctrl2", "wt.Control"),new PParameter("type", "java.lang.String"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_ctrl1 = body.getOrCreateVariableByName("ctrl1");
      		PVariable var_signal = body.getOrCreateVariableByName("signal");
      		PVariable var_ctrl2 = body.getOrCreateVariableByName("ctrl2");
      		PVariable var_type = body.getOrCreateVariableByName("type");
      		new TypeConstraint(body, new FlatTuple(var_ctrl1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      		new TypeConstraint(body, new FlatTuple(var_signal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Signal")));
      		new TypeConstraint(body, new FlatTuple(var_ctrl2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_ctrl1, "ctrl1"),
      		   new ExportedParameter(body, var_signal, "signal"),
      		   new ExportedParameter(body, var_ctrl2, "ctrl2"),
      		   new ExportedParameter(body, var_type, "type")
      		));
      		// 	Control.type(ctrl1, type)
      		new TypeConstraint(body, new FlatTuple(var_ctrl1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_ctrl1, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Control", "type")));
      		new Equality(body, var__virtual_0_, var_type);
      		// 	Control.type(ctrl2, type)
      		new TypeConstraint(body, new FlatTuple(var_ctrl2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_ctrl2, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Control", "type")));
      		new Equality(body, var__virtual_1_, var_type);
      		// 	Control.provides(ctrl2, signal)
      		new TypeConstraint(body, new FlatTuple(var_ctrl2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_ctrl2, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Module", "provides")));
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
