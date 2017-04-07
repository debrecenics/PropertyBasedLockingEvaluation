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
import org.mondo.collaboration.security.query.ContainedByMatch;
import org.mondo.collaboration.security.query.ContainedByMatcher;

/**
 * A pattern-specific query specification that can instantiate ContainedByMatcher in a type-safe way.
 * 
 * @see ContainedByMatcher
 * @see ContainedByMatch
 * 
 */
@SuppressWarnings("all")
public final class ContainedByQuerySpecification extends BaseGeneratedEMFQuerySpecification<ContainedByMatcher> {
  private ContainedByQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ContainedByQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ContainedByMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ContainedByMatcher.on(engine);
  }
  
  @Override
  public ContainedByMatch newEmptyMatch() {
    return ContainedByMatch.newEmptyMatch();
  }
  
  @Override
  public ContainedByMatch newMatch(final Object... parameters) {
    return ContainedByMatch.newMatch((wt.Module) parameters[0], (java.lang.Object) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static ContainedByQuerySpecification INSTANCE = make();
    
    public static ContainedByQuerySpecification make() {
      return new ContainedByQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ContainedByQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.mondo.collaboration.security.query.containedBy";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("parent","child");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("parent", "wt.Module"),new PParameter("child", "java.lang.Object"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_parent = body.getOrCreateVariableByName("parent");
      		PVariable var_child = body.getOrCreateVariableByName("child");
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_parent, "parent"),
      		   new ExportedParameter(body, var_child, "child")
      		));
      		// 		Composite.submodules(parent,child)
      		new TypeConstraint(body, new FlatTuple(var_parent), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Composite")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_parent, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Composite", "submodules")));
      		new Equality(body, var__virtual_0_, var_child);
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_parent = body.getOrCreateVariableByName("parent");
      		PVariable var_child = body.getOrCreateVariableByName("child");
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_parent, "parent"),
      		   new ExportedParameter(body, var_child, "child")
      		));
      		// 	Module.provides(parent,child)
      		new TypeConstraint(body, new FlatTuple(var_parent), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Module")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_parent, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Module", "provides")));
      		new Equality(body, var__virtual_0_, var_child);
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
