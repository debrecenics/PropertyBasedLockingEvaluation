package org.mondo.collaboration.security.query;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;
import org.mondo.collaboration.security.query.FragmentMatch;
import org.mondo.collaboration.security.query.util.FragmentQuerySpecification;
import wt.Module;

/**
 * Generated pattern matcher API of the org.mondo.collaboration.security.query.fragment pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link FragmentMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern fragment(fragment) {
 * 	neg find containedBy(_,root);
 * 	Composite.submodules(root,fragment);
 * }
 * </pre></code>
 * 
 * @see FragmentMatch
 * @see FragmentProcessor
 * @see FragmentQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class FragmentMatcher extends BaseMatcher<FragmentMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static FragmentMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    FragmentMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new FragmentMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_FRAGMENT = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(FragmentMatcher.class);
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet).
   * If a pattern matcher is already constructed with the same root, only a light-weight reference is returned.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead, e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}
   * 
   */
  @Deprecated
  public FragmentMatcher(final Notifier emfRoot) throws IncQueryException {
    this(IncQueryEngine.on(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead
   * 
   */
  @Deprecated
  public FragmentMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pFragment the fixed value of pattern parameter fragment, or null if not bound.
   * @return matches represented as a FragmentMatch object.
   * 
   */
  public Collection<FragmentMatch> getAllMatches(final Module pFragment) {
    return rawGetAllMatches(new Object[]{pFragment});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pFragment the fixed value of pattern parameter fragment, or null if not bound.
   * @return a match represented as a FragmentMatch object, or null if no match is found.
   * 
   */
  public FragmentMatch getOneArbitraryMatch(final Module pFragment) {
    return rawGetOneArbitraryMatch(new Object[]{pFragment});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pFragment the fixed value of pattern parameter fragment, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Module pFragment) {
    return rawHasMatch(new Object[]{pFragment});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pFragment the fixed value of pattern parameter fragment, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Module pFragment) {
    return rawCountMatches(new Object[]{pFragment});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pFragment the fixed value of pattern parameter fragment, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Module pFragment, final IMatchProcessor<? super FragmentMatch> processor) {
    rawForEachMatch(new Object[]{pFragment}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pFragment the fixed value of pattern parameter fragment, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Module pFragment, final IMatchProcessor<? super FragmentMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pFragment}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pFragment the fixed value of pattern parameter fragment, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public FragmentMatch newMatch(final Module pFragment) {
    return FragmentMatch.newMatch(pFragment);
  }
  
  /**
   * Retrieve the set of values that occur in matches for fragment.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Module> rawAccumulateAllValuesOffragment(final Object[] parameters) {
    Set<Module> results = new HashSet<Module>();
    rawAccumulateAllValues(POSITION_FRAGMENT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for fragment.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Module> getAllValuesOffragment() {
    return rawAccumulateAllValuesOffragment(emptyArray());
  }
  
  @Override
  protected FragmentMatch tupleToMatch(final Tuple t) {
    try {
    	return FragmentMatch.newMatch((wt.Module) t.get(POSITION_FRAGMENT));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected FragmentMatch arrayToMatch(final Object[] match) {
    try {
    	return FragmentMatch.newMatch((wt.Module) match[POSITION_FRAGMENT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected FragmentMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return FragmentMatch.newMutableMatch((wt.Module) match[POSITION_FRAGMENT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<FragmentMatcher> querySpecification() throws IncQueryException {
    return FragmentQuerySpecification.instance();
  }
}
