// Counter with XOR example
import chisel3._
import chisel3.util._

class counter_with_xor(val max: Int = 1) extends Module {
  val io = IO(new Bundle{
    val out = Output(UInt((log2Ceil(max).W)))
  })
  // Start Coding here

  // End your code here
}
println((new chisel3.stage.ChiselStage).emitVerilog(new counter_with_xor(n)))
