




object OuterWrapper {
  case class InnerWrapper[T](value: T)
  def apply[T](value:T) = {
    InnerWrapper[T](value)
  }
}

val stringWrapped = OuterWrapper("foo")
val intWrapped = OuterWrapper(500)


stringWrapped // OuterWrapper.InnerWrapper[String]
intWrapped // OuterWrapper.InnerWrapper[Int]

stringWrapped.value // String = foo
intWrapped.value // Int = 500


/*
* Storing the wrappers to an array to see if
* the type of value is maintained
*
*   - TODO:
*     - Try to make a type for the Seq that is contravariant
*       - will make it more generalizable
*     - Try using an implicit class
*       - the variable types will not be mixed in the Seq, so
*       maybe an implicit class can overload an apply that
*       selects the type of list to assign it to
*
* */
val ContainerSeq = IndexedSeq(stringWrapped,intWrapped) // IndexedSeq[OuterWrapper.InnerWrapper[_ >: Int with String]]

val theStringElement = ContainerSeq(0)
val theIntElement = ContainerSeq(1)

theStringElement.value // Any = foo
theIntElement.value // Any = 500

theStringElement.value.getClass // Class[?0] = class java.lang.String
theIntElement.value.getClass // Class[?0] = class java.lang.Integer

theStringElement.value + "bar"
// theIntElement.value + 1 // Does not compile

// Why does this compile for theIntElement?
theStringElement.value + "bar"
theIntElement.value + "bar"



// Homogenous Seqs to avoid the type erasure
val IntContainerSeq = IndexedSeq(intWrapped,intWrapped) // IndexedSeq[OuterWrapper.InnerWrapper[Int]]
val StringContainerSeq = IndexedSeq(stringWrapped,stringWrapped) // IndexedSeq[OuterWrapper.InnerWrapper[String]]

IntContainerSeq(0).value // Int = 500
IntContainerSeq(0).value.getClass // Class[Int] = int

StringContainerSeq(0).value // String = foo
StringContainerSeq(0).value.getClass // class java.lang.String


// A specialized container to handle all of the numeric types
//val NumericContainerSeq:IndexedSeq[@specialized with (Int,Double,Long)] = IndexedSeq(intWrapped,intWrapped) // IndexedSeq[OuterWrapper.InnerWrapper[Int]]


case class NumericContainer[@specialized(Int, Long, Double) T](item:T)

val anInt:Int = 50000000
val aDouble:Double = 5.321
val aLong:Long = 50000000

NumericContainer(anInt)
NumericContainer(aDouble)
NumericContainer(aLong)

NumericContainer(anInt).item
NumericContainer(aDouble).item
NumericContainer(aLong).item



abstract class NumericTrait[@specialized(Int, Long, Double) T]{
//  type TypePlaceholder = T

  val numericList:List[T]
}



object MyExtensions {
  class RichInt( i: Int ) {
    def square = i * i
    def add = i + i
  }

  class RichString( i: String ) {
    def add = i + " " + i
  }

  implicit def richInt( i: Int ) = new RichInt( i )
  implicit def RichString( i: String ) = new RichString( i )

}

import MyExtensions._

1.add
"hi".add



//OuterWrapper




val anIntList:IndexedSeq[Int] = IndexedSeq(6,7,8)
val aLongList:IndexedSeq[Long] = IndexedSeq(5000, 6000, 70000)
val aDoubleList:IndexedSeq[Double] = IndexedSeq(5.2, 7.897, 2.3)


anIntList map {OuterWrapper(_)}
aLongList map {OuterWrapper(_)}
aDoubleList map {OuterWrapper(_)}



















































//val ContainerSeq = IndexedSeq(stringWrapped,intWrapped) // IndexedSeq[OuterWrapper.InnerWrapper[_ >: Int with String]]
//
//ContainerSeq(0)
//ContainerSeq(1)
//
//ContainerSeq(0).value // Any = foo
//ContainerSeq(1).value // Any = 500
//
//ContainerSeq(0).value.getClass // Class[?0] = class java.lang.String
//ContainerSeq(1).value.getClass // Class[?0] = class java.lang.Integer
//
//ContainerSeq(0).value + "bar"
////ContainerSeq(1).value + 1 // Does not compile
//
//// Why does this compile?
//ContainerSeq(0).value + "bar"
//ContainerSeq(1).value + "bar"