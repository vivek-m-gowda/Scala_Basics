package lectures.part1basics

object Functions extends App{

  // defining a function
  //(a: String) parameter name and type
  //def aFunction(a: String, b: Int): String = a + "" + b //single line  expression implementation


  //code block
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }
  println((aFunction("hello", 300000)))

  //parameter less function
  def aParameterlessFuncion() : Int = 42
  println(aParameterlessFuncion())
  println(aParameterlessFuncion)


  //making use of recursive function instead of  loops
  def aRepeatedFunction (aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }
  println(aRepeatedFunction("hello", 3))
  //WHEN YOU NEED LOOPS, USE RECURSION

  //a Function With Side Effects
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  println(aFunctionWithSideEffects("hi"))


  //codeblocks allows you to define axillary functions inside
  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(o: Int, p: Int): Int = o + p

    aSmallerFunction(n, n - 1)
  }
  println(aBigFunction(10))


  //Exercise
  //1) A greeting function (name, age) and prints => "Hi my name is ------ and I am ---- years old"

  def greeting(name: String, age: Int): String = "Hi my name is " + name + "and I am "+ age +" years old"
  println(greeting("Nohith", 18))

  //2) Factorial function
  def factorial(number: Int): Int ={
    if (number <= 0) 1
    else number * factorial(number-1)
  }
  println(factorial(3))

  //3)Fibonacci function
  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n-1) + fibonacci(n-2)
  }
  // 1 1 2 3 5 8 12 21
  println(fibonacci(8))

  //4)Test if a number is prime
  def prime(num: Int): Boolean = {
    def primeUntil(t: Int): Boolean =
      if (t <= 1) true
      else num % t != 0 && primeUntil(t-1)
    primeUntil(num / 2)
  }
  println(prime(5))
  println(prime(4))


  //Compiler looks at the right hand side and figures out the data type
  //example
  val message = "hello" // compiler figures that the returns statement for message is string

  //In this example the return type of x i int and return type of y is string [as it is string concatenation]
  val x = 2
  val y = x + "items"

  //even for the functions the return types are figured
  def add(a: Int, b:Int) = a+b


}
