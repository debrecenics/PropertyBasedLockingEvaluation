package org.mondo.collaboration.security.query;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.util.LockOp1QuerySpecification;
import wt.Control;
import wt.Signal;

/**
 * Pattern-specific match representation of the org.mondo.collaboration.security.query.lockOp1 pattern,
 * to be used in conjunction with {@link LockOp1Matcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see LockOp1Matcher
 * @see LockOp1Processor
 * 
 */
@SuppressWarnings("all")
public abstract class LockOp1Match extends BasePatternMatch {
  private Control fCtrl1;
  
  private Signal fSignal;
  
  private Control fCtrl2;
  
  private String fType;
  
  private static List<String> parameterNames = makeImmutableList("ctrl1", "signal", "ctrl2", "type");
  
  private LockOp1Match(final Control pCtrl1, final Signal pSignal, final Control pCtrl2, final String pType) {
    this.fCtrl1 = pCtrl1;
    this.fSignal = pSignal;
    this.fCtrl2 = pCtrl2;
    this.fType = pType;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("ctrl1".equals(parameterName)) return this.fCtrl1;
    if ("signal".equals(parameterName)) return this.fSignal;
    if ("ctrl2".equals(parameterName)) return this.fCtrl2;
    if ("type".equals(parameterName)) return this.fType;
    return null;
  }
  
  public Control getCtrl1() {
    return this.fCtrl1;
  }
  
  public Signal getSignal() {
    return this.fSignal;
  }
  
  public Control getCtrl2() {
    return this.fCtrl2;
  }
  
  public String getType() {
    return this.fType;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("ctrl1".equals(parameterName) ) {
    	this.fCtrl1 = (wt.Control) newValue;
    	return true;
    }
    if ("signal".equals(parameterName) ) {
    	this.fSignal = (wt.Signal) newValue;
    	return true;
    }
    if ("ctrl2".equals(parameterName) ) {
    	this.fCtrl2 = (wt.Control) newValue;
    	return true;
    }
    if ("type".equals(parameterName) ) {
    	this.fType = (java.lang.String) newValue;
    	return true;
    }
    return false;
  }
  
  public void setCtrl1(final Control pCtrl1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCtrl1 = pCtrl1;
  }
  
  public void setSignal(final Signal pSignal) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSignal = pSignal;
  }
  
  public void setCtrl2(final Control pCtrl2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCtrl2 = pCtrl2;
  }
  
  public void setType(final String pType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fType = pType;
  }
  
  @Override
  public String patternName() {
    return "org.mondo.collaboration.security.query.lockOp1";
  }
  
  @Override
  public List<String> parameterNames() {
    return LockOp1Match.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCtrl1, fSignal, fCtrl2, fType};
  }
  
  @Override
  public LockOp1Match toImmutable() {
    return isMutable() ? newMatch(fCtrl1, fSignal, fCtrl2, fType) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"ctrl1\"=" + prettyPrintValue(fCtrl1) + ", ");
    
    result.append("\"signal\"=" + prettyPrintValue(fSignal) + ", ");
    
    result.append("\"ctrl2\"=" + prettyPrintValue(fCtrl2) + ", ");
    
    result.append("\"type\"=" + prettyPrintValue(fType)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCtrl1 == null) ? 0 : fCtrl1.hashCode());
    result = prime * result + ((fSignal == null) ? 0 : fSignal.hashCode());
    result = prime * result + ((fCtrl2 == null) ? 0 : fCtrl2.hashCode());
    result = prime * result + ((fType == null) ? 0 : fType.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof LockOp1Match)) { // this should be infrequent
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
    LockOp1Match other = (LockOp1Match) obj;
    if (fCtrl1 == null) {if (other.fCtrl1 != null) return false;}
    else if (!fCtrl1.equals(other.fCtrl1)) return false;
    if (fSignal == null) {if (other.fSignal != null) return false;}
    else if (!fSignal.equals(other.fSignal)) return false;
    if (fCtrl2 == null) {if (other.fCtrl2 != null) return false;}
    else if (!fCtrl2.equals(other.fCtrl2)) return false;
    if (fType == null) {if (other.fType != null) return false;}
    else if (!fType.equals(other.fType)) return false;
    return true;
  }
  
  @Override
  public LockOp1QuerySpecification specification() {
    try {
    	return LockOp1QuerySpecification.instance();
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
  public static LockOp1Match newEmptyMatch() {
    return new Mutable(null, null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCtrl1 the fixed value of pattern parameter ctrl1, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pCtrl2 the fixed value of pattern parameter ctrl2, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static LockOp1Match newMutableMatch(final Control pCtrl1, final Signal pSignal, final Control pCtrl2, final String pType) {
    return new Mutable(pCtrl1, pSignal, pCtrl2, pType);
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
  public static LockOp1Match newMatch(final Control pCtrl1, final Signal pSignal, final Control pCtrl2, final String pType) {
    return new Immutable(pCtrl1, pSignal, pCtrl2, pType);
  }
  
  private static final class Mutable extends LockOp1Match {
    Mutable(final Control pCtrl1, final Signal pSignal, final Control pCtrl2, final String pType) {
      super(pCtrl1, pSignal, pCtrl2, pType);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends LockOp1Match {
    Immutable(final Control pCtrl1, final Signal pSignal, final Control pCtrl2, final String pType) {
      super(pCtrl1, pSignal, pCtrl2, pType);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
