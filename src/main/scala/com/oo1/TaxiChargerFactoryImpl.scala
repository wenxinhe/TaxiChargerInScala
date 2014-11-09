package com.oo1

import com.oo1.distanceCharger.{FixCharger, MileCharger}
import com.{TaxiCharger, TaxiChargerFactory}

import scala.Double.MaxValue

object TaxiChargerFactoryImpl extends TaxiChargerFactory {
  override def newNanjingTaxiCharger(time: Double): TaxiCharger = {
    if (isMidnight(time))
      MileCharger(FixCharger(3.0, 13.0), MaxValue, 2.4)
    else
      MileCharger(FixCharger(3.0, 11.0), MaxValue, 1.6)
  }

  override def newShanghaiDowntownTaxiCharger(time: Double): TaxiCharger = {
    if (isMidnight(time))
      MileCharger(MileCharger(FixCharger(3.0, 14.0), 10.0, 3.4), MaxValue, 3.6)
    else
      MileCharger(MileCharger(FixCharger(3.0, 13.0), 10.0, 2.6), MaxValue, 3.2)
  }

  override def newShanghaiUptownTaxiCharger(time: Double): TaxiCharger = {
    if (isMidnight(time))
      MileCharger(FixCharger(3.0, 14.0), MaxValue, 3.4)
    else
      MileCharger(FixCharger(3.0, 13.0), MaxValue, 2.6)
  }

}


