package org.realityforge.swung_weave;

/**
 * This listener is invoked when a violation occurs.
 * It is invoked in the EDT.
 */
public interface EDTViolationListener
{
  void violationOccurred( EDTViolation violation );
}
