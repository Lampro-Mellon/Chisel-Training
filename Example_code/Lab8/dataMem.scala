package LM_Chisel

import chisel3._
import chisel3.util._
import Control._

class DataMemIO extends Bundle with Config {
  val addr        = Input(UInt(WLEN.W))
  val wdata       = Input(UInt(WLEN.W))
  val rd_en       = Input(Bool())
  val wr_en       = Input(Bool())
  val st_type     = Input(UInt(STTYPE_LEN.W))
  val rdata       = Output(UInt(WLEN.W))
}

class DataMem extends Module with Config {
  val io = IO(new DataMemIO)

  // Data memory size and addressability width
  val dmem = SyncReadMem(DATA_MEM_LEN, UInt(BLEN.W))
  val addr = io.addr
  val read_data = Wire(UInt(XLEN.W)) 
      read_data := 0.U      
  
    when (io.wr_en) {
      when (io.st_type === 1.U) {
        dmem (addr) := io.wdata(7,0)
        dmem (addr + 1.U) := io.wdata(15,8)
        dmem (addr + 2.U) := io.wdata(23,16)
        dmem (addr + 3.U) := io.wdata(31,24) 
      }.elsewhen (io.st_type === 2.U) {
        dmem (addr) := io.wdata(7,0)
        dmem (addr + 1.U) := io.wdata(15,8)
      }.elsewhen (io.st_type === 3.U) {
        dmem (addr) := io.wdata(7,0)
      }
    } 

    // read data from 4 memory banks
    read_data := Cat(dmem(addr + 3.U), dmem(addr + 2.U), dmem(addr + 1.U), dmem(addr))
     
    io.rdata := Mux(io.rd_en, read_data, 0.U)
}