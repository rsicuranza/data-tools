

/*
* Can I make the methods in the subtypes accessible from
* and instance of food?
*   - it looks like they are Private[this] by default?
*
* If I can make the methods of the subtypes accessible,
* can I use pattern matching to make a wrapper and avoid
* the type erasure?
*   - For example,
*     - A.value = Int
*     - B.value = String
*
*   - Would Food#A.value.type be interchangeable with Int?
*
* */

// the super
abstract class Food { val name: String }

// subtype, still abstract,so no need for an implementation yet
abstract class Fruit extends Food

/*
* subtypes with parametric fields
*   - these are producing methods that each satisfy
*   the accessor method for name in the super of Food
*     - they are made concrete with parametric fields
*     for the val of name in Food
* */
case class Banana(name: String) extends Fruit
case class Apple(name: String) extends Fruit

abstract class Cereal extends Food
case class Granola(name: String) extends Cereal
case class Muesli(name: String) extends Cereal

val fuji = Apple("Fuji")
val alpen = Muesli("Alpen")

def eat(f: Food): String = s"${f.name} eaten"