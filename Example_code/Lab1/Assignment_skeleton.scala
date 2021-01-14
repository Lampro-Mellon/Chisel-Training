package Counter

import chisel3._
import chisel3.util._
import java.io.File

class counter_up_down(n: Int) extends Module {
    val io = IO(new Bundle {
      val data_in = Input(UInt(n.W))
      val reload = Input(Bool())
      val out = Output(Bool())
    })

    val counter = RegInit(0.U(n.W))
    val max_count = RegInit(6.U(n.W))

	//Your code

  }
