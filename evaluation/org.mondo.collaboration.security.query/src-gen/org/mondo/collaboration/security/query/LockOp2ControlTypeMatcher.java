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
import org.mondo.collaboration.security.query.LockOp2ControlTypeMatch;
import org.mondo.collaboration.security.query.util.LockOp2ControlTypeQuerySpecification;
import wt.Composite;
import wt.Control;

/**
 * Generated pattern matcher API of the org.mondo.collaboration.security.query.lockOp2ControlType pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link LockOp2ControlTypeMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern lockOp2ControlType(vendor, object : Control, type, composite : Composite) {
 * 	Composite.vendor(composite,vendor);
 * 	find containedBy+(composite,object);
 * 	Control.type(object, type);
 * }
 * </pre></code>
 * 
 * @see LockOp2ControlTypeMatch
 * @see LockOp2ControlTypeProcessor
 * @see LockOp2ControlTypeQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class LockOp2ControlTypeMatcher extends BaseMatcher<LockOp2ControlTypeMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static LockOp2ControlTypeMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    LockOp2ControlTypeMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new LockOp2ControlTypeMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_VENDOR = 0;
  
  private final static int POSITION_OBJECT = 1;
  
  private final static int POSITION_TYPE = 2;
  
  private final static int POSITION_COMPOSITE = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(LockOp2ControlTypeMatcher.class);
  
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
  public LockOp2ControlTypeMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public LockOp2ControlTypeMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @return matches represented as a LockOp2ControlTypeMatch object.
   * 
   */
  public Collection<LockOp2ControlTypeMatch> getAllMatches(final String pVendor, final Control pObject, final String pType, final Composite pComposite) {
    return rawGetAllMatches(new Object[]{pVendor, pObject, pType, pComposite});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @return a match represented as a LockOp2ControlTypeMatch object, or null if no match is found.
   * 
   */
  public LockOp2ControlTypeMatch getOneArbitraryMatch(final String pVendor, final Control pObject, final String pType, final Composite pComposite) {
    return rawGetOneArbitraryMatch(new Object[]{pVendor, pObject, pType, pComposite});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final String pVendor, final Control pObject, final String pType, final Composite pComposite) {
    return rawHasMatch(new Object[]{pVendor, pObject, pType, pComposite});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final String pVendor, final Control pObject, final String pType, final Composite pComposite) {
    return rawCountMatches(new Object[]{pVendor, pObject, pType, pComposite});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final String pVendor, final Control pObject, final String pType, final Composite pComposite, final IMatchProcessor<? super LockOp2ControlTypeMatch> processor) {
    rawForEachMatch(new Object[]{pVendor, pObject, pType, pComposite}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final String pVendor, final Control pObject, final String pType, final Composite pComposite, final IMatchProcessor<? super LockOp2ControlTypeMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pVendor, pObject, pType, pComposite}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public LockOp2ControlTypeMatch newMatch(final String pVendor, final Control pObject, final String pType, final Composite pComposite) {
    return LockOp2ControlTypeMatch.newMatch(pVendor, pObject, pType, pComposite);
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
  public Set<String> getAllValuesOfvendor(final LockOp2ControlTypeMatch partialMatch) {
    return rawAccumulateAllValuesOfvendor(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for vendor.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfvendor(final Control pObject, final String pType, final Composite pComposite) {
    return rawAccumulateAllValuesOfvendor(new Object[]{
    null, 
    pObject, 
    pType, 
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
  public Set<Control> getAllValuesOfobject(final LockOp2ControlTypeMatch partialMatch) {
    return rawAccumulateAllValuesOfobject(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for object.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfobject(final String pVendor, final String pType, final Composite pComposite) {
    return rawAccumulateAllValuesOfobject(new Object[]{
    pVendor, 
    null, 
    pType, 
    pComposite
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
  public Set<String> getAllValuesOftype(final LockOp2ControlTypeMatch partialMatch) {
    return rawAccumulateAllValuesOftype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOftype(final String pVendor, final Control pObject, final Composite pComposite) {
    return rawAccumulateAllValuesOftype(new Object[]{
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
  public Set<Composite> getAllValuesOfcomposite(final LockOp2ControlTypeMatch partialMatch) {
    return rawAccumulateAllValuesOfcomposite(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for composite.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Composite> getAllValuesOfcomposite(final String pVendor, final Control pObject, final String pType) {
    return rawAccumulateAllValuesOfcomposite(new Object[]{
    pVendor, 
    pObject, 
    pType, 
    null
    });
  }
  
  @Override
  protected LockOp2ControlTypeMatch tupleToMatch(final Tuple t) {
    try {
    	return LockOp2ControlTypeMatch.newMatch((java.lang.String) t.get(POSITION_VENDOR), (wt.Control) t.get(POSITION_OBJECT), (java.lang.String) t.get(POSITION_TYPE), (wt.Composite) t.get(POSITION_COMPOSITE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LockOp2ControlTypeMatch arrayToMatch(final Object[] match) {
    try {
    	return LockOp2ControlTypeMatch.newMatch((java.lang.String) match[POSITION_VENDOR], (wt.Control) match[POSITION_OBJECT], (java.lang.String) match[POSITION_TYPE], (wt.Composite) match[POSITION_COMPOSITE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LockOp2ControlTypeMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return LockOp2ControlTypeMatch.newMutableMatch((java.lang.String) match[POSITION_VENDOR], (wt.Control) match[POSITION_OBJECT], (java.lang.String) match[POSITION_TYPE], (wt.Composite) match[POSITION_COMPOSITE]);
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
  public static IQuerySpecification<LockOp2ControlTypeMatcher> querySpecification() throws IncQueryException {
    return LockOp2ControlTypeQuerySpecification.instance();
  }
}
