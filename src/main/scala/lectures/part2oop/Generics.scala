package lectures.part2oop

object Generics extends App {

  class MyList[A] {

    //can use the type A inside the class definition

  }

  class MyMap [key, Value ]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  //generic methods

  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfInteger = MyList.empty[Int]



  //variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //1. Yes List[Cat] extends List[Animals] = COVARIANCE ----- [+A]

  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  //animalList.add(new Dog) ? HARD QUESTION

  //2. No List[Cat] extends List[Animals] = INVARIANCE ----- [A]
  class InVariantList[A]
  val inVariantAnimalList: InVariantList[Animal] = new InVariantList[Animal]

  //3. NOOO! List[Cat] extends List[Animals] = CONTRAVARIANCE ----- [-A]
  class ContraVariantList[-A]
  //val contraVariantAnimalList = contraVariantAnimalList[Cat] = new ContraVariantList[Animal]

  //bounded type [upper bound "<", Lower bound ">"]

  class Cage[A <: Animal] (animal: A)
  val cage = new Cage(new Dog)






}
