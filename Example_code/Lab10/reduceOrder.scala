// Illustration of the order of reduce method
val uList = List(1, 2, 3, 4, 5)

val uSum: Double = uList.reduce(_ - _)
println(s"Difference of elements using reduce function = $uSum")

val uSum_Explicit = uList.reduceLeft(_ - _)
println(s"Difference of elements using reduceLeft = $uSum_Explicit")

val uSum_Explicit1 = uList.reduceRight(_ - _)
println(s"Difference of elements using reduceRight = $uSum_Explicit1")

// The output at the terminal 
Difference of elements using reduce function = -13.0
Difference of elements using reduceLeft function = -13
Difference of elements using reduceRight function = 3