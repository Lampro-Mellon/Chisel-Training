// BitPat example
// define partial opcodes for RISC V instructions 
def opCode_BEQ = BitPat("b000?????1100011")
def opCode_BLT = BitPat("b100?????1100011")

// opcode matching with don't care bits
when(opCode_BEQ === "b000110001100011".U){ 
// above comparison evaluates to true.B
// user code 
}