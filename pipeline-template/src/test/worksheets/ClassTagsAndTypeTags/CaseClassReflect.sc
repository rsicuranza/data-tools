

import scala.reflect._
import scala.reflect.runtime.universe._

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

// Test
case class MyParams(id: String, stuff: Int) extends AbstractParams[MyParams]
val p = new MyParams("joe", 2)
p.getField[String]("id")












//
//class AbstractParams[T: TypeTag]{
//  def tag: TypeTag[T]  = typeTag[T]
//  def getField[B](fieldName:String) = {
//    val tag = this.tag
//    val tpe = tag.tpe
//
//    val m = runtimeMirror(getClass.getClassLoader)
//    val im = m.reflect(this)
//
//    val fieldReflectMethod = tpe.decl(fieldName: TermName).asMethod
//    val returnValue = im.reflectField(fieldReflectMethod).get
//
//    returnValue.asInstanceOf[B]
//  }
//}
//
//// Test
//case class MyParams(id: String, stuff: Int) extends AbstractParams[MyParams]
//val p = new MyParams("joe", 2)
//p.getField[String]("id")









//import scala.reflect.runtime.universe._
//
//class AbstractParams[T: TypeTag]{
//  def tag: TypeTag[T]  = typeTag[T]
//  def extractorHelp(fieldName:String) = {
//    val tag = this.tag
//    val tpe = tag.tpe // This is the same as typeOf[Foo]
//
//    val m = runtimeMirror(getClass.getClassLoader)
//    val im = m.reflect(this)
//
//    val fieldReflectMethod = tpe.decl(fieldName: TermName).asMethod
//    val returnType = tpe.decl(fieldName: TermName).typeSignature.resultType
//    val returnValue = im.reflectField(fieldReflectMethod).get
//
//    (returnType, returnValue)
//  }
//}
//
//// Test
//case class MyParams(id: String, stuff: Int) extends AbstractParams[MyParams]
//val p = new MyParams("joe", 2)
//p.extractorHelp("id")









//import scala.reflect.runtime.universe._
//
//class AbstractParams[T: TypeTag] {
//  def tag: TypeTag[T]  = typeTag[T]
//  def extractorHelp = {
//    val tag = this.tag
//    val tpe = tag.tpe // This is the same as typeOf[Foo]
//
//    val m = runtimeMirror(getClass.getClassLoader)
//    val im = m.reflect(this)
//
//    val fieldName = "id"
//
//    val fieldReflectMethod = tpe.decl(fieldName: TermName).asMethod
//    val returnType = tpe.decl(fieldName: TermName).typeSignature.resultType
//    val returnValue = im.reflectField(fieldReflectMethod).get
//
//    (returnType, returnValue)
//  }
//}
//
//// Test
//case class MyParams(id: String, stuff: Int) extends AbstractParams[MyParams]
//val p = new MyParams("joe", 2)
//p.extractorHelp






//import scala.reflect.runtime.universe._
//
//class AbstractParams[T: TypeTag] {
//  def tag: TypeTag[T]  = typeTag[T]
//  def getArgsAsTuple = {
//    // Find all case class fields in concrete class instance and print them as "[field name] [field value]"
//    val tag = this.tag
//    val tpe = tag.tpe
//    val allAccessors = tpe.decls.collect { case meth: MethodSymbol if meth.isCaseAccessor => meth }
//
//    val m = runtimeMirror(getClass.getClassLoader)
//    val im = m.reflect(this)
//
//    val fieldName = "id"
//
//    val fieldReflectMethod = tpe.decl(fieldName: TermName).asMethod
//    val returnType = tpe.decl(fieldName: TermName).typeSignature.resultType
//    val returnValue = im.reflectField(fieldReflectMethod).get
//
//    (returnType, returnValue)
//  }
//}
//
//
//// Test
//case class MyParams(id: String, stuff: Int) extends AbstractParams[MyParams]
//val p = new MyParams("joe", 2)
//p.getArgsAsTuple




















////////
//val rm = scala.reflect.runtime.currentMirror
//val accessors = rm.classSymbol(p.getClass).toType.members.collect {
//  case m: MethodSymbol if m.isGetter && m.isPublic => m
//}
//val instanceMirror = rm.reflect(p)
//for(acc <- accessors) yield instanceMirror.reflectMethod(acc).apply()




























//import scala.reflect.runtime.universe._
//
//class AbstractParams[T: TypeTag] {
//  def tag: TypeTag[T]  = typeTag[T]
//  def getArgsAsTuple = {
//    // Find all case class fields in concrete class instance and print them as "[field name] [field value]"
//    val tag = this.tag
//    val tpe = tag.tpe
//    val allAccessors = tpe.decls.collect { case meth: MethodSymbol if meth.isCaseAccessor => meth }
//
//    val m = runtimeMirror(getClass.getClassLoader)
//    val im = m.reflect(this)
//
//    val ctorArg2Tuples = allAccessors map { sym =>
//      val fldMirror = im.reflectField(sym)
//      val value = fldMirror.get
//      (sym.name, value)
//    }
//    ctorArg2Tuples
//  }
//}
//
//case class MyParams(id: String, stuff: Int) extends AbstractParams[MyParams]
//
//
//val p = new MyParams("joe", 2)
//
//p.getArgsAsTuple








//val rm = scala.reflect.runtime.currentMirror
//val accessors = rm.classSymbol(p.getClass).toType.members.collect {
//  case m: MethodSymbol if m.isGetter && m.isPublic => m
//}
//val instanceMirror = rm.reflect(p)
//for(acc <- accessors)
//  println(s"$p: ${instanceMirror.reflectMethod(acc).apply()}")



//import scala.reflect.runtime.universe._
//
//class AbstractParams[T: TypeTag] {
//  def tag: TypeTag[T]  = typeTag[T]
//  override def toString: String = {
//    // Find all case class fields in concrete class instance and print them as "[field name] [field value]"
//    val tag = this.tag
//    val tpe = tag.tpe
//    val allAccessors = tpe.declarations.collect { case meth: MethodSymbol if meth.isCaseAccessor => meth }
//
//    val m = runtimeMirror(getClass.getClassLoader)
//    val im = m.reflect(this)
//    val ctorArg2Strings = allAccessors map { sym =>
//      val fldMirror = im.reflectField(sym)
//      val value = fldMirror.get
//      "[" + sym.name + ": " + value + "]"
//    }
//    ctorArg2Strings.mkString(" ")
//  }
//}
//
//case class MyParams(id: String, stuff: Int) extends AbstractParams[MyParams]
//
//object Ex extends App {
//  val p = new MyParams("joe", 2)
//  println(s"$p")
//  // prints:
//  // [id: joe] [stuff: 2]
//}