import chisel3._
import chisel3.util._
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}
import chisel3.experimental.ChiselEnum
import chisel3.experimental.{withClock, withReset, withClockAndReset}
import chisel3.experimental.BundleLiterals._

object Manchester_Encoding{
  object State extends ChiselEnum {
    val sNone, sRead, sWait, sDecode = Value
  }
}

class Manchester_Encoding extends Module {
  import Manchester_Encoding.State
  import Manchester_Encoding.State._
  val io = IO(new Bundle {
    val in  = Input(UInt(1.W))
    val start = Input(Bool())
    //val alternateReset    = Input(Bool())
    //val alternateClock    = Input(Clock())
    val out = Output(UInt(8.W))
      val flag = Output(UInt(1.W))
  })
        val state = RegInit(sNone)
        val data_in = RegInit(UInt(8.W), 0.U)
        val data_next = (data_in << 1) | io.in
        val count = RegInit(0.U(4.U))
    
        when(state === sWait){
        io.flag:= 1.U }
        .otherwise{
        io.flag:= 0.U }
    
    
        io.out := data_in

    switch (state) {
        is (sNone) {
            when (io.start) {
              state:=sRead
            }.otherwise{
                  state:=sNone
              }
        }
        is (sRead) {
              when (count<8.U) {
                  data_in := data_next
                  count := count + 1.U
                  state:=sWait
              }.otherwise {
                  count:=0.U
                  state:=sDecode
                }
        }
        is (sWait) {
               state:=sRead
        }        
    is (sDecode) 
        {
            
            state:=sDecode
        }
  }

}
//println(getVerilog(new Manchester_Encoding))


