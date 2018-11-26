package com.rsic.datatools.pipeline.template.pipeline

import com.rsic.datatools.pipeline.template.models.inputs.HistoricalPrices
import com.rsic.datatools.pipeline.template.utils.SparkSessionHandler
import com.typesafe.config.ConfigFactory
import org.apache.spark.sql.functions.{col, round}
import org.apache.spark.sql.types.{DoubleType, LongType}
import org.apache.spark.sql.{Column, Dataset}

object SourceData extends SparkSessionHandler {

  import spark.implicits._

  // rounding and casting types on read
  val pricesFilePath: String =
    ConfigFactory.load.getString("input.file.historicalStockPrices.filePath")

  val stringTypeColumns: Seq[Column] =
    Seq("date", "symbol").map { colName =>
      col(colName)
    }

  val doubleTypeColumns: Seq[Column] =
    Seq("open", "high", "low", "adj_close").map { colName =>
      round(col(colName), 2).cast(DoubleType).as(colName)
    }

  val longTypeColumns: Seq[Column] =
    Seq("volume").map { colName =>
      round(col(colName), 2).cast(LongType).as(colName)
    }

  def apply(
      pricesFilePath: String = pricesFilePath): Dataset[HistoricalPrices] = {
    spark.read
      .option("header", "true")
      .csv(pricesFilePath)
      .select(stringTypeColumns ++ doubleTypeColumns ++ longTypeColumns: _*)
      .as[HistoricalPrices]
  }
}
