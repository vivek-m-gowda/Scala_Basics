package lectures.part1basics

object ValuesVariablesTypes extends App {

  //values declaration
  val x: Int = 5
  val y = 10 //data types for val are optional
  println(x)
  println(y)

  val name: String = "vivek"
  print(name)

  //val it is similar to final keyword it can not be changed [IMMUTABLE]

  //Different data types
  val aBoolean: Boolean = true
  val aChar: Char = 'v'
  val aInt: Int = 78
  val aShort: Short = 7488
  val aLongs: Long = 3962338742327847246L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.23

  //Variable declaration
  var studentName: String = "Vivek"
  //println(studentName)

  studentName = "Vivek Gowda"
  println(studentName)

}
