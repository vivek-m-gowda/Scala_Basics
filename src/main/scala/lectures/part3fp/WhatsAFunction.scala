package lectures.part3fp

object WhatsAFunction extends  App {

  //To use functions as first class elements

  val doubler = new MyFunction[Int, Int]{
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2)) //doubler acts like a function

  //  function types = Function1[A, B] can call unto 22 functions
  val stringToIntConverter = new Function1[String, Int]{
    override def apply(string: String): Int = string.toInt
  }


  //In java to define function we used to create function like class
  trait MyFunction[A, B] {
    def apply(element: A): B
  }

  //ALL SCALA FUNCTIONS ARE OBJECTS

  /*
      1.  a function which takes 2 strings and concatenates them
      2.  transform the MyPredicate and MyTransformer into function types
      3.  define a function which takes an int and returns another function which takes an int and returns an int
          - what's the type of this function
          - how to do it
     */


  //1.
  def concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }
  println(concatenator("hello", "Scala"))


  //3
  val supperAdder: Function1[Int, Function1[Int, Int]] = new Function[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }
  val adder3 = supperAdder(3)
  println(adder3(4))
  println(supperAdder(3)(4))  //curried function



}
