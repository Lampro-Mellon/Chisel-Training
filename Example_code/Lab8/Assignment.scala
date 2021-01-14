package Lab8

import chisel3._
import chisel3.util._

class memory_assignment extends Module {
  val io = IO(new Bundle{
    val memory_out = Vec(4, Output(UInt(32.W)))
    val requestor = Vec(4, Flipped(Decoupled(UInt(32.W))))
    val Readaddr = Input(UInt(5.W))
    val Writeaddr = Input(UInt(5.W))
  })
  // Start your code from here

  // End your code here
}


