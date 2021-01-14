// Encoder using when-else-statement
import chisel3._

class LM_IO_Interface extends Bundle {
  val in  = Input(UInt(4.W))
  val out = Output(UInt(2.W))
}

class Encoder_4to2 extends Module {
  val io = IO(new LM_IO_Interface)
    
  when (io.in === "b0001".U) {
    io.out := "b00".U
  } .elsewhen(io.in === "b0010".U) {
    io.out := "b01".U
  } .elsewhen(io.in === "b0100".U) {
    io.out := "b10".U
  } .otherwise {
    io.out := "b11".U
  }
}

println((new chisel3.stage.ChiselStage).emitVerilog(new Encoder_4to2()))
