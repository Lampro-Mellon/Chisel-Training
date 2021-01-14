val uVec = Vector(1 to 10: _*) 

// variant of expression uVec.map(_ + 1).map(_ * 2) 
val uVecMapped = uVec map(_ + 1) map (_ * 2)  // syntactic sugar

println(uVec)
println(uVecMapped)

// Output at the terminal 
Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
Vector(4, 6, 8, 10, 12, 14, 16, 18, 20, 22)