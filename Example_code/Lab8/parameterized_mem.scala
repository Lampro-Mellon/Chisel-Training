// parameterized memory
import chisel3._
import chisel3.util._

class Parameterized_Mem(val size: Int = 32, val width: Int = 32) extends Module {
  val io = IO(new Bundle {
    val dataIn = Input(UInt(width.W))
    val dataOut = Output(UInt(width.W))
    val addr = Input(UInt(log2Ceil(size).W))
    val rd_enable = Input(Bool())
    val wr_enable = Input(Bool())
  })

  val Sync_memory = SyncReadMem(size, UInt(width.W))
  // memory write operation
  when(io.wr_enable){
    Sync_memory.write(io.addr, io.dataIn)
  }
  io.dataOut := Sync_memory.read(io.addr, io.rd_enable)
}
println((new chisel3.stage.ChiselStage).emitVerilog(new Parameterized_Mem))
