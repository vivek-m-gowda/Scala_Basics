package lectures.part2oop

object Inheritance extends App {

  //Single class inheritance

  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  class Cat extends Animal

  val cat = new Cat
  cat.eat

  //override

  class Dog extends Animal {
    override val creatureType = "domestic"
    override def eat = println("crunch crunch")
    super.eat
  }

  val dog = new Dog
  dog.eat
  println(dog.creatureType)

  //super [is used when you wan to reference a method or field from the parent class]

}
