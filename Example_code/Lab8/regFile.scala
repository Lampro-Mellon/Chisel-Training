import chisel3._

class RegFileIO  extends Bundle with Config {
  val raddr1 = Input(UInt(5.W))
  val raddr2 = Input(UInt(5.W))
  val rdata1 = Output(UInt(XLEN.W))
  val rdata2 = Output(UInt(XLEN.W))
  val wen    = Input(Bool())
  val waddr  = Input(UInt(5.W))
  val wdata  = Input(UInt(XLEN.W))
}

class RegFile extends Module with Config {
  val io = IO(new RegFileIO)
  val regs = Mem(REGFILE_LEN, UInt(XLEN.W))
  
  io.rdata1 := Mux((io.raddr1.orR), regs(io.raddr1), 0.U)
  io.rdata2 := Mux((io.raddr2.orR), regs(io.raddr2), 0.U)
  
  when(io.wen & io.waddr.orR) {
     regs(io.waddr) := io.wdata
  }
}