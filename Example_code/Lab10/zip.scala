val uList1: List[(Char)] = List('a', 'b', 'c', 'd', 'e')
val uList2: List[(Int)] = List(20, 40, 100)

val uList_Zipped = uList1.zip(uList2)
println(s"The zipped list is: $uList_Zipped")

val uList_unZipped = uList_Zipped.unzip 
println(s"The unzipped list is: $uList_unZipped")

val uList_indexZip = uList1.zipWithIndex 
println(s"The list zipped with its index: $uList_indexZip")

// The output at the terminal 
The zipped list is: List((a,20), (b,40), (c,100))
The unzipped list is: (List(a, b, c),List(20, 40, 100))
The list zipped with its index: List((a,0), (b,1), (c,2), (d,3), (e,4))