// List of Strings
val modules: List[String] = List("ALU", "Branch", "Control")
val peripherals = List("Uart", "Timer")

// List of Integers
val nums: List[Int] = List(1, 2, 3, 3, 4)

// split the list apart
val List(b, c, d) = modules
val a :: rest = modules

// concatenate two lists (using ::: or List.:::() or List.concat() )
val combined_list = modules ::: peripherals
println(rest)           // List(Branch, Control)
println(nums)           // List(1, 2, 3, 3, 4)
println(combined_list)  // List(ALU, Branch, Control, Uart, Timer)

// combine two lists of different types
println(modules:::nums)// List(ALU, Branch, Control, 1, 2, 3, 3, 4)

