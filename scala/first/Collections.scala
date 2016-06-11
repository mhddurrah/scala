package scala.first

/**
 * @author ug
 */
object Collections extends App {

  val list = List("scala", "java", "php", "python")

  val *-^ = list filter { _.length > 3 } filter { _.startsWith("s") } map { e => <lang>{ e.capitalize }</lang> }

  println(*-^) // List(<lang>Scala</lang>) :D
}