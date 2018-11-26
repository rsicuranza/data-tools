package com.rsic.datatools.pipeline.template.api

import com.rsic.datatools.pipeline.template.models.inputs.HistoricalPrices
import com.rsic.datatools.pipeline.template.utils.SparkSessionHandler
import org.scalatest.{BeforeAndAfter, FlatSpec}
import org.apache.spark.sql.Dataset

/*
 * This test spec is a mock nested suite:
 *   - It it imported to the MainTestSpec, where all of the nested suites
 *   are stored in an IndexedSeq
 *
 *   - The MainTestSpec also takes care of a couple of other things:
 *     - Get the configs from the testing config factory
 *     - uses the beforeAll override to create the dataset for all of the nested suites
 *     to use
 *       - This is why there is a declared field in the constructor for pricesDS
 *     - Tears down the Spark context after all tests have been run
 * */
class BarTestSpec(pricesDS: Dataset[HistoricalPrices])
    extends FlatSpec
    with SparkSessionHandler
    with BeforeAndAfter {

  behavior of "something bar"
  it should "be bar-like" in {
    assert("bar" == "bar")
  }

  behavior of "spark bar"
  it should "be bar-like, but with Spark" in {
    pricesDS.show(10)
    assert("bar" == "bar")
  }

}
