



import scala.reflect._

def getClassTag[T: ClassTag](x: T): ClassTag[T] = classTag[T]

/////////////////////////////////////////////////////
//////// Getting the ClassTag with Inference ////////
/////////////////////////////////////////////////////
val ct = getClassTag(10)

// Using the ClassTag to make an array
val intArr = ct.newArray(0)

val addElement1 = intArr :+ 1
val populateElements1 = intArr ++ Array(1,5,4)

/////////////////////////////////////////////////////
//////////// Define class tag explicitly ////////////
/////////////////////////////////////////////////////
val ct2 = classTag[String]

// Using the ClassTag to make an array
val intArr2 = ct2.newArray(0)

val addElement2 = intArr2 :+ 1
val populateElements2 = intArr2 ++ Array(1,5,4)


/////////////////////////////////////////////////////
//////////// Implicit Class Tag Matching ////////////
/////////////////////////////////////////////////////

//def isA[T](x: Any): Boolean = x match {
//  case _: T => true
//  case _ => false
//}
//Warning: abstract type pattern T is unchecked since it is eliminated by erasure
//case _: T => true
//isA[Int](7)        // true
//isA[Int]("Hello")  // true!

// Implicitly check for a type
def isA[T: ClassTag](x: Any): Boolean = x match {
  case _: T => true
  case _ => false
}
// no warning
isA[Int](7)  // true
isA[Int]("Hello")  // false














