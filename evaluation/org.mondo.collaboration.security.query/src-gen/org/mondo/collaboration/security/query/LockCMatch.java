package org.mondo.collaboration.security.query;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.util.LockCQuerySpecification;
import wt.Signal;

/**
 * Pattern-specific match representation of the org.mondo.collaboration.security.query.lockC pattern,
 * to be used in conjunction with {@link LockCMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see LockCMatcher
 * @see LockCProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class LockCMatch extends BasePatternMatch {
  private Signal fSignal;
  
  private String fVendor;
  
  private static List<String> parameterNames = makeImmutableList("signal", "vendor");
  
  private LockCMatch(final Signal pSignal, final String pVendor) {
    this.fSignal = pSignal;
    this.fVendor = pVendor;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("signal".equals(parameterName)) return this.fSignal;
    if ("vendor".equals(parameterName)) return this.fVendor;
    return null;
  }
  
  public Signal getSignal() {
    return this.fSignal;
  }
  
  public String getVendor() {
    return this.fVendor;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("signal".equals(parameterName) ) {
    	this.fSignal = (wt.Signal) newValue;
    	return true;
    }
    if ("vendor".equals(parameterName) ) {
    	this.fVendor = (java.lang.String) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSignal(final Signal pSignal) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSignal = pSignal;
  }
  
  public void setVendor(final String pVendor) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fVendor = pVendor;
  }
  
  @Override
  public String patternName() {
    return "org.mondo.collaboration.security.query.lockC";
  }
  
  @Override
  public List<String> parameterNames() {
    return LockCMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSignal, fVendor};
  }
  
  @Override
  public LockCMatch toImmutable() {
    return isMutable() ? newMatch(fSignal, fVendor) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"signal\"=" + prettyPrintValue(fSignal) + ", ");
    
    result.append("\"vendor\"=" + prettyPrintValue(fVendor)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSignal == null) ? 0 : fSignal.hashCode());
    result = prime * result + ((fVendor == null) ? 0 : fVendor.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof LockCMatch)) { // this should be infrequent
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
    LockCMatch other = (LockCMatch) obj;
    if (fSignal == null) {if (other.fSignal != null) return false;}
    else if (!fSignal.equals(other.fSignal)) return false;
    if (fVendor == null) {if (other.fVendor != null) return false;}
    else if (!fVendor.equals(other.fVendor)) return false;
    return true;
  }
  
  @Override
  public LockCQuerySpecification specification() {
    try {
    	return LockCQuerySpecification.instance();
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
  public static LockCMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static LockCMatch newMutableMatch(final Signal pSignal, final String pVendor) {
    return new Mutable(pSignal, pVendor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static LockCMatch newMatch(final Signal pSignal, final String pVendor) {
    return new Immutable(pSignal, pVendor);
  }
  
  private static final class Mutable extends LockCMatch {
    Mutable(final Signal pSignal, final String pVendor) {
      super(pSignal, pVendor);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends LockCMatch {
    Immutable(final Signal pSignal, final String pVendor) {
      super(pSignal, pVendor);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
