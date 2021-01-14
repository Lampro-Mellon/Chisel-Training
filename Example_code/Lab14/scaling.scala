class LinearMap {
  def multiplyOffset(x: Int) (implicit weight: Int, offset: Float) = 
      (weight * x).toFloat + offset
}

// initial value assignment
implicit val weightage = 3
implicit val offset = 4.0F
val x = 5

val scale = new LinearMap
println("The result with Implicit parameters omitted: " + scale.multiplyOffset(x))
println("The result with Implicit parameters passed explicitly: " + scale.multiplyOffset(x)(weightage, offset))

// output at the terminal is
The result with Implicit parameters omitted: 19.0
The result with Implicit parameters passed explicitly: 19.0