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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.mondo.collaboration.security.query.FragmentMatch;
import org.mondo.collaboration.security.query.FragmentMatcher;
import org.mondo.collaboration.security.query.util.ContainedByQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate FragmentMatcher in a type-safe way.
 * 
 * @see FragmentMatcher
 * @see FragmentMatch
 * 
 */
@SuppressWarnings("all")
public final class FragmentQuerySpecification extends BaseGeneratedEMFQuerySpecification<FragmentMatcher> {
  private FragmentQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static FragmentQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected FragmentMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return FragmentMatcher.on(engine);
  }
  
  @Override
  public FragmentMatch newEmptyMatch() {
    return FragmentMatch.newEmptyMatch();
  }
  
  @Override
  public FragmentMatch newMatch(final Object... parameters) {
    return FragmentMatch.newMatch((wt.Module) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static FragmentQuerySpecification INSTANCE = make();
    
    public static FragmentQuerySpecification make() {
      return new FragmentQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static FragmentQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.mondo.collaboration.security.query.fragment";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("fragment");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("fragment", "wt.Module"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_fragment = body.getOrCreateVariableByName("fragment");
      		PVariable var_root = body.getOrCreateVariableByName("root");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_fragment, "fragment")
      		));
      		// 	neg find containedBy(_,root)
      		new NegativePatternCall(body, new FlatTuple(var___0_, var_root), ContainedByQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Composite.submodules(root,fragment)
      		new TypeConstraint(body, new FlatTuple(var_root), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Composite")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_root, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Composite", "submodules")));
      		new Equality(body, var__virtual_0_, var_fragment);
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
