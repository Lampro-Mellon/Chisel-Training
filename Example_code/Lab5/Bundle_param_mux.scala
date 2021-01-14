import chisel3._
import chisel3.util._

class LM_IO_Interface[T <: Data](data_type:T) extends Bundle{
  val in1  = Input(data_type.cloneType)
  val in2  = Input(data_type.cloneType)
  val out  = Output(data_type.cloneType)
  val sel  = Input(Bool())
}

class Mux_2 extends Module{
  val io = IO(new LM_IO_Interface(8.U))
  
  io.out := Mux(io.sel,io.in1,io.in2)
}
println(chisel3.Driver.emitVerilog(new Mux_2))
