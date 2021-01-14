// 8 to 1 mux using MuxCase
import chisel3._
import chisel3.util._

class MuxCase_ex extends Module {
  val io = IO(new Bundle{
    val in0 = Input(Bool())
    val in1 = Input(Bool())
    val in2 = Input(Bool())
    val in3 = Input(Bool())
    val in4 = Input(Bool())
    val in5 = Input(Bool())
    val in6 = Input(Bool())
    val in7 = Input(Bool())
    val sel = Input(UInt(3.W))
    val out = Output(Bool())
  })
                            
  io.out := MuxCase(false.B, Array(
        (io.sel===0.U) ->     io.in0,
        (io.sel===1.U) ->     io.in1,
        (io.sel===2.U) ->     io.in2,
        (io.sel===3.U) ->     io.in3,
        (io.sel===4.U) ->     io.in4, 
        (io.sel===5.U) ->     io.in5,      
        (io.sel===6.U) ->     io.in6,      
        (io.sel===7.U) ->     io.in7)
  )
}

println((new chisel3.stage.ChiselStage).emitVerilog(new MuxCase_ex()))
