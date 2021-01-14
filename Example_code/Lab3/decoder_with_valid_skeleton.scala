package lab3
import chisel3._
import chisel3.util._

class LM_IO_Interface_decoder_with_valid extends Bundle {
   val in  = Input(UInt(2.W))
   val out = Valid(Output(UInt(4.W)))
}

class decoder_with_valid extends Module {
   val io = IO(new LM_IO_Interface_decoder_with_valid)
  
  // Start coding here

  // End coding here
}
