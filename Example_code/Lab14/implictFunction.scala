import scala.language.implicitConversions

class Implicit_Function (i : Int) {
  // Explicit conversion to Seq (List) and then increment
  val i_explicit_seq_inc = Seq(i).map { n => n + 1
  }
  
  val i_inc = i + 2

  // Implicit conversion to Seq (List) and then increment
  val i_implicit_seq_inc = i.map(_ + 3)
  
// Implicit function for conversion
  implicit def any_name(i: Int): Seq[Int] = Seq(i) 
}

val convert = new Implicit_Function(5)
println("Explicit conversion and increment: " + convert.i_explicit_seq_inc)
println("Simple increment: " +convert.i_inc)
println("Implicit conversion and increment: " +convert.i_implicit_seq_inc)

// The output at the terminal 
Explicit conversion and increment: List(6)
Simple increment: 7
Implicit conversion and increment: List(8)