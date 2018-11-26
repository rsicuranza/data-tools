import org.apache.spark.annotation.InterfaceStability
import org.apache.spark.sql.{Column, TypedColumn}
import org.apache.spark.sql.catalyst.analysis.UnresolvedDeserializer
import org.apache.spark.sql.catalyst.encoders.ExpressionEncoder
import org.apache.spark.sql.catalyst.expressions.{Attribute, Expression}
import org.apache.spark.sql.execution.aggregate.TypedAggregateExpression

///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////

@InterfaceStability.Stable
class TypedColumn[-T, U](expr: Expression,
                         private[sql] val encoder: ExpressionEncoder[U])
    extends Column(expr) {

  /**
    * Inserts the specific input type and schema into any expressions that are expected to operate
    * on a decoded object.
    */
  private[sql] def withInputType(
      inputEncoder: ExpressionEncoder[_],
      inputAttributes: Seq[Attribute]): TypedColumn[T, U] = {
    val unresolvedDeserializer =
      UnresolvedDeserializer(inputEncoder.deserializer, inputAttributes)
    val newExpr = expr transform {
      case ta: TypedAggregateExpression if ta.inputDeserializer.isEmpty =>
        ta.withInputInfo(deser = unresolvedDeserializer,
                         cls = inputEncoder.clsTag.runtimeClass,
                         schema = inputEncoder.schema)
    }
    new TypedColumn[T, U](newExpr, encoder)
  }

  /**
    * Gives the [[TypedColumn]] a name (alias).
    * If the current `TypedColumn` has metadata associated with it, this metadata will be propagated
    * to the new column.
    *
    * @group expr_ops
    * @since 2.0.0
    */
  override def name(alias: String): TypedColumn[T, U] =
    new TypedColumn[T, U](super.name(alias).expr, encoder)

}
