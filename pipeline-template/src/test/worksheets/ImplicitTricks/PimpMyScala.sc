


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