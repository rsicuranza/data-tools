package com.rsic.datatools.pipeline.template

import com.rsic.datatools.pipeline.template.api.{BarTestSpec, FooTestSpec}
import com.rsic.datatools.pipeline.template.models.inputs.HistoricalPrices
import com.rsic.datatools.pipeline.template.utils.SparkSessionHandler
import com.typesafe.config.ConfigFactory
import org.apache.spark.sql.{Column, Dataset}
import org.apache.spark.sql.functions.{col, round}
import org.apache.spark.sql.types.{DoubleType, LongType}
import org.scalatest.{BeforeAndAfterAll, Suite}

import scala.collection.immutable.IndexedSeq

class MainTestSpec
    extends Suite
    with BeforeAndAfterAll
    with SparkSessionHandler {

  import spark.implicits._

  var pricesDS: Dataset[HistoricalPrices] = _

  override def beforeAll(): Unit = {

    val pricesFilePath: String =
      ConfigFactory.load.getString("input.file.historicalStockPrices.filePath")

    val stringTypeColumns: Seq[Column] =
      Seq("date", "symbol").map { col(_) }

    val doubleTypeColumns: Seq[Column] =
      Seq("open", "high", "low", "adj_close").map { colName =>
        round(col(colName), 2).cast(DoubleType).as(colName)
      }

    val longTypeColumns: Seq[Column] =
      Seq("volume").map { colName =>
        round(col(colName), 2).cast(LongType).as(colName)
      }

    this.pricesDS = spark.read
      .option("header", "true")
      .csv(pricesFilePath)
      .select(stringTypeColumns ++ doubleTypeColumns ++ longTypeColumns: _*)
      .as[HistoricalPrices]
  }

  override def nestedSuites: IndexedSeq[Suite] =
    IndexedSeq(new BarTestSpec(pricesDS), new FooTestSpec(pricesDS))

}
