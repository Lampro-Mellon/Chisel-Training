// lazy val illustration 
object lazyvalApp extends App{
  lazy val x = { println("x is NOT initialized."); 99 }
  println("Unless we access 'x',")
  println(x + 1)
  println(x + 2)
}

// Output at the terminal
Unless we access 'x',
x is NOT initialized.
100
101