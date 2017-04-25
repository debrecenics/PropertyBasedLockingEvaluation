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
import org.mondo.collaboration.security.query.LockOp1Match;
import org.mondo.collaboration.security.query.util.LockOp1QuerySpecification;
import wt.Control;
import wt.Signal;

/**
 * Generated pattern matcher API of the org.mondo.collaboration.security.query.lockOp1 pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link LockOp1Match}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern lockOp1(ctrl1 : Control, signal : Signal, ctrl2 : Control, type) {
 * 	Control.type(ctrl1, type);
 * 	Control.type(ctrl2, type);
 * 	Control.provides(ctrl2, signal);
 * }
 * </pre></code>
 * 
 * @see LockOp1Match
 * @see LockOp1Processor
 * @see LockOp1QuerySpecification
 * 
 */
@SuppressWarnings("all")
public class LockOp1Matcher extends BaseMatcher<LockOp1Match> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static LockOp1Matcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    LockOp1Matcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new LockOp1Matcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CTRL1 = 0;
  
  private final static int POSITION_SIGNAL = 1;
  
  private final static int POSITION_CTRL2 = 2;
  
  private final static int POSITION_TYPE = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(LockOp1Matcher.class);
  
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
  public LockOp1Matcher(final Notifier emfRoot) throws IncQueryException {
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
  public LockOp1Matcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCtrl1 the fixed value of pattern parameter ctrl1, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCtrl2 the fixed value of pattern parameter ctrl2, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return matches represented as a LockOp1Match object.
   * 
   */
  public Collection<LockOp1Match> getAllMatches(final Control pCtrl1, final Signal pSignal, final Control pCtrl2, final String pType) {
    return rawGetAllMatches(new Object[]{pCtrl1, pSignal, pCtrl2, pType});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCtrl1 the fixed value of pattern parameter ctrl1, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCtrl2 the fixed value of pattern parameter ctrl2, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return a match represented as a LockOp1Match object, or null if no match is found.
   * 
   */
  public LockOp1Match getOneArbitraryMatch(final Control pCtrl1, final Signal pSignal, final Control pCtrl2, final String pType) {
    return rawGetOneArbitraryMatch(new Object[]{pCtrl1, pSignal, pCtrl2, pType});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pCtrl1 the fixed value of pattern parameter ctrl1, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCtrl2 the fixed value of pattern parameter ctrl2, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Control pCtrl1, final Signal pSignal, final Control pCtrl2, final String pType) {
    return rawHasMatch(new Object[]{pCtrl1, pSignal, pCtrl2, pType});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCtrl1 the fixed value of pattern parameter ctrl1, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCtrl2 the fixed value of pattern parameter ctrl2, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Control pCtrl1, final Signal pSignal, final Control pCtrl2, final String pType) {
    return rawCountMatches(new Object[]{pCtrl1, pSignal, pCtrl2, pType});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pCtrl1 the fixed value of pattern parameter ctrl1, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCtrl2 the fixed value of pattern parameter ctrl2, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Control pCtrl1, final Signal pSignal, final Control pCtrl2, final String pType, final IMatchProcessor<? super LockOp1Match> processor) {
    rawForEachMatch(new Object[]{pCtrl1, pSignal, pCtrl2, pType}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCtrl1 the fixed value of pattern parameter ctrl1, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCtrl2 the fixed value of pattern parameter ctrl2, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Control pCtrl1, final Signal pSignal, final Control pCtrl2, final String pType, final IMatchProcessor<? super LockOp1Match> processor) {
    return rawForOneArbitraryMatch(new Object[]{pCtrl1, pSignal, pCtrl2, pType}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCtrl1 the fixed value of pattern parameter ctrl1, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCtrl2 the fixed value of pattern parameter ctrl2, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public LockOp1Match newMatch(final Control pCtrl1, final Signal pSignal, final Control pCtrl2, final String pType) {
    return LockOp1Match.newMatch(pCtrl1, pSignal, pCtrl2, pType);
  }
  
  /**
   * Retrieve the set of values that occur in matches for ctrl1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Control> rawAccumulateAllValuesOfctrl1(final Object[] parameters) {
    Set<Control> results = new HashSet<Control>();
    rawAccumulateAllValues(POSITION_CTRL1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for ctrl1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfctrl1() {
    return rawAccumulateAllValuesOfctrl1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ctrl1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfctrl1(final LockOp1Match partialMatch) {
    return rawAccumulateAllValuesOfctrl1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ctrl1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfctrl1(final Signal pSignal, final Control pCtrl2, final String pType) {
    return rawAccumulateAllValuesOfctrl1(new Object[]{
    null, 
    pSignal, 
    pCtrl2, 
    pType
    });
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
  public Set<Signal> getAllValuesOfsignal(final LockOp1Match partialMatch) {
    return rawAccumulateAllValuesOfsignal(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsignal(final Control pCtrl1, final Control pCtrl2, final String pType) {
    return rawAccumulateAllValuesOfsignal(new Object[]{
    pCtrl1, 
    null, 
    pCtrl2, 
    pType
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for ctrl2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Control> rawAccumulateAllValuesOfctrl2(final Object[] parameters) {
    Set<Control> results = new HashSet<Control>();
    rawAccumulateAllValues(POSITION_CTRL2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for ctrl2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfctrl2() {
    return rawAccumulateAllValuesOfctrl2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ctrl2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfctrl2(final LockOp1Match partialMatch) {
    return rawAccumulateAllValuesOfctrl2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ctrl2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfctrl2(final Control pCtrl1, final Signal pSignal, final String pType) {
    return rawAccumulateAllValuesOfctrl2(new Object[]{
    pCtrl1, 
    pSignal, 
    null, 
    pType
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOftype(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_TYPE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOftype() {
    return rawAccumulateAllValuesOftype(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOftype(final LockOp1Match partialMatch) {
    return rawAccumulateAllValuesOftype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOftype(final Control pCtrl1, final Signal pSignal, final Control pCtrl2) {
    return rawAccumulateAllValuesOftype(new Object[]{
    pCtrl1, 
    pSignal, 
    pCtrl2, 
    null
    });
  }
  
  @Override
  protected LockOp1Match tupleToMatch(final Tuple t) {
    try {
    	return LockOp1Match.newMatch((wt.Control) t.get(POSITION_CTRL1), (wt.Signal) t.get(POSITION_SIGNAL), (wt.Control) t.get(POSITION_CTRL2), (java.lang.String) t.get(POSITION_TYPE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LockOp1Match arrayToMatch(final Object[] match) {
    try {
    	return LockOp1Match.newMatch((wt.Control) match[POSITION_CTRL1], (wt.Signal) match[POSITION_SIGNAL], (wt.Control) match[POSITION_CTRL2], (java.lang.String) match[POSITION_TYPE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LockOp1Match arrayToMatchMutable(final Object[] match) {
    try {
    	return LockOp1Match.newMutableMatch((wt.Control) match[POSITION_CTRL1], (wt.Signal) match[POSITION_SIGNAL], (wt.Control) match[POSITION_CTRL2], (java.lang.String) match[POSITION_TYPE]);
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
  public static IQuerySpecification<LockOp1Matcher> querySpecification() throws IncQueryException {
    return LockOp1QuerySpecification.instance();
  }
}
