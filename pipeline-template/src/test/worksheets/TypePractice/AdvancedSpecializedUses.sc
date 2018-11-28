



// Overview
// https://dzone.com/articles/type-specialization-in-scala



// Best practices
// http://aleksandar-prokopec.com/2013/11/03/specialization-quirks.html


// Primitives and behind the scenes
// http://www.scala-notes.org/2011/04/specializing-for-primitive-types/

// https://blog.scalac.io/2017/05/25/scala-specialization.html



case class NumericTrait[@specialized(Int, Long, Double) T](listOfStuff:List[T]){
//  def makeList()
}