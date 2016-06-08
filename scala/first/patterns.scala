package scala.first

import scala.collection.immutable.List

object SimplePattern extends App {

  def filter(a: String) = {
    a match {
      case "String" => a
      case _        => null
    }
  }
  println(filter("a")) // null

  val list = List("Scala", "Java", "Php")

  list.filter(a =>
    a match {
      case "String" => true
      case _        => false
    })

  // alternative as in scala we can call method a.method(param) as a method param :D 
  list.filter { a =>
    a match {
      case "String" => true
      case _        => false
    }
  }

  // or either 
  val other = list filter { a =>
    a match {
      case "Scala" => true
      case _       => false
    }
  }

  println(other) // List(Scala)

}