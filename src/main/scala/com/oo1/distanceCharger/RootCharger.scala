package com.oo1.distanceCharger

object RootCharger extends DistanceCharger {
  override def chargeFor(distance: Double): Double = 0.0

  override def overDistance(distance: Double): Double = distance
}
