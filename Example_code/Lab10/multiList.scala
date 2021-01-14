val uList1: List[(Int)] = List(3, 2)
val uList2: List[(Int)] = List(20, 40, 100)

// Processing multiple lists
val resultProduct = (uList1, uList2).zipped.map(_ * _)
val resultCount = (uList1, uList2).zipped.max

println(s"The product of two lists: $resultProduct")
println(s"The max element: $resultCount")

// The output at the terminal 
The product of two lists: List(60, 80)
The max element: (3,20)