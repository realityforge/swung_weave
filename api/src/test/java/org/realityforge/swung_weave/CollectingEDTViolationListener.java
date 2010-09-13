package org.realityforge.swung_weave;

import java.util.LinkedList;

final class CollectingEDTViolationListener
  implements EDTViolationListener
{
  final LinkedList<EDTViolation> _violations = new LinkedList<EDTViolation>();

  @Override
  public void violationOccurred( final EDTViolation violation )
  {
    //System.out.println( "violationOccurred(" + violation + ")" );
    _violations.add( violation );
  }
}
