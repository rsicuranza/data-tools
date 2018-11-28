
// http://fasihkhatib.com/2017/07/05/scalaz-tupleops/

import scalaz._
import Scalaz._

(1, 2) fold( (_1, _2) => _1 + _2 )

(1, 2) mapElements(_1 => _1 * 2, _2 => _2 * 2)

(1, 2) map (_ * 2)