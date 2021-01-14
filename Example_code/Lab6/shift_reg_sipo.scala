// shift register (serial in and parallel out)
val shiftReg = RegInit(0.U(n.W))

// shift register implementation
shiftReg := Cat(data_in , shiftReg (n-1, 1))
val Q = shiftReg 
