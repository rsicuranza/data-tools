

case class MockData(date: Option[String],
                    client_id: Option[String],
                    account_id: Option[String],
                    has_something: Option[String],
                    some_amount: Option[Int],
                    some_ratio: Option[Double],
                    some_indicator: Option[Int])

val mockDataSeq = IndexedSeq(
  MockData(Some("2015-01"),
    Some("a12345"),
    Some("aaaaaa"),
    Some("yes"),
    Some(100),
    Some(1.5),
    Some(1)),
  MockData(Some("2015-02"),
    Some("a12345"),
    Some("aaaaaa"),
    Some("yes"),
    Some(200),
    Some(1.5),
    Some(1)),
  MockData(Some("2015-03"),
    Some("a12345"),
    Some("aaaaaa"),
    Some("yes"),
    Some(300),
    Some(1.5),
    Some(0)),
  MockData(Some("2015-04"),
    Some("a12345"),
    Some("aaaaaa"),
    Some("yes"),
    Some(400),
    Some(1.5),
    Some(0)),
  MockData(Some("2015-04"),
    Some("a12345"),
    Some("bbbbbb"),
    Some("yes"),
    Some(400),
    Some(1.5),
    Some(0)),
  MockData(Some("2015-05"),
    Some("a12345"),
    Some("aaaaaa"),
    Some("yes"),
    Some(500),
    Some(2.5),
    Some(1)),
  MockData(Some("2015-05"),
    Some("a12345"),
    Some("bbbbbb"),
    Some("yes"),
    Some(500),
    Some(2.5),
    Some(0)),
  MockData(Some("2015-06"),
    Some("a12345"),
    Some("aaaaaa"),
    Some("no"),
    Some(500),
    Some(3.5),
    None),
  MockData(Some("2015-06"),
    Some("a12345"),
    Some("bbbbbb"),
    Some("no"),
    Some(500),
    Some(3.5),
    None),
  MockData(Some("2015-07"),
    Some("a12345"),
    Some("aaaaaa"),
    Some("no"),
    Some(600),
    Some(4.5),
    None),
  MockData(Some("2015-07"),
    Some("a12345"),
    Some("bbbbbb"),
    Some("no"),
    Some(600),
    Some(4.5),
    None),
  MockData(Some("2015-08"),
    Some("a12345"),
    Some("aaaaaa"),
    Some("no"),
    Some(600),
    Some(4.5),
    Some(1)),
  MockData(Some("2015-08"),
    Some("a12345"),
    Some("bbbbbb"),
    Some("no"),
    Some(600),
    Some(4.5),
    Some(0)),
  MockData(Some("2015-09"),
    Some("a12345"),
    Some("aaaaaa"),
    Some("maybe"),
    Some(600),
    Some(4.5),
    Some(1)),
  MockData(Some("2015-09"),
    Some("a12345"),
    Some("bbbbbb"),
    Some("maybe"),
    Some(600),
    Some(4.5),
    Some(1)),
  MockData(Some("2015-10"),
    Some("a12345"),
    Some("aaaaaa"),
    Some("maybe"),
    Some(600),
    Some(4.5),
    Some(1)),
  MockData(Some("2015-10"),
    Some("a12345"),
    Some("bbbbbb"),
    Some("maybe"),
    Some(600),
    Some(4.5),
    Some(1)),
  MockData(Some("2015-10"),
    Some("a12345"),
    Some("ccccccc"),
    Some("maybe"),
    Some(600),
    Some(4.5),
    Some(0)),
  MockData(Some("2015-11"),
    Some("a12345"),
    Some("aaaaaa"),
    Some("maybe"),
    Some(200),
    None,
    Some(1)),
  MockData(Some("2015-11"),
    Some("a12345"),
    Some("bbbbbb"),
    Some("maybe"),
    Some(200),
    None,
    Some(0)),
  MockData(Some("2015-11"),
    Some("a12345"),
    Some("ccccccc"),
    Some("maybe"),
    Some(200),
    None,
    Some(0)),
  MockData(Some("2015-12"),
    Some("a12345"),
    Some("aaaaaa"),
    Some("yes"),
    Some(200),
    Some(5.5),
    Some(0)),
  MockData(Some("2015-12"),
    Some("a12345"),
    Some("bbbbbb"),
    Some("yes"),
    Some(200),
    Some(5.5),
    Some(1)),
  MockData(Some("2015-12"),
    Some("a12345"),
    Some("ccccccc"),
    Some("yes"),
    Some(200),
    Some(5.5),
    Some(0)),
  MockData(Some("2016-01"),
    Some("a12345"),
    Some("aaaaaa"),
    Some("yes"),
    Some(200),
    Some(5.5),
    Some(0)),
  MockData(Some("2016-01"),
    Some("a12345"),
    Some("bbbbbb"),
    Some("yes"),
    Some(200),
    Some(5.5),
    Some(1)),
  MockData(Some("2016-02"),
    Some("a12345"),
    Some("aaaaaa"),
    Some("yes"),
    None,
    None,
    Some(0)),
  MockData(Some("2016-02"),
    Some("a12345"),
    Some("bbbbbb"),
    Some("yes"),
    None,
    None,
    Some(1)),
  MockData(Some("2016-02"),
    Some("a12345"),
    Some("ccccccc"),
    Some("yes"),
    None,
    None,
    Some(0)),
  MockData(Some("2016-03"),
    Some("a12345"),
    Some("aaaaaa"),
    None,
    Some(200),
    None,
    Some(0)),
  MockData(Some("2016-03"),
    Some("a12345"),
    Some("bbbbbb"),
    None,
    Some(200),
    None,
    Some(1)),
  MockData(Some("2016-03"),
    Some("a12345"),
    Some("ccccccc"),
    None,
    Some(200),
    None,
    Some(0)),
  MockData(Some("2016-04"),
    Some("a12345"),
    Some("aaaaaa"),
    Some("yes"),
    None,
    Some(4.5),
    Some(0)),
  MockData(Some("2016-04"),
    Some("a12345"),
    Some("bbbbbb"),
    Some("yes"),
    None,
    Some(4.5),
    Some(1)),
  MockData(Some("2016-04"),
    Some("a12345"),
    Some("ccccccc"),
    Some("yes"),
    None,
    Some(4.5),
    Some(0)),
  MockData(Some("2016-05"),
    Some("a12345"),
    Some("aaaaaa"),
    None,
    Some(500),
    None,
    Some(0)),
  MockData(Some("2016-05"),
    Some("a12345"),
    Some("bbbbbb"),
    None,
    Some(500),
    None,
    Some(1)),
  MockData(Some("2016-05"),
    Some("a12345"),
    Some("ccccccc"),
    None,
    Some(500),
    None,
    Some(0)),
  MockData(Some("2016-06"),
    Some("a12345"),
    Some("aaaaaa"),
    Some("yes"),
    None,
    Some(5.5),
    Some(0)),
  MockData(Some("2016-06"),
    Some("a12345"),
    Some("bbbbbb"),
    Some("yes"),
    None,
    Some(5.5),
    Some(0)),
  MockData(Some("2016-06"),
    Some("a12345"),
    Some("ccccccc"),
    Some("yes"),
    None,
    Some(5.5),
    Some(1)),
  MockData(Some("2016-07"),
    Some("a12345"),
    Some("aaaaaa"),
    None,
    None,
    Some(5.5),
    Some(0)),
  MockData(Some("2016-07"),
    Some("a12345"),
    Some("bbbbbb"),
    None,
    None,
    Some(5.5),
    Some(0)),
  MockData(Some("2016-07"),
    Some("a12345"),
    Some("ccccccc"),
    None,
    None,
    Some(5.5),
    Some(1)),
  MockData(Some("2016-08"),
    Some("a12345"),
    Some("aaaaaa"),
    None,
    None,
    Some(5.5),
    Some(0)),
  MockData(Some("2016-08"),
    Some("a12345"),
    Some("bbbbbb"),
    None,
    None,
    Some(5.5),
    Some(0)),
  MockData(Some("2016-08"),
    Some("a12345"),
    Some("ccccccc"),
    None,
    None,
    Some(5.5),
    Some(1)),
  MockData(Some("2016-09"),
    Some("a12345"),
    Some("aaaaaa"),
    None,
    Some(600),
    Some(5.5),
    None),
  MockData(Some("2016-09"),
    Some("a12345"),
    Some("bbbbbb"),
    None,
    None,
    None,
    None),
  MockData(Some("2016-09"),
    Some("a12345"),
    Some("ccccccc"),
    None,
    Some(600),
    Some(5.5),
    Some(1)),
  MockData(Some("2016-10"),
    Some("a12345"),
    Some("aaaaaa"),
    Some("yes"),
    Some(600),
    Some(5.5),
    None),
  MockData(Some("2016-10"),
    Some("a12345"),
    Some("bbbbbb"),
    Some("yes"),
    None,
    None,
    None),
  MockData(Some("2016-10"),
    Some("a12345"),
    Some("ccccccc"),
    Some("yes"),
    None,
    None,
    None),
  MockData(Some("2016-11"),
    Some("a12345"),
    Some("aaaaaa"),
    Some("yes"),
    Some(600),
    Some(5.5),
    Some(0)),
  MockData(Some("2016-11"),
    Some("a12345"),
    Some("bbbbbb"),
    Some("yes"),
    Some(600),
    Some(5.5),
    Some(0)),
  MockData(Some("2016-11"),
    Some("a12345"),
    Some("ccccccc"),
    Some("yes"),
    Some(600),
    Some(5.5),
    None),
  MockData(Some("2016-12"),
    Some("a12345"),
    Some("aaaaaa"),
    Some("no"),
    Some(600),
    Some(5.5),
    Some(0)),
  MockData(Some("2016-12"),
    Some("a12345"),
    Some("bbbbbb"),
    Some("no"),
    Some(600),
    Some(5.5),
    Some(0)),
  MockData(Some("2016-12"),
    Some("a12345"),
    Some("ccccccc"),
    Some("no"),
    Some(600),
    Some(5.5),
    Some(1))
)

