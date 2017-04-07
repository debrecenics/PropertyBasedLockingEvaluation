package org.mondo.collaboration.security.query.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.mondo.collaboration.security.query.LockOp1HelperMatch;
import wt.Control;
import wt.Signal;

/**
 * A match processor tailored for the org.mondo.collaboration.security.query.lockOp1Helper pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class LockOp1HelperProcessor implements IMatchProcessor<LockOp1HelperMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSignal the value of pattern parameter signal in the currently processed match
   * @param pCtrl the value of pattern parameter ctrl in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * 
   */
  public abstract void process(final Signal pSignal, final Control pCtrl, final String pType);
  
  @Override
  public void process(final LockOp1HelperMatch match) {
    process(match.getSignal(), match.getCtrl(), match.getType());
  }
}
