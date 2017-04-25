package org.mondo.collaboration.security.query;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.query.ContainedByMatcher;
import org.mondo.collaboration.security.query.FragmentMatcher;
import org.mondo.collaboration.security.query.LockOp1Matcher;
import org.mondo.collaboration.security.query.LockOp2ControlConsumeMatcher;
import org.mondo.collaboration.security.query.LockOp2ControlCycleMatcher;
import org.mondo.collaboration.security.query.LockOp2ControlProvideMatcher;
import org.mondo.collaboration.security.query.LockOp2ControlTypeMatcher;
import org.mondo.collaboration.security.query.LockOp2Matcher;
import org.mondo.collaboration.security.query.LockOp2SignalFrequencyMatcher;
import org.mondo.collaboration.security.query.LockOp3Matcher;
import org.mondo.collaboration.security.query.util.ContainedByQuerySpecification;
import org.mondo.collaboration.security.query.util.FragmentQuerySpecification;
import org.mondo.collaboration.security.query.util.LockOp1QuerySpecification;
import org.mondo.collaboration.security.query.util.LockOp2ControlConsumeQuerySpecification;
import org.mondo.collaboration.security.query.util.LockOp2ControlCycleQuerySpecification;
import org.mondo.collaboration.security.query.util.LockOp2ControlProvideQuerySpecification;
import org.mondo.collaboration.security.query.util.LockOp2ControlTypeQuerySpecification;
import org.mondo.collaboration.security.query.util.LockOp2QuerySpecification;
import org.mondo.collaboration.security.query.util.LockOp2SignalFrequencyQuerySpecification;
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
 * <li>lockOp2ControlCycle</li>
 * <li>lockOp2ControlType</li>
 * <li>lockOp2ControlProvide</li>
 * <li>lockOp2ControlConsume</li>
 * <li>lockOp2SignalFrequency</li>
 * <li>lockOp3</li>
 * <li>fragment</li>
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
    querySpecifications.add(LockOp2ControlCycleQuerySpecification.instance());
    querySpecifications.add(LockOp2ControlTypeQuerySpecification.instance());
    querySpecifications.add(LockOp2ControlProvideQuerySpecification.instance());
    querySpecifications.add(LockOp2ControlConsumeQuerySpecification.instance());
    querySpecifications.add(LockOp2SignalFrequencyQuerySpecification.instance());
    querySpecifications.add(LockOp3QuerySpecification.instance());
    querySpecifications.add(FragmentQuerySpecification.instance());
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
  
  public LockOp2ControlCycleQuerySpecification getLockOp2ControlCycle() throws IncQueryException {
    return LockOp2ControlCycleQuerySpecification.instance();
  }
  
  public LockOp2ControlCycleMatcher getLockOp2ControlCycle(final IncQueryEngine engine) throws IncQueryException {
    return LockOp2ControlCycleMatcher.on(engine);
  }
  
  public LockOp2ControlTypeQuerySpecification getLockOp2ControlType() throws IncQueryException {
    return LockOp2ControlTypeQuerySpecification.instance();
  }
  
  public LockOp2ControlTypeMatcher getLockOp2ControlType(final IncQueryEngine engine) throws IncQueryException {
    return LockOp2ControlTypeMatcher.on(engine);
  }
  
  public LockOp2ControlProvideQuerySpecification getLockOp2ControlProvide() throws IncQueryException {
    return LockOp2ControlProvideQuerySpecification.instance();
  }
  
  public LockOp2ControlProvideMatcher getLockOp2ControlProvide(final IncQueryEngine engine) throws IncQueryException {
    return LockOp2ControlProvideMatcher.on(engine);
  }
  
  public LockOp2ControlConsumeQuerySpecification getLockOp2ControlConsume() throws IncQueryException {
    return LockOp2ControlConsumeQuerySpecification.instance();
  }
  
  public LockOp2ControlConsumeMatcher getLockOp2ControlConsume(final IncQueryEngine engine) throws IncQueryException {
    return LockOp2ControlConsumeMatcher.on(engine);
  }
  
  public LockOp2SignalFrequencyQuerySpecification getLockOp2SignalFrequency() throws IncQueryException {
    return LockOp2SignalFrequencyQuerySpecification.instance();
  }
  
  public LockOp2SignalFrequencyMatcher getLockOp2SignalFrequency(final IncQueryEngine engine) throws IncQueryException {
    return LockOp2SignalFrequencyMatcher.on(engine);
  }
  
  public LockOp3QuerySpecification getLockOp3() throws IncQueryException {
    return LockOp3QuerySpecification.instance();
  }
  
  public LockOp3Matcher getLockOp3(final IncQueryEngine engine) throws IncQueryException {
    return LockOp3Matcher.on(engine);
  }
  
  public FragmentQuerySpecification getFragment() throws IncQueryException {
    return FragmentQuerySpecification.instance();
  }
  
  public FragmentMatcher getFragment(final IncQueryEngine engine) throws IncQueryException {
    return FragmentMatcher.on(engine);
  }
  
  public ContainedByQuerySpecification getContainedBy() throws IncQueryException {
    return ContainedByQuerySpecification.instance();
  }
  
  public ContainedByMatcher getContainedBy(final IncQueryEngine engine) throws IncQueryException {
    return ContainedByMatcher.on(engine);
  }
}
