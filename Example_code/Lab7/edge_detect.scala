import chisel3._
import chisel3.util._

class Edge_FSM extends Module {
   val io = IO(new Bundle{
   val sin = Input(Bool())
   val edge = Output(Bool())
})

  // Detect the edge
  io.edge = !io.sin & RegNext(io.sin)
}

