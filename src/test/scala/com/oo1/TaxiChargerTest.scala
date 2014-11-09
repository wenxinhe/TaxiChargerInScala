package com.oo1

import com.TaxiChargerFactory

class TaxiChargerTest extends com.TaxiChargerTest {
  override def taxiChargerFactory(): TaxiChargerFactory = TaxiChargerFactoryImpl
}
