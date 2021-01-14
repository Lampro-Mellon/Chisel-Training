// Illustration of reduce method for Lists
val uList = List(1, 2, 3, 4, 5)

val uSum_Explicit = uList.reduce((a, b) => a + b)
println(s"Sum of elements using reduce function explicitly= $uSum_Explicit")

val uSum: Double = uList.reduce(_ + _)
println(s"Sum of elements using reduce function with wildcard = $uSum")

// The output at the terminal is given below
Sum of elements using reduce function explicitly = 15 
Sum of elements using reduce function with wildcard = 15.0 
