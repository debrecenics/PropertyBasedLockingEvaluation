package org.mondo.collaboration.security.query;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.ContainedByMatcher;
import org.mondo.collaboration.security.query.LockOp1HelperMatcher;
import org.mondo.collaboration.security.query.LockOp1Matcher;
import org.mondo.collaboration.security.query.LockOp2Matcher;
import org.mondo.collaboration.security.query.LockOp3HelperMatcher;
import org.mondo.collaboration.security.query.LockOp3Matcher;
import org.mondo.collaboration.security.query.util.ContainedByQuerySpecification;
import org.mondo.collaboration.security.query.util.LockOp1HelperQuerySpecification;
import org.mondo.collaboration.security.query.util.LockOp1QuerySpecification;
import org.mondo.collaboration.security.query.util.LockOp2QuerySpecification;
import org.mondo.collaboration.security.query.util.LockOp3HelperQuerySpecification;
import org.mondo.collaboration.security.query.util.LockOp3QuerySpecification;

/**
 * A pattern group formed of all patterns defined in lockQueries.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file lockQueries.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package org.mondo.collaboration.security.query, the group contains the definition of the following patterns: <ul>
 * <li>lockOp1</li>
 * <li>lockOp2</li>
 * <li>lockOp3</li>
 * <li>lockOp1Helper</li>
 * <li>lockOp3Helper</li>
 * <li>containedBy</li>
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
    querySpecifications.add(LockOp1QuerySpecification.instance());
    querySpecifications.add(LockOp2QuerySpecification.instance());
    querySpecifications.add(LockOp3QuerySpecification.instance());
    querySpecifications.add(LockOp1HelperQuerySpecification.instance());
    querySpecifications.add(LockOp3HelperQuerySpecification.instance());
    querySpecifications.add(ContainedByQuerySpecification.instance());
  }
  
  public LockOp1QuerySpecification getLockOp1() throws IncQueryException {
    return LockOp1QuerySpecification.instance();
  }
  
  public LockOp1Matcher getLockOp1(final IncQueryEngine engine) throws IncQueryException {
    return LockOp1Matcher.on(engine);
  }
  
  public LockOp2QuerySpecification getLockOp2() throws IncQueryException {
    return LockOp2QuerySpecification.instance();
  }
  
  public LockOp2Matcher getLockOp2(final IncQueryEngine engine) throws IncQueryException {
    return LockOp2Matcher.on(engine);
  }
  
  public LockOp3QuerySpecification getLockOp3() throws IncQueryException {
    return LockOp3QuerySpecification.instance();
  }
  
  public LockOp3Matcher getLockOp3(final IncQueryEngine engine) throws IncQueryException {
    return LockOp3Matcher.on(engine);
  }
  
  public LockOp1HelperQuerySpecification getLockOp1Helper() throws IncQueryException {
    return LockOp1HelperQuerySpecification.instance();
  }
  
  public LockOp1HelperMatcher getLockOp1Helper(final IncQueryEngine engine) throws IncQueryException {
    return LockOp1HelperMatcher.on(engine);
  }
  
  public LockOp3HelperQuerySpecification getLockOp3Helper() throws IncQueryException {
    return LockOp3HelperQuerySpecification.instance();
  }
  
  public LockOp3HelperMatcher getLockOp3Helper(final IncQueryEngine engine) throws IncQueryException {
    return LockOp3HelperMatcher.on(engine);
  }
  
  public ContainedByQuerySpecification getContainedBy() throws IncQueryException {
    return ContainedByQuerySpecification.instance();
  }
  
  public ContainedByMatcher getContainedBy(final IncQueryEngine engine) throws IncQueryException {
    return ContainedByMatcher.on(engine);
  }
}
