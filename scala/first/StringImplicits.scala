package scala.first

object StringImplicits extends App {

  import BetterString._

  val string = "abbaabba"
  println(string.palindrome)
  //true

  val string1 = "astring"
  println(string1.palindrome) //false
}

class BetterString(val string: String) {
  def palindrome = {
    string.reverse == string
  }
}

object BetterString {
  implicit def toBetterString(string: String): BetterString = new BetterString(string)
}
