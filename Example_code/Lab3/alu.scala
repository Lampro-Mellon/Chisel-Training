//ALU example
import chisel3._

class LM_IO_Interface extends Bundle {
  val alu_oper = Input(UInt(4.W))
  val arg_x = Input(UInt(32.W))
  val arg_y = Input(UInt(32.W))
  val alu_out = Output(UInt(32.W))
}

class myALU extends Module {
  val io = IO(new LM_IO_Interface)

  io.alu_out := 0.U

  switch(io.alu_oper) {
    is("b0000".U) { //AND
      io.alu_out := io.arg_x & io.arg_y
    }
    is("b0001".U) { //OR
      io.alu_out := io.arg_x | io.arg_y
    }
    is("b0010".U) { //ADD
      io.alu_out := io.arg_x + io.arg_y
    }
    is("b0110".U) { //SUB
      io.alu_out := io.arg_x - io.arg_y
    }
    is("b0011".U) { //XOR
      io.alu_out := io.arg_x ^ io.arg_y
    }
    is("b0100".U) { //SLL
      io.alu_out := io.arg_x << io.arg_y(4, 0)
    }
    is("b0101".U) { //SRL
      io.alu_out := io.arg_x >> io.arg_y(4, 0)
    }
    is("b0111".U) { //SRA
      io.alu_out := (io.arg_x.asSInt >> io.arg_y(4, 0)).asUInt
    }
    is("b1000".U) { //SLT
      io.alu_out := io.arg_x.asSInt < io.arg_y.asSInt
    }
    is("b1001".U) { //SLTU
      io.alu_out := io.arg_x < io.arg_y
    }
  }
}
