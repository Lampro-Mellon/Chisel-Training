case class register(addr:Int, init: Int)
  
var c = register(100, 11001100) 
var d = c.copy(addr = 104)
          
 // Display the register
println("Reg Addr: " + c.addr + " Initial value: " + c.init) 
println("Reg Addr: " + d.addr + " Initial value: " + d.init)  

// the output on the terminal
Reg Addr: 100    Initial value: 11001100
Reg Addr: 104    Initial value: 11001100


