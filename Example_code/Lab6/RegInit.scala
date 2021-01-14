// following uses of RegInit are valid
val reg1 = RegInit(24.U(8.W))
val reg2 = Reg(UInt(8.W))
val reg3 = RegInit(reg2)

// following uses are invalid
val reg1 = RegInit(0.U(UInt(8.W)))
val reg2 = RegInit(UInt(8.W))