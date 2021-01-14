package Lab7
import chisel3._
import chisel3.util._
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}
import chisel3.experimental.ChiselEnum
import chisel3.experimental.{withClock, withReset, withClockAndReset}
import chisel3.experimental.BundleLiterals._

//optional, you can use compaion object
object Manchester_Encoding{  //optional
//your code
}

class Manchester_Encoding extends Module {
  import Manchester_Encoding.State
  import Manchester_Encoding.State._
  val io = IO(new Bundle {
    val in  = Input(UInt(1.W))
    val start = Input(Bool())
    val out = Output(UInt(8.W))
      val flag = Output(UInt(1.W))
  })
//your code here
}


