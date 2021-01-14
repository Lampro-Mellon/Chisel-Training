
import chisel3._
import chisel3.util._

class cross_bar_2_to_1[T<:Data](gen:T) extends Module{
  val io = IO(new Bundle{
    val in1  = Input(gen) 
    val in2  = Input(gen)
    val out1  = Output(gen)
    val out2  = Output(gen)
    val sel   = Input(Bool())
  }) 
  when(io.sel){
  io.out1 := io.in2
  io.out2 := io.in1}
  .otherwise{
  io.out1 := io.in1
  io.out2 := io.in2
  }
}
println(chisel3.Driver.emitVerilog(new cross_bar_2_to_1(UInt(8.W))))

