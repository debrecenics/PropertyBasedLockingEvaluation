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
import org.mondo.collaboration.security.query.LockOp2ControlCycleMatch;
import org.mondo.collaboration.security.query.util.LockOp2ControlCycleQuerySpecification;
import wt.Composite;
import wt.Control;

/**
 * Generated pattern matcher API of the org.mondo.collaboration.security.query.lockOp2ControlCycle pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link LockOp2ControlCycleMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern lockOp2ControlCycle(vendor, object, cycle, composite : Composite) {
 * 	Composite.vendor(composite,vendor);
 * 	find containedBy+(composite,object);
 * 	Control.cycle(object, cycle);
 * }
 * </pre></code>
 * 
 * @see LockOp2ControlCycleMatch
 * @see LockOp2ControlCycleProcessor
 * @see LockOp2ControlCycleQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class LockOp2ControlCycleMatcher extends BaseMatcher<LockOp2ControlCycleMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static LockOp2ControlCycleMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    LockOp2ControlCycleMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new LockOp2ControlCycleMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_VENDOR = 0;
  
  private final static int POSITION_OBJECT = 1;
  
  private final static int POSITION_CYCLE = 2;
  
  private final static int POSITION_COMPOSITE = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(LockOp2ControlCycleMatcher.class);
  
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
  public LockOp2ControlCycleMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public LockOp2ControlCycleMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pCycle the fixed value of pattern parameter cycle, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @return matches represented as a LockOp2ControlCycleMatch object.
   * 
   */
  public Collection<LockOp2ControlCycleMatch> getAllMatches(final String pVendor, final Control pObject, final String pCycle, final Composite pComposite) {
    return rawGetAllMatches(new Object[]{pVendor, pObject, pCycle, pComposite});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pCycle the fixed value of pattern parameter cycle, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @return a match represented as a LockOp2ControlCycleMatch object, or null if no match is found.
   * 
   */
  public LockOp2ControlCycleMatch getOneArbitraryMatch(final String pVendor, final Control pObject, final String pCycle, final Composite pComposite) {
    return rawGetOneArbitraryMatch(new Object[]{pVendor, pObject, pCycle, pComposite});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pCycle the fixed value of pattern parameter cycle, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final String pVendor, final Control pObject, final String pCycle, final Composite pComposite) {
    return rawHasMatch(new Object[]{pVendor, pObject, pCycle, pComposite});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pCycle the fixed value of pattern parameter cycle, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final String pVendor, final Control pObject, final String pCycle, final Composite pComposite) {
    return rawCountMatches(new Object[]{pVendor, pObject, pCycle, pComposite});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pCycle the fixed value of pattern parameter cycle, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final String pVendor, final Control pObject, final String pCycle, final Composite pComposite, final IMatchProcessor<? super LockOp2ControlCycleMatch> processor) {
    rawForEachMatch(new Object[]{pVendor, pObject, pCycle, pComposite}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pCycle the fixed value of pattern parameter cycle, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final String pVendor, final Control pObject, final String pCycle, final Composite pComposite, final IMatchProcessor<? super LockOp2ControlCycleMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pVendor, pObject, pCycle, pComposite}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pCycle the fixed value of pattern parameter cycle, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public LockOp2ControlCycleMatch newMatch(final String pVendor, final Control pObject, final String pCycle, final Composite pComposite) {
    return LockOp2ControlCycleMatch.newMatch(pVendor, pObject, pCycle, pComposite);
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
  public Set<String> getAllValuesOfvendor(final LockOp2ControlCycleMatch partialMatch) {
    return rawAccumulateAllValuesOfvendor(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for vendor.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfvendor(final Control pObject, final String pCycle, final Composite pComposite) {
    return rawAccumulateAllValuesOfvendor(new Object[]{
    null, 
    pObject, 
    pCycle, 
    pComposite
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for object.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Control> rawAccumulateAllValuesOfobject(final Object[] parameters) {
    Set<Control> results = new HashSet<Control>();
    rawAccumulateAllValues(POSITION_OBJECT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for object.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfobject() {
    return rawAccumulateAllValuesOfobject(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for object.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfobject(final LockOp2ControlCycleMatch partialMatch) {
    return rawAccumulateAllValuesOfobject(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for object.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfobject(final String pVendor, final String pCycle, final Composite pComposite) {
    return rawAccumulateAllValuesOfobject(new Object[]{
    pVendor, 
    null, 
    pCycle, 
    pComposite
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for cycle.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfcycle(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_CYCLE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for cycle.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfcycle() {
    return rawAccumulateAllValuesOfcycle(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cycle.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfcycle(final LockOp2ControlCycleMatch partialMatch) {
    return rawAccumulateAllValuesOfcycle(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cycle.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfcycle(final String pVendor, final Control pObject, final Composite pComposite) {
    return rawAccumulateAllValuesOfcycle(new Object[]{
    pVendor, 
    pObject, 
    null, 
    pComposite
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for composite.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Composite> rawAccumulateAllValuesOfcomposite(final Object[] parameters) {
    Set<Composite> results = new HashSet<Composite>();
    rawAccumulateAllValues(POSITION_COMPOSITE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for composite.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Composite> getAllValuesOfcomposite() {
    return rawAccumulateAllValuesOfcomposite(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for composite.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Composite> getAllValuesOfcomposite(final LockOp2ControlCycleMatch partialMatch) {
    return rawAccumulateAllValuesOfcomposite(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for composite.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Composite> getAllValuesOfcomposite(final String pVendor, final Control pObject, final String pCycle) {
    return rawAccumulateAllValuesOfcomposite(new Object[]{
    pVendor, 
    pObject, 
    pCycle, 
    null
    });
  }
  
  @Override
  protected LockOp2ControlCycleMatch tupleToMatch(final Tuple t) {
    try {
    	return LockOp2ControlCycleMatch.newMatch((java.lang.String) t.get(POSITION_VENDOR), (wt.Control) t.get(POSITION_OBJECT), (java.lang.String) t.get(POSITION_CYCLE), (wt.Composite) t.get(POSITION_COMPOSITE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LockOp2ControlCycleMatch arrayToMatch(final Object[] match) {
    try {
    	return LockOp2ControlCycleMatch.newMatch((java.lang.String) match[POSITION_VENDOR], (wt.Control) match[POSITION_OBJECT], (java.lang.String) match[POSITION_CYCLE], (wt.Composite) match[POSITION_COMPOSITE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LockOp2ControlCycleMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return LockOp2ControlCycleMatch.newMutableMatch((java.lang.String) match[POSITION_VENDOR], (wt.Control) match[POSITION_OBJECT], (java.lang.String) match[POSITION_CYCLE], (wt.Composite) match[POSITION_COMPOSITE]);
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
  public static IQuerySpecification<LockOp2ControlCycleMatcher> querySpecification() throws IncQueryException {
    return LockOp2ControlCycleQuerySpecification.instance();
  }
}
