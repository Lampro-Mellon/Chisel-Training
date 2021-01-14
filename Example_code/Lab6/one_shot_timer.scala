// One shot generator
import chisel3._
import chisel3.util._

class oneShotTimer extends Module {
  val io = IO(new Bundle{
    val reloadValue = Input(UInt(8.W))
    val reload = Input(Bool())
    val out = Output(Bool())
  })
    val counter = RegInit(0.U(8.W))
    counter := RegNext(Mux(RegNext(io.reload) & !io.reload, io.reloadValue, Mux(counter===0.U, 0.U, counter-1.U)))
    io.out := (counter===0.U) & RegNext(counter===1.U)
 }

println((new chisel3.stage.ChiselStage).emitVerilog(new oneShotTimer()))
