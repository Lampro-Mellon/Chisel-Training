// Round robin arbiter example
import chisel3._
import chisel3.util._

class RR_Arbiter extends Module{
  val io = IO(new Bundle {
      val in = Flipped(Vec(2, Decoupled(UInt(8.W))))
      val out = Decoupled(UInt(8.W))
    })
    // RRArbiter doesn't have a convenience constructor, so it's built like any Module
    val arbiter = Module(new Arbiter(UInt(8.W), 2))  // 2 to 1 round robin Arbiter
    arbiter.io.in <> io.in
    io.out <> arbiter.io.out
  }

println((new chisel3.stage.ChiselStage).emitVerilog(new RR_Arbiter))
