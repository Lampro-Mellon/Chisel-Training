// Mux 8 to 1 (Assignment)
import chisel3._

class LM_IO_Interface extends Bundle {
  val in  = Input(UInt(8.W))
  val s0  = Input(Bool())
  val s1  = Input(Bool())
  val s2  = Input(Bool())
  val out = Output(Bool())    //UInt(1.W))
}

class Mux_8to1 extends Module {
  val io = IO(new LM_IO_Interface)
  
// Start coding here


// End your code here
// Well, you can actually write classes too. So, technically you have no limit ;)
}
println((new chisel3.stage.ChiselStage).emitVerilog(new Mux_8to1))
