package org.mondo.collaboration.security.query;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.util.LockOp2QuerySpecification;
import wt.Control;

/**
 * Pattern-specific match representation of the org.mondo.collaboration.security.query.lockOp2 pattern,
 * to be used in conjunction with {@link LockOp2Matcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see LockOp2Matcher
 * @see LockOp2Processor
 * 
 */
@SuppressWarnings("all")
public abstract class LockOp2Match extends BasePatternMatch {
  private String fVendor;
  
  private Control fControl;
  
  private static List<String> parameterNames = makeImmutableList("vendor", "control");
  
  private LockOp2Match(final String pVendor, final Control pControl) {
    this.fVendor = pVendor;
    this.fControl = pControl;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("vendor".equals(parameterName)) return this.fVendor;
    if ("control".equals(parameterName)) return this.fControl;
    return null;
  }
  
  public String getVendor() {
    return this.fVendor;
  }
  
  public Control getControl() {
    return this.fControl;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("vendor".equals(parameterName) ) {
    	this.fVendor = (java.lang.String) newValue;
    	return true;
    }
    if ("control".equals(parameterName) ) {
    	this.fControl = (wt.Control) newValue;
    	return true;
    }
    return false;
  }
  
  public void setVendor(final String pVendor) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fVendor = pVendor;
  }
  
  public void setControl(final Control pControl) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fControl = pControl;
  }
  
  @Override
  public String patternName() {
    return "org.mondo.collaboration.security.query.lockOp2";
  }
  
  @Override
  public List<String> parameterNames() {
    return LockOp2Match.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fVendor, fControl};
  }
  
  @Override
  public LockOp2Match toImmutable() {
    return isMutable() ? newMatch(fVendor, fControl) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"vendor\"=" + prettyPrintValue(fVendor) + ", ");
    
    result.append("\"control\"=" + prettyPrintValue(fControl)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fVendor == null) ? 0 : fVendor.hashCode());
    result = prime * result + ((fControl == null) ? 0 : fControl.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof LockOp2Match)) { // this should be infrequent
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
    LockOp2Match other = (LockOp2Match) obj;
    if (fVendor == null) {if (other.fVendor != null) return false;}
    else if (!fVendor.equals(other.fVendor)) return false;
    if (fControl == null) {if (other.fControl != null) return false;}
    else if (!fControl.equals(other.fControl)) return false;
    return true;
  }
  
  @Override
  public LockOp2QuerySpecification specification() {
    try {
    	return LockOp2QuerySpecification.instance();
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
  public static LockOp2Match newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pControl the fixed value of pattern parameter control, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static LockOp2Match newMutableMatch(final String pVendor, final Control pControl) {
    return new Mutable(pVendor, pControl);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pControl the fixed value of pattern parameter control, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static LockOp2Match newMatch(final String pVendor, final Control pControl) {
    return new Immutable(pVendor, pControl);
  }
  
  private static final class Mutable extends LockOp2Match {
    Mutable(final String pVendor, final Control pControl) {
      super(pVendor, pControl);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends LockOp2Match {
    Immutable(final String pVendor, final Control pControl) {
      super(pVendor, pControl);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
