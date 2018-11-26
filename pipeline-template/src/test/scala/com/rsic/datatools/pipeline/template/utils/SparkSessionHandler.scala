package com.rsic.datatools.pipeline.template.utils

import org.apache.spark.sql.SparkSession

/*
 * The SparkSession that will be shared
 *   - SparkSessionUtils has a builder for it, that sources configs from
 *   the config factory
 * */
trait SparkSessionHandler {
  val spark: SparkSession = SparkSessionUtils.getSparkSession
}
