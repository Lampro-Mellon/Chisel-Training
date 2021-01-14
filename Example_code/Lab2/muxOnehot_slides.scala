// Mux-Onehot example
import chisel3._
import chisel3.util._

class Encoder_4to2 extends Module {
  val io = IO(new Bundle{
  val in = Input(UInt(4.W))
  val out = Output(UInt(4.W))
})
  io.out := Mux1H(io.in,Seq(0.U,1.U,2.U,3.U))
}

println((new chisel3.stage.ChiselStage).emitVerilog(new Encoder_4to2()))
