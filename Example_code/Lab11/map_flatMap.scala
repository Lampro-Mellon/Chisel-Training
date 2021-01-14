// An example list
val uList: List[Int] = List(1, 2, 3, 4, 5)

def g(v:Int) = List(v-1, v, v+1)
val uList_Extended = uList.map(x => g(x))
println(s"Extended list using map = $uList_Extended")

val uList_Extended_flatmap = uList.flatMap(x => g(x))
println(s"Extended list using flatMap = $uList_Extended_flatmap")

// The output at the terminal is 
Extended list using map = List(List(0, 1, 2), List(1, 2, 3), List(2, 3, 4), List(3, 4, 5), List(4, 5, 6))

Extended list using flatMap = List(0, 1, 2, 1, 2, 3, 2, 3, 4, 3, 4, 5, 4, 5, 6)