case class uModule(name: String, bitWidth: Int)

// pattern matching using unapply method of case class
def matchObject(obj: uModule) = {
  val result = obj match {
    case uModule(name, 32) => println("Module name is: " + name)
    case uModule(name, 16) => println("Module name is: " + name)
    case _                => println(None)
  }
}
// instantiate different modules
val objA = uModule("ALU", 32)
val objI = uModule("Imm", 32)
val objB = uModule("Branch", 16)
val objM = uModule("Mul", 64)

matchObject(objI)

// output at the terminal 
Module name is: Imm