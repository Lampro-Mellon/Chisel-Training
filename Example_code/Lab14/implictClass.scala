class StringModifier(s: String) {
  def increment = s.map(c => ((c + 1).toChar).toUpper)
}

val result = (new StringModifier("hal")).increment
println("hal is modified to: " + result)

// The output at the terminal
hal is modified to: IBM



implicit class StringModifier(s: String) {
  def increment = s.map(c => ((c + 1).toChar).toUpper)
}

val result = ("hal").increment
println("hal is modified to: " + result)

// The output at the terminal
HAL is modified to: IBM
