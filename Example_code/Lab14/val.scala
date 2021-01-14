// val evaluation illustration 
object valApp extends App{
  val x = { println("x is initialized,"); 99 }
  println("before we access 'x'")
  println(x + 1)
} 

// Output at the terminal
x is initialized,
before we access 'x'
100