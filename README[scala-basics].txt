
-----------------------------------------------------SCALA & FUNCTIONAL PROGRAMMING ESSENTIALS | ROCK THE JVM-------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

GETTING STARTED 
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	Software requirements 
		
		1)		JAVA development kit [scala runs on JVM so we need JAVA]
				can download lates version from -- https://www.oracle.com/in/java/technologies/downloads/

		2)		Software Development Kit [we make use of IntelliJ IDEA]
				can download lates version from -- https://www.jetbrains.com/idea/download/#section=linux
				
>>	Once after you have JAVA and SDK in your machine install SCALA plugin in your SDK

>>	First code [Hello world]
		
		package playground

		object Playground {

			def main(args: Array[String]): Unit = {
				println("hello world")
			}
			
		}

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

SCALA BASICS

1.1 Values, Variables and Types
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	Variable is a name which is used to refer memory location. You can create mutable and immutable variable in scala.

>>	Values declaration using "val" keyword & Initialization 
				  
		* val it is similar to final keyword it can not be changed [IMMUTABLE]
		* data types for val are optional

		  val x: Int = 5
		  val y = 10 //data types for val are optional
		  println(x)
		  println(y)
		  
		  val name: String = "vivek"
		  print(name)
		  
>>	 Different data types in SCALA
		
		  val aBoolean: Boolean = true
		  val aChar: Char = 'v'
		  val aInt: Int = 78
		  val aShort: Short = 7488
		  val aLongs: Long = 3962338742327847246L
		  val aFloat: Float = 2.0f
		  val aDouble: Double = 3.23

>>	Variable declaration using "var" keyword. it can not be changed [MUTABLE] but there are some side effects

		  var studentName: String = "Vivek"
		  println(studentName)
		  studentName = "Vivek Gowda"
		  println(studentName)
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

1.2 Expressions
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	In Scala, all statements are expressions that return a value.
		* example
		
		 val x = 1+2 //expression [type is int]
		 println(x)

>>	We have basic math operators are [+, -, *, /, $, |, ^, <<, >> ]
		along with this scala has >>> (right shift with zero extension)
	 
	 println(2 + 3 * 4) //basic math expression

>>	In scala we have relational operators [==, !=, >, >=, <, <= ]
		println(1 == x)

>>	Boolean operators or logical operators [!, &&, ||]
		println(!(1==x))
>>	manipulating variables or changing variables [+=, -=, *=, /=] .......side effects
  
		 var aVariable  = 2
		 aVariable += 3
		 println(aVariable)

>>	Instruction v/s Expressions
		* Instruction is something that we tell the computer to do [print to console, change variable]
		* Expressions is something that has a value
		
		IF EXPRESSION

		  val aCondition = true
		  val aConditionValue = if(aCondition) 5 else 3 // at the same time
		  println(aConditionValue)
		  println(if(aCondition) 5 else 3)
		  
		  If in scala is an expression not an instruction

>>	 Side effects [ reassigning a variable is side effect]
		* In scala unit is similar to void [which return meaningless vaues]
		* For example
		
			val aWeirdValue = (aVariable = 3) // unit = void
			println(aWeirdValue)
		
		* The output will be () because Data type for aWeirdValue is Unit
		* the only a value the unit type can hold is ()
		* side effect in scala is expression returning unit's
		* side effects are: println(), whiles, reassigning
		
		* Even a while loop can become side effectif we reassign
			var i = 0
			val aWile = while (i < 10) {
				println(i)
				i += 1
			}
			println(aWile)
		* Donot use WHILE loops in scala

>>	Code blocks
		* Code Block is multiple lines of code that are enclosed between braces i.e. everything between { and } is in one block code.
		* Block of code is generally used in methods, class definition, loop statements, and logic.
		
			  val aCodeBlock = {
				val y = 2
				val z = y+1
				if(z > 2) "hello" else "goodbye" 
				45
			  } 
			  prinintln(aCodeBlock) // we get 45 as answer bez last expression in int 45
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

1.3 Functions
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	Functions are defined using a "def" keyword followed by parameters with name and type and finally a return type
		* example [ single line  expression implementation]
		
			def aFunction(a: String, b: Int): String = a + "" + b
			//(a: String) parameter name and type
		
		* example [function in code block]
		
			  def aFunction(a: String, b: Int): String = {
				a + "" + b
			  }
			  println((aFunction("heelo", 3)))

>>	parameter less function
		* example
		
			  def aParameterlessFuncion() : Int = 42
			  println(aParameterlessFuncion())
			  println(aParameterlessFuncion)

