import chisel3._
import chisel3.stage.ChiselStage

class DontTouch extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(32.W))
    val b = Output(UInt(32.W))
  })
  
  io.b := io.a
  val reg1 = RegInit(18.U)
  val unused = io.a + reg1 // 'unused' will be eliminated if not
  dontTouch(unused)        // preserved with dontTouch 
}

println((new ChiselStage).emitVerilog(new DontTouch))