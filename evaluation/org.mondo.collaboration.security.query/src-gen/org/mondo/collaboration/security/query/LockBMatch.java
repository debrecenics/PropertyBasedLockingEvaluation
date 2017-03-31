package org.mondo.collaboration.security.query;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.util.LockBQuerySpecification;
import wt.Module;
import wt.Signal;

/**
 * Pattern-specific match representation of the org.mondo.collaboration.security.query.lockB pattern,
 * to be used in conjunction with {@link LockBMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see LockBMatcher
 * @see LockBProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class LockBMatch extends BasePatternMatch {
  private Signal fSignal;
  
  private String fType;
  
  private Module fModule;
  
  private static List<String> parameterNames = makeImmutableList("signal", "type", "module");
  
  private LockBMatch(final Signal pSignal, final String pType, final Module pModule) {
    this.fSignal = pSignal;
    this.fType = pType;
    this.fModule = pModule;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("signal".equals(parameterName)) return this.fSignal;
    if ("type".equals(parameterName)) return this.fType;
    if ("module".equals(parameterName)) return this.fModule;
    return null;
  }
  
  public Signal getSignal() {
    return this.fSignal;
  }
  
  public String getType() {
    return this.fType;
  }
  
  public Module getModule() {
    return this.fModule;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("signal".equals(parameterName) ) {
    	this.fSignal = (wt.Signal) newValue;
    	return true;
    }
    if ("type".equals(parameterName) ) {
    	this.fType = (java.lang.String) newValue;
    	return true;
    }
    if ("module".equals(parameterName) ) {
    	this.fModule = (wt.Module) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSignal(final Signal pSignal) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSignal = pSignal;
  }
  
  public void setType(final String pType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fType = pType;
  }
  
  public void setModule(final Module pModule) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fModule = pModule;
  }
  
  @Override
  public String patternName() {
    return "org.mondo.collaboration.security.query.lockB";
  }
  
  @Override
  public List<String> parameterNames() {
    return LockBMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSignal, fType, fModule};
  }
  
  @Override
  public LockBMatch toImmutable() {
    return isMutable() ? newMatch(fSignal, fType, fModule) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"signal\"=" + prettyPrintValue(fSignal) + ", ");
    
    result.append("\"type\"=" + prettyPrintValue(fType) + ", ");
    
    result.append("\"module\"=" + prettyPrintValue(fModule)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSignal == null) ? 0 : fSignal.hashCode());
    result = prime * result + ((fType == null) ? 0 : fType.hashCode());
    result = prime * result + ((fModule == null) ? 0 : fModule.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof LockBMatch)) { // this should be infrequent
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
    LockBMatch other = (LockBMatch) obj;
    if (fSignal == null) {if (other.fSignal != null) return false;}
    else if (!fSignal.equals(other.fSignal)) return false;
    if (fType == null) {if (other.fType != null) return false;}
    else if (!fType.equals(other.fType)) return false;
    if (fModule == null) {if (other.fModule != null) return false;}
    else if (!fModule.equals(other.fModule)) return false;
    return true;
  }
  
  @Override
  public LockBQuerySpecification specification() {
    try {
    	return LockBQuerySpecification.instance();
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
  public static LockBMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pModule the fixed value of pattern parameter module, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static LockBMatch newMutableMatch(final Signal pSignal, final String pType, final Module pModule) {
    return new Mutable(pSignal, pType, pModule);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pModule the fixed value of pattern parameter module, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static LockBMatch newMatch(final Signal pSignal, final String pType, final Module pModule) {
    return new Immutable(pSignal, pType, pModule);
  }
  
  private static final class Mutable extends LockBMatch {
    Mutable(final Signal pSignal, final String pType, final Module pModule) {
      super(pSignal, pType, pModule);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends LockBMatch {
    Immutable(final Signal pSignal, final String pType, final Module pModule) {
      super(pSignal, pType, pModule);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