>>	 WHEN YOU NEED LOOPS, USE RECURSION
		  * Making use of recursive function instead of loops
		  * Return types are mandatory for recursive functions
		  
			  def aRepeatedFunction (aString: String, n: Int): String = {
				if (n == 1) aString
				else aString + aRepeatedFunction(aString, n-1)
			  }
			  println(aRepeatedFunction("hello", 3))
 
 >>	A Function With Side Effects
		* example [which prints () & hi ]
		
			def aFunctionWithSideEffects(aString: String): Unit = println(aString)
			println(aFunctionWithSideEffects("hi"))
			
>>	Codeblocks allows you to define axillary functions inside
		* example
		
			  def aBigFunction(n: Int): Int = {
				def aSmallerFunction(o: Int, p: Int): Int = o + p
				aSmallerFunction(n, n - 1)
			  }

>>	Exercise
		* 1)A greeting function (name, age) and prints => "Hi my name is ------ and I am ---- years old"

			  def greeting(name: String, age: Int): String = "Hi my name is " + name + "and I am "+ age +" years old"
			  println(greeting("Nohith", 18))

		* 2)Factorial function
		
			  def factorial(number: Int): Int ={
				if (number <= 0) 1
				else number * factorial(number-1)
			  }
			  println(factorial(3))

		* 3)Fibonacci function
		
			  def fibonacci(n: Int): Int = {
				if (n <= 2) 1
				else fibonacci(n-1) + fibonacci(n-2)
			  }
			  // 1 1 2 3 5 8 12 21
			  println(fibonacci(8))

		*4)Test if a number is prime
		
				def prime(num: Int): Boolean = {
				def primeUntil(t: Int): Boolean =
				  if (t <= 1) true
				  else num % t != 0 && primeUntil(t-1)
				primeUntil(num / 2)
			  }
			  println(prime(5))
			  println(prime(4)) 
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

1.4 Type Inference
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	Compiler looks at the right hand side and figures out the data type
		* example
		  val message = "hello" // compiler figures that the returns statement for message is string

		* In this example the return type of x i int and return type of y is string [as it is string concatenation]
		  val x = 2
		  val y = x + "items"

		* even for the functions the return types are figured
		  def add(a: Int, b:Int) = a+b
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

1.5 Recursion
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	each call of the recursive function uses stack frame
	* stack frame is a limited memory prodived by JVM
	* example 
	
		 def factorial(number: Int): Int = {
			if (number <= 1) 1
			else {
			println("Computing factorial of " + number +  " _ I first need factorial of " + (number - 1))
			val result = number * factorial(number - 1)
			println("Computing factorial of " + number )
			result
			}
		}
		println(factorial(10))
		println(factorial(5000)) //it causes stack overflow
	* The code block fails as stack overflow because it uses recursive stack frames
	
	* example 
	
		def anotherFactorial(number: Int): BigInt = {
			@tailrec
			def factorialHelper(x: Int, accumulator: BigInt): BigInt =
				if (x <= 1) accumulator
				else factorialHelper(x-1, x*accumulator) //this is called TAIL RECURSION
			factorialHelper(number, 1 )
		}
		println(anotherFactorial(5000)) //it does not causes stack overflow
	* This code block maintain single stack frame
	* TAIL RECURSION [use the recursive call as the last expression]
	* We can also make use of @tailrec annotation [if that particular function is not the last expression compiler will throw an error]
	* When you need loop use _TAIL_ Recursion
	
	working
	/*
		anotherFactorial(10) = factorialHelper(10, 1)
		= factorialHelper(9, 10*1)
		= factorialHelper(8, 9 * 10 * 1)
		= factorialHelper(7, 8 * 9 * 10 * 1)
		= factorialHelper(6, 7 * 8 * 9 * 10 * 1)
		= ...
		= factorialHelper(2, 3 * 4 * .... 10 * 1)
		= factorialHelper(1, 1 * 2 * 3 * 4 * .... 10)
   */
   
>>	Exercise	
		1)concatenating string n times
		
			  @tailrec
			  def concatenateTailrec(aString: String, n: Int, accumulator: String): String =
				if (n <= 0) accumulator
				else concatenateTailrec(aString, n-1, aString + accumulator)

			  println(concatenateTailrec("hello", 3000, ""))


		2) isPrime function tail recursive
		
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

		3)Fibonacci function, tail recursive.

			def fibonacci (n: Int): Int ={
				def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
				  if (i >= n) last
				  else fiboTailrec(i + 1, last + nextToLast, last)

				if(n <= 2)1
				else fiboTailrec(2, 1, 1)
			}
			println(fibonacci(8))
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

