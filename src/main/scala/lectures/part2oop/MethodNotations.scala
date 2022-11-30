package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"${name}, what the heck?!"

    def isAlive: Boolean = true

    def +(nickName: String): Person = new Person(s"$name ($nickName)", favoriteMovie)

    def apply(): String = s"Hi my name is $name and I like $favoriteMovie"

    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"

    def learns(thing: String) = s"$name is learning $thing"

    def learnsScala = this learns "Scala"
  }


  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  //we can also implement the same as
  println(mary likes ("3")) //equivalent
  //infix notation or operator notation

  //"operators" in scala
  val tom = new Person("Tom", "fight club")
  println(mary hangOutWith tom)

  //ALL OPERATORS ARE METHODS
  println(1+2)
  println(1.+(2))

  //prefix notation
  val x = -1 //equivalent with 1.unary_-
  val y = 1.unary_-
  // unary prefix only works with - + ~ !

  println(!mary) //equivalent with mary.unary_!
  println(mary.unary_!)

  //Postfix operators
  println(mary.isAlive)
  println(mary isAlive)


  //apply
  println(mary.apply())
  println(mary())

  /*
      1.  Overload the + operator
          mary + "the rockstar" => new person "Mary (the rockstar)"
      2.  Add an age to the Person class
          Add a unary + operator => new person with the age + 1
          +mary => mary with the age incrementer
      3.  Add a "learns" method in the Person class => "Mary learns Scala"
          Add a learnsScala method, calls learns method with "Scala".
          Use it in postfix notation.
      4.  Overload the apply method
          mary.apply(2) => "Mary watched Inception 2 times"
     */


  println((mary + "the Rockstar").apply())

  //println((+mary).age)

  println(mary learnsScala)

  println(mary(10))




}
