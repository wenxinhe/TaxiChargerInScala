package com

trait TaxiChargerFactory {
  def newNanjingTaxiCharger(time: Double): TaxiCharger = ???

  def newShanghaiDowntownTaxiCharger(time: Double): TaxiCharger = ???

  def newShanghaiUptownTaxiCharger(time: Double): TaxiCharger = ???

  protected def isMidnight(time: Double): Boolean = {
    time > 22.0 || time <= 6.0
  }

}