1.6 Call-by-Name and Call-by-Value
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	In Scala when arguments pass through call-by-value function it compute the passed-in expression’s or arguments value once before calling the function . 
		But a call-by-Name function in Scala calls the expression and recompute the passed-in expression’s value every time it get accessed inside the function.

>>	we use "=>" to define a call by name function
		* consider an example
			
			def something() = {
			  println("calling something")
			  1 // return value
			}
		
		* Now we are going to define two function that accept Int arguments that are exactly the same except 
		that one takes the argument in a call-by-value style (x: Int) and the other in a call-by-name style (x: => Int).

			def callByValue(x: Int) = {
			  println("x1=" + x)
			  println("x2=" + x)
			}

			def callByName(x: => Int) = {
			  println("x1=" + x)
			  println("x2=" + x)
			}
			
		* Now what happens when we call them with our side-effecting function?

			scala> callByValue(something())
			calling something
			x1=1
			x2=1

			scala> callByName(something())
			calling something
			x1=1
			calling something
			x2=1
			
		* So you can see that in the call-by-value version, the side-effect of the passed-in function call (something()) only happened once. 
		   However, in the call-by-name version, the side-effect happened twice. This is because call-by-value functions compute the passed-in expression's value before calling the function, 
		   thus the same value is accessed every time. Instead, call-by-name functions recompute the passed-in expression's value every time it is accessed.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

1.7 Default and Named Arguments
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	Scala provides the ability to give parameters default values that can be used to allow a caller to omit those parameters.
		* example
		
			def log(message: String, level: String = "INFO") = println(s"$level: $message")
			log("System starting")  // prints INFO: System starting
			log("User not found", "WARNING")  // prints WARNING: User not found

		* The parameter level has a default value so it is optional. On the last line, the argument "WARNING" overrides the default argument "INFO". 
		   Where you might do overloaded methods in Java, you can use methods with optional parameters to achieve the same effect. However, 
		   if the caller omits an argument, any following arguments must be named.
		   
>>	you can not omit the leading argument 

			def log(message: String = System starting, level: String = "INFO") 
			log("WARNING")  //this throws an error
			
			* Solution is to name the argument
				log(message = "user not found",  level = "WARNING")
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

1.8 Smart Operations on Strings
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	Some of the java and scala specific string operations   

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
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

OBJECT-ORIENTED PROGRAMMING IN SCALA

2.1 Object-Oriented Basics
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
>>	We can simply instantiate the new object from class as 
			
			val person = new Person()
			
>>	class PARAMETERS are not field to access them with dot operator
		* convert the class parameter to filed by add the keyword "val"

			class Person(name: String, val age: Int) //constructor
			
			object OOBasics extends App {
					val person = new Person("Nohith", 24)
					 println(person.age)
					 person.greet("vivek")
					 person.greet90	 
			}

>>	When a function is defined inside a class definition is called a method
		* this.name here is a class person name and another name is greet name from the method
			
			class Person(name: String, val age: Int) {
				def greet(name: String) : Unit = println(s"${this.name} say: Hi, $name")
			}

>>	Overloading [defining methods with same name but with different signatures]
			
			def greet(): Unit = println(s"$name") // this is nothing but ${this.name} 	
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

2.2 Object-Oriented Basics (exercises)
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
>>	Novel and writer class exercises

		   writer class has firstname, surname, year
			 -method full name [string concatenation]

		   novel class has name, year of release, author
		   -method authorAge
		   -method isWrittenBy
		   -method copy (new year of release) = new instance of Novel

		 class Novel(name: String, year: Int, author: Writer){
		 def authorAge: Int = year - author.year
		 def isWrittenBy(author: Writer) = author == this.author
		 def copy(newYear: Int): Novel = new Novel(name, newYear, author)
		}

		class Writer(firstname:String, surname:String, val year:Int){
		 def FullName: Unit = println(s"Writer name is ${this.firstname} + ${this.surname}")
		}

