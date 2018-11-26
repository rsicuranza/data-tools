
/// product w serializable
// https://underscore.io/blog/posts/2015/06/04/more-on-sealed.html

sealed trait Color extends Product with Serializable
final case object Red extends Color
final case object Green extends Color
final case object Blue extends Color

// https://underscore.io/blog/posts/2015/06/02/everything-about-sealed.html

sealed trait Base
final case class SubtypeOne(a: Int) extends Base
final case class SubtypeTwo(b: Option[String]) extends Base

