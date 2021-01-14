>// 2 to 1 Mux for tester
import chisel3._
import chisel3.util._

class Mux_for_tester extends Module {
  val io = IO(new Bundle{
    val in = Vec(2,Input(Bool()))
    val sel = Input(Bool())
    val out = Output(Bool())
  })
  io.out := Mux(io.sel, io.in(0), io.in(1)) 
}
