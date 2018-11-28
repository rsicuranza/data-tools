

//////////////////////////////////////////////////////
////////////////// Using implicitly //////////////////
//////////////////////////////////////////////////////
val intNumT = implicitly[Numeric[Int]]
intNumT.times(5, 8)


val doubleNumT = implicitly[Numeric[Double]]
doubleNumT.times(5.0, 8.0)


//////////////////////////////////////////////////////
////////////////// Using a Wrapper ///////////////////
//////////////////////////////////////////////////////
//case class Cell[T](item: T) {
//  def *[U: Numeric](other: Cell[U])(implicit ev: T =:= U): Cell[U] = {
//    val numClass = implicitly[Numeric[U]]
//    Cell(numClass.times(this.item, other.item))
//  }
//}
//
//val stringCell = Cell("hello")
//val intCell = Cell(6)
//intCell * Cell(7)




//class NumericReducers[T]{
//  def sum[U: Numeric](values: IndexedSeq[U])= {
//    val numClass = implicitly[Numeric[U]]
//    values.foldLeft(numClass.zero)((acc, value) => numClass.plus(acc, value))
//  }
//}
//
//
//
//
val anIntSeq = IndexedSeq(100,200,300)
val anDoubleSeq = IndexedSeq(0.50,1.75,6.5)
//
//val numericReducers =  new NumericReducers
//
//numericReducers.sum(anDoubleSeq)


import scala.language.implicitConversions

object MyExtensions {
  class RichNumeric[U:Numeric]( values: IndexedSeq[U] ) {

    val numClass = implicitly[Numeric[U]]

    def sum = values.foldLeft(numClass.zero)((acc, value) => numClass.plus(acc, value))
    def count = values.foldLeft(numClass.zero)((acc, value) => numClass.plus(acc, value))
  }

  class RichString( values: IndexedSeq[String] ) {
    def count = values.length
  }

  implicit def richNumeric[U:Numeric]( values: IndexedSeq[U] ) = new RichNumeric( values )
  implicit def richString( values: IndexedSeq[String] ) = new RichString( values )

}

import MyExtensions._

anIntSeq.count
anIntSeq.sum

//1.add
//1.square
//
//
//(20.5).add
//
//
//"hi".add








//
//import scala.language.implicitConversions
//
//object MyExtensions {
//  class RichNumeric[U:Numeric]( i: U ) {
//
//    val numClass = implicitly[Numeric[U]]
//
//    def square = numClass.times(i,i)
//    def add = numClass.plus(i,i)
//  }
//
//  class RichString( i: String ) {
//    def add = i + " " + i
//  }
//
//  implicit def richNumeric[U:Numeric]( i: U ) = new RichNumeric( i )
//  implicit def richString( i: String ) = new RichString( i )
//
//}
//
//import MyExtensions._
//
//1.add
//1.square
//
//
//(20.5).add
//
//
//"hi".add




//class NumericReducers[T]{
//  def sum[U: Numeric](values: IndexedSeq[U])= {
//    val numClass = implicitly[Numeric[U]]
//    values.foldLeft(numClass.zero)((acc, value) => numClass.plus(acc, value))
//  }
//}
//
//object Reducers {
//
//}
//
//
//val anIntSeq = IndexedSeq(100,200,300)
//val anDoubleSeq = IndexedSeq(0.50,1.75,6.5)
//
//val numericReducers =  new NumericReducers
//
//numericReducers.sum(anDoubleSeq)
