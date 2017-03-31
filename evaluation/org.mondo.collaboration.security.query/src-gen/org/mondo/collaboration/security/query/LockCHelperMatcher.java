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
import org.mondo.collaboration.security.query.LockCHelperMatch;
import org.mondo.collaboration.security.query.util.LockCHelperQuerySpecification;
import wt.Control;
import wt.Module;
import wt.Signal;

/**
 * Generated pattern matcher API of the org.mondo.collaboration.security.query.lockCHelper pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link LockCHelperMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern lockCHelper(signal :Signal, vendor, provider : Control, consumer : Module) {
 * 	Composite.vendor(composite,vendor);
 * 	Composite.submodules(composite,provider);
 * 	Control.provides(provider, signal);
 * 	Module.consumes(consumer, signal);
 * }
 * </pre></code>
 * 
 * @see LockCHelperMatch
 * @see LockCHelperProcessor
 * @see LockCHelperQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class LockCHelperMatcher extends BaseMatcher<LockCHelperMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static LockCHelperMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    LockCHelperMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new LockCHelperMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SIGNAL = 0;
  
  private final static int POSITION_VENDOR = 1;
  
  private final static int POSITION_PROVIDER = 2;
  
  private final static int POSITION_CONSUMER = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(LockCHelperMatcher.class);
  
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
  public LockCHelperMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public LockCHelperMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pProvider the fixed value of pattern parameter provider, or null if not bound.
   * @param pConsumer the fixed value of pattern parameter consumer, or null if not bound.
   * @return matches represented as a LockCHelperMatch object.
   * 
   */
  public Collection<LockCHelperMatch> getAllMatches(final Signal pSignal, final String pVendor, final Control pProvider, final Module pConsumer) {
    return rawGetAllMatches(new Object[]{pSignal, pVendor, pProvider, pConsumer});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pProvider the fixed value of pattern parameter provider, or null if not bound.
   * @param pConsumer the fixed value of pattern parameter consumer, or null if not bound.
   * @return a match represented as a LockCHelperMatch object, or null if no match is found.
   * 
   */
  public LockCHelperMatch getOneArbitraryMatch(final Signal pSignal, final String pVendor, final Control pProvider, final Module pConsumer) {
    return rawGetOneArbitraryMatch(new Object[]{pSignal, pVendor, pProvider, pConsumer});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pProvider the fixed value of pattern parameter provider, or null if not bound.
   * @param pConsumer the fixed value of pattern parameter consumer, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Signal pSignal, final String pVendor, final Control pProvider, final Module pConsumer) {
    return rawHasMatch(new Object[]{pSignal, pVendor, pProvider, pConsumer});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pProvider the fixed value of pattern parameter provider, or null if not bound.
   * @param pConsumer the fixed value of pattern parameter consumer, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Signal pSignal, final String pVendor, final Control pProvider, final Module pConsumer) {
    return rawCountMatches(new Object[]{pSignal, pVendor, pProvider, pConsumer});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pProvider the fixed value of pattern parameter provider, or null if not bound.
   * @param pConsumer the fixed value of pattern parameter consumer, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Signal pSignal, final String pVendor, final Control pProvider, final Module pConsumer, final IMatchProcessor<? super LockCHelperMatch> processor) {
    rawForEachMatch(new Object[]{pSignal, pVendor, pProvider, pConsumer}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pProvider the fixed value of pattern parameter provider, or null if not bound.
   * @param pConsumer the fixed value of pattern parameter consumer, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Signal pSignal, final String pVendor, final Control pProvider, final Module pConsumer, final IMatchProcessor<? super LockCHelperMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSignal, pVendor, pProvider, pConsumer}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pProvider the fixed value of pattern parameter provider, or null if not bound.
   * @param pConsumer the fixed value of pattern parameter consumer, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public LockCHelperMatch newMatch(final Signal pSignal, final String pVendor, final Control pProvider, final Module pConsumer) {
    return LockCHelperMatch.newMatch(pSignal, pVendor, pProvider, pConsumer);
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
  public Set<Signal> getAllValuesOfsignal(final LockCHelperMatch partialMatch) {
    return rawAccumulateAllValuesOfsignal(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsignal(final String pVendor, final Control pProvider, final Module pConsumer) {
    return rawAccumulateAllValuesOfsignal(new Object[]{
    null, 
    pVendor, 
    pProvider, 
    pConsumer
    });
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
  public Set<String> getAllValuesOfvendor(final LockCHelperMatch partialMatch) {
    return rawAccumulateAllValuesOfvendor(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for vendor.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfvendor(final Signal pSignal, final Control pProvider, final Module pConsumer) {
    return rawAccumulateAllValuesOfvendor(new Object[]{
    pSignal, 
    null, 
    pProvider, 
    pConsumer
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for provider.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Control> rawAccumulateAllValuesOfprovider(final Object[] parameters) {
    Set<Control> results = new HashSet<Control>();
    rawAccumulateAllValues(POSITION_PROVIDER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for provider.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfprovider() {
    return rawAccumulateAllValuesOfprovider(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for provider.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfprovider(final LockCHelperMatch partialMatch) {
    return rawAccumulateAllValuesOfprovider(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for provider.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfprovider(final Signal pSignal, final String pVendor, final Module pConsumer) {
    return rawAccumulateAllValuesOfprovider(new Object[]{
    pSignal, 
    pVendor, 
    null, 
    pConsumer
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for consumer.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Module> rawAccumulateAllValuesOfconsumer(final Object[] parameters) {
    Set<Module> results = new HashSet<Module>();
    rawAccumulateAllValues(POSITION_CONSUMER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for consumer.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Module> getAllValuesOfconsumer() {
    return rawAccumulateAllValuesOfconsumer(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for consumer.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Module> getAllValuesOfconsumer(final LockCHelperMatch partialMatch) {
    return rawAccumulateAllValuesOfconsumer(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for consumer.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Module> getAllValuesOfconsumer(final Signal pSignal, final String pVendor, final Control pProvider) {
    return rawAccumulateAllValuesOfconsumer(new Object[]{
    pSignal, 
    pVendor, 
    pProvider, 
    null
    });
  }
  
  @Override
  protected LockCHelperMatch tupleToMatch(final Tuple t) {
    try {
    	return LockCHelperMatch.newMatch((wt.Signal) t.get(POSITION_SIGNAL), (java.lang.String) t.get(POSITION_VENDOR), (wt.Control) t.get(POSITION_PROVIDER), (wt.Module) t.get(POSITION_CONSUMER));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LockCHelperMatch arrayToMatch(final Object[] match) {
    try {
    	return LockCHelperMatch.newMatch((wt.Signal) match[POSITION_SIGNAL], (java.lang.String) match[POSITION_VENDOR], (wt.Control) match[POSITION_PROVIDER], (wt.Module) match[POSITION_CONSUMER]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LockCHelperMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return LockCHelperMatch.newMutableMatch((wt.Signal) match[POSITION_SIGNAL], (java.lang.String) match[POSITION_VENDOR], (wt.Control) match[POSITION_PROVIDER], (wt.Module) match[POSITION_CONSUMER]);
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
  public static IQuerySpecification<LockCHelperMatcher> querySpecification() throws IncQueryException {
    return LockCHelperQuerySpecification.instance();
  }
}
