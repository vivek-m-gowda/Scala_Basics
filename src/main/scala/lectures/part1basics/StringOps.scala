package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello I am learning scala"

  //to print the index value
  println(str.charAt(2))

  //to print the sub string
  println(str.substring(7, 11))

  //to split the string into multiple parts
  //if the space is not provided between double quotes it will print separate each letter
  println(str.split(" ").toList)

  //string testing returns boolean
  println(str.startsWith("Hello"))

  //string replacement
  println(str.replace("Hello", "hello"))

  //string lowercase and uppercase
  println(str.toUpperCase())

  //to return the length of the string
  println(str.length)

  //SCALA specific utilities function
  //data type conversations
  val numberString = "45" //here the data type is string
  val number = numberString.toInt //we can easily convert it into int

  //concatenation prepending and appending
  println('a' +: numberString :+ 'z')

  //string reverse
  println(str.reverse)

  //to take char outnof string
  println(str.take(2))

  //scala specific interpolator
  //S-interpolator [allows us to pass the stored values]
  val name = "vinay"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  //S-interpolator allows us to perform expression inside {}
  val anotherGreeting = s"Hello, my name is $name and I am turning ${age+1} years old"
  println(greeting)
  println(anotherGreeting)

  //f-interpolator are similar to s-interpolator
  //f-interpolator are formatted strings they can receive printf like formats
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  //raw-interpolator
  // "/" backslash will not be escaped if passed without injection
  println("This is a \n newline")
  val escaped = "This is a \n newline"
  println(escaped)

}
