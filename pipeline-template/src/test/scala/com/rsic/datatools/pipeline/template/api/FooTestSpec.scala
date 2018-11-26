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
class FooTestSpec(pricesDS: Dataset[HistoricalPrices])
    extends FlatSpec
    with SparkSessionHandler
    with BeforeAndAfter {

  behavior of "something foo"
  it should "be foo-like" in {
    assert("foo" == "foo")
  }

  behavior of "spark foo"
  it should "be foo-like, but with Spark" in {
    pricesDS.show(10)
    assert("foo" == "foo")
  }

}
