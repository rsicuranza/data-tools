package com.rsic.datatools.pipeline.template.utilities

import java.io._

// a worked alternative to unit
object FileWriter extends App {


  class WriterOutput(writer: PrintWriter) {
    def write(s: String): Unit = writer.println(s)
  }

  // make a PrintWriter instance
  val ex1 = new PrintWriter(new File("ex1.txt")) // this will be saved in the root

  // create an instance of the output writer
  val out1 = new WriterOutput(ex1)

  // iteratively writing to the file
  out1.write("Hello")
  out1.write("to")
  out1.write("you")

  // close the file
  ex1.close()
}

