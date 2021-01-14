// An example set of type integer 
val set1 : Set[Int] = Set(2,4,5)

// A second example set of integer type
val set2 : Set[Int] = Set(1,3,3,5,5,7)

// Union of sets with ++ as operator
var set_union1 = set1 ++ set2

// Union of sets with ++ as method
var set_union2 = set1.++(set2)

// Intersection of sets with & as method
var set_intersect1 = set1.&(set2)

println(set1)             // Set(2, 4, 5)
println(set2)             // Set(1, 3, 5, 7)
println(set2.head)        // 1
println(set2.tail)        // Set(3, 5, 7)
println(set1.isEmpty)     // false
println(set_union1)       // Set(5, 1, 2, 7, 3, 4)
println(set_union2)       // Set(5, 1, 2, 7, 3, 4)
println(set_intersect1)   // Set(5)