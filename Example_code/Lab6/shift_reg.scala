// shift register example
import chisel3._

class shift_reg(val init: Int = 1) extends Module {
  val io = IO(new Bundle{
    val in = Input(Bool())
    val out = Output(UInt(4.W))
  })
  // register initialization
  val state = RegInit(init.U(4.W)) 
  
  // serial data in at LSB
  val nextState = (state << 1) | io.in
  state := nextState
  io.out := state
}
println((new chisel3.stage.ChiselStage).emitVerilog(new shift_reg))