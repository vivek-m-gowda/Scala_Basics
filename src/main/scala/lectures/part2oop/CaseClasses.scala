package lectures.part2oop

object CaseClasses extends App {

  /*
  equals, hashCode, toString
   */

   case class Person (name: String, age: Int)

  //1. class parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  //2. sensible to string
  // we doesn't even need to specify .tostring because println(instance) = (instance.toString)
  println(jim.toString)

  //3. equals and hashCode implemented out of the box
  val jim2= new Person("Jim", 34)
  println(jim == jim2)

  //4. case classes have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  //5. case class have a companion objects
  //we don't use a keyword new when instantiating a case class
  val thePerson = Person
  val mary = Person("Mary", 23)

  //6. case classes are serializable

  //7. case classes have extractor patterns [used for PATTERN MATCHING]


  case object UnitedKingdom {

    def name: String = "The UK of GB an NI"
  }


}
