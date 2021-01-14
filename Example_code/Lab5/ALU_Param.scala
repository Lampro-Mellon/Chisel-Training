import chisel3._
import chisel3.util._
import chisel3.iotesters.{Driver,PeekPokeTester}

class ALU(width_parameter:Int) extends Module {
  val io = IO(new IO_Interface(width_parameter))
  
  io.alu_out := 0.U 
  val index = log2Ceil(width_parameter)

  switch(io.alu_oper) { //AND
    is("b0000".U) { 
      io.alu_out := io.arg_x & io.arg_y
    } //OR
    is("b0001".U) { 
      io.alu_out := io.arg_x | io.arg_y
    } //ADD
    is("b0010".U) { 
      io.alu_out := io.arg_x + io.arg_y
    } //SUB
    is("b0110".U) { 
      io.alu_out := io.arg_x - io.arg_y
    } //XOR
    is("b0011".U) { 
      io.alu_out := io.arg_x ^ io.arg_y
    } //SLL
    is("b0100".U) { 
      io.alu_out := io.arg_x << io.arg_y(index-1, 0) 
    } //SRL
    is("b0101".U) { 
      io.alu_out := io.arg_x >> io.arg_y(index-1, 0)
    } //SRA
    is("b0111".U) { 
      io.alu_out := (io.arg_x.asSInt >> io.arg_y(index-1, 0)).asUInt
    } //SLT
    is("b1000".U) { 
      io.alu_out := io.arg_x.asSInt < io.arg_y.asSInt
    } //SLTU
    is("b1001".U) { 
      io.alu_out := io.arg_x < io.arg_y
    }
  }
}

class IO_Interface(width:Int) extends Bundle {
  val alu_oper = Input(UInt(width.W))
  val arg_x = Input(UInt(width.W))
  val arg_y = Input(UInt(width.W))
  val alu_out = Output(UInt(width.W))
}

println((new chisel3.stage.ChiselStage).emitVerilog(new ALU(32)))
println((new chisel3.stage.ChiselStage).emitVerilog(new ALU(64)))