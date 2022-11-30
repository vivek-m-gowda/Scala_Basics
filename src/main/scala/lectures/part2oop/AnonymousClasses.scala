package lectures.part2oop

object AnonymousClasses extends App {

  //Anonymous class is an inner class without a name,
  // which means that we can declare and instantiate class at the same time.

  abstract class Animal{
    def eat: Unit
  }

  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("ahahahahahah")
  }

  //anonymous class
  val funnyAnimal: Animal = new AnonymousClasses$$anon$1

  println(funnyAnimal.getClass)



}
