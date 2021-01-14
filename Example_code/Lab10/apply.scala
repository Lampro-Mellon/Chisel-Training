// Illustration of built-in apply functions for different types of collections
val uList = List (11 , 22 , 33 , 44 , 55)
val uSet = Set (11 , 22 , 33 , 44 , 55)
val uMap = Map (1 -> 'a', 2 -> 'b', 3 -> 'c', 4 -> 'd')

println (s" Apply method for the List with .apply = ${uList.apply (1)}")
// Similarly we can call the apply method without the use of .apply
println (s" Apply method for the List without .apply = ${uList(1)}")

println (s" Apply method for the Set with .apply = ${uSet.apply(22)}")
// Similarly we can call the apply method without the use of .apply
println (s" Apply method for the Set without .apply = ${uSet(22)}")

println (s" Apply method for Map with .apply = ${uMap.apply(2)}")
// Similarly we can call the apply method without the use of .apply
println (s" Apply method for Map without .apply = ${uMap(2)}")