//////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////


object TimeIndexedKV {
  case class InnerWrapper[T](timeIndex:Option[String], value: T)
  def apply[T](timeIndex:Option[String], value:T) = {
    InnerWrapper[T](timeIndex, value)
  }
}

// this might have an implicit class, so that is can direct and cast
object TimeIndexedKVSeq {

  def genericZipper[T](timeIndices:IndexedSeq[Option[String]], values:IndexedSeq[T]) = {
    timeIndices zip values
  }

  def toWrapperSeq[T](genericSeq:IndexedSeq[(Option[String],T)]) = {
    genericSeq map { r => TimeIndexedKV(r._1, r._2) }
  }

  def apply[T](timeIndices:IndexedSeq[Option[String]], values:IndexedSeq[Option[T]]) = {
    val zipped = genericZipper(timeIndices, values)
    toWrapperSeq(zipped)
  }
}

/////////////////////////////////////////////////////
//////////////// Test Implementation ////////////////
/////////////////////////////////////////////////////

// The dates
val timeIndexSeq:IndexedSeq[Option[String]] = mockDataSeq map { _.date }

// The values
val intValuesSeq = mockDataSeq map { _.some_amount }
val doubleValuesSeq = mockDataSeq map { _.some_ratio }
val stringValuesSeq = mockDataSeq map { _.has_something }

