// Up-down counter example
import chisel3._
import chisel3.util._

class up_down_counter(val max: Int = 10) extends Module {
  val io = IO(new Bundle{
    val out = Output(UInt(log2Ceil(max).W))
    val up_down = Input(Bool())
  })
  // Start code here


 // End your code here 
}

println((new chisel3.stage.ChiselStage).emitVerilog(new up_down_counter(4)))
