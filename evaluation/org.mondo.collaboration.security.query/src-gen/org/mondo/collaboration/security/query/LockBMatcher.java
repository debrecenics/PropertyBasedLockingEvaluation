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
import org.mondo.collaboration.security.query.LockBMatch;
import org.mondo.collaboration.security.query.util.LockBQuerySpecification;
import wt.Module;
import wt.Signal;

/**
 * Generated pattern matcher API of the org.mondo.collaboration.security.query.lockB pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link LockBMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern lockB(signal :Signal, type, module :Module) {
 * 	Control.type(ctrl, type);
 * 	Control.provides(ctrl, signal);
 * 	Module.consumes(module, signal);
 * }
 * </pre></code>
 * 
 * @see LockBMatch
 * @see LockBProcessor
 * @see LockBQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class LockBMatcher extends BaseMatcher<LockBMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static LockBMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    LockBMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new LockBMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SIGNAL = 0;
  
  private final static int POSITION_TYPE = 1;
  
  private final static int POSITION_MODULE = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(LockBMatcher.class);
  
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
  public LockBMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public LockBMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pModule the fixed value of pattern parameter module, or null if not bound.
   * @return matches represented as a LockBMatch object.
   * 
   */
  public Collection<LockBMatch> getAllMatches(final Signal pSignal, final String pType, final Module pModule) {
    return rawGetAllMatches(new Object[]{pSignal, pType, pModule});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pModule the fixed value of pattern parameter module, or null if not bound.
   * @return a match represented as a LockBMatch object, or null if no match is found.
   * 
   */
  public LockBMatch getOneArbitraryMatch(final Signal pSignal, final String pType, final Module pModule) {
    return rawGetOneArbitraryMatch(new Object[]{pSignal, pType, pModule});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pModule the fixed value of pattern parameter module, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Signal pSignal, final String pType, final Module pModule) {
    return rawHasMatch(new Object[]{pSignal, pType, pModule});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pModule the fixed value of pattern parameter module, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Signal pSignal, final String pType, final Module pModule) {
    return rawCountMatches(new Object[]{pSignal, pType, pModule});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pModule the fixed value of pattern parameter module, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Signal pSignal, final String pType, final Module pModule, final IMatchProcessor<? super LockBMatch> processor) {
    rawForEachMatch(new Object[]{pSignal, pType, pModule}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pModule the fixed value of pattern parameter module, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Signal pSignal, final String pType, final Module pModule, final IMatchProcessor<? super LockBMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSignal, pType, pModule}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pModule the fixed value of pattern parameter module, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public LockBMatch newMatch(final Signal pSignal, final String pType, final Module pModule) {
    return LockBMatch.newMatch(pSignal, pType, pModule);
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
  public Set<Signal> getAllValuesOfsignal(final LockBMatch partialMatch) {
    return rawAccumulateAllValuesOfsignal(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsignal(final String pType, final Module pModule) {
    return rawAccumulateAllValuesOfsignal(new Object[]{
    null, 
    pType, 
    pModule
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
  public Set<String> getAllValuesOftype(final LockBMatch partialMatch) {
    return rawAccumulateAllValuesOftype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOftype(final Signal pSignal, final Module pModule) {
    return rawAccumulateAllValuesOftype(new Object[]{
    pSignal, 
    null, 
    pModule
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for module.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Module> rawAccumulateAllValuesOfmodule(final Object[] parameters) {
    Set<Module> results = new HashSet<Module>();
    rawAccumulateAllValues(POSITION_MODULE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for module.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Module> getAllValuesOfmodule() {
    return rawAccumulateAllValuesOfmodule(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for module.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Module> getAllValuesOfmodule(final LockBMatch partialMatch) {
    return rawAccumulateAllValuesOfmodule(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for module.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Module> getAllValuesOfmodule(final Signal pSignal, final String pType) {
    return rawAccumulateAllValuesOfmodule(new Object[]{
    pSignal, 
    pType, 
    null
    });
  }
  
  @Override
  protected LockBMatch tupleToMatch(final Tuple t) {
    try {
    	return LockBMatch.newMatch((wt.Signal) t.get(POSITION_SIGNAL), (java.lang.String) t.get(POSITION_TYPE), (wt.Module) t.get(POSITION_MODULE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LockBMatch arrayToMatch(final Object[] match) {
    try {
    	return LockBMatch.newMatch((wt.Signal) match[POSITION_SIGNAL], (java.lang.String) match[POSITION_TYPE], (wt.Module) match[POSITION_MODULE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LockBMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return LockBMatch.newMutableMatch((wt.Signal) match[POSITION_SIGNAL], (java.lang.String) match[POSITION_TYPE], (wt.Module) match[POSITION_MODULE]);
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
  public static IQuerySpecification<LockBMatcher> querySpecification() throws IncQueryException {
    return LockBQuerySpecification.instance();
  }
}
