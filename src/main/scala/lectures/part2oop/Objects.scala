package lectures.part2oop

object Objects extends App {

  //SCALA DOES NOT HAVE CLASS_LEVEL FUNCTIONALITY ("static")

  //defining class level functionality in scala
  //obj do not receive parameter
  object Person{
    //static or class-leve functionality
    val N_EYES = 2
    def canFly: Boolean = false
  }

  class Person{
    //instance-level functionality
  }

  //writing class and objects in same scope is called COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly )

  //scala object is a singleton instance
  val mery = Person
  val john = Person
  println( mery == john) //mery and john point to the same instance

  //object extends App is similar to
  //def main(args: Array[String]): Unit

}