import chisel3.util._

class Parameters extends Bundle{
 val addrWidth = UInt(32.W)
 val dataWidth = UInt(32.W)
}


class adder(params: Parameters) extends Module{
  val io = IO(new Bundle{
    val in1  = Input(params.addrWidth) 
    val in2  = Input(UInt(32.W))
    val out1  = Output(UInt(32.W))
    val out2  = Output(UInt(32.W))
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

val params = (new Parameters)
println(chisel3.Driver.emitVerilog(new adder(params)))