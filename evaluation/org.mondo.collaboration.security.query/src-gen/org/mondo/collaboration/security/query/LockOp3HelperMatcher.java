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
import org.mondo.collaboration.security.query.LockOp3HelperMatch;
import org.mondo.collaboration.security.query.util.LockOp3HelperQuerySpecification;
import wt.Control;
import wt.Signal;

/**
 * Generated pattern matcher API of the org.mondo.collaboration.security.query.lockOp3Helper pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link LockOp3HelperMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern lockOp3Helper(signal :Signal, cycle, value, ctrl :Control) {
 * 	Control.cycle(ctrl, cycle);
 * 	Control.provides(ctrl, signal);
 * 	Signal.frequency(signal, value);
 * }
 * </pre></code>
 * 
 * @see LockOp3HelperMatch
 * @see LockOp3HelperProcessor
 * @see LockOp3HelperQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class LockOp3HelperMatcher extends BaseMatcher<LockOp3HelperMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static LockOp3HelperMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    LockOp3HelperMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new LockOp3HelperMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SIGNAL = 0;
  
  private final static int POSITION_CYCLE = 1;
  
  private final static int POSITION_VALUE = 2;
  
  private final static int POSITION_CTRL = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(LockOp3HelperMatcher.class);
  
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
  public LockOp3HelperMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public LockOp3HelperMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCycle the fixed value of pattern parameter cycle, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @return matches represented as a LockOp3HelperMatch object.
   * 
   */
  public Collection<LockOp3HelperMatch> getAllMatches(final Signal pSignal, final String pCycle, final Integer pValue, final Control pCtrl) {
    return rawGetAllMatches(new Object[]{pSignal, pCycle, pValue, pCtrl});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCycle the fixed value of pattern parameter cycle, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @return a match represented as a LockOp3HelperMatch object, or null if no match is found.
   * 
   */
  public LockOp3HelperMatch getOneArbitraryMatch(final Signal pSignal, final String pCycle, final Integer pValue, final Control pCtrl) {
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
  public boolean hasMatch(final Signal pSignal, final String pCycle, final Integer pValue, final Control pCtrl) {
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
  public int countMatches(final Signal pSignal, final String pCycle, final Integer pValue, final Control pCtrl) {
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
  public void forEachMatch(final Signal pSignal, final String pCycle, final Integer pValue, final Control pCtrl, final IMatchProcessor<? super LockOp3HelperMatch> processor) {
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
  public boolean forOneArbitraryMatch(final Signal pSignal, final String pCycle, final Integer pValue, final Control pCtrl, final IMatchProcessor<? super LockOp3HelperMatch> processor) {
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
  public LockOp3HelperMatch newMatch(final Signal pSignal, final String pCycle, final Integer pValue, final Control pCtrl) {
    return LockOp3HelperMatch.newMatch(pSignal, pCycle, pValue, pCtrl);
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
  public Set<Signal> getAllValuesOfsignal(final LockOp3HelperMatch partialMatch) {
    return rawAccumulateAllValuesOfsignal(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsignal(final String pCycle, final Integer pValue, final Control pCtrl) {
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
  public Set<String> getAllValuesOfcycle(final LockOp3HelperMatch partialMatch) {
    return rawAccumulateAllValuesOfcycle(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cycle.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfcycle(final Signal pSignal, final Integer pValue, final Control pCtrl) {
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
  public Set<Integer> getAllValuesOfvalue(final LockOp3HelperMatch partialMatch) {
    return rawAccumulateAllValuesOfvalue(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for value.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfvalue(final Signal pSignal, final String pCycle, final Control pCtrl) {
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
  public Set<Control> getAllValuesOfctrl(final LockOp3HelperMatch partialMatch) {
    return rawAccumulateAllValuesOfctrl(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ctrl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfctrl(final Signal pSignal, final String pCycle, final Integer pValue) {
    return rawAccumulateAllValuesOfctrl(new Object[]{
    pSignal, 
    pCycle, 
    pValue, 
    null
    });
  }
  
  @Override
  protected LockOp3HelperMatch tupleToMatch(final Tuple t) {
    try {
    	return LockOp3HelperMatch.newMatch((wt.Signal) t.get(POSITION_SIGNAL), (java.lang.String) t.get(POSITION_CYCLE), (java.lang.Integer) t.get(POSITION_VALUE), (wt.Control) t.get(POSITION_CTRL));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LockOp3HelperMatch arrayToMatch(final Object[] match) {
    try {
    	return LockOp3HelperMatch.newMatch((wt.Signal) match[POSITION_SIGNAL], (java.lang.String) match[POSITION_CYCLE], (java.lang.Integer) match[POSITION_VALUE], (wt.Control) match[POSITION_CTRL]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LockOp3HelperMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return LockOp3HelperMatch.newMutableMatch((wt.Signal) match[POSITION_SIGNAL], (java.lang.String) match[POSITION_CYCLE], (java.lang.Integer) match[POSITION_VALUE], (wt.Control) match[POSITION_CTRL]);
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
  public static IQuerySpecification<LockOp3HelperMatcher> querySpecification() throws IncQueryException {
    return LockOp3HelperQuerySpecification.instance();
  }
}
