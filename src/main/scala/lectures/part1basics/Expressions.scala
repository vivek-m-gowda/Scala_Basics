package lectures.part1basics

object Expressions extends App{

  val x = 1+2 //expression [type is int]
  println(x)

  // math operators are [+, -, *, /, $, |, ^, <<, >> ]
  //along with this scala has >>> (right shift with zero extension)
  println(2 + 3 * 4) //basic math expression

  // relational operators [==, !=, >, >=, <, <= ]
  println(1 == x)

  // boolean operators or logical operators [!, &&, ||]
  println(!(1==x))

  //manipulating variables or changing variables [+=, -=, *=, /=] .......side effects
  var aVariable  = 2
  aVariable += 3
  println(aVariable)

  //Instruction v/s Expressions
  //Instruction is something that we tell the computer to do [print to console, change variable]
  //Expressions is something that has a value

  //If expression

  val aCondition = true
  val aConditionValue = if(aCondition) 5 else 3 // at the same time
  println(aConditionValue)
  println(if(aCondition) 5 else 3)
  //If in scala is an expression

  var i=0
  while (i<10){
    println(i)
    i += 1
  }
   //Data type for aWeirdValue is Unit
  val aWeirdValue = (aVariable = 3) // unit = void
  println(aWeirdValue)
  //the only a value the unit type can hold is ()
  // reassigning a variable is side effect
  // side effect in scala is expression returning unit's


  //Even a while is unit
  var j = 0
  val aWile = while (j < 10) {
    println(j)
    j += 1
  }
  println(aWile)

  //side effects are: println(), whiles, reassigning

  //code blocks

  val aCodeBlock ={
    val y = 2
    val z = y+1
    if(z > 6) "hello" else "goodbye"
  }
  println(aCodeBlock)








}
