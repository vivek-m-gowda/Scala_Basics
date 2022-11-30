package lectures.part2oop

object AbstractDataTypes extends App {

  //abstract
  //fields are methods that are unimplemented are called abstract
  //are defined by the keyword abstract
  //abstract classes can't be instantiated

  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "k9"
    override def eat: Unit = println("crunch crunch")
  }

  //traits
  //are defined by the keyword traits

  trait Carnivore {
    def eat (animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    val creatureType: String = "croc"
    def eat: Unit = println("nomnom")
    def eat(animal: Animal): Unit = s"I am corcodile and I am eating ${animal.creatureType}"
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

}
