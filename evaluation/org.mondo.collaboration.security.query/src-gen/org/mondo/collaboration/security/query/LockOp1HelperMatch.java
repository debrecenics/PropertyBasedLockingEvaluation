package org.mondo.collaboration.security.query;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.util.LockOp1HelperQuerySpecification;
import wt.Control;
import wt.Signal;

/**
 * Pattern-specific match representation of the org.mondo.collaboration.security.query.lockOp1Helper pattern,
 * to be used in conjunction with {@link LockOp1HelperMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see LockOp1HelperMatcher
 * @see LockOp1HelperProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class LockOp1HelperMatch extends BasePatternMatch {
  private Signal fSignal;
  
  private Control fCtrl;
  
  private String fType;
  
  private static List<String> parameterNames = makeImmutableList("signal", "ctrl", "type");
  
  private LockOp1HelperMatch(final Signal pSignal, final Control pCtrl, final String pType) {
    this.fSignal = pSignal;
    this.fCtrl = pCtrl;
    this.fType = pType;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("signal".equals(parameterName)) return this.fSignal;
    if ("ctrl".equals(parameterName)) return this.fCtrl;
    if ("type".equals(parameterName)) return this.fType;
    return null;
  }
  
  public Signal getSignal() {
    return this.fSignal;
  }
  
  public Control getCtrl() {
    return this.fCtrl;
  }
  
  public String getType() {
    return this.fType;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("signal".equals(parameterName) ) {
    	this.fSignal = (wt.Signal) newValue;
    	return true;
    }
    if ("ctrl".equals(parameterName) ) {
    	this.fCtrl = (wt.Control) newValue;
    	return true;
    }
    if ("type".equals(parameterName) ) {
    	this.fType = (java.lang.String) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSignal(final Signal pSignal) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSignal = pSignal;
  }
  
  public void setCtrl(final Control pCtrl) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCtrl = pCtrl;
  }
  
  public void setType(final String pType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fType = pType;
  }
  
  @Override
  public String patternName() {
    return "org.mondo.collaboration.security.query.lockOp1Helper";
  }
  
  @Override
  public List<String> parameterNames() {
    return LockOp1HelperMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSignal, fCtrl, fType};
  }
  
  @Override
  public LockOp1HelperMatch toImmutable() {
    return isMutable() ? newMatch(fSignal, fCtrl, fType) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"signal\"=" + prettyPrintValue(fSignal) + ", ");
    
    result.append("\"ctrl\"=" + prettyPrintValue(fCtrl) + ", ");
    
    result.append("\"type\"=" + prettyPrintValue(fType)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSignal == null) ? 0 : fSignal.hashCode());
    result = prime * result + ((fCtrl == null) ? 0 : fCtrl.hashCode());
    result = prime * result + ((fType == null) ? 0 : fType.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof LockOp1HelperMatch)) { // this should be infrequent
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
    LockOp1HelperMatch other = (LockOp1HelperMatch) obj;
    if (fSignal == null) {if (other.fSignal != null) return false;}
    else if (!fSignal.equals(other.fSignal)) return false;
    if (fCtrl == null) {if (other.fCtrl != null) return false;}
    else if (!fCtrl.equals(other.fCtrl)) return false;
    if (fType == null) {if (other.fType != null) return false;}
    else if (!fType.equals(other.fType)) return false;
    return true;
  }
  
  @Override
  public LockOp1HelperQuerySpecification specification() {
    try {
    	return LockOp1HelperQuerySpecification.instance();
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
  public static LockOp1HelperMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static LockOp1HelperMatch newMutableMatch(final Signal pSignal, final Control pCtrl, final String pType) {
    return new Mutable(pSignal, pCtrl, pType);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static LockOp1HelperMatch newMatch(final Signal pSignal, final Control pCtrl, final String pType) {
    return new Immutable(pSignal, pCtrl, pType);
  }
  
  private static final class Mutable extends LockOp1HelperMatch {
    Mutable(final Signal pSignal, final Control pCtrl, final String pType) {
      super(pSignal, pCtrl, pType);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends LockOp1HelperMatch {
    Immutable(final Signal pSignal, final Control pCtrl, final String pType) {
      super(pSignal, pCtrl, pType);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
