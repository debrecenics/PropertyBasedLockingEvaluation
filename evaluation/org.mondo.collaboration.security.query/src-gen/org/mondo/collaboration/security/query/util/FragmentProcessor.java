package org.mondo.collaboration.security.query.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.mondo.collaboration.security.query.FragmentMatch;
import wt.Module;

/**
 * A match processor tailored for the org.mondo.collaboration.security.query.fragment pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class FragmentProcessor implements IMatchProcessor<FragmentMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pFragment the value of pattern parameter fragment in the currently processed match
   * 
   */
  public abstract void process(final Module pFragment);
  
  @Override
  public void process(final FragmentMatch match) {
    process(match.getFragment());
  }
}
