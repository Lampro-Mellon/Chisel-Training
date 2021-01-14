//The i in "iSet1" shows that it is immutable
val iSet1 : Set[Int] = Set(1, 2, 3, 4, 5)
val iSet2 : Set[Int] = Set(4, 5, 6, 7, 8)
println(s"Union of both Sets are =${iSet1.++(iSet2)}")
// Union of the two Sets = Set(5, 1, 6, 2, 7, 3, 8, 4)
println(s"Intersection of both Sets are =${iSet1.&(iSet2)}")
// Intersection of the two Sets = Set(5, 4)