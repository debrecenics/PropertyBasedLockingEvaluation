package org.mondo.collaboration.security.query.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.mondo.collaboration.security.query.LockOp2SignalFrequencyMatch;
import wt.Composite;
import wt.Signal;

/**
 * A match processor tailored for the org.mondo.collaboration.security.query.lockOp2SignalFrequency pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class LockOp2SignalFrequencyProcessor implements IMatchProcessor<LockOp2SignalFrequencyMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pVendor the value of pattern parameter vendor in the currently processed match
   * @param pObject the value of pattern parameter object in the currently processed match
   * @param pFrequency the value of pattern parameter frequency in the currently processed match
   * @param pComposite the value of pattern parameter composite in the currently processed match
   * 
   */
  public abstract void process(final String pVendor, final Signal pObject, final Integer pFrequency, final Composite pComposite);
  
  @Override
  public void process(final LockOp2SignalFrequencyMatch match) {
    process(match.getVendor(), match.getObject(), match.getFrequency(), match.getComposite());
  }
}
