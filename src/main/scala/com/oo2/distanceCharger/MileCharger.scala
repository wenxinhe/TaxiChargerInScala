package com.oo2.distanceCharger

case class MileCharger(startDistance: Double, perMileFare: Double) extends DistanceCharger {

  override def chargeFor(distance: Double): Double = {
    basicCharger.chargeFor(basicDistance(distance, startDistance)) + inDistance(distance, startDistance) * perMileFare
  }
}