>>	/*
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
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

2.3 Syntactic Sugar: Method Notations
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
>>	Method Invocation is a technique that demonstrates different syntax in which we dynamically call methods of a class with an object.

>>	Infix notation or operator notation [using object, method and parameter in single expression]
		Any method which takes a single parameter can be used as an infix operator: mary.likes("Inception") can also be written as a mary likes 3
		
		* this style of writing is called Syntactic Sugar
		* only woks for methods with one parameter

			object MethodNotations extends App {
			  class Person(val name: String, favoriteMovie: String) {
				def likes(movie: String): Boolean = movie == favoriteMovie
			  }
			  val mary = new Person("Mary", "Inception")
			  println(mary.likes("Inception"))
			  //we can also implement the same as
			  println(mary likes ("3")) //equivalent
			  //infix notation or operator notation
			}

>>	In Scala, operators are methods. Any method with a single parameter can be used as an infix operator. For example, + can be called with dot-notation:

		  //ALL OPERATORS ARE METHODS
		  println(1+2)
		  println(1.+(2))
		 
>>	Prefix operators work if an object has a method name that starts with unary_ 
		unary prefix only works with - + ~ !
		
			class {
				def unary_! : String = s"${name}, what the heck?!"
			}
			 println(!mary) //equivalent with mary.unary_!
			 println(mary.unary_!)

>>	Postfix operators
		Any method which does not require a parameter can be used as a postfix operator: a.m can be written as a m.
		For instance, a.+(b) is equivalent to a + b and a.! is the same as a!.
		{
			def isAlive: Boolean = true
		}
		
			println(mary.isAlive)
			println(mary isAlive)
		
		* You should import this file import scala.language.postfixOps
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

2.4 Method Notations (Exercises)
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 
>>	1.  Overload the + operator
			mary + "the rockstar" => new person "Mary (the rockstar)"
		2.  Add an age to the Person class
			Add a unary + operator => new person with the age + 1
			+mary => mary with the age incrementer
		3.  Add a "learns" method in the Person class => "Mary learns Scala"
			Add a learnsScala method, calls learns method with "Scala".
			Use it in postfix notation.
		4.  Overload the apply method
			mary.apply(2) => "Mary watched Inception 2 times"
		{
			def +(nickName: String): Person = new Person(s"$name ($nickName)", favoriteMovie)
			def apply(): String = s"Hi my name is $name and I like $favoriteMovie"
			def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
			def learns(thing: String) = s"$name is learning $thing"
			def learnsScala = this learns "Scala"
		}

			  println((mary + "the Rockstar").apply())
			  println((+mary).age)
			  println(mary learnsScala)
			  println(mary(10))
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

2.4 Scala Objects
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	An object is a class that has exactly one instance. It is created lazily when it is referenced, like a lazy val.
		As a top-level value, an object is a singleton.
		As a member of an enclosing class or as a local value, it behaves exactly like a lazy val.
		An object with the same name as a class is called a companion object. 

>>	SCALA DOES NOT HAVE CLASS_LEVEL FUNCTIONALITY ("static")

		* defining class level functionality in scala
		* obj do not receive parameter
		  object Person{
			//static or class-leve functionality
			val N_EYES = 2
			def canFly: Boolean = false
		  }

		  class Person{
			//instance-level functionality
		  }

		 *writing class and objects in same scope is called COMPANIONS 

		  println(Person.N_EYES)
		  println(Person.canFly )
		  
		  val mery = Person
		  val john = Person
		  println( mery == john) //mery and john point to the same instance

		*object extends App is similar to
		  def main(args: Array[String]): Unit
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

2.5 Inheritance
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	Inheritance is an important pillar of OOP(Object Oriented Programming). 
		It is the mechanism in Scala by which one class is allowed to inherit the features(fields and methods) of another class. 
		
		can refer here https://www.geeksforgeeks.org/inheritance-in-scala/
		
		  class Animal {
			def eat = println("nomnom")
		  }
		  
		  class Cat extends Animal
		  val cat = new Cat
		  cat.eat

>>	super [is used when you wan to reference a method or field from the parent class]		
>>	can prevent the override by using final or seal the class [using sealed keyword]
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

2.6 Inheritance, Continued: Abstract Classes and Traits
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
>>	Fields are methods that are unimplemented are called abstract
		are defined by the keyword abstract
		abstract classes can't be instantiated
		
		  abstract class Animal {
			val creatureType: String
			def eat: Unit
		  }

		  class Dog extends Animal {
			override val creatureType: String = "k9"
			override def eat: Unit = println("crunch crunch")
		  }

>>	Traits are used to share interfaces and fields between classes. They are similar to Java 8’s interfaces. 
		Classes and objects can extend traits, but traits cannot be instantiated and therefore have no parameters.

			trait Iterator[A]:
			  def hasNext: Boolean
			  def next(): A

			class IntIterator(to: Int) extends Iterator[Int]:
			  private var current = 0
			  override def hasNext: Boolean = current < to
			  override def next(): Int =
				if hasNext then
				  val t = current
				  current += 1
				  t
				else
				  0
			end IntIterator

			val iterator = new IntIterator(10)
			iterator.next()  // returns 0
			iterator.next()
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

2.7 Generics
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	Generic classes are classes which take a type as a parameter. They are particularly useful for collection classes.
		* Defined as
	
			class MyList[A]
			
			 class MyList[A] {
					//can use the type A inside the class definition
			}
				  class MyMap [key, Value ]
				  val listOfIntegers = new MyList[Int]
				  val listOfStrings = new MyList[String]
				  //generic methods
				  object MyList {
					def empty[A]: MyList[A] = ???
				  }
				  val emptyListOfInteger = MyList.empty[Int]

>>	  //variance problem

		  class Animal
		  class Cat extends Animal
		  class Dog extends Animal

		  //1. Yes List[Cat] extends List[Animals] = COVARIANCE ----- [+A]

		  class CovariantList[+A]
		  val animal: Animal = new Cat
		  val animalList: CovariantList[Animal] = new CovariantList[Cat]

		  //animalList.add(new Dog) ? HARD QUESTION

		  //2. No List[Cat] extends List[Animals] = INVARIANCE ----- [A]
		  class InVariantList[A]
		  val inVariantAnimalList: InVariantList[Animal] = new InVariantList[Animal]

		  //3. NOOO! List[Cat] extends List[Animals] = CONTRAVARIANCE ----- [-A]
		  class ContraVariantList[-A]
		  val contraVariantAnimalList = contraVariantAnimalList[Cat] = new ContraVariantList[Animal]

>>	Bounded type
		* There may be times when you want to restrict the types that can be used as type arguments in a parameterized type. For example, 
		* a method that operates on numbers might only want to accept instances of Numbers or their subclasses. 
		* This is what bounded type parameters are for
		
		  //bounded type [upper bound "<", Lower bound ">"]
		  class Cage[A <: Animal] (animal: A)
		  val cage = new Cage(new Dog)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

2.8 Anonymous class
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	Anonymous class is an inner class without a name, which means that we can declare and instantiate class at the same time.

		  abstract class Animal{
			def eat: Unit
		  }

		  class AnonymousClasses$$anon$1 extends Animal {
			override def eat: Unit = println("ahahahahahah")
		  }

		  //anonymous class
		  val funnyAnimal: Animal = new AnonymousClasses$$anon$1

		  println(funnyAnimal.getClass)
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

2.9 Object-Oriented Exercises: Expanding Our Collection
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	Exercises:
		1.  Generic trait MyPredicate[-T] with a little method test(T) => Boolean
		2.  Generic trait MyTransformer[-A, B] with a method transform(A) => B
		3.  MyList:
			- map(transformer) => MyList
			- filter(predicate) => MyList
			- flatMap(transformer from A to MyList[B]) => MyList[B]
			class EvenPredicate extends MyPredicate[Int]
			class StringToIntTransformer extends MyTransformer[String, Int]
			[1,2,3].map(n * 2) = [2,4,6]
			[1,2,3,4].filter(n % 2) = [2,4]
			[1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]

>>	Solution

		abstract class MyList[+A]{
			  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty

			  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

			  def filter(predicate: Mypredicate[Nothing]): MyList[Nothing] = Empty

			  def ++[B >: Nothing] (list: MyList[B]): MyList[B] = list
		}
		
		trait Mypredicate[-T] {
		  def test(elem: T): Boolean
		}

		trait MyTransformer[-A, B]  {
		  def transformer(elem: A): B
		}

		object Empty extends MyList[Nothing] {
		  //Exercises:
		  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
		  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
		  def filter(predicate: Mypredicate[Nothing]): MyList[Nothing] = Empty
		  def ++[B >: Nothing] (list: MyList[B]): MyList[B] = list
		}

		class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
		  //Exercises:
		  def filter(predicate: Mypredicate[A]): MyList[A] =
			if (predicate.test(h)) new Cons(h, t.filter(predicate))
			else t.filter(predicate)
		  def map[B](transformer: MyTransformer[A, B]): MyList[B] =
			new Cons(transformer.transformer(h), t.map(transformer))
		  def flatMap[B] (transformer: MyTransformer[A, MyList[B]]): MyList[B] =
			transformer.transformer(h) ++ t.flatMap(transformer)
		  def ++[B >: A] (list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
		}


		object ListTest extends App {
		  //Exercises:
		  //[1,2,3].map(n * 2) = [2,4,6]
		  println(listOfInterger.map(new MyTransformer[Int, Int] {
			override def transformer(elem: Int): Int = elem * 2
		  }).toString)
		  //[1,2,3,4].filter(n % 2) = [2,4]
		  println(listOfInterger.filter(new Mypredicate[Int] {
			override def test(elem: Int): Boolean = elem % 2 == 0
		  }).toString)
		  //[1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
		  println(listOfInterger ++ anotherListOfInterger).toString
		  println(listOfInterger.flatMap(new MyTransformer[Int, MyList[Int]] {
			override def transformer(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem +1, Empty))
		  }).toString)

		}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

2.10 Case Classes 
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	Scala case classes are just regular classes which are immutable by default and decomposable through pattern matching. 
		It uses equal method to compare instance structurally. 
		It does not use new keyword to instantiate object. All the parameters listed in the case class are public and immutable by default.

	   /*
	  equals, hashCode, toString
	   */

	   case class Person (name: String, age: Int)

