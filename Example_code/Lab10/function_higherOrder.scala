// Define a higher order function
def higherOrder(a: Int, b: Int, c: Int, d: Int, function: (Int, Int) => Int) = {
  val first_inst = function(a, b)
  val second_inst = function(c, d)
  function(first_inst, second_inst)
}

// call to higherOrder function
val result1 = higherOrder(2, 5, 7, 9, (x, y) => x + y)
val result2 = higherOrder(2, 5, 7, 9, _ + _)

println(s"The result1 is = $result1")
println(s"The result2 is same = $result2")

// The output at the terminal
The result1 is = 23
The result2 is same = 23
