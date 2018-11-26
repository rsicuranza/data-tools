package com.rsic.datatools.pipeline.template.utils

import com.typesafe.config.ConfigFactory
import org.apache.spark.sql.SparkSession

/*
 * This object builds the SparkSession
 *   - It is extended by the each test spec, so that they all have a shared
 *   Spark context
 * */
object SparkSessionUtils {
  def getSparkSession: SparkSession = {
    val config = ConfigFactory.load
    SparkSession.builder
      .config("spark.driver.host", "localhost")
      .master(config.getString("sparkQA.master"))
      .getOrCreate

//      .master(config.getString("spark.master"))
  }
}
