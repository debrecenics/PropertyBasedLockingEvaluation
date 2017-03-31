package org.mondo.collaboration.security.query;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.LockAHelperMatcher;
import org.mondo.collaboration.security.query.LockAMatcher;
import org.mondo.collaboration.security.query.LockBMatcher;
import org.mondo.collaboration.security.query.LockCHelperMatcher;
import org.mondo.collaboration.security.query.LockCMatcher;
import org.mondo.collaboration.security.query.ObjectobjectMatcher;
import org.mondo.collaboration.security.query.util.LockAHelperQuerySpecification;
import org.mondo.collaboration.security.query.util.LockAQuerySpecification;
import org.mondo.collaboration.security.query.util.LockBQuerySpecification;
import org.mondo.collaboration.security.query.util.LockCHelperQuerySpecification;
import org.mondo.collaboration.security.query.util.LockCQuerySpecification;
import org.mondo.collaboration.security.query.util.ObjectobjectQuerySpecification;

/**
 * A pattern group formed of all patterns defined in lockQueries.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file lockQueries.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package org.mondo.collaboration.security.query, the group contains the definition of the following patterns: <ul>
 * <li>lockA</li>
 * <li>lockAHelper</li>
 * <li>lockB</li>
 * <li>lockC</li>
 * <li>lockCHelper</li>
 * <li>objectobject</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class LockQueries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static LockQueries instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new LockQueries();
    }
    return INSTANCE;
  }
  
  private static LockQueries INSTANCE;
  
  private LockQueries() throws IncQueryException {
    querySpecifications.add(LockAQuerySpecification.instance());
    querySpecifications.add(LockAHelperQuerySpecification.instance());
    querySpecifications.add(LockBQuerySpecification.instance());
    querySpecifications.add(LockCQuerySpecification.instance());
    querySpecifications.add(LockCHelperQuerySpecification.instance());
    querySpecifications.add(ObjectobjectQuerySpecification.instance());
  }
  
  public LockAQuerySpecification getLockA() throws IncQueryException {
    return LockAQuerySpecification.instance();
  }
  
  public LockAMatcher getLockA(final IncQueryEngine engine) throws IncQueryException {
    return LockAMatcher.on(engine);
  }
  
  public LockAHelperQuerySpecification getLockAHelper() throws IncQueryException {
    return LockAHelperQuerySpecification.instance();
  }
  
  public LockAHelperMatcher getLockAHelper(final IncQueryEngine engine) throws IncQueryException {
    return LockAHelperMatcher.on(engine);
  }
  
  public LockBQuerySpecification getLockB() throws IncQueryException {
    return LockBQuerySpecification.instance();
  }
  
  public LockBMatcher getLockB(final IncQueryEngine engine) throws IncQueryException {
    return LockBMatcher.on(engine);
  }
  
  public LockCQuerySpecification getLockC() throws IncQueryException {
    return LockCQuerySpecification.instance();
  }
  
  public LockCMatcher getLockC(final IncQueryEngine engine) throws IncQueryException {
    return LockCMatcher.on(engine);
  }
  
  public LockCHelperQuerySpecification getLockCHelper() throws IncQueryException {
    return LockCHelperQuerySpecification.instance();
  }
  
  public LockCHelperMatcher getLockCHelper(final IncQueryEngine engine) throws IncQueryException {
    return LockCHelperMatcher.on(engine);
  }
  
  public ObjectobjectQuerySpecification getObjectobject() throws IncQueryException {
    return ObjectobjectQuerySpecification.instance();
  }
  
  public ObjectobjectMatcher getObjectobject(final IncQueryEngine engine) throws IncQueryException {
    return ObjectobjectMatcher.on(engine);
  }
}
