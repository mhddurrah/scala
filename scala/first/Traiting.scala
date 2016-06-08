package scala.first

trait Thing

abstract class LivingThing extends Thing
abstract class Plant extends LivingThing
abstract class Animal extends LivingThing

// only subclass of Animal can mix this trait
trait HasLegs extends Animal {
  def walk() = { println("Wolking") }
}

trait HasWings extends Animal {
  def flap() { println("Flap Flap") }
}

trait Flies {
  // only HasWings can fly :D
  this: HasWings =>
  def fly() { println("Flying") }
}

class Rabbit extends Animal with HasLegs

class Bird extends Animal with HasLegs with HasWings

class Robin extends Bird with Flies
class Ostrich extends Bird

abstract class Mammal extends Animal {
  def bodyTemperature: Double
}

trait KnowsName extends Animal {
  def name: String
}

class Dog(val name: String) extends Mammal with HasLegs with KnowsName {
  def bodyTemperature = 99.3
}

trait IgnoresName {
  this: KnowsName =>
  def ignoreName(when: String): Boolean

  def currentName(when: String): Option[String] = if (ignoreName(when)) None else Some(name)
}

class Cat(val name: String) extends Mammal with HasLegs with KnowsName with IgnoresName {
  def ignoreName(when: String) = when match {
    case "Dinner" => false
    case _        => true
  }

  def bodyTemperature: Double = 99.3
}

trait Athlete extends Animal

trait Runner {
  this: HasLegs with Athlete =>
  def run() = { println("I'm running") }
}

class Person(val name: String) extends Mammal with HasLegs with KnowsName {
  def bodyTemperature = 98.6
}

trait Biker extends Person {
  this: Athlete =>
  def ride() { println("riding") }
}

trait Gender
trait Male extends Gender
trait Female extends Gender

object Main {
  // wrong :D Biker should be a Person
  //  val bikerDog = new Dog("bikder") with Athlete with Biker

  val archer = new Dog("archer") with Athlete with Runner with Male

  val dpp = new Person("david") with Athlete with Biker with Male
  def goBiking(b: Biker) = println(b.name + " is biking")

  def main(args: Array[String]): Unit = {
    goBiking(dpp)
  }
}