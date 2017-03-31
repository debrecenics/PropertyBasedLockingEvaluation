package org.mondo.collaboration.security.query.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.mondo.collaboration.security.query.LockCHelperMatch;
import wt.Control;
import wt.Module;
import wt.Signal;

/**
 * A match processor tailored for the org.mondo.collaboration.security.query.lockCHelper pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class LockCHelperProcessor implements IMatchProcessor<LockCHelperMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSignal the value of pattern parameter signal in the currently processed match
   * @param pVendor the value of pattern parameter vendor in the currently processed match
   * @param pProvider the value of pattern parameter provider in the currently processed match
   * @param pConsumer the value of pattern parameter consumer in the currently processed match
   * 
   */
  public abstract void process(final Signal pSignal, final String pVendor, final Control pProvider, final Module pConsumer);
  
  @Override
  public void process(final LockCHelperMatch match) {
    process(match.getSignal(), match.getVendor(), match.getProvider(), match.getConsumer());
  }
}
