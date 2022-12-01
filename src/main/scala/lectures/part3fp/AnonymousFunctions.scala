package lectures.part3fp

object AnonymousFunctions extends App {

  // Anonymous function (LAMBDA)
  val doubler = (x: Int) => x * 2 //Or val doubler: Int => Int = (x: Int) => x * 2

  //multiple parms in lambda
  val adder= (a:Int, b: Int) => a + b //Or  val adder: (Int, Int) => Int (a:Int, b: Int) => a + b

  //no parms
  val justDoSomething = () => 3 //Or val justDoSomething: () => Int = () => 3
  println(justDoSomething) //function itself
  println(justDoSomething())  //call

  //curly braces with lambdas
  val stringToInt = {(str: String) =>
    str.toInt
  }

  //MOR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 //equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ //equivalent to (a,b) => a + b

  /*
      1.  MyList: replace all FunctionX calls with lambdas
      2.  Rewrite the "special" adder as an anonymous function
     */

  val superAdd = (x: Int) => (y: Int) => x +y
  println(superAdd(3)(4))

}
