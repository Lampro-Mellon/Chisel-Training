// Illustration of the order of fold method
val uList = List(1, 2, 3, 4, 5)

val uSum_fold = uList.fold(0)(_ - _)
println(s"Elements difference using fold method = $uSum_fold")

val uSum_foldLeft = uList.foldLeft(0)(_ - _)
println(s"Elements difference using foldLeft method = $uSum_foldLeft")

val uSum_foldRight = uList.foldRight(0)(_ - _)
println(s"Elements difference using foldRight method = $uSum_foldRight")

// The output at the terminal 
Elements difference using fold method = -15
Elements difference using foldLeft method = -15
Elements difference using foldRight method = 3