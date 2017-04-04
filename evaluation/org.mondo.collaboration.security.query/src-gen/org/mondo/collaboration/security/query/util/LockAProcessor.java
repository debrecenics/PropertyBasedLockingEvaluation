package org.mondo.collaboration.security.query.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.mondo.collaboration.security.query.LockAMatch;
import wt.Signal;

/**
 * A match processor tailored for the org.mondo.collaboration.security.query.lockA pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class LockAProcessor implements IMatchProcessor<LockAMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSignal the value of pattern parameter signal in the currently processed match
   * @param pCycle the value of pattern parameter cycle in the currently processed match
   * @param pValue the value of pattern parameter value in the currently processed match
   * 
   */
  public abstract void process(final Signal pSignal, final String pCycle, final Integer pValue);
  
  @Override
  public void process(final LockAMatch match) {
    process(match.getSignal(), match.getCycle(), match.getValue());
  }
}
