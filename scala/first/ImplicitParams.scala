/**
  * Created by mhd.ug on 6/13/16.
  */

class Prompt(val preference: String)

object Prefs {
  /**
    * define an implicit variable that will be supplied by compiler @runtime
    */
  implicit val prompt = new Prompt("Yes, master>  ")
}

object ImplicitParams {

  // normal method definition
  def greet(name: String, preferredPrompt: Prompt) = {
    println(s"Welcome $name. the system is ready")
    println(preferredPrompt.preference)
  }

  // method definition with implicit argument
  def greetImplicit(name: String)(implicit preferredPrompt: Prompt) = {
    println(s"Welcome $name. the system is ready")
    println(preferredPrompt.preference)
  }


  def main(args: Array[String]) {
    // normal method call
    greet("Scala", new Prompt(">relax"))

    // with line marked ** commented this call will fail
    //could not find implicit value for parameter preferredPrompt: Prompt
    import Prefs._//**
    greetImplicit("Scala")
  }
}
