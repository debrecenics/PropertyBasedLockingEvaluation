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
import org.mondo.collaboration.security.query.LockOp2Match;
import org.mondo.collaboration.security.query.util.LockOp2QuerySpecification;
import wt.Control;

/**
 * Generated pattern matcher API of the org.mondo.collaboration.security.query.lockOp2 pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link LockOp2Match}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern lockOp2(vendor, control : Control) {
 * 	Composite.vendor(composite,vendor);
 * 	neg find containedBy(_,root);
 * 	Composite.submodules(root,composite);
 * 	find containedBy+(composite,control);
 * }
 * </pre></code>
 * 
 * @see LockOp2Match
 * @see LockOp2Processor
 * @see LockOp2QuerySpecification
 * 
 */
@SuppressWarnings("all")
public class LockOp2Matcher extends BaseMatcher<LockOp2Match> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static LockOp2Matcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    LockOp2Matcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new LockOp2Matcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_VENDOR = 0;
  
  private final static int POSITION_CONTROL = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(LockOp2Matcher.class);
  
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
  public LockOp2Matcher(final Notifier emfRoot) throws IncQueryException {
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
  public LockOp2Matcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pControl the fixed value of pattern parameter control, or null if not bound.
   * @return matches represented as a LockOp2Match object.
   * 
   */
  public Collection<LockOp2Match> getAllMatches(final String pVendor, final Control pControl) {
    return rawGetAllMatches(new Object[]{pVendor, pControl});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pControl the fixed value of pattern parameter control, or null if not bound.
   * @return a match represented as a LockOp2Match object, or null if no match is found.
   * 
   */
  public LockOp2Match getOneArbitraryMatch(final String pVendor, final Control pControl) {
    return rawGetOneArbitraryMatch(new Object[]{pVendor, pControl});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pControl the fixed value of pattern parameter control, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final String pVendor, final Control pControl) {
    return rawHasMatch(new Object[]{pVendor, pControl});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pControl the fixed value of pattern parameter control, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final String pVendor, final Control pControl) {
    return rawCountMatches(new Object[]{pVendor, pControl});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pControl the fixed value of pattern parameter control, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final String pVendor, final Control pControl, final IMatchProcessor<? super LockOp2Match> processor) {
    rawForEachMatch(new Object[]{pVendor, pControl}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pControl the fixed value of pattern parameter control, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final String pVendor, final Control pControl, final IMatchProcessor<? super LockOp2Match> processor) {
    return rawForOneArbitraryMatch(new Object[]{pVendor, pControl}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pControl the fixed value of pattern parameter control, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public LockOp2Match newMatch(final String pVendor, final Control pControl) {
    return LockOp2Match.newMatch(pVendor, pControl);
  }
  
  /**
   * Retrieve the set of values that occur in matches for vendor.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfvendor(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_VENDOR, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for vendor.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfvendor() {
    return rawAccumulateAllValuesOfvendor(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for vendor.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfvendor(final LockOp2Match partialMatch) {
    return rawAccumulateAllValuesOfvendor(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for vendor.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfvendor(final Control pControl) {
    return rawAccumulateAllValuesOfvendor(new Object[]{
    null, 
    pControl
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for control.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Control> rawAccumulateAllValuesOfcontrol(final Object[] parameters) {
    Set<Control> results = new HashSet<Control>();
    rawAccumulateAllValues(POSITION_CONTROL, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for control.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfcontrol() {
    return rawAccumulateAllValuesOfcontrol(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for control.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfcontrol(final LockOp2Match partialMatch) {
    return rawAccumulateAllValuesOfcontrol(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for control.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfcontrol(final String pVendor) {
    return rawAccumulateAllValuesOfcontrol(new Object[]{
    pVendor, 
    null
    });
  }
  
  @Override
  protected LockOp2Match tupleToMatch(final Tuple t) {
    try {
    	return LockOp2Match.newMatch((java.lang.String) t.get(POSITION_VENDOR), (wt.Control) t.get(POSITION_CONTROL));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LockOp2Match arrayToMatch(final Object[] match) {
    try {
    	return LockOp2Match.newMatch((java.lang.String) match[POSITION_VENDOR], (wt.Control) match[POSITION_CONTROL]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LockOp2Match arrayToMatchMutable(final Object[] match) {
    try {
    	return LockOp2Match.newMutableMatch((java.lang.String) match[POSITION_VENDOR], (wt.Control) match[POSITION_CONTROL]);
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
  public static IQuerySpecification<LockOp2Matcher> querySpecification() throws IncQueryException {
    return LockOp2QuerySpecification.instance();
  }
}
