package lectures.part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App {

  def factorial(number: Int): Int = {
    if (number <= 1) 1
    else {
      println("Computing factorial of " + number +  " _ I first need factorial of " + (number - 1))
      val result = number * factorial(number - 1)
      println("Computing factorial of " + number )
      result
    }
  }
  //println(factorial(10))
  //println(factorial(5000)) //it causes stack overflow

  //each call of the recursive function uses stack frame


  def anotherFactorial(number: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factorialHelper(x-1, x*accumulator) //TAIL RECURSION [use the recursive call as the last expression]
    factorialHelper(number, 1 )
  }
  println(anotherFactorial(5000)) //it does not causes stack overflow

  //When you need loop use _TAIL_ Recursion


  /*
    anotherFactorial(10) = factorialHelper(10, 1)
    = factorialHelper(9, 10*1)
    = factorialHelper(8, 9 * 10 * 1)
    = factorialHelper(7, 8 * 9 * 10 * 1)
    = factorialHelper(6, 7 * 8 * 9 * 10 * 1)
    = ...
    = factorialHelper(2, 3 * 4 * .... 10 * 1)
    = factorialHelper(1, 1 * 2 * 3 * 4 * .... 10)

    * We can also make use of @tailrec annotation [if that particular function is not the last expression compiler will throw an error]
   */

  //excises
  //1) concatenating string n times
  @tailrec
  def concatenateTailrec(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateTailrec(aString, n-1, aString + accumulator)

  println(concatenateTailrec("hello", 3000, ""))


  //2) isPrime function tail recursive
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t-1, n % t != 0 && isStillPrime)
    isPrimeTailrec(n/2, true)
  }
  println(isPrime(2003))
  println(isPrime(69))

  //3) Fibonacci function, tail recursive.

  def fibonacci (n: Int): Int ={
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if(n <= 2)1
    else fiboTailrec(2, 1, 1)
  }
  println(fibonacci(8))

}
