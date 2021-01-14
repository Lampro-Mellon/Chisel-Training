package LM_Chisel
import chisel3._

class MuxTreeIO extends Bundle {
  val in_1   = Input(UInt(32.W))
  val in_2   = Input(UInt(32.W))
  val in_3   = Input(UInt(32.W))
  val sel_1  = Input(Bool())
  val sel_2  = Input(Bool())
  val out    = Output(UInt())    
}

// 3 to 1 MuxTree implementation
class MuxTree extends Module {
  val io = IO(new MuxTreeIO)
  
  // update the output
  io.out := Mux(io.sel_2, io.in_3, Mux(io.sel_1, io.in_2, io.in_1)) 
}