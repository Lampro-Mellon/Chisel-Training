val squareRoot: PartialFunction[Double, Double] = { 
    case d: Double if d > 0 => Math.sqrt(d) 
}
val list: List[Double] = List(4, 16, 25, -9)
val result = list.collect(squareRoot)
// OR 
val result = list collect squareRoot

// The output is shown below
result: List[Double] = List(2.0, 4.0, 5.0)

// Doing the same with the map method
val list: List[Double] = List(4, 16, 25, -9)
val result = list.map(Math.sqrt)
result: List[Double] = List(2.0, 4.0, 5.0, NaN)