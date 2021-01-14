//Example 2 to 4 decoder
import chisel3._
class LM_IO_Interface extends Bundle {
  val in  = Input(UInt(2.W))
  val out = Output(UInt(4.W))
}
class Decoder_2to4 extends Module {
  val io = IO(new LM_IO_Interface)
  
  when(io.in === "b00".U) {
    io.out := "b0001".U
  } .elsewhen(io.in === "b01".U) {
    io.out := "b0010".U
  } .elsewhen(io.in === "b10".U) {
    io.out := "b0100".U
  } .otherwise {
    io.out := "b1000".U
  }

}

println((new chisel3.stage.ChiselStage).emitVerilog(new Decoder_2to4()))
