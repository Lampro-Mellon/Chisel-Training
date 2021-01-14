// An example List
val uList = List(11, -10, 5, 0, -5, 10)

// Applying .filter to List 
val uList_filter1 = uList.filter(x => x > -1)
println(s"Filtered list = $uList_filter1")
 
// Applying .filter to List using _ 
val uList_filter2 = uList.filter(_ > -1)
println(s"Filtered list using _ as place holder = $uList_filter2")

// The output at the terminal
Filtered list = List(11, 5, 0, 10)
Filtered list using _ as place holder = List(11, 5, 0, 10)