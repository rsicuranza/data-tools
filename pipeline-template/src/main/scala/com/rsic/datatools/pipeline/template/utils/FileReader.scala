package com.rsic.datatools.pipeline.template.utils

import scala.io.Source


object FileReader {

  // Java.io is the preferable option to this
  for (line <- Source.fromFile("somefile.txt").getLines()) {
    println(line)
  }


}
