// Memory forwarding example
import chisel3._
import chisel3.util._

class Forwarding extends Module {
  val io = IO(new Bundle{
    val out = Output(UInt(32.W))
    val rdAddr = Input(UInt(10.W))
    val wrAddr = Input(UInt(10.W))
    val wrData = Input(UInt(32.W))
    val wr_en = Input(Bool())
  })
  
  val memory = SyncReadMem(1024, UInt(32.W))
  val wrDataReg = RegNext(io.wrData)
  val doForwardReg = RegNext(io.wrAddr === io.rdAddr && io.wr_en)
  val memData = memory.read(io.rdAddr)
  when(io.wr_en) 
  {memory.write(io.wrAddr, io.wrData)}
  io.out := Mux(doForwardReg , wrDataReg , memData)
}

println((new chisel3.stage.ChiselStage).emitVerilog(new Forwarding()))
