package org.mondo.collaboration.security.query;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.util.FragmentQuerySpecification;
import wt.Module;

/**
 * Pattern-specific match representation of the org.mondo.collaboration.security.query.fragment pattern,
 * to be used in conjunction with {@link FragmentMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see FragmentMatcher
 * @see FragmentProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class FragmentMatch extends BasePatternMatch {
  private Module fFragment;
  
  private static List<String> parameterNames = makeImmutableList("fragment");
  
  private FragmentMatch(final Module pFragment) {
    this.fFragment = pFragment;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("fragment".equals(parameterName)) return this.fFragment;
    return null;
  }
  
  public Module getFragment() {
    return this.fFragment;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("fragment".equals(parameterName) ) {
    	this.fFragment = (wt.Module) newValue;
    	return true;
    }
    return false;
  }
  
  public void setFragment(final Module pFragment) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fFragment = pFragment;
  }
  
  @Override
  public String patternName() {
    return "org.mondo.collaboration.security.query.fragment";
  }
  
  @Override
  public List<String> parameterNames() {
    return FragmentMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fFragment};
  }
  
  @Override
  public FragmentMatch toImmutable() {
    return isMutable() ? newMatch(fFragment) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"fragment\"=" + prettyPrintValue(fFragment)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fFragment == null) ? 0 : fFragment.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof FragmentMatch)) { // this should be infrequent
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
    FragmentMatch other = (FragmentMatch) obj;
    if (fFragment == null) {if (other.fFragment != null) return false;}
    else if (!fFragment.equals(other.fFragment)) return false;
    return true;
  }
  
  @Override
  public FragmentQuerySpecification specification() {
    try {
    	return FragmentQuerySpecification.instance();
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
  public static FragmentMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pFragment the fixed value of pattern parameter fragment, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static FragmentMatch newMutableMatch(final Module pFragment) {
    return new Mutable(pFragment);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pFragment the fixed value of pattern parameter fragment, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static FragmentMatch newMatch(final Module pFragment) {
    return new Immutable(pFragment);
  }
  
  private static final class Mutable extends FragmentMatch {
    Mutable(final Module pFragment) {
      super(pFragment);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends FragmentMatch {
    Immutable(final Module pFragment) {
      super(pFragment);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
