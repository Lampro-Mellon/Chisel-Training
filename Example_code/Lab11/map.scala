// An example list
val uList = List(1, 2, 3, 4, 5)

// map method applied to List
val uList_Twice = uList.map( x => x*2 )
println(s"List elements doubled = $uList_Twice")

// Applying map to List using user defined method  
def f(x: Int) = if (x > 2) x*x else None
val uList_Squared = uList.map(x => f(x))
println(s"List elements squared selectively = $uList_Squared")

// The output at the terminal is given below
List elements doubled = List(2, 4, 6, 8, 10)
List elements squared selectively = List(None, None, 9, 16, 25)