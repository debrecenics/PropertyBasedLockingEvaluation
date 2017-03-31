package org.mondo.collaboration.security.query;

import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.util.ObjectobjectQuerySpecification;

/**
 * Pattern-specific match representation of the org.mondo.collaboration.security.query.objectobject pattern,
 * to be used in conjunction with {@link ObjectobjectMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ObjectobjectMatcher
 * @see ObjectobjectProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ObjectobjectMatch extends BasePatternMatch {
  private EObject fObject;
  
  private static List<String> parameterNames = makeImmutableList("object");
  
  private ObjectobjectMatch(final EObject pObject) {
    this.fObject = pObject;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("object".equals(parameterName)) return this.fObject;
    return null;
  }
  
  public EObject getObject() {
    return this.fObject;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("object".equals(parameterName) ) {
    	this.fObject = (org.eclipse.emf.ecore.EObject) newValue;
    	return true;
    }
    return false;
  }
  
  public void setObject(final EObject pObject) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fObject = pObject;
  }
  
  @Override
  public String patternName() {
    return "org.mondo.collaboration.security.query.objectobject";
  }
  
  @Override
  public List<String> parameterNames() {
    return ObjectobjectMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fObject};
  }
  
  @Override
  public ObjectobjectMatch toImmutable() {
    return isMutable() ? newMatch(fObject) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"object\"=" + prettyPrintValue(fObject)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fObject == null) ? 0 : fObject.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ObjectobjectMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    ObjectobjectMatch other = (ObjectobjectMatch) obj;
    if (fObject == null) {if (other.fObject != null) return false;}
    else if (!fObject.equals(other.fObject)) return false;
    return true;
  }
  
  @Override
  public ObjectobjectQuerySpecification specification() {
    try {
    	return ObjectobjectQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static ObjectobjectMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ObjectobjectMatch newMutableMatch(final EObject pObject) {
    return new Mutable(pObject);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ObjectobjectMatch newMatch(final EObject pObject) {
    return new Immutable(pObject);
  }
  
  private static final class Mutable extends ObjectobjectMatch {
    Mutable(final EObject pObject) {
      super(pObject);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ObjectobjectMatch {
    Immutable(final EObject pObject) {
      super(pObject);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
