package lectures.part4pm

object BracelessSyntax extends App{

  // if -expression
  val anIfExpression = if (2>3) "bigger" else "smaller"

  // java style
  val anIfExpression_v2 =
    if (2>3) {
      "bigger"
    } else {
      "smaller"
    }

  //compat
  val anIfExpression_v3 =
    if (2 > 3) "bigger"
    else "smaller"

  //scala 3
//  val anIfExpression_v4 =
//    if 2 > 3 then
//      "bigger"
//    else
//      "smaller"

  //for  comprehensions
  val aForComprehensions = for  {
    n <- List(1,2,3)
    s <- List("black", "white")
  }yield s"$n$s"


  //scala 3 style


}
