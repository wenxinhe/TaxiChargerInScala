package com.oo1.distanceCharger

import com.TaxiCharger

trait DistanceCharger extends TaxiCharger {
  def overDistance(distance: Double): Double

  protected def overDistance(maxDistance: Double, distance: Double): Double = {
    if (distance > maxDistance)
      Math.ceil(distance - maxDistance)
    else
      0.0
  }
}
