val f: Float = 34.6F;
val c: Char = 'c';

val ccast = c.asInstanceOf[Int];
val fcast = f.asInstanceOf[Int];

display("Char ", c);
display("Char to Int ", ccast);

display("Float ", f);
display("Float to Int ", fcast);

def display[A](y: String, x: A): Unit = {
  println(
    y + " = " + x + " is of type " +
      x.getClass
  );
}