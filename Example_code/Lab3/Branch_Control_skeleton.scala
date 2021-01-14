// Branch control (Assignment)
package lab3
import chisel3._
import chisel3.util._

class LM_IO_Interface_BranchControl extends Bundle {
    val fnct3     = Input(UInt(3.W))
    val branch    = Input(Bool())
    val arg_x     = Input(UInt(32.W))
    val arg_y     = Input(UInt(32.W))
    val br_taken  = Output(Bool())
}

class BranchControl extends Module {
  val io = IO(new LM_IO_Interface_BranchControl)
// Start Coding here


// End your code here
// Well, you can actually write classes too. So, technically you have no limit ;)
}

println((new chisel3.stage.ChiselStage).emitVerilog(new Branch_Control))

