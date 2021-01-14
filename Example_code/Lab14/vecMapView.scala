val uVec = Vector(1 to 10: _*) 

// view method and resulting view collection
val uVecView = uVec.view
val iView = uVecView map (_ + 1) map (_ * 2) filter (_ > 0)
val uVecMapped = iView.force

println(iView)
println(uVecMapped)

// Output at the terminal 
SeqViewMMF(...)
Vector(4, 6, 8, 10, 12, 14, 16, 18, 20, 22)