>>	1. class parameters are fields
		  val jim = new Person("Jim", 34)
		  println(jim.name)

>>	2. sensible to string
		  // we doesn't even need to specify .tostring because println(instance) = (instance.toString)
		  println(jim.toString)

>>	3. equals and hashCode implemented out of the box
		  val jim2= new Person("Jim", 34)
		  println(jim == jim2)

>>	4. case classes have handy copy method
		  val jim3 = jim.copy(age = 45)
		  println(jim3)

>>	5. case class have a companion objects
		  //we don't use a keyword new when instantiating a case class
		  val thePerson = Person
		  val mary = Person("Mary", 23)

>>	6. case classes are serializable
>>	7. case classes have extractor patterns [used for PATTERN MATCHING]
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

2.11 Scala 3: Enums
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	An enumeration refers to a group of named constants. 

>>	An enumeration is used to define a type consisting of a set of named values.

		enum Color:
		  case Red, Green, Blue
		  
>>	This defines a new sealed class, Color, with three values, Color.Red, Color.Green, Color.Blue. The color values are members of Colors companion object.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

2.12 Exceptions
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	1. trowing and exceptions
			val x: String = null
			println(x.length)
			val aWeirdValue: String = throw new NullPointerException

	  * throwable classes extends the throwable class.
	  * Exception and Error are the major Throwable subtypes

