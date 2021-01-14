import chisel3._
import chisel3.util._

class User_Queue extends Module {
  val io = IO(new Bundle {
    //valid is Input, ready is Output, bits is Input
    val in = Flipped(Decoupled(UInt(8.W)))
    //valid is Output, ready is Input , bits is Output
    val out = Decoupled(UInt(8.W))
  })
  // 16 element queue
  val queue = Module(new Queue(UInt(), 16)) 
  queue.io.enq <> io.in
  io.out <> queue.io.deq
}

println(chisel3.Driver.emitVerilog(new User_Queue))