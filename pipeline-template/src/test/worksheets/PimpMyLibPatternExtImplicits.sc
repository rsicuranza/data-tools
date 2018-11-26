

// https://coderwall.com/p/4clu3a/extension-methods-in-scala

//object Thing {
//
//  class ExtendedInt(value: Int) {
//    def plus(other:Int) = value + other
//  }
//
//  implicit def extendInt(i: Int) = new ExtendedInt(i)
//
//}
//
//val t1 = new Thing.ExtendedInt(5)
//
//t1 plus 5

//implicit class ExtendedInt(val value: Int) extends AnyVal {
//  def plus(other:Int) = value + other
//}


// https://sachabarbs.wordpress.com/2015/10/23/scala-extension-methods/

//object MyExtensions {
//  class RichInt(i: Int) {
//    def square = i * i
//  }
//  implicit def richInt(i: Int) = new RichInt(i)
//}
//
//import MyExtensions._
//val theInt = 20
//val theSquaredInt = theInt.square

//object ClassesDemo {
//  def main(args: Array[String]) =
//  {
//
//
//    val theInt = 20
//    val theSquaredInt = theInt.square
//
//    System.out.print(s"theSquaredInt = $theSquaredInt")
//
//    System.in.read()
//
//    ()
//  }
//
//}






//object MyExtensions {
//  implicit class RichInt(val i: Int) extends AnyVal {
//    def square = i * i
//  }
//}
//
//import MyExtensions._
//
//val theInt = 20
//val theSquaredInt = theInt.square


// https://stackoverflow.com/questions/3119580/scala-equivalent-of-c-s-extension-methods
//object MyExtensions {
//  class RichInt( i: Int ) {
//    def square = i * i
//  }
//  implicit def richInt( i: Int ) = new RichInt( i )
//}
//
//import MyExtensions._

//1.square


object MyExtensions {
  class RichInt( i: Int ) {
    def square = i * i
    def add = i + i
  }

  class RichString( i: String ) {
    def add = i + " " + i
  }

  implicit def richInt( i: Int ) = new RichInt( i )
  implicit def RichString( i: String ) = new RichString( i )

}

import MyExtensions._

1.add
"hi".add



// implicit params
// https://www.oreilly.com/library/view/learning-scala/9781449368814/ch10.html

















