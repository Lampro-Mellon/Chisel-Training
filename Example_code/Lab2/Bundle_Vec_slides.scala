//Example using Asynchronous memory
import chisel3._
import chisel3.util._

class IO_Interface extends Bundle{
  // input using a Vector of 4 values
  val data_in = Input(Vec(4,(UInt(32.W))))
 
  val data_selector = Input(UInt(2.W))  // vector slection lines
  val data_out = Output(UInt(32.W))     // output data
  val addr = Input(UInt(5.W))           // address lines
  val wr_en = Input(Bool())             // high for write
}

class Mem_bundle_intf extends Module {
  val io = IO(new IO_Interface)
  val memory = Mem(32, UInt(32.W))      // Make memory of 32x32
  
  io.data_out := 0.U
 
  when(io.wr_en) {     
   // Write at addr, with selected data from data_in vector
    memory.write(io.addr, io.data_in(io.data_selector))  
  } .otherwise {
   // Asyncronous read from addr location
  io.data_out := memory.read(io.addr) 
  }
}

println((new chisel3.stage.ChiselStage).emitVerilog(new Mem_bundle_intf()))