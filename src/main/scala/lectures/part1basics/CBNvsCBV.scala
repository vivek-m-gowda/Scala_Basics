package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValuse(x: Long): Unit ={
    println("by value" + x)
    println("by value" + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name" + x)
    println("by name" + x)
  }

  calledByValuse(System.nanoTime())
  calledByName(System.nanoTime())



  //Simple exapmle
  def something() = {
    println("calling something")
    1 // return value
  }
  /* Now we are going to define two function that accept Int arguments that are exactly the same except
  that one takes the argument in a call -by - value style (x: Int) and the other in a call - by - name style (x:
  => Int
  ).*/
  def callByValue(x: Int) = {
    println("x1=" + x)
    println("x2=" + x)
  }

  def callByName(x: => Int) = {
    println("x1=" + x)
    println("x2=" + x)
  }
  callByValue(something())
  callByName(something())



  def infinite(): Int =1 +infinite()
  def printFirst(x: Int, y: => Int) = println(x)
  //printFirst(infinite(), 34)
  printFirst(34, infinite())

}
