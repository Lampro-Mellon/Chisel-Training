package Lab2

import chisel3._

class LM_IO_Interface extends Bundle {
  val s0  = Input(Bool())
  val s1  = Input(Bool())
  val s2  = Input(Bool())
  val out = Output(UInt(32.W))
}

class Mux_5to1 extends Module {
  val io = IO(new LM_IO_Interface)
  
  // Start coding here


  // End your code here
}
println((new chisel3.stage.ChiselStage).emitVerilog(new Mux_5to1))
