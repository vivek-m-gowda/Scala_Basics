package exercieses

abstract class MyList[+A] {

  /*
     head = first element of  the  list
     tail = remainder of the list
     isEmpty = is this list empty
     add(int) => new list with this element added
     toString => a string representation of the list
   */

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElement: String

  override def toString: String = "[" + printElement + "]"

  //Exercises

  // Higher order functions
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B] (transformer: A => MyList[B]): MyList[B]
  def filter (predicate: A => Boolean): MyList[A]

  //concatenation
  def ++[B >: A] (list: MyList[B]): MyList[B]

  //for each method
  // [hof]
  def forEach(f: A => Unit): Unit
  def sort(compare: (A, A) => Int ): MyList[A]
  def zipWith[B, C](list: MyList[B], zip:(A, B) => C): MyList[C]
  def fold[B](start: B)(operator: (B, A) => B): B

}

case object Empty extends MyList[Nothing] {

  def head: Nothing = throw new NoSuchElementException()

  def tail: MyList[Nothing] = throw new NoSuchElementException()

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def printElement: String = ""

  //Exercises:
  def map[B](transformer: Nothing => B): MyList[B] = Empty

  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing] (list: MyList[B]): MyList[B] = list

  // [hofs]

  def forEach(f: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing) => Int )  = Empty
  def zipWith[B, C](list: MyList[B], zip:(Nothing, B) => C): MyList[C] =
    if(!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Empty
  def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  def printElement: String = {
    if (t.isEmpty) "" + h
    //else h + " " + t.printElement
    else s"$h  ${t.printElement}"
  }

  //Exercises:
  def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))

  def flatMap[B] (transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  def ++[B >: A] (list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  // [hofs]

  def forEach(f: A => Unit): Unit = {
    f(h)
    t.forEach(f)
  }

  def sort(compare: (A, A) => Int ): MyList[A] ={
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if(sortedList.isEmpty) new Cons(x, Empty)
      else if(compare( x, sortedList.head) < 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTial = t.sort(compare)
    insert(h, sortedTial)
  }

  def zipWith[B, C](list: MyList[B], zip:(A, B) => C): MyList[C] =
    if(list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))

  def fold[B](start: B)(operator: (B, A) => B): B = {
    t.fold(operator(start, h))(operator)

  }

}

/*
    Exercises:
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
   */





object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)

  println(list.toString)

  val listOfInterger: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  val anotherListOfInterger: MyList[Int] = new Cons(4, new Cons(5, Empty))
  val cloneListOfInterger: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))
  println(listOfInterger.toString)
  println(listOfStrings.toString)


  //Exercises:
  //[1,2,3].map(n * 2) = [2,4,6]
  println(listOfInterger.map(elem => elem * 2).toString)

  //[1,2,3,4].filter(n % 2) = [2,4]
  println(listOfInterger.filter(elem => elem % 2 == 0).toString)

  //[1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
  println(listOfInterger ++ anotherListOfInterger).toString

  println(listOfInterger.flatMap( elem => new Cons(elem, new Cons(elem +1, Empty))).toString)

  println(cloneListOfInterger == listOfInterger)

  // [hofs]

  listOfInterger.forEach(x => println(x))

  println(listOfInterger.sort((x,y) => y-x))

  println(anotherListOfInterger.zipWith[String, String](listOfStrings, _ + "-" + _))

  println(listOfInterger.fold(0)(_ + _))

  //map,flatmap,filters
  //for comprehensions

  val combinations = for {
    n <- listOfInterger
    string <- listOfStrings
  } yield n+"-"+ string
  println(combinations)
}