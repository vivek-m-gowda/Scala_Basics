package lectures.part1basics

object DefaultArgs extends App {

  def tailFactorial(n: Int, accumulator: Int): Int =
    if (n <= 1) accumulator
    else tailFactorial(n - 1, n * accumulator)


  //Scala provides the ability to give parameters default values that can be used to allow a caller to omit those parameters.


  def log(message: String, level: String = "INFO") = println(s"$level: $message")

  log("System starting") // prints INFO: System starting
  log("User not found", "WARNING") // prints WARNING: User not found
  log(message = "syntax error", level = "ERROR") // you can name the argument
}
