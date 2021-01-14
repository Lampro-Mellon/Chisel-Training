// An example list 
val uList: List[Int] = List(1, 2, 3, 4, 5)

// Applying map and flatMap to List with builtin Options class
def f(x: Int) = if (x > 2) Some(x) else None
val uList_selective = uList.map(x => f(x))
println(s"Selective elements of List with .map = $uList_selective")

val uList_selective_flatMap = uList.flatMap(x => f(x))
println(s"Selective elements of List with .flatMap = $uList_selective_flatMap")

// Output at the terminal
Selective elements of List using .map = List(None, None, Some(3), Some(4), Some(5))
Selective elements of List using .flatMap = List(3, 4, 5)