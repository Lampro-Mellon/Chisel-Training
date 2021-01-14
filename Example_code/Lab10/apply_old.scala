// Illustration of the order of reduce method
val uList = List(11, 22, 33, 44, 55)
val uSet = Set(11, 22, 33, 44, 55)
val uMap = Map(1 -> 'a', 2 -> 'b', 3 -> 'c', 4 -> 'd')

val list_apply: Double = uList.apply(1)
println(s"Apply method for the List = $list_apply")

val set_apply = uSet.apply(22)
println(s"Apply method for the Set = $set_apply")

val map_apply = uMap.apply(1)
println(s"Apply method for the Map = $map_apply")

// The output at the terminal
Apply method for the List = 22.0
Apply method for the Set = true
Apply method for the Map = a