import chisel3._

class IO_Interface extends Bundle {
  val data_M_to_S  = Output(UInt(32.W))
  val data_S_to_M  = Input(UInt(32.W))
  val addr         = Output(UInt(5.W))
  val rd_wr        = Output(Bool())
}

class Master extends Module {
  val io = IO(new IO_Interface)
  
  io.data_M_to_S := io.data_S_to_M
  io.addr        := 2.U
  io.rd_wr       := true.B
}

class Slave extends Module {
  val io = IO(Flipped(new IO_Interface)) // use of Flipped
  
  io.data_S_to_M := io.data_M_to_S
}

class Top_Level extends Module {
  val io = IO(new Bundle {
    val master_io = new IO_Interface
    val slave_io  = Flipped(new IO_Interface) // use of Flipped
})
  
  val master_node = Module(new Master())
  val slave_node  = Module(new Slave())
  
  master_node.io <> slave_node.io      // bulk connections
  io.master_io   <> master_node.io   
  io.slave_io    <> slave_node.io  
}

println((new chisel3.stage.ChiselStage).emitVerilog(new Top_Level))
