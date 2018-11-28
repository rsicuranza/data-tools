


import scala.reflect._ // For the class tag
import scala.reflect.runtime.universe._ // For the type tag


val ct = classTag[Map[String, List[Int]]]
val tt = typeTag[Map[String, List[Int]]]



case class Foo ( a:Option[Int], b:Option[Double], c:Option[String])

val foo1 = Foo(Some(5), Some(99.99), Some("bar"))
val foo2 = Foo(None, Some(99.99), Some("bar"))
val foo3 = Foo(Some(5), None, Some("bar"))
val foo4 = Foo(Some(5), Some(99.99), None)

foo1.productIterator