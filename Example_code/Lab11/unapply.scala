class uModule(val name: String, val bitWidth: Int)

// companion object
object uModule {
  def apply(name: String, bitWidth: Int): uModule = new uModule(name, bitWidth)
  
  def unapply(mod: uModule): Option[(String, Int)] = {
    if (mod.bitWidth == 0) None
    else Some((mod.name, mod.bitWidth))
  }
}

// Using the apply method
val objA = uModule("ALU", 32)
// Extractor using unapply method
val uModule(module_name, module_bitW) = objA 
println("Module name is: " + module_name)

// output at the terminal is
Module name is: ALU