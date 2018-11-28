



/*
* can an implicit class cast name, based on the
* subtype?
*
* */

/*
* Works for covariant, since String is member any
*   - able to access the val too
* */
//abstract class OuterWrapper { val value: Any }
//
//abstract class InnerWrapper extends OuterWrapper
//case class StringContainer(value: String) extends OuterWrapper
//
//val stringContainerTest = StringContainer("Foo")
//stringContainerTest.value



abstract class OuterWrapper { val value: Any }

abstract class InnerWrapper extends OuterWrapper

case class StringContainer(value: String) extends OuterWrapper
case class IntContainer(value: Int) extends OuterWrapper

val stringContainerTest = StringContainer("Foo")
val intContainerTest = IntContainer(100)

stringContainerTest.value
intContainerTest.value

/*
* Pametric function, takes generic
* then assign to a sink based on the type
*
* */
def pickWrapper[T<:Int](value:T) = value match {
//  case _:String => StringContainer(value)
  case _:Int => IntContainer(value)
}


val testWrapper = pickWrapper(5)
testWrapper.value


//def pickWrapper[T<:Int with String](value:T) = value match {
//  case _:String => StringContainer(value)
//  case _:Int => IntContainer(value)
//}


// Contravariance not working
//def pickWrapper[T>:AnyVal](value:T) = value match {
//  case _:String => StringContainer(value)
//  case _:Int => IntContainer(value)
//}










