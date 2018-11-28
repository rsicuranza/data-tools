

import scala.reflect.runtime.universe._

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

class AbstractParams[T: TypeTag]{
  def tag: TypeTag[T]  = typeTag[T]
  def getField[B](fieldName:String) = {
    val tag = this.tag
    val tpe = tag.tpe

    val m = runtimeMirror(getClass.getClassLoader)
    val im = m.reflect(this)

    val fieldReflectMethod = tpe.decl(fieldName: TermName).asMethod
    val returnValue = im.reflectField(fieldReflectMethod).get

    // TODO: Get the classTag to reflect
    returnValue.asInstanceOf[B]
  }
}

case class MockData(date: Option[String],
                    client_id: Option[String],
                    account_id: Option[String],
                    has_something: Option[String],
                    some_amount: Option[Int],
                    some_ratio: Option[Double],
                    some_indicator: Option[Int]) extends AbstractParams[MockData]

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


mockDataSeq(0).getField[Option[String]]("date")
mockDataSeq(0).getField[Option[String]]("client_id")
mockDataSeq(0).getField[Option[String]]("account_id")
mockDataSeq(0).getField[Option[String]]("has_something")
mockDataSeq(0).getField[Option[Int]]("some_amount")
mockDataSeq(0).getField[Option[Double]]("some_ratio")
mockDataSeq(0).getField[Option[Int]]("some_indicator")


mockDataSeq map {_.getField[Option[String]]("date")}
mockDataSeq map {_.getField[Option[String]]("client_id")}
mockDataSeq map {_.getField[Option[String]]("account_id")}
mockDataSeq map {_.getField[Option[String]]("has_something")}
mockDataSeq map {_.getField[Option[Int]]("some_amount")}
mockDataSeq map {_.getField[Option[Double]]("some_ratio")}
mockDataSeq map {_.getField[Option[Int]]("some_indicator")}


 // Map a mapping of type to or class tag to string field names