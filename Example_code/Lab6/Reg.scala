// following uses of Reg and RegNext are valid
val reg1 = Reg(UInt(8.W))
val reg2 = RegNext(reg1)      // width is inferred from reg1
val reg3 = RegNext(3.U(8.W))  // width is specified

// following uses are invalid
val reg4 = Reg(3.U(8.W))
val reg5 = RegNext(UInt(8.W))