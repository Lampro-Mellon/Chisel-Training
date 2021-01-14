// ShiftRegister construct
import chisel3._
import chisel3.util._

class shift_reg extends Module {
  val io = IO(new Bundle{
    val out = Output(UInt(4.W))
    val in = Input(UInt(4.W))
  })
  io.out := ShiftRegister(io.in, 2, true.B)
}

println((new chisel3.stage.ChiselStage).emitVerilog(new shift_reg))
