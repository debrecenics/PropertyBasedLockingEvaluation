package org.mondo.collaboration.security.query.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.mondo.collaboration.security.query.LockOp1Match;
import wt.Control;
import wt.Signal;

/**
 * A match processor tailored for the org.mondo.collaboration.security.query.lockOp1 pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class LockOp1Processor implements IMatchProcessor<LockOp1Match> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCtrl1 the value of pattern parameter ctrl1 in the currently processed match
   * @param pSignal the value of pattern parameter signal in the currently processed match
   * @param pCtrl2 the value of pattern parameter ctrl2 in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * 
   */
  public abstract void process(final Control pCtrl1, final Signal pSignal, final Control pCtrl2, final String pType);
  
  @Override
  public void process(final LockOp1Match match) {
    process(match.getCtrl1(), match.getSignal(), match.getCtrl2(), match.getType());
  }
}
