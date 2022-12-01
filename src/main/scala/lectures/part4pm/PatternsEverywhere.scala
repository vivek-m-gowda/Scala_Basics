package lectures.part4pm

object PatternsEverywhere extends App {

  //big idea
  try{
    //code
  }catch{
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "nullPointerException"
    case _ => "something else"
  }
  //catches are actually matches

  //big idea #2
  val list = List(1,2,3,4)
  val evenOnes = for{
    x <- list if x % 2 == 0
  } yield 10 *x

  //generators are also based on PATTERN MATCHING
  val tuples = List((1,2), (3,4))
  val filterTuples = for{
    (first, second) <- tuples
  } yield first * second

  //big idea 3
  val tuple = (1,2,3)
  val (a, b, c) = tuple
  println(b)

  //multiple values definitions based on PATTREN MATCHING

  val head :: tail = list
  println(head)
  println(tail)


  //big idea 4
  val mappedList = list.map{ x => x match {

    case v if v % 2 == 0 => v + "is even"
    case 1 => "the one"
    case _ => "something else"
    }
  }
  println(mappedList)


}
