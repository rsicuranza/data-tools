


/*
*  Object with apply method to implement
*  generic case class
*   - the val of value is generic and maintains
*   it's type on instantiation
* */
object OuterWrapper {
  case class InnerWrapper[T](value: T)
  def apply[T](value:T) = {
    InnerWrapper[T](value)
  }
}

// Create instances
val stringWrapped = OuterWrapper("foo")
val intWrapped = OuterWrapper(500)


stringWrapped // OuterWrapper.InnerWrapper[String]
intWrapped // OuterWrapper.InnerWrapper[Int]

stringWrapped.value // String = foo
intWrapped.value // Int = 500