>>	2. catching the exceptions
			 def getInt(withExceptions: Boolean): Int =
			   if (withExceptions) throw new RuntimeException("No int for you")
			   else 42

			 try {
			   //code that might throw
			   getInt(true)
			 }catch {
			   case e: RuntimeException => println("caught a runtime exception")
			 }finally {
			   //code that will execute NO MATTER WHAT
			   //finally is optional, does not influence the return type of this expression
			   //use finally only for side effects
			   println("finally")
			 }
			 
>>	3. how to define your own exceptions
				class MyException extends  Exception
				val exception = new MyException
				throw exception

>>	Exercises:
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
						
>>	 Solution

			1.
					  val array = Array.ofDim(Int.MaxValue)

			2.
					def infinite: Int = 1 + infinite
					val noLimit = infinite

			3.
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
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

2.13 Packaging and Imports
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	Package is a bunch of different definitions grouped under same name
>>	packages are not expressions

>>	Package members are accessible by their simple name
			val writer = new Writer("Vivek", "Gowda", 1998)

>>	If you are not in the same package structure import the package OR you can mention the fully qualified names

>>	Package objects can contain arbitrary definitions, not just variable and method definitions. For instance,
		they are frequently used to hold package-wide type aliases and implicit conversions.
		Package objects can even inherit Scala classes and traits.

>>	to create package object right click on package and select package object
		only one package object can be created per package

			sayHello
			println(SPEED_OF_LIGHT)
			
			import java.util.Date
			import java.sql.Date
			
			val date = new Date
			val sqlDate = new java.sql.Date(1988,2,28)
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

FUNCTIONAL PROGRAMMING IN SCALA

3.1 What's a Function, Really?
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	To use functions as first class elements

>>	In java to define function we used to create function like class

			trait MyFunction[A, B]{
			  def apply(element: A): B
			}

			val doubler = new MyFunction[Int, Int]{
				override def apply(element: Int): Int = element * 2
			}
			println(doubler(2)) //doubler acts like a function

>>	function types = Function1[A, B] can call unto 22 functions

			val stringToIntConverter = new Function1[String, Int]{
				override def apply(string: String): Int = string.toInt
			}
			println(stringToIntConverter("3") + 4)

