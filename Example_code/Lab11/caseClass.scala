case class register(addr:Int, init: Int)
  
var c = register(100, 11001100) 
          
 // Display the register
println("Reg Addr: " + c.addr + " Initial value: " + c.init) 

// the output on the terminal
Reg Addr: 100    Initial value: 11001100

// when tried to update the address
c.addr = 15

// the following error is encountered
reassignment to val error



