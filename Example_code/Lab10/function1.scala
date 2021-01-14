// assigning a function to val
val f_max = scala.math.max _
val f_abs = scala.math.abs _

// calling the function
val max_value = f_max(1, 5)
val abs_value = f_abs(-123)

println(s"The maximum value is = $max_value")
println(s"The absolute value is = $abs_value")

// The output at the terminal
The maximum value is = 5
The absolute value is = 123