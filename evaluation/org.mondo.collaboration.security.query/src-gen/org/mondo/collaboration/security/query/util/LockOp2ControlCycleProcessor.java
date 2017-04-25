package org.mondo.collaboration.security.query.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.mondo.collaboration.security.query.LockOp2ControlCycleMatch;
import wt.Composite;
import wt.Control;

/**
 * A match processor tailored for the org.mondo.collaboration.security.query.lockOp2ControlCycle pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class LockOp2ControlCycleProcessor implements IMatchProcessor<LockOp2ControlCycleMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pVendor the value of pattern parameter vendor in the currently processed match
   * @param pObject the value of pattern parameter object in the currently processed match
   * @param pCycle the value of pattern parameter cycle in the currently processed match
   * @param pComposite the value of pattern parameter composite in the currently processed match
   * 
   */
  public abstract void process(final String pVendor, final Control pObject, final String pCycle, final Composite pComposite);
  
  @Override
  public void process(final LockOp2ControlCycleMatch match) {
    process(match.getVendor(), match.getObject(), match.getCycle(), match.getComposite());
  }
}
