package org.mondo.collaboration.security.query;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.util.LockOp3QuerySpecification;
import wt.Signal;

/**
 * Pattern-specific match representation of the org.mondo.collaboration.security.query.lockOp3 pattern,
 * to be used in conjunction with {@link LockOp3Matcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see LockOp3Matcher
 * @see LockOp3Processor
 * 
 */
@SuppressWarnings("all")
public abstract class LockOp3Match extends BasePatternMatch {
  private Signal fSignal;
  
  private String fCycle;
  
  private Integer fValue;
  
  private static List<String> parameterNames = makeImmutableList("signal", "cycle", "value");
  
  private LockOp3Match(final Signal pSignal, final String pCycle, final Integer pValue) {
    this.fSignal = pSignal;
    this.fCycle = pCycle;
    this.fValue = pValue;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("signal".equals(parameterName)) return this.fSignal;
    if ("cycle".equals(parameterName)) return this.fCycle;
    if ("value".equals(parameterName)) return this.fValue;
    return null;
  }
  
  public Signal getSignal() {
    return this.fSignal;
  }
  
  public String getCycle() {
    return this.fCycle;
  }
  
  public Integer getValue() {
    return this.fValue;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("signal".equals(parameterName) ) {
    	this.fSignal = (wt.Signal) newValue;
    	return true;
    }
    if ("cycle".equals(parameterName) ) {
    	this.fCycle = (java.lang.String) newValue;
    	return true;
    }
    if ("value".equals(parameterName) ) {
    	this.fValue = (java.lang.Integer) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSignal(final Signal pSignal) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSignal = pSignal;
  }
  
  public void setCycle(final String pCycle) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCycle = pCycle;
  }
  
  public void setValue(final Integer pValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fValue = pValue;
  }
  
  @Override
  public String patternName() {
    return "org.mondo.collaboration.security.query.lockOp3";
  }
  
  @Override
  public List<String> parameterNames() {
    return LockOp3Match.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSignal, fCycle, fValue};
  }
  
  @Override
  public LockOp3Match toImmutable() {
    return isMutable() ? newMatch(fSignal, fCycle, fValue) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"signal\"=" + prettyPrintValue(fSignal) + ", ");
    
    result.append("\"cycle\"=" + prettyPrintValue(fCycle) + ", ");
    
    result.append("\"value\"=" + prettyPrintValue(fValue)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSignal == null) ? 0 : fSignal.hashCode());
    result = prime * result + ((fCycle == null) ? 0 : fCycle.hashCode());
    result = prime * result + ((fValue == null) ? 0 : fValue.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof LockOp3Match)) { // this should be infrequent
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
    LockOp3Match other = (LockOp3Match) obj;
    if (fSignal == null) {if (other.fSignal != null) return false;}
    else if (!fSignal.equals(other.fSignal)) return false;
    if (fCycle == null) {if (other.fCycle != null) return false;}
    else if (!fCycle.equals(other.fCycle)) return false;
    if (fValue == null) {if (other.fValue != null) return false;}
    else if (!fValue.equals(other.fValue)) return false;
    return true;
  }
  
  @Override
  public LockOp3QuerySpecification specification() {
    try {
    	return LockOp3QuerySpecification.instance();
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
  public static LockOp3Match newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCycle the fixed value of pattern parameter cycle, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static LockOp3Match newMutableMatch(final Signal pSignal, final String pCycle, final Integer pValue) {
    return new Mutable(pSignal, pCycle, pValue);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCycle the fixed value of pattern parameter cycle, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static LockOp3Match newMatch(final Signal pSignal, final String pCycle, final Integer pValue) {
    return new Immutable(pSignal, pCycle, pValue);
  }
  
  private static final class Mutable extends LockOp3Match {
    Mutable(final Signal pSignal, final String pCycle, final Integer pValue) {
      super(pSignal, pCycle, pValue);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends LockOp3Match {
    Immutable(final Signal pSignal, final String pCycle, final Integer pValue) {
      super(pSignal, pCycle, pValue);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
