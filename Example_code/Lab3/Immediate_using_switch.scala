\\immediate using switch
class ImmdValGen extends Module {
  val io = IO(new LM_IO_Interface)

  io.immd_se := 0.U

  val opcode = io.instr(6,0)
  switch(opcode) {
    is("b0010011".U) {      //I-type arithematic
      val immd = io.instr(31,20)
      io.immd_se := Cat(Fill(20,immd(11)),immd)
    }
    is("b0000011".U) {        //I-type  Load
      val immd = io.instr(31,20)
      io.immd_se := Cat(Fill(20,immd(11)),immd)
    }
    is("b1100111".U) {        //I-type    JALR
      val immd = io.instr(31,20)
      io.immd_se := Cat(Fill(20,immd(11)),immd)
    }
    is("b0100011".U) {        //S-type
      val immd = Cat(io.instr(31,25),io.instr(11,7))
      io.immd_se := Cat(Fill(20,immd(11)),immd)
    }
    is("b1100011".U) {        //B-type
      val immd = Cat(io.instr(31),io.instr(7),io.instr(30,25),io.instr(11,8))
      io.immd_se := Cat(Fill(19,immd(11)),immd, 0.U)
    }
    is("b1101111".U) {        //J-type
      val immd = Cat(io.instr(31),io.instr(19,12),io.instr(20),io.instr(30,25),io.instr(24,21))
      io.immd_se := Cat(Fill(11,immd(19)),immd, 0.U)
    }
    is("b0110111".U) {        //U-type lui
      val immd = Cat(io.instr(31,12))
      io.immd_se := Cat(immd, Fill(12,0.U))
    }
    is("b0010111".U) {        //U-type  auipc
      val immd = Cat(io.instr(31,12))
      io.immd_se := Cat(immd, Fill(12,0.U))
    }
  }
}

class LM_IO_Interface extends Bundle {
  val instr = Input(UInt(32.W))
  val immd_se = Output(UInt(32.W))
}
