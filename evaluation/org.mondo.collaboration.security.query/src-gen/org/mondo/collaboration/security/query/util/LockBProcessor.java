package org.mondo.collaboration.security.query.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.mondo.collaboration.security.query.LockBMatch;
import wt.Module;
import wt.Signal;

/**
 * A match processor tailored for the org.mondo.collaboration.security.query.lockB pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class LockBProcessor implements IMatchProcessor<LockBMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSignal the value of pattern parameter signal in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * @param pModule the value of pattern parameter module in the currently processed match
   * 
   */
  public abstract void process(final Signal pSignal, final String pType, final Module pModule);
  
  @Override
  public void process(final LockBMatch match) {
    process(match.getSignal(), match.getType(), match.getModule());
  }
}
