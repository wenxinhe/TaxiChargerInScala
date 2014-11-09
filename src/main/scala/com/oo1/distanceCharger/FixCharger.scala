package com.oo1.distanceCharger

case class FixCharger(basicCharger: DistanceCharger, maxDistance: Double, fixFare: Double) extends DistanceCharger {

  def this(basicDistance: Double, fixFare: Double) = this(RootCharger, basicDistance, fixFare)

  override def chargeFor(distance: Double): Double =
    basicCharger.chargeFor(distance) + fixFare

  override def overDistance(distance: Double): Double =
    overDistance(maxDistance, distance)
}

object FixCharger {
   def apply(basicDistance: Double, fixFare: Double) = new FixCharger(basicDistance, fixFare)
}
