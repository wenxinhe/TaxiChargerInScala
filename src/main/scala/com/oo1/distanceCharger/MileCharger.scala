package com.oo1.distanceCharger

case class MileCharger(basicCharger: DistanceCharger, maxDistance: Double,
                                  perMileFare: Double) extends DistanceCharger {
  override def chargeFor(distance: Double): Double =
    basicCharger.chargeFor(distance) + inDistance(distance) * perMileFare


  override def overDistance(distance: Double): Double =
    overDistance(maxDistance, distance)

  private def inDistance(distance: Double): Double = {
    Math.min(basicCharger.overDistance(distance),
      basicCharger.overDistance(maxDistance))
  }

}
