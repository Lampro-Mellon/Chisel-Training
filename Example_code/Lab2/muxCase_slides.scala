// 4 to 1 mux using MuxCase
import chisel3._
import chisel3.util._

class MuxCase_Example extends Module {
  val io = IO(new Bundle{
    val in0 = Input(Bool())
    val in1 = Input(Bool())
    val in2 = Input(Bool())
    val in3 = Input(Bool())   
    val sel = Input(UInt(2.W))
    val out = Output(Bool())
  })
                            
  io.out := MuxCase(false.B, Array(
       (io.sel === 0.U)  ->      io.in0,
       (io.sel === 1.U)  ->      io.in1,
       (io.sel === 2.U)  ->      io.in2,
       (io.sel === 3.U)  ->      io.in3
     )
   )
}

println((new chisel3.stage.ChiselStage).emitVerilog(new MuxCase_Example ()))