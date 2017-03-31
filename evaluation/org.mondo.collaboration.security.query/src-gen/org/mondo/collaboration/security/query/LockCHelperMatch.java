package org.mondo.collaboration.security.query;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.util.LockCHelperQuerySpecification;
import wt.Control;
import wt.Module;
import wt.Signal;

/**
 * Pattern-specific match representation of the org.mondo.collaboration.security.query.lockCHelper pattern,
 * to be used in conjunction with {@link LockCHelperMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see LockCHelperMatcher
 * @see LockCHelperProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class LockCHelperMatch extends BasePatternMatch {
  private Signal fSignal;
  
  private String fVendor;
  
  private Control fProvider;
  
  private Module fConsumer;
  
  private static List<String> parameterNames = makeImmutableList("signal", "vendor", "provider", "consumer");
  
  private LockCHelperMatch(final Signal pSignal, final String pVendor, final Control pProvider, final Module pConsumer) {
    this.fSignal = pSignal;
    this.fVendor = pVendor;
    this.fProvider = pProvider;
    this.fConsumer = pConsumer;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("signal".equals(parameterName)) return this.fSignal;
    if ("vendor".equals(parameterName)) return this.fVendor;
    if ("provider".equals(parameterName)) return this.fProvider;
    if ("consumer".equals(parameterName)) return this.fConsumer;
    return null;
  }
  
  public Signal getSignal() {
    return this.fSignal;
  }
  
  public String getVendor() {
    return this.fVendor;
  }
  
  public Control getProvider() {
    return this.fProvider;
  }
  
  public Module getConsumer() {
    return this.fConsumer;
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
    if ("provider".equals(parameterName) ) {
    	this.fProvider = (wt.Control) newValue;
    	return true;
    }
    if ("consumer".equals(parameterName) ) {
    	this.fConsumer = (wt.Module) newValue;
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
  
  public void setProvider(final Control pProvider) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fProvider = pProvider;
  }
  
  public void setConsumer(final Module pConsumer) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fConsumer = pConsumer;
  }
  
  @Override
  public String patternName() {
    return "org.mondo.collaboration.security.query.lockCHelper";
  }
  
  @Override
  public List<String> parameterNames() {
    return LockCHelperMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSignal, fVendor, fProvider, fConsumer};
  }
  
  @Override
  public LockCHelperMatch toImmutable() {
    return isMutable() ? newMatch(fSignal, fVendor, fProvider, fConsumer) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"signal\"=" + prettyPrintValue(fSignal) + ", ");
    
    result.append("\"vendor\"=" + prettyPrintValue(fVendor) + ", ");
    
    result.append("\"provider\"=" + prettyPrintValue(fProvider) + ", ");
    
    result.append("\"consumer\"=" + prettyPrintValue(fConsumer)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSignal == null) ? 0 : fSignal.hashCode());
    result = prime * result + ((fVendor == null) ? 0 : fVendor.hashCode());
    result = prime * result + ((fProvider == null) ? 0 : fProvider.hashCode());
    result = prime * result + ((fConsumer == null) ? 0 : fConsumer.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof LockCHelperMatch)) { // this should be infrequent
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
    LockCHelperMatch other = (LockCHelperMatch) obj;
    if (fSignal == null) {if (other.fSignal != null) return false;}
    else if (!fSignal.equals(other.fSignal)) return false;
    if (fVendor == null) {if (other.fVendor != null) return false;}
    else if (!fVendor.equals(other.fVendor)) return false;
    if (fProvider == null) {if (other.fProvider != null) return false;}
    else if (!fProvider.equals(other.fProvider)) return false;
    if (fConsumer == null) {if (other.fConsumer != null) return false;}
    else if (!fConsumer.equals(other.fConsumer)) return false;
    return true;
  }
  
  @Override
  public LockCHelperQuerySpecification specification() {
    try {
    	return LockCHelperQuerySpecification.instance();
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
  public static LockCHelperMatch newEmptyMatch() {
    return new Mutable(null, null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pProvider the fixed value of pattern parameter provider, or null if not bound.
   * @param pConsumer the fixed value of pattern parameter consumer, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static LockCHelperMatch newMutableMatch(final Signal pSignal, final String pVendor, final Control pProvider, final Module pConsumer) {
    return new Mutable(pSignal, pVendor, pProvider, pConsumer);
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
  public static LockCHelperMatch newMatch(final Signal pSignal, final String pVendor, final Control pProvider, final Module pConsumer) {
    return new Immutable(pSignal, pVendor, pProvider, pConsumer);
  }
  
  private static final class Mutable extends LockCHelperMatch {
    Mutable(final Signal pSignal, final String pVendor, final Control pProvider, final Module pConsumer) {
      super(pSignal, pVendor, pProvider, pConsumer);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends LockCHelperMatch {
    Immutable(final Signal pSignal, final String pVendor, final Control pProvider, final Module pConsumer) {
      super(pSignal, pVendor, pProvider, pConsumer);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
