class Alu_Lookup extends Module with Config {
  val io = IO(new AluIO)

  val shamt = io.in_B(4,0).asUInt

  io.out := MuxLookup(io.alu_Op, io.in_B, Seq(
      ALU_ADD  -> (io.in_A + io.in_B),
      ALU_SUB  -> (io.in_A - io.in_B),
      ALU_SRA  -> (io.in_A .asSInt >> shamt).asUInt,
      ALU_SRL  -> (io.in_A >> shamt),
      ALU_SLL  -> (io.in_A << shamt),
      ALU_SLT  -> (io.in_A .asSInt < io.in_B.asSInt),
      ALU_SLTU -> (io.in_A < io.in_B),
      ALU_AND  -> (io.in_A & io.in_B),
      ALU_OR   -> (io.in_A | io.in_B),
      ALU_XOR  -> (io.in_A ^ io.in_B),
      ALU_COPY_A -> io.in_A ))

}
