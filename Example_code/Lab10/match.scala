def ALU_Scala(a: Int, b: Int, op: Int): Int = {
  op match {
    case 1 => a + b
    case 2 => a - b
    case 3 => a & b
    case 4 => a | b
    case 5 => a ^ b
    case _ => -999   // This should not happen
  }
}

var result = ALU_Scala(18,11,2)
println(s"The result is: $result")

result = ALU_Scala(12,17,9)
println(s"The result is: $result")

// The output at the terminal
The result is: 7
The result is: -999