



case class InnerWrapper[T](value: T)

val stringWrapped1 = InnerWrapper("foo")
val intWrapped1 = InnerWrapper(500)




object OuterWrapper {

  case class InnerWrapper[T](value: T)

  def apply[T](value:T) = {
          InnerWrapper[T](value)
  }
}


val stringWrapped2 = OuterWrapper("foo")
val intWrapped2 = OuterWrapper(500)

stringWrapped2
intWrapped2

stringWrapped2.value
intWrapped2.value





















//class OuterWrapper[T](var value: T)
//
//// companion
//object OuterWrapper {
//
//  case class StringContainer(override val value: String)
//  case class IntContainer(override val value: Int)
//
//  def apply[T](value:T) = value match {
//      case _:String => StringContainer(value)
//      case _:Int => IntContainer[Int](value)
//  }
//}






//class OuterWrapper[T](var value: T)
//
//// companion
//object OuterWrapper {
//
//  case class StringContainer(override val value: String) extends OuterWrapper(value:String)
//  case class IntContainer(override val value: Int) extends OuterWrapper(value:Int)
//
//  def apply[T](value:T) = value match {
//    case _:String => OuterWrapper(value)
//    //    case _:Int => OuterWrapper[Int](value)
//  }
//
//}



















