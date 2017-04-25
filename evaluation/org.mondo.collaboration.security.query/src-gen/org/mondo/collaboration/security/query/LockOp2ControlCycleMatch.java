package org.mondo.collaboration.security.query;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.util.LockOp2ControlCycleQuerySpecification;
import wt.Composite;
import wt.Control;

/**
 * Pattern-specific match representation of the org.mondo.collaboration.security.query.lockOp2ControlCycle pattern,
 * to be used in conjunction with {@link LockOp2ControlCycleMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see LockOp2ControlCycleMatcher
 * @see LockOp2ControlCycleProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class LockOp2ControlCycleMatch extends BasePatternMatch {
  private String fVendor;
  
  private Control fObject;
  
  private String fCycle;
  
  private Composite fComposite;
  
  private static List<String> parameterNames = makeImmutableList("vendor", "object", "cycle", "composite");
  
  private LockOp2ControlCycleMatch(final String pVendor, final Control pObject, final String pCycle, final Composite pComposite) {
    this.fVendor = pVendor;
    this.fObject = pObject;
    this.fCycle = pCycle;
    this.fComposite = pComposite;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("vendor".equals(parameterName)) return this.fVendor;
    if ("object".equals(parameterName)) return this.fObject;
    if ("cycle".equals(parameterName)) return this.fCycle;
    if ("composite".equals(parameterName)) return this.fComposite;
    return null;
  }
  
  public String getVendor() {
    return this.fVendor;
  }
  
  public Control getObject() {
    return this.fObject;
  }
  
  public String getCycle() {
    return this.fCycle;
  }
  
  public Composite getComposite() {
    return this.fComposite;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("vendor".equals(parameterName) ) {
    	this.fVendor = (java.lang.String) newValue;
    	return true;
    }
    if ("object".equals(parameterName) ) {
    	this.fObject = (wt.Control) newValue;
    	return true;
    }
    if ("cycle".equals(parameterName) ) {
    	this.fCycle = (java.lang.String) newValue;
    	return true;
    }
    if ("composite".equals(parameterName) ) {
    	this.fComposite = (wt.Composite) newValue;
    	return true;
    }
    return false;
  }
  
  public void setVendor(final String pVendor) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fVendor = pVendor;
  }
  
  public void setObject(final Control pObject) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fObject = pObject;
  }
  
  public void setCycle(final String pCycle) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCycle = pCycle;
  }
  
  public void setComposite(final Composite pComposite) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fComposite = pComposite;
  }
  
  @Override
  public String patternName() {
    return "org.mondo.collaboration.security.query.lockOp2ControlCycle";
  }
  
  @Override
  public List<String> parameterNames() {
    return LockOp2ControlCycleMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fVendor, fObject, fCycle, fComposite};
  }
  
  @Override
  public LockOp2ControlCycleMatch toImmutable() {
    return isMutable() ? newMatch(fVendor, fObject, fCycle, fComposite) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"vendor\"=" + prettyPrintValue(fVendor) + ", ");
    
    result.append("\"object\"=" + prettyPrintValue(fObject) + ", ");
    
    result.append("\"cycle\"=" + prettyPrintValue(fCycle) + ", ");
    
    result.append("\"composite\"=" + prettyPrintValue(fComposite)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fVendor == null) ? 0 : fVendor.hashCode());
    result = prime * result + ((fObject == null) ? 0 : fObject.hashCode());
    result = prime * result + ((fCycle == null) ? 0 : fCycle.hashCode());
    result = prime * result + ((fComposite == null) ? 0 : fComposite.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof LockOp2ControlCycleMatch)) { // this should be infrequent
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
    LockOp2ControlCycleMatch other = (LockOp2ControlCycleMatch) obj;
    if (fVendor == null) {if (other.fVendor != null) return false;}
    else if (!fVendor.equals(other.fVendor)) return false;
    if (fObject == null) {if (other.fObject != null) return false;}
    else if (!fObject.equals(other.fObject)) return false;
    if (fCycle == null) {if (other.fCycle != null) return false;}
    else if (!fCycle.equals(other.fCycle)) return false;
    if (fComposite == null) {if (other.fComposite != null) return false;}
    else if (!fComposite.equals(other.fComposite)) return false;
    return true;
  }
  
  @Override
  public LockOp2ControlCycleQuerySpecification specification() {
    try {
    	return LockOp2ControlCycleQuerySpecification.instance();
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
  public static LockOp2ControlCycleMatch newEmptyMatch() {
    return new Mutable(null, null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pCycle the fixed value of pattern parameter cycle, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static LockOp2ControlCycleMatch newMutableMatch(final String pVendor, final Control pObject, final String pCycle, final Composite pComposite) {
    return new Mutable(pVendor, pObject, pCycle, pComposite);
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
  public static LockOp2ControlCycleMatch newMatch(final String pVendor, final Control pObject, final String pCycle, final Composite pComposite) {
    return new Immutable(pVendor, pObject, pCycle, pComposite);
  }
  
  private static final class Mutable extends LockOp2ControlCycleMatch {
    Mutable(final String pVendor, final Control pObject, final String pCycle, final Composite pComposite) {
      super(pVendor, pObject, pCycle, pComposite);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends LockOp2ControlCycleMatch {
    Immutable(final String pVendor, final Control pObject, final String pCycle, final Composite pComposite) {
      super(pVendor, pObject, pCycle, pComposite);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
