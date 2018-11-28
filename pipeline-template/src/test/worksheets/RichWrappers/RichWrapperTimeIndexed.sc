

object TimeIndexedKV {
  case class InnerWrapper[T](timeIndex:String, value: T)
  def apply[T](timeIndex:String, value:T) = {
    InnerWrapper[T](timeIndex, value)
  }
}

// this might have an implicit class, so that is can direct and cast
object TimeIndexedKVSeq {

  def genericZipper[T](timeIndices:IndexedSeq[String], values:IndexedSeq[T]) = {
    timeIndices zip values
  }

  def toWrapperSeq[T](genericSeq:IndexedSeq[(String,T)]) = {
    genericSeq map { r => TimeIndexedKV(r._1, r._2) }
  }

  def apply[T](timeIndices:IndexedSeq[String], values:IndexedSeq[T]) = {
    val zipped = genericZipper(timeIndices, values)
    toWrapperSeq(zipped)
  }
}

/*
* TODO: This might not even need a custom extractor anymore!!
*   - The product can be consumed and reffered to 
*
* */


/////////////////////////////////////////////////////
//////////////// Test Implementation ////////////////
/////////////////////////////////////////////////////

// The dates
val timeIndexSeq:IndexedSeq[String] = IndexedSeq("2015-01","2015-02","2015-03")

// The values
val intValuesSeq:IndexedSeq[Int] = IndexedSeq(100,400,900)
val doubleValuesSeq:IndexedSeq[Double] = IndexedSeq(1.8, 5.321, 90.9)
val stringValuesSeq:IndexedSeq[String] = IndexedSeq("foo","bar","baz")

/*
* Implement
*
* TODO: Add an implcit class that just returns casted arrays
* */
val intTimeIndexKVCollection = TimeIndexedKVSeq(timeIndexSeq, intValuesSeq)
val doubleTimeIndexKVCollection = TimeIndexedKVSeq(timeIndexSeq, doubleValuesSeq)
val stringTimeIndexKVCollection = TimeIndexedKVSeq(timeIndexSeq, stringValuesSeq)






















//object TimeIndexedKV {
//  case class InnerWrapper[T](timeIndex:String, value: T)
//  def apply[T](timeIndex:String, value:T) = {
//    InnerWrapper[T](timeIndex, value)
//  }
//}
//
//def genericZipper[T](timeIndices:IndexedSeq[String], values:IndexedSeq[T]) = {
//  timeIndices zip values
//}
//
//def toWrapperSeq[T](genericSeq:IndexedSeq[(String,T)]) = {
//  genericSeq map { r => TimeIndexedKV(r._1, r._2) }
//}
//
//// The dates
//val timeIndexSeq:IndexedSeq[String] = IndexedSeq("2015-01","2015-02","2015-03")
//
//// The values
//val intValuesSeq:IndexedSeq[Int] = IndexedSeq(100,400,900)
//val doubleValuesSeq:IndexedSeq[Double] = IndexedSeq(1.8, 5.321, 90.9)
//val stringValuesSeq:IndexedSeq[String] = IndexedSeq("foo","bar","baz")
//
//// The zipper
//val intTupleSeq = genericZipper(timeIndexSeq, intValuesSeq)
//val doubleTupleSeq = genericZipper(timeIndexSeq, doubleValuesSeq)
//val stringTupleSeq = genericZipper(timeIndexSeq, stringValuesSeq)
//
//// The implementation
//toWrapperSeq(intTupleSeq)
//toWrapperSeq(doubleTupleSeq)
//toWrapperSeq(stringTupleSeq)








//object TimeIndexedKV {
//  case class InnerWrapper[T](timeIndex:String, value: T)
//  def apply[T](timeIndex:String, value:T) = {
//    InnerWrapper[T](timeIndex, value)
//  }
//}
//
//def toWrapperSeq[T](genericSeq:IndexedSeq[(String,T)]) = {
//  genericSeq map { r => TimeIndexedKV(r._1, r._2) }
//}
//
//
//// The dates
//val timeIndexSeq:IndexedSeq[String] = IndexedSeq("2015-01","2015-02","2015-03")
//
//// The values
//val intValuesSeq:IndexedSeq[Int] = IndexedSeq(100,400,900)
//val doubleValuesSeq:IndexedSeq[Double] = IndexedSeq(1.8, 5.321, 90.9)
//val stringValuesSeq:IndexedSeq[String] = IndexedSeq("foo","bar","baz")
//
//// The zipper maintains the type!
//
//
//// TODO: Get to this format from product iterator somehow (maybe implicit and classtag?)
//val intTupleSeq:IndexedSeq[(String,Int)] = timeIndexSeq zip intValuesSeq
//val doubleTupleSeq:IndexedSeq[(String,Double)] = timeIndexSeq zip doubleValuesSeq
//val stringTupleSeq:IndexedSeq[(String,String)] = timeIndexSeq zip stringValuesSeq
//
//toWrapperSeq(intTupleSeq)
//toWrapperSeq(doubleTupleSeq)
//toWrapperSeq(stringTupleSeq)









//object TimeIndexedKV {
//  case class InnerWrapper[T](timeIndex:String, value: T)
//  def apply[T](timeIndex:String, value:T) = {
//    InnerWrapper[T](timeIndex, value)
//  }
//}
//
//def toWrapperSeq[T](genericSeq:IndexedSeq[(String,T)]) = {
//  genericSeq map { r => TimeIndexedKV(r._1, r._2) }
//}
//
//// TODO: Get to this format from product iterator somehow (maybe implicit and classtag?)
//val intTupleSeq:IndexedSeq[(String,Int)] = IndexedSeq("2015-01"->100, "2015-02"->400, "2015-03"->900)
//val stringTupleSeq:IndexedSeq[(String,String)] = IndexedSeq("2015-01"->"foo", "2015-02"->"bar", "2015-03"->"baz")
//
//toWrapperSeq(intTupleSeq)
//toWrapperSeq(stringTupleSeq)
//
//
//val timeIndexSeq:IndexedSeq[String] = IndexedSeq("2015-01","2015-02","2015-03")
//val intValuesSeq:IndexedSeq[Int] = IndexedSeq(100,400,900)
//
//// The zipper maintains the type!
//timeIndexSeq zip intValuesSeq


















//
//intMap(0)
//
//TimeIndexedKV(intMap(0)._1, intMap(0)._2)
//
//
//
//def toWrapperSeq[T](genericSeq:IndexedSeq[(String,T)]) = {
//  genericSeq map { r => TimeIndexedKV(r._1, r._2) }
//}
//
//toWrapperSeq(intMap)




//val anIntList:IndexedSeq[Int] = IndexedSeq(6,7,8)
//val aLongList:IndexedSeq[Long] = IndexedSeq(5000, 6000, 70000)
//val aDoubleList:IndexedSeq[Double] = IndexedSeq(5.2, 7.897, 2.3)
//
//anIntList map {OuterWrapper(_)}
//aLongList map {OuterWrapper(_)}
//aDoubleList map {OuterWrapper(_)}
//
//def toWrapperSeq[T](genericSeq:IndexedSeq[T]) = {
//  genericSeq map {OuterWrapper(_)}
//}
//
//toWrapperSeq(anIntList)
//toWrapperSeq(aLongList)
//toWrapperSeq(aDoubleList)

