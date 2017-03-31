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
import org.mondo.collaboration.security.query.LockAHelperMatch;
import org.mondo.collaboration.security.query.util.LockAHelperQuerySpecification;
import wt.Control;
import wt.Cycle;
import wt.Signal;

/**
 * Generated pattern matcher API of the org.mondo.collaboration.security.query.lockAHelper pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link LockAHelperMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern lockAHelper(signal :Signal, cycle :Cycle, value, ctrl :Control) {
 * 	Control.cycle(ctrl, cycle);
 * 	Control.provides(ctrl, signal);
 * 	Signal.frequency(signal, value);
 * }
 * </pre></code>
 * 
 * @see LockAHelperMatch
 * @see LockAHelperProcessor
 * @see LockAHelperQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class LockAHelperMatcher extends BaseMatcher<LockAHelperMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static LockAHelperMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    LockAHelperMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new LockAHelperMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SIGNAL = 0;
  
  private final static int POSITION_CYCLE = 1;
  
  private final static int POSITION_VALUE = 2;
  
  private final static int POSITION_CTRL = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(LockAHelperMatcher.class);
  
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
  public LockAHelperMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public LockAHelperMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCycle the fixed value of pattern parameter cycle, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @return matches represented as a LockAHelperMatch object.
   * 
   */
  public Collection<LockAHelperMatch> getAllMatches(final Signal pSignal, final Cycle pCycle, final Integer pValue, final Control pCtrl) {
    return rawGetAllMatches(new Object[]{pSignal, pCycle, pValue, pCtrl});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCycle the fixed value of pattern parameter cycle, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @return a match represented as a LockAHelperMatch object, or null if no match is found.
   * 
   */
  public LockAHelperMatch getOneArbitraryMatch(final Signal pSignal, final Cycle pCycle, final Integer pValue, final Control pCtrl) {
    return rawGetOneArbitraryMatch(new Object[]{pSignal, pCycle, pValue, pCtrl});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCycle the fixed value of pattern parameter cycle, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Signal pSignal, final Cycle pCycle, final Integer pValue, final Control pCtrl) {
    return rawHasMatch(new Object[]{pSignal, pCycle, pValue, pCtrl});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCycle the fixed value of pattern parameter cycle, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Signal pSignal, final Cycle pCycle, final Integer pValue, final Control pCtrl) {
    return rawCountMatches(new Object[]{pSignal, pCycle, pValue, pCtrl});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCycle the fixed value of pattern parameter cycle, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Signal pSignal, final Cycle pCycle, final Integer pValue, final Control pCtrl, final IMatchProcessor<? super LockAHelperMatch> processor) {
    rawForEachMatch(new Object[]{pSignal, pCycle, pValue, pCtrl}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCycle the fixed value of pattern parameter cycle, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Signal pSignal, final Cycle pCycle, final Integer pValue, final Control pCtrl, final IMatchProcessor<? super LockAHelperMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSignal, pCycle, pValue, pCtrl}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCycle the fixed value of pattern parameter cycle, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public LockAHelperMatch newMatch(final Signal pSignal, final Cycle pCycle, final Integer pValue, final Control pCtrl) {
    return LockAHelperMatch.newMatch(pSignal, pCycle, pValue, pCtrl);
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Signal> rawAccumulateAllValuesOfsignal(final Object[] parameters) {
    Set<Signal> results = new HashSet<Signal>();
    rawAccumulateAllValues(POSITION_SIGNAL, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsignal() {
    return rawAccumulateAllValuesOfsignal(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsignal(final LockAHelperMatch partialMatch) {
    return rawAccumulateAllValuesOfsignal(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsignal(final Cycle pCycle, final Integer pValue, final Control pCtrl) {
    return rawAccumulateAllValuesOfsignal(new Object[]{
    null, 
    pCycle, 
    pValue, 
    pCtrl
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for cycle.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Cycle> rawAccumulateAllValuesOfcycle(final Object[] parameters) {
    Set<Cycle> results = new HashSet<Cycle>();
    rawAccumulateAllValues(POSITION_CYCLE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for cycle.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Cycle> getAllValuesOfcycle() {
    return rawAccumulateAllValuesOfcycle(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cycle.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Cycle> getAllValuesOfcycle(final LockAHelperMatch partialMatch) {
    return rawAccumulateAllValuesOfcycle(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cycle.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Cycle> getAllValuesOfcycle(final Signal pSignal, final Integer pValue, final Control pCtrl) {
    return rawAccumulateAllValuesOfcycle(new Object[]{
    pSignal, 
    null, 
    pValue, 
    pCtrl
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for value.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Integer> rawAccumulateAllValuesOfvalue(final Object[] parameters) {
    Set<Integer> results = new HashSet<Integer>();
    rawAccumulateAllValues(POSITION_VALUE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for value.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfvalue() {
    return rawAccumulateAllValuesOfvalue(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for value.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfvalue(final LockAHelperMatch partialMatch) {
    return rawAccumulateAllValuesOfvalue(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for value.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfvalue(final Signal pSignal, final Cycle pCycle, final Control pCtrl) {
    return rawAccumulateAllValuesOfvalue(new Object[]{
    pSignal, 
    pCycle, 
    null, 
    pCtrl
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for ctrl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Control> rawAccumulateAllValuesOfctrl(final Object[] parameters) {
    Set<Control> results = new HashSet<Control>();
    rawAccumulateAllValues(POSITION_CTRL, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for ctrl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfctrl() {
    return rawAccumulateAllValuesOfctrl(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ctrl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfctrl(final LockAHelperMatch partialMatch) {
    return rawAccumulateAllValuesOfctrl(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ctrl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfctrl(final Signal pSignal, final Cycle pCycle, final Integer pValue) {
    return rawAccumulateAllValuesOfctrl(new Object[]{
    pSignal, 
    pCycle, 
    pValue, 
    null
    });
  }
  
  @Override
  protected LockAHelperMatch tupleToMatch(final Tuple t) {
    try {
    	return LockAHelperMatch.newMatch((wt.Signal) t.get(POSITION_SIGNAL), (wt.Cycle) t.get(POSITION_CYCLE), (java.lang.Integer) t.get(POSITION_VALUE), (wt.Control) t.get(POSITION_CTRL));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LockAHelperMatch arrayToMatch(final Object[] match) {
    try {
    	return LockAHelperMatch.newMatch((wt.Signal) match[POSITION_SIGNAL], (wt.Cycle) match[POSITION_CYCLE], (java.lang.Integer) match[POSITION_VALUE], (wt.Control) match[POSITION_CTRL]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LockAHelperMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return LockAHelperMatch.newMutableMatch((wt.Signal) match[POSITION_SIGNAL], (wt.Cycle) match[POSITION_CYCLE], (java.lang.Integer) match[POSITION_VALUE], (wt.Control) match[POSITION_CTRL]);
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
  public static IQuerySpecification<LockAHelperMatcher> querySpecification() throws IncQueryException {
    return LockAHelperQuerySpecification.instance();
  }
}
