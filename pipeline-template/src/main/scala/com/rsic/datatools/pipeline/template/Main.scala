package com.rsic.datatools.pipeline.template

import com.rsic.datatools.pipeline.template.fixtures.MockData

object Main extends App {

  val mockDataSeq = MockData.mockDataSeq
  mockDataSeq.foreach(println)

}
