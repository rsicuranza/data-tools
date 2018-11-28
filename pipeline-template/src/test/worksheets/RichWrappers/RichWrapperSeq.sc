





object OuterWrapper {
  case class InnerWrapper[T](value: T)
  def apply[T](value:T) = {
    InnerWrapper[T](value)
  }
}

val anIntList:IndexedSeq[Int] = IndexedSeq(6,7,8)
val aLongList:IndexedSeq[Long] = IndexedSeq(5000, 6000, 70000)
val aDoubleList:IndexedSeq[Double] = IndexedSeq(5.2, 7.897, 2.3)

anIntList map {OuterWrapper(_)}
aLongList map {OuterWrapper(_)}
aDoubleList map {OuterWrapper(_)}

def toWrapperSeq[T](genericSeq:IndexedSeq[T]) = {
  genericSeq map {OuterWrapper(_)}
}

toWrapperSeq(anIntList)
toWrapperSeq(aLongList)
toWrapperSeq(aDoubleList











)