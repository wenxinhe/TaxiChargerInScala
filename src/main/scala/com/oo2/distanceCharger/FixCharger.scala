package com.oo2.distanceCharger

case class FixCharger(startDistance: Double, fixFare: Double) extends DistanceCharger {

  override def chargeFor(distance: Double): Double =
    basicCharger.chargeFor(basicDistance(distance, startDistance)) + fixFare

}
