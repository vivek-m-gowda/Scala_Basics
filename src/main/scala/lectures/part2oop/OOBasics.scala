package lectures.part2oop

import java.time.Year

object OOBasics extends App {

 val person = new Person("Nohith", 24)
 // in java if we wanted to print person age we say person.age
 println(person.age)
 println(person.x)
 person.greet("vivek")
 person.greet()


 val author = new Writer("vivek", "Gowda", 1812)
 val imposter = new Writer("vivek", "Gowda", 1812)
 val novel = new Novel("scala-beginners", 1861, author)

 println(author.FullName)
 println(novel.authorAge)
 println(novel.isWrittenBy(author))
 println(novel.copy(1998))

 val counter = new Counter()
 counter.inc.print
 counter.inc.inc.inc.print
 counter.inc(10).print

}

//class PARAMETERS are not field to access them with dot operator
//convert the class parameter to filed by declaring them as val
//constructor
class Person(name: String, val age: Int) {

 //class body we can have values, functions etc..
 val x = 88

 println(2)

 //when a function is defined inside a class definition is called a method
 //this.name here is a class person name and another name is greet name from the method
 def greet(name: String) : Unit = println(s"${this.name} say: Hi, $name")
 def greet(): Unit = println(s"$name")

 //Multiple constructors is defined using " def this() "
 //Most of the time we use Multiple constructor as default constructor
 //Or simply we can pass default parameters

 def this(name: String) = this(name, 0)

}



/*
   Novel and writer class exercises

   writer class has firstname, surname, year
     -method full name [string concatenation]

   novel class has name, year of release, author
   -method authorAge
   -method isWrittenBy
   -method copy (new year of release) = new instance of Novel
 */

class Novel(name: String, year: Int, author: Writer){
 def authorAge: Int = year - author.year
 def isWrittenBy(author: Writer) = author == this.author
 def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

class Writer(firstname:String, surname:String, val year:Int){
 def FullName: Unit = println(s"Writer name is ${this.firstname} + ${this.surname}")
}

/*
  Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
 */
class Counter(val count: Int = 0) {
 def inc = {
  println("incrementing")
  new Counter(count + 1)  // immutability
 }

 def dec = {
  println("decrementing")
  new Counter(count - 1)
 }

 def inc(n: Int): Counter = {
  if (n <= 0) this
  else inc.inc(n-1)
 }

 def dec(n: Int): Counter =
  if (n <= 0) this
  else dec.dec(n-1)

 def print = println(count)
}