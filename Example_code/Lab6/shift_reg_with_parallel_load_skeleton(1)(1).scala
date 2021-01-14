// Shift register with parallel load
import chisel3._
import chisel3.util._

class shift_reg_with_parallel_load(val len : Int=1) extends Module {
  val io = IO(new Bundle{
    val out = Vec(len, Output(Bool()))
    val load_in = Vec(len, Input(Bool()))
    val in = Input(Bool())
    val load = Input(Bool())
  })
// Start Coding here


// End your code here
// Well, you can actually write classes too. So, technically you have no limit ;)
}

println((new chisel3.stage.ChiselStage).emitVerilog(new shift_reg_with_parallel_load(n)))
