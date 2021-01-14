// Decoder using switch statement
import chisel3._

class LM_IO_Interface extends Bundle {
  val in  = Input(UInt(2.W))
  val out = Output(UInt(4.W))
}

class Decoder_2to4 extends Module {
  val io = IO(new LM_IO_Interface)
  
  io.out := 0.U
  switch (io.in) {
    is ("b00".U) {io.out := "b0001".U}
    is ("b01".U) {io.out := "b0010".U}
    is ("b10".U) {io.out := "b0100".U}
    is ("b11".U) {io.out := "b1000".U}
  }  
}

println((new chisel3.stage.ChiselStage).emitVerilog(new Decoder_2to4()))
