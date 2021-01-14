// Map of timer registers
val timer_regs_map = Map("cntReg" -> 10001014, "cmpReg" -> 10001018, "contReg" -> 10001010)

// Map of uart registers
val uart_regs_map = Map("txReg" -> 10001000, "rxReg" -> 10001004, "contReg" -> 10001008)

println("Timer Regs: " + timer_regs_map)
println("Uart Regs: " + uart_regs_map)

// concatenating two maps using ++ operator
val combined_regs = (uart_regs_map ++ timer_regs_map)

combined_regs.keys.foreach{i => print( "Reg Name = " + i )
                       println(" Address = " + combined_regs(i))}

// The output at the terminal
Timer Regs: Map(cntReg -> 10001000, cmpReg -> 10001004, contReg -> 10001010)

Uart Regs: Map(txReg -> 10001000, rxReg -> 10001004, contReg -> 10001008)

Reg Name = contReg Address = 10001010
Reg Name = rxReg Address = 10001004
Reg Name = txReg Address = 10001000
Reg Name = cmpReg Address = 10001018
Reg Name = cntReg Address = 10001014