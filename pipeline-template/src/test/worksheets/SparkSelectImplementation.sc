import org.apache.spark.sql.{Dataset, TypedColumn}
import org.apache.spark.sql.catalyst.encoders.ExpressionEncoder
import org.apache.spark.sql.catalyst.plans.logical.Project


//import spark.implicits._
//
//def select[U1](c1: TypedColumn[T, U1]): Dataset[U1] = {
//  implicit val encoder = c1.encoder
//  val project = Project(c1.withInputType(exprEnc, planWithBarrier.output).named :: Nil,
//    planWithBarrier)
//
//  if (encoder.flat) {
//    new Dataset[U1](sparkSession, project, encoder)
//  } else {
//    // Flattens inner fields of U1
//    new Dataset[Tuple1[U1]](sparkSession, project, ExpressionEncoder.tuple(encoder)).map(_._1)
//  }
//}