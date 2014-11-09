package com.oo2

import com.oo2.distanceCharger.{MileCharger, FixCharger}
import com.{TaxiCharger, TaxiChargerFactory}

object TaxiChargerFactoryImpl extends TaxiChargerFactory {
  override def newNanjingTaxiCharger(time: Double): TaxiCharger = {
    if (isMidnight(time))
      FixCharger(0, 13.0).chargeWith(MileCharger(3, 2.4))
    else
      FixCharger(0, 11.0).chargeWith(MileCharger(3, 1.6))
  }

  override def newShanghaiDowntownTaxiCharger(time: Double): TaxiCharger = {
    if (isMidnight(time))
      FixCharger(0, 14.0).chargeWith(MileCharger(3, 3.4)).chargeWith(MileCharger(10, 3.6))
    else
      FixCharger(0, 13.0).chargeWith(MileCharger(3, 2.6)).chargeWith(MileCharger(10, 3.2))
  }

  override def newShanghaiUptownTaxiCharger(time: Double): TaxiCharger = {
    if (isMidnight(time))
      FixCharger(0, 14.0).chargeWith(MileCharger(3, 3.4))
    else
      FixCharger(0, 13.0).chargeWith(MileCharger(3, 2.6))
  }

}


