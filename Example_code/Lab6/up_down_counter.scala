// Up-down counter example
import chisel3._
import chisel3.util._

class up_down_counter(val max: Int = 10) extends Module {
  val io = IO(new Bundle{
    val out = Output(UInt(log2Ceil(max).W))
    val up_down = Input(Bool())
  })
  val counter = RegInit(0.U(log2Ceil(max).W))
  counter := Mux(io.up_down, 
                Mux(counter===(max-1).U, 0.U, counter+1.U), counter-1.U)
  io.out := counter 
}

println((new chisel3.stage.ChiselStage).emitVerilog(new up_down_counter(4)))
