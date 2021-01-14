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
  io.out(0) := RegNext(0.U, Mux(io.load, io.load_in(0), io.in))
  for(i<- 1 until len){
    io.out(i) := RegNext(0.U, Mux(io.load, io.load_in(0), io.out(i-1)))
  }
}

println((new chisel3.stage.ChiselStage).emitVerilog(new shift_reg_with_parallel_load(4)))
