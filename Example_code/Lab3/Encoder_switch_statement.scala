// Encoder using switch statement
import chisel3._

class LM_IO_Interface extends Bundle {
  val in  = Input(UInt(4.W))
  val out = Output(UInt(2.W))
}

class Encoder_4to2 extends Module {
  val io = IO(new LM_IO_Interface)
  
  io.out := "b00".U
  switch(io.in) {
    is("b0001".U) {io.out := "b00".U}
    is("b0010".U) {io.out := "b01".U}
    is("b0100".U) {io.out := "b10".U}
    is("b1000".U) {io.out := "b11".U}
  }
}

println((new chisel3.stage.ChiselStage).emitVerilog(new Encoder_4to1()))

