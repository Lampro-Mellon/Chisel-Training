// source collection
val uList = List(1, 5, 7, 8)

// converting every element to a pair of the form (x,1)
val uList_Modified = uList.map(x => (x, 1))

// adding elements at correspnding positions
val result = uList_Modified.fold(0,0)((a, b) => (a._1 + b._1, a._2 + b._2))
val average = (result._1).toFloat / (result._2).toFloat

println("(sum, no_of_elements) = " + result)
println("Average = " + average)

// The result at the terminal
(sum, no_of_elements) = (21,4)
Average = 5.25