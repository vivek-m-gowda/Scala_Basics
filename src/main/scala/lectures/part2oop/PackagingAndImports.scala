package lectures.part2oop

import java.sql
import java.util.Date
import java.sql.Date

object PackagingAndImports extends App{

  //Package is a bunch of different definitions grouped under same name
  //packages are not expressions

  //Package members are accessible by their simple name
  val writer = new Writer("Vivek", "Gowda", 1998)

  //If you are not in the same package structure import the package OR you can mention the fully qualified names


  // package object
  // Package objects can contain arbitrary definitions,
  // not just variable and method definitions. For instance,
  // they are frequently used to hold package-wide type aliases and implicit conversions.
  // Package objects can even inherit Scala classes and traits.

  //to create package object right click on package and select package object
  // only one package object can be created per package

  sayHello
  println(SPEED_OF_LIGHT)

  //

//  val date = new Date
//  val sqlDate = new java.sql.Date(1988,2,28)








}



