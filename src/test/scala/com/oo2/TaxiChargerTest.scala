package com.oo2

import com.TaxiChargerFactory

class TaxiChargerTest extends com.TaxiChargerTest {
  override def taxiChargerFactory(): TaxiChargerFactory = TaxiChargerFactoryImpl
}
