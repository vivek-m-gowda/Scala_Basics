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
  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B] (transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter (predicate: Mypredicate[A]): MyList[A]

  //concatenation
  def ++[B >: A] (list: MyList[B]): MyList[B]

}

case object Empty extends MyList[Nothing] {

  def head: Nothing = throw new NoSuchElementException()

  def tail: MyList[Nothing] = throw new NoSuchElementException()

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def printElement: String = ""

  //Exercises:
  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

  def filter(predicate: Mypredicate[Nothing]): MyList[Nothing] = Empty

  def ++[B >: Nothing] (list: MyList[B]): MyList[B] = list

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
  def filter(predicate: Mypredicate[A]): MyList[A] =
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer: MyTransformer[A, B]): MyList[B] =
    new Cons(transformer.transformer(h), t.map(transformer))

  def flatMap[B] (transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transformer(h) ++ t.flatMap(transformer)

  def ++[B >: A] (list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
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


trait Mypredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B]  {
  def transformer(elem: A): B
}


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

  println(cloneListOfInterger == listOfInterger)

}