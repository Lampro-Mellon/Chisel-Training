import chisel3._
import chisel3.util._

class switch_2cross2 [T <: Data](parameter:T) extends Module{
  val io = IO(new Bundle{
    val in1  = Input(parameter) 
    val in2  = Input(parameter)
    val out1  = Output(parameter)
    val out2  = Output(parameter)
    val sel   = Input(Bool())
  })
 
  when(io.sel){
  io.out1 := io.in2
  io.out2 := io.in1
  }
  .otherwise{
  io.out1 := io.in1
  io.out2 := io.in2
  }
}

println(chisel3.Driver.emitVerilog(new switch_2cross2(UInt(8.W))))