>>	ALL SCALA FUNCTIONS ARE OBJECTS

>>	=> is the "function arrow". It is used both in function type signatures as well as anonymous function terms.

>>	Exercises:
					1.  a function which takes 2 strings and concatenates them
					2.  transform the MyPredicate and MyTransformer into function types
					3.  define a function which takes an int and returns another function which takes an int and returns an int
							- what's the type of this function
							- how to do it
	
>>	Solutions
					1.
						def concatenator: (String, String) => String = new Function2[String, String, String] {
							override def apply(v1: String, v2: String): String = v1 + v2
						}
						println(concatenator("hello", "Scala"))
					
					2. Sloved in MyList file
					
					3. 
						val supperAdder: Function1[Int, Function1[Int, Int]] = new Function[Int, Function1[Int, Int]] {
							override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
								override def apply(y: Int): Int = x + y
						}
						}
						val adder3 = supperAdder(3)
						println(adder3(4))
						println(supperAdder(3)(4))  //curried function		
						
>>	Syntactic Sugar is syntax within a programming language that is designed to make things easier to read or to express.
		we use more Syntactic Sugar 
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

3.2	Anonymous Functions
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	An anonymous function is also known as a literal function. A function that does not contain a name is known as an anonymous function. 
		An anonymous function provides a lightweight function definition. It is useful when we want to create an inline function.

>>	Anonymous function (LAMBDA)
			val doubler = (x: Int) => x * 2 //Or val doubler: Int => Int = (x: Int) => x * 2

>>	multiple parms in lambda
			val adder= (a:Int, b: Int) => a + b //Or  val adder: (Int, Int) => Int (a:Int, b: Int) => a + b

>>	no parms
			val justDoSomething = () => 3 //Or val justDoSomething: () => Int = () => 3
			println(justDoSomething) //function itself
			println(justDoSomething())  //call

>>	curly braces with lambdas
			val stringToInt = {(str: String) =>
			str.toInt
			}

>>	MOR syntactic sugar
			val niceIncrementer: Int => Int = _ + 1 //equivalent to x => x + 1
			val niceAdder: (Int, Int) => Int = _ + _ //equivalent to (a,b) => a + b
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

3.3	Higher-Order-Functions and Curries
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	Higher order functions take other functions as parameters or return a function as a result. 
		This is possible because functions are first-class values in Scala.

>>	Also refer https://docs.scala-lang.org/tour/higher-order-functions.html

>>	A function that takes function as parameters and returns function as results is called HOF
		example of HOF are map, flatmap, filters

			val superFunction: (Int, (String, (Int => Boolean)) => Int => (Int => Int)) = null

		* simpler example of HOF
		* unction that applies a function n times over a value x
			// nTimes(f, n, x)
			// nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x)) = f(f(f(x)))
			// nTimes(f, n, x) = f(f(...f(x))) = nTimes(f, n-1, f(x))

			def nTimes(f: Int => Int, n: Int, x: Int): Int =
				if(n <= 0) x
				else nTimes(f, n-1, f(x))

			val plusOne = (x: Int) => x + 1
			println(nTimes(plusOne, 10, 1))

			// ntb(f,n) = x => f(f(f...(x)))
			// increment10 = ntb(plusOne, 10) = x => plusOne(plusOne....(x))
			// val y = increment10(1)
			def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
				if (n <= 0) (x: Int) => x
				else (x: Int) => nTimesBetter(f, n - 1)(f(x))

			val plus10 = nTimesBetter(plusOne, 100000)
			println(plus10(1))
			
>>	 curried functions which takes multiple parmetes list

		val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
		val add3 = superAdder(3) // y => 3 + y
		println(add3(10))
		println(superAdder(3)(10))

>>	functions with multiple parameter lists example
		def curriedFormatter(c: String)(x: Double): String = c.format(x)

		val standardFormat: (Double => String) = curriedFormatter("%4.2f")
		val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

		println(standardFormat(Math.PI))
		println(preciseFormat(Math.PI))	
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

3.4	Map, flatMap, filter and for-comprehensions
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	The List type is a linear, immutable sequence. This just means that it’s a linked-list that you can’t modify. 
		Any time you want to add or remove List elements, you create a new List from an existing List.

>>	REFER https://www.scala-lang.org/api/current/scala/collection/immutable/List.html

