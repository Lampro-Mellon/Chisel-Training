// Counter with XOR example
import chisel3._
import chisel3.util._

class counter_with_xor(val max: Int = 1) extends Module {
  val io = IO(new Bundle{
    val out = Output(UInt((log2Ceil(max).W)))
  })
  val counter = RegInit(0.U((log2Ceil(max)+1).W))
  val inter = Mux(counter(log2Ceil(max))^true.B, 0.U, counter+1.U)
  counter := inter
  io.out := counter
}


