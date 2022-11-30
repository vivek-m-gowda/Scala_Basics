package lectures.part2oop

object Exceptions extends App {



  //1. trowing and exceptions
  //  val x: String = null
  //  println(x.length)
  //  val aWeirdValue: String = throw new NullPointerException

  //throwable classes extends the throwable class.
  //Exception and Error are the major Throwable subtypes

  //2. catching the exceptions
//  def getInt(withExceptions: Boolean): Int =
//    if (withExceptions) throw new RuntimeException("No int for you")
//    else 42
//
//  try {
//    //code that might throw
//    getInt(true)
//  }catch {
//    case e: RuntimeException => println("caught a runtime exception")
//  }finally {
//    //code that will execute NO MATTER WHAT
//    //finally is optional, does not influence the return type of this expression
//    //use finally only for side effects
//    println("finally")
//  }

//  val potentialFail = try {
//    //code that might throw
//    getInt(false)
//  } catch {
//    case e: RuntimeException => println("caught a runtime exception")
//  } finally {
//    //coe that will execute NO MATTER WHAT
//    println("finally")
//  }
//  println(potentialFail)

  //3. how to define your own exceptions
//  class MyException extends  Exception
//  val exception = new MyException
//  throw exception





  /*
     1.  Crash your program with an OutOfMemoryError
     2.  Crash with StackOverflow Error
     3.  PocketCalculator
         - add(x,y)
         - subtract(x,y)
         - multiply(x,y)
         - divide(x,y)
         Throw
           - OverflowException if add(x,y) exceeds Int.MAX_VALUE
           - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
           - MathCalculationException for division by 0
    */
  //  OOM
  //  val array = Array.ofDim(Int.MaxValue)

  //  SO
  //  def infinite: Int = 1 + infinite
  //  val noLimit = infinite

  // 1.
  //val array = Array.ofDim(Int.MaxValue)

  // 2.
//  def infinite: Int = 1 + infinite
//  val noLimit = infinite


  class OverflowException extends RuntimeException

  class UnderflowException extends RuntimeException

  class MathCalculatorException extends RuntimeException("Division by ZERO")

  object PocketCalculator {

    def add(x: Int, y:Int) = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y > 0 && result < 0) throw new UnderflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if ( y == 0 ) throw new MathCalculatorException
      else x/y
    }

  }

  println(PocketCalculator.add(4, 2))
  println(PocketCalculator.subtract(4, 2))
  println(PocketCalculator.multiply(4, 2))
  println(PocketCalculator.divide(4, 2))
  //println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2, 0))

}
