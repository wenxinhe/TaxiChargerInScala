package com.oo2.distanceCharger

import java.lang.Math._

import com.TaxiCharger

trait DistanceCharger extends TaxiCharger {

  protected var basicCharger: DistanceCharger = RootCharger

  def setBasicCharger(basicCharger: DistanceCharger): Unit = {
    this.basicCharger = basicCharger
  }

  def chargeWith(distanceCharger: DistanceCharger): DistanceCharger = {
    distanceCharger.setBasicCharger(this)
    distanceCharger
  }

  protected def basicDistance(distance: Double, startDistance: Double) = ceil(min(distance, startDistance))

  protected def inDistance(distance: Double, startDistance: Double) = ceil(max(distance - startDistance, 0))

}
