
// https://stackoverflow.com/questions/21465661/scala-reflection-to-access-all-public-fields-at-runtime
// https://stackoverflow.com/questions/21465661/scala-reflection-to-access-all-public-fields-at-runtime
import scala.reflect.runtime.universe._
import scala.reflect._

case class Foo ( a:Option[Int], b:Option[Double], c:Option[String])
val foo1 = Foo(Some(5), Some(99.99), Some("bar"))
val foo2 = Foo(None, Some(99.99), Some("bar"))
val foo3 = Foo(Some(5), None, Some("bar"))
val foo4 = Foo(Some(5), Some(99.99), None)


// Params
val classInst = foo1
type TypePlaceHolder = Foo
val fieldName = "a"

// Mirrors
val currentMirror = runtimeMirror(getClass.getClassLoader)
val instanceMir = currentMirror.reflect(classInst)
val fieldReflectMethod = typeOf[TypePlaceHolder].decl(fieldName: TermName).asMethod

// Outputs
val fieldValue = instanceMir.reflectField(fieldReflectMethod).get
val fieldResultType = typeOf[TypePlaceHolder].decl(fieldName: TermName).typeSignature.resultType


// use an implicit cast method here
fieldResultType match {
  case _ if fieldResultType =:= typeOf[Option[Int]] => "Option Int" // replace these with case function
  case _ if fieldResultType =:= typeOf[Option[String]] => "Option String"
}


instanceMir.symbol
























//import scala.reflect.runtime.universe._
//import scala.reflect._
//
//case class Foo ( a:Option[Int], b:Option[Double], c:Option[String])
//val foo1 = Foo(Some(5), Some(99.99), Some("bar"))
//val foo2 = Foo(None, Some(99.99), Some("bar"))
//val foo3 = Foo(Some(5), None, Some("bar"))
//val foo4 = Foo(Some(5), Some(99.99), None)
//
//
//val classInst = foo1
//type TypePlaceHolder = Foo
//val fieldName = "a"
//
//val currentMirror = runtimeMirror(getClass.getClassLoader)
//val instanceMir = currentMirror.reflect(classInst)
//
//val zt = typeOf[Foo].decl(fieldName: TermName).asMethod
//instanceMir.reflectField(zt).get
//
//
//
//typeOf[TypePlaceHolder].decl(fieldName: TermName).typeSignature
//typeOf[TypePlaceHolder].decl(fieldName: TermName).typeSignature.resultType
//typeOf[TypePlaceHolder]
//
//typeOf[TypePlaceHolder].decl(fieldName: TermName).typeSignature =:= typeOf[Int]
//
//typeOf[TypePlaceHolder].decl(fieldName: TermName).typeSignature.resultType =:= typeOf[Option[Int]]
//
//// use an implicit cast method here
//val hi  = typeOf[TypePlaceHolder].decl(fieldName: TermName).typeSignature.resultType
//hi match {
//  case _ if hi =:= typeOf[Option[Int]] => "Option Int" // replace these with case function
//  case _ if hi =:= typeOf[Option[String]] => "Option String"
//}
//
//instanceMir.symbol




//import scala.reflect.runtime.universe._
//
//class A {
//  val x = 3
//  val y = 4
//}
//
//class B extends A {
//  val z = 5
//}
//
//typeOf[B]
//
//typeOf[B].decls
//
//val b = new B
//
//val currentMirror = runtimeMirror(getClass.getClassLoader)
//val bMir = currentMirror.reflect(b)
//
//val zt = typeOf[B].decl("z": TermName).asMethod
//bMir.reflectField(zt).get
//
//bMir.symbol
//
//typeOf[B].decl("z": TermName).typeSignature
//typeOf[B].decl("z": TermName).typeSignature.resultType
//typeOf[Int]
//
//typeOf[B].decl("z": TermName).typeSignature =:= typeOf[Int]
//
//typeOf[B].decl("z": TermName).typeSignature.resultType =:= typeOf[Int]
//
//// use an implicit cast method here
//val hi  = typeOf[B].decl("z": TermName).typeSignature.resultType
//hi match {
//  case _ if hi =:= typeOf[Int] => "Int" // replace these with case function
//  case _ if hi =:= typeOf[String] => "String"