package com.rsic.datatools.pipeline.template

import com.rsic.datatools.pipeline.template.api.{BarTestSpec, FooTestSpec}
import com.rsic.datatools.pipeline.template.models.inputs.HistoricalPrices
import com.rsic.datatools.pipeline.template.utils.SparkSessionHandler
import com.typesafe.config.ConfigFactory
import org.apache.spark.sql.{Dataset}
import org.scalatest.{BeforeAndAfterAll, Suite}

import scala.collection.immutable.IndexedSeq
import pipeline.SourceData

class MainTestSpec
    extends Suite
    with BeforeAndAfterAll
    with SparkSessionHandler {

  var pricesDS: Dataset[HistoricalPrices] = _

  override def beforeAll(): Unit = {

    val pricesFilePath: String =
      ConfigFactory.load.getString("input.file.historicalStockPrices.filePath")

    this.pricesDS = SourceData(pricesFilePath)
  }

  override def nestedSuites: IndexedSeq[Suite] =
    IndexedSeq(new BarTestSpec(pricesDS), new FooTestSpec(pricesDS))

}
