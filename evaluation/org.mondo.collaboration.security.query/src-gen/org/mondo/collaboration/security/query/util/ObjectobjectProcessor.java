package org.mondo.collaboration.security.query.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.mondo.collaboration.security.query.ObjectobjectMatch;

/**
 * A match processor tailored for the org.mondo.collaboration.security.query.objectobject pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ObjectobjectProcessor implements IMatchProcessor<ObjectobjectMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pObject the value of pattern parameter object in the currently processed match
   * 
   */
  public abstract void process(final EObject pObject);
  
  @Override
  public void process(final ObjectobjectMatch match) {
    process(match.getObject());
  }
}
