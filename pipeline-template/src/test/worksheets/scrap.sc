

abstract class A(field: String)
case class B(f: String) extends A(f)
case class C(i: Int) extends A(i.toString)

def printer (a: A) = {
  a match{
    case B(f) => println(f)
    case C(i) => println(i)
  }
}

