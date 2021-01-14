class uStack[A] {
  private var elements: List[A] = Nil
  def push(x: A) { elements = x :: elements }
  def pop(): A = {
    val elementTop = elements.head
    elements = elements.tail
    elementTop
  }
}

val stackObj = new uStack[String]
stackObj.push("Hello")
stackObj.push("Trainee")
println(stackObj.pop) // will print Trainee
println(stackObj.pop) // will print Hello