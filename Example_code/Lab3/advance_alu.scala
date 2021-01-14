import ALUOP._

class ALUIO extends Bundle with Config {
  val in_A      = Input(UInt(WLEN.W))
  val in_B      = Input(UInt(WLEN.W))
  val alu_Op    = Input(UInt(ALUOP_SIG_LEN.W))
  val out       = Output(UInt(WLEN.W))
  val sum       = Output(UInt(WLEN.W))
}

class ALU extends Module with Config {
  val io = IO(new ALUIO)

  val sum    = io.in_A + Mux(io.alu_Op(0), -io.in_B, io.in_B)
  val cmp    = Mux(io.in_A (XLEN-1) === io.in_B(XLEN-1), sum(XLEN-1),
                   Mux(io.alu_Op(1), io.in_B(XLEN-1), io.in_A(XLEN-1)))
  val shamt  = io.in_B(4,0).asUInt
  val shin   = Mux(io.alu_Op(3), io.in_A, Reverse(io.in_A))
  val shiftr = (Cat(io.alu_Op(0) && shin(XLEN-1), shin).asSInt >> shamt)(XLEN-1, 0)
  val shiftl = Reverse(shiftr)

  val out = 
    Mux(io.alu_Op === ALU_ADD.U || io.alu_Op === ALU_SUB.U, sum,
    Mux(io.alu_Op === ALU_SLT.U || io.alu_Op === ALU_SLTU.U, cmp,
    Mux(io.alu_Op === ALU_SRA.U || io.alu_Op === ALU_SRL.U, shiftr,
    Mux(io.alu_Op === ALU_SLL.U, shiftl,
    Mux(io.alu_Op === ALU_AND.U, (io.in_A & io.in_B),
    Mux(io.alu_Op === ALU_OR.U,  (io.in_A | io.in_B),
    Mux(io.alu_Op === ALU_XOR.U, (io.in_A ^ io.in_B), 
    Mux(io.alu_Op === ALU_COPY_A.U, io.in_A, 
    Mux(io.alu_Op === ALU_COPY_A.U, io.in_B, 0.U)))))))))

  io.out := out
  io.sum := sum
}