/*
* Implement
*
* TODO: Add an implcit class that just returns casted arrays
* */
val intTimeIndexKVCollection = TimeIndexedKVSeq(timeIndexSeq, intValuesSeq)
val doubleTimeIndexKVCollection = TimeIndexedKVSeq(timeIndexSeq, doubleValuesSeq)
val stringTimeIndexKVCollection = TimeIndexedKVSeq(timeIndexSeq, stringValuesSeq)



//case class MockData(date: Option[String],
//                    client_id: Option[String],
//                    account_id: Option[String],
//                    has_something: Option[String],
//                    some_amount: Option[Int],
//                    some_ratio: Option[Double],
//                    some_indicator: Option[Int])

























//object TimeIndexedKV {
//  case class InnerWrapper[T](timeIndex:Option[String], value: T)
//  def apply[T](timeIndex:Option[String], value:T) = {
//    InnerWrapper[T](timeIndex, value)
//  }
//}
//
//// this might have an implicit class, so that is can direct and cast
//object TimeIndexedKVSeq {
//
//  def genericZipper[T](timeIndices:IndexedSeq[Option[String]], values:IndexedSeq[T]) = {
//    timeIndices zip values
//  }
//
//  def toWrapperSeq[T](genericSeq:IndexedSeq[(Option[String],T)]) = {
//    genericSeq map { r => TimeIndexedKV(r._1, r._2) }
//  }
//
//  //  def apply[T](timeIndices:IndexedSeq[String], values:IndexedSeq[T]) = {
//  def apply[T](timeIndices:IndexedSeq[Option[String]], values:IndexedSeq[Option[T]]) = {
//    val zipped = genericZipper(timeIndices, values)
//    toWrapperSeq(zipped)
//  }
//}
//
///*
//* TODO: This might not even need a custom extractor anymore!!
//*   - The product can be consumed and reffered to
//*
//* */
//
//
///////////////////////////////////////////////////////
////////////////// Test Implementation ////////////////
///////////////////////////////////////////////////////
//
//// The dates
//val timeIndexSeq:IndexedSeq[Option[String]] = IndexedSeq(Some("2015-01"),Some("2015-02"),Some("2015-03"))
//
//// The values
//val intValuesSeq:IndexedSeq[Option[Int]] = IndexedSeq(Some(100),Some(400),Some(900))
//val doubleValuesSeq:IndexedSeq[Option[Double]] = IndexedSeq(Some(1.8), Some(5.321), Some(90.9))
//val stringValuesSeq:IndexedSeq[Option[String]] = IndexedSeq(Some("foo"),Some("bar"),Some("baz"))
//
///*
//* Implement
//*
//* TODO: Add an implcit class that just returns casted arrays
//* */
//val intTimeIndexKVCollection = TimeIndexedKVSeq(timeIndexSeq, intValuesSeq)
//val doubleTimeIndexKVCollection = TimeIndexedKVSeq(timeIndexSeq, doubleValuesSeq)
//val stringTimeIndexKVCollection = TimeIndexedKVSeq(timeIndexSeq, stringValuesSeq)



//object TimeIndexedKV {
//  case class InnerWrapper[T](timeIndex:String, value: T)
//  def apply[T](timeIndex:String, value:T) = {
//    InnerWrapper[T](timeIndex, value)
//  }
//}
//
//// this might have an implicit class, so that is can direct and cast
//object TimeIndexedKVSeq {
//
//  def genericZipper[T](timeIndices:IndexedSeq[String], values:IndexedSeq[T]) = {
//    timeIndices zip values
//  }
//
//  def toWrapperSeq[T](genericSeq:IndexedSeq[(String,T)]) = {
//    genericSeq map { r => TimeIndexedKV(r._1, r._2) }
//  }
//
//  def apply[T](timeIndices:IndexedSeq[String], values:IndexedSeq[T]) = {
//    val zipped = genericZipper(timeIndices, values)
//    toWrapperSeq(zipped)
//  }
//}
//
///*
//* TODO: This might not even need a custom extractor anymore!!
//*   - The product can be consumed and reffered to
//*
//* */
//
//
///////////////////////////////////////////////////////
////////////////// Test Implementation ////////////////
///////////////////////////////////////////////////////
//
//// The dates
//val timeIndexSeq:IndexedSeq[String] = IndexedSeq("2015-01","2015-02","2015-03")
//
//// The values
//val intValuesSeq:IndexedSeq[Int] = IndexedSeq(100,400,900)
//val doubleValuesSeq:IndexedSeq[Double] = IndexedSeq(1.8, 5.321, 90.9)
//val stringValuesSeq:IndexedSeq[String] = IndexedSeq("foo","bar","baz")
//
///*
//* Implement
//*
//* TODO: Add an implcit class that just returns casted arrays
//* */
//val intTimeIndexKVCollection = TimeIndexedKVSeq(timeIndexSeq, intValuesSeq)
//val doubleTimeIndexKVCollection = TimeIndexedKVSeq(timeIndexSeq, doubleValuesSeq)
//val stringTimeIndexKVCollection = TimeIndexedKVSeq(timeIndexSeq, stringValuesSeq)
