package com

import org.scalatest.{FunSpec, ShouldMatchers}

trait TaxiChargerTest extends FunSpec with ShouldMatchers {

  def newNanjingTaxiCharger(time: Double): TaxiCharger = taxiChargerFactory.newNanjingTaxiCharger(time)

  def newShanghaiDowntownTaxiCharger(time: Double): TaxiCharger = taxiChargerFactory.newShanghaiDowntownTaxiCharger(time)

  def newShanghaiUptownTaxiCharger(time: Double): TaxiCharger = taxiChargerFactory.newShanghaiUptownTaxiCharger(time)

  def taxiChargerFactory(): TaxiChargerFactory

  describe("南京出租车计费") {
     describe("白天上车（时间6:00 - 22:00（含））") {
       val taxiCharger: TaxiCharger = newNanjingTaxiCharger(12.0)
       describe("3公里（含），11元"){

       }
       describe("超过3公里后，每公里1.6元") {
         it("超过起步距离1公里，计费12.6元") {
           taxiCharger.chargeFor(3.0 + 1.0) shouldBe 11.0 + 1.6
         }
       }
     }

     describe("夜间上车(时间22:00-6:00（含）)") {
       val taxiCharger: TaxiCharger = newNanjingTaxiCharger(0.0)
       describe("3公里（含），13元"){

       }
       describe("超过3公里，每公里2.4元") {
         it("超过起步距离2公里，计费17.8元") {
           taxiCharger.chargeFor(5) shouldBe 13.0 + 2.4 * 2
         }
       }
     }
  }




  describe("上海内环出租车计费") {
     describe("白天上车（时间6:00 - 22:00（含））") {
       val taxiCharger: TaxiCharger = newShanghaiDowntownTaxiCharger(12.0)
       describe("3公里（含），13元"){

       }
       describe("超过3公里，10公里以内，每公里2.6元") {
         it("超过起步距离1公里，计费15.6元") {
           taxiCharger.chargeFor(3.0 + 1.0) shouldBe 13.0 + 2.6
         }
       }
       describe("超过10公里后，每公里3.2元") {
         it("11公里，计费34.4元") {
           taxiCharger.chargeFor(11.0) shouldBe 13.0 + 2.6 * 7 + 3.2
         }
       }

     }

     describe("夜间上车(时间22:00-6:00（含）)") {
       val taxiCharger: TaxiCharger = newShanghaiDowntownTaxiCharger(0.0)
       describe("3公里（含），14元"){

       }
       describe("超过3公里，10公里以内，每公里3.4元") {
         it("超过起步距离2公里，计费20.8元") {
           taxiCharger.chargeFor(5) shouldBe 14.0 + 3.4 * 2
         }
       }
       describe("超过10公里后，每公里3.6元") {
         it("11公里，计费40.4元") {
           taxiCharger.chargeFor(11.0) shouldBe 14.0 + 3.4 * 7 + 3.6
         }
       }
     }
   }



  describe("上海外环出租车计费") {
     describe("白天上车（时间6:00 - 22:00（含））") {
       val taxiCharger: TaxiCharger = newShanghaiUptownTaxiCharger(12.0)
       describe("3公里（含），13元"){

       }
       describe("超过3公里，每公里2.6元") {
         it("4公里，计费15.6元") {
           taxiCharger.chargeFor(3.0 + 1.0) shouldBe 13.0 + 2.6
         }
       }
       describe("超过10公里后，每公里仍然2.6元") {
         it("11公里，计费33.8元") {
           taxiCharger.chargeFor(11.0) shouldBe 13.0 + 2.6 * 8
         }
       }
     }

     describe("夜间上车(时间22:00-6:00（含）)") {
       val taxiCharger: TaxiCharger = newShanghaiUptownTaxiCharger(0.0)
       describe("3公里（含），14元"){

       }
       describe("超过3公里，每公里3.4元") {
         it("超过起步距离2公里，计费20.8元") {
           taxiCharger.chargeFor(5) shouldBe 14.0 + 3.4 * 2
         }
       }
       describe("超过10公里后，每公里3.4元") {
         it("11公里，计费41.2元") {
           taxiCharger.chargeFor(11.0) shouldBe 14.0 + 3.4 * 8
         }
       }
     }
   }

 }
