import chisel3._
import chisel3.util._

class Parameters(dWidth: Int, aWidth: Int) extends Bundle{
 val addrWidth = UInt(aWidth.W)
 val dataWidth = UInt(dWidth.W)
}

class DataMem (params: Parameters) extends Module {
  val io = IO(new Bundle{
   val data_in  = Input(params.dataWidth)  
   val data_out = Output(params.dataWidth) 
   val addr     = Input(params.addrWidth)  
   val wr_en    = Input(Bool())
})
  
// Make memory of 32 x 32
val memory = Mem(32, params.dataWidth) 
  
  io.data_out := 0.U
 
  when(io.wr_en) {     
    memory.write(io.addr, io.data_in)  
  } .otherwise {
    io.data_out := memory.read(io.addr) 
  }
}

val params = (new Parameters(32, 5))
println((new chisel3.stage.ChiselStage).emitVerilog(new DataMem(params)))