package LM_Chisel

import chisel3._
import chisel3.util._

class DataMemIO extends Bundle with Config {
  val addr        = Input(UInt(WLEN.W))
  val wdata       = Input(UInt(WLEN.W))
  val rd_en       = Input(Bool())
  val wr_en       = Input(Bool())
  val mask        = Input(Vec(4, Bool()))
  val rdata       = Output(UInt(WLEN.W))
}

class DataMem extends Module with Config {
  val io = IO(new DataMemIO)

  // Data memory size and addressability width
  val dmem = SyncReadMem(DATA_MEM_LEN, UInt(BLEN.W))
  // Write with mask
  when (io.wr_en.toBool()) {
     dmem.write(io.addr, io.wdata, io.mask)
  }
  io.rdata := dmem.read(io.addr, rd_en)
}