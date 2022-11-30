package lectures.part3fp

object WhatsAFunction extends  App {

  //To use functions as first class elements

  val doubler = new MyFunction[Int, Int]{
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2))

}
//In java to define function we used to create fnction like class
trait MyFunction[A, B]{
  def apply(element: A): B
}