>>	.map
		When map is applied on some collection of type A, it returns a new collection of the same type with elements of type B.

			val list = List(1,2,3) // this is calling apply method on companion object
			println(list)
			// map
			println(list.map(_ + 1)) // returns List (same type) of type Int
			println(list.map(_ + " is a number")) // returns List (same type) of type String

>>	.filter
		Takes a lambda that takes one param and returns boolean. Values are filtered when boolean is true.

			println(list.filter(_ % 2 == 0)) // prints 2

>>	.flatMap
		flatten (reduces) the hierarchy by one level each time it is applied

			val toPair = (x: Int) => List(x, x+1)
			println(list.flatMap(toPair))
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

3.5	Sequences: List, Array, Vector
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	Sequence
			val aSequence = Seq(1, 3, 2, 4)
			println(aSequence)
			println(aSequence.reverse)
			println(aSequence(2))
			println(aSequence ++ Seq(7, 5, 6))
			println(aSequence.sorted)

>>	Ranges
			val aRange: Seq[Int] = 1 until 10 //1 to 10 also works
			aRange.foreach(println)

			(1 to 10).foreach(x => println("Hello"))

>>	lists
			val aList = List(1, 2, 3)
			val prepended = 42 +: aList :+ 89 // to prepend we can use :: or +: operators  // :+ to append
			println(prepended)

			val apples5 = List.fill(5)("apple")
			println(apples5)
			println(aList.mkString("-|-"))

>>	arrays
			val numbers = Array(1, 2, 3, 4)
			val threeElements = Array.ofDim[String](3)
			threeElements.foreach(println)

>>	mutation
		numbers(2) = 0 // syntax sugar for numbers.update(2, 0)
		println(numbers.mkString(" "))
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

3.6	Tuples and Maps
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	A tuple is a sequence of values:
>>	A cool feature is a compound assignment that extracts the components of a tuple and assigns them to variables or constants:

>>	tuples are finite ordered "lists"
>>	Tuple2[Int, String] = (Int, String)
>>	tuples grouped upto 22

			val aTuple = (2, "hello Scala")
			println(aTuple._1) // 2
			println(aTuple.copy(_2 = "goodbye Java"))
			println(aTuple.swap) // ("hello, Scala", 2)

>>	A map is a collection of key-value pairs, usually implemented as a tree or hash table.
>>	By default, maps are immutable. This means that once created, pairs can't be added, removed, or modified:

			// Maps - keys -> values
			val aMap: Map[String, Int] = Map()

			val phonebook = Map(("Jim", 555), "Daniel" -> 789, ("JIM", 9000)).withDefaultValue(-1)
			// a -> b is sugar for (a, b)
			println(phonebook)
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

3.7	Options 
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	Special types of collections

>>	An options is a wrapper for a value that might be present or not

>>	Scala Option[ T ] is a container for zero or one element of a given type. An Option[T] can be either Some[T] or None object, which represents a missing value.

>>	Represents optional values. Instances of Option are either an instance of scala.Some or the object None.

>>	The most idiomatic way to use an scala.Option instance is to treat it as a collection or monad and use map,flatMap, filter, or foreach:

			val name: Option[String] = request getParameter "name"
			val upper = name map { _.trim } filter { _.length != 0 } map { _.toUpperCase }
			println(upper getOrElse "")
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

3.7	Handling Failure 
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	  // create success and failure
			val aSuccess = Success(3)
			val aFailure = Failure(new RuntimeException("SUPER FAILURE"))

			println(aSuccess)
			println(aFailure)

			def unsafeMethod(): String = throw new RuntimeException("NO STRING FOR YOU BUSTER")

>>	Try objects via the apply method
			val potentialFailure = Try(unsafeMethod())
			println(potentialFailure)
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

PATTERN MATCHING

4.1 Pattern Matching
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

>>	Pattern matching is a mechanism for checking a value against a pattern. 
		A successful match can also deconstruct a value into its constituent parts. 
		It is a more powerful version of the switch statement in Java and it can likewise be used in place of a series of if/else statements.
			
			import scala.util.Random
			val x: Int = Random.nextInt(10)

			x match
				case 0 => "zero"
				case 1 => "one"
				case 2 => "two"
				case _ => "other"

>>	  Decompose values

			  case class Person(name: String, age: Int)
			  val bob = Person("Bob", 25)

			  val greeting = bob match {
				case Person(n, a) if a < 21 => s"Hi, my name is $n and I can't drink in the US"
				case Person(n, a) => s"Hi, my name is $n and I am $a years old"
				case _ => "I don't know who I am"
			  }
			  println(greeting)



















