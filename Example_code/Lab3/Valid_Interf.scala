import chisel3._
import chisel3.util._
import chisel3.iotesters.{ChiselFlatSpec,Driver,PeekPokeTester}

class Valid_Interf extends Module{
      val io  = IO(new Bundle {
      val in  = Flipped(Valid(UInt(8.W))) //valid = Input,   bits = Input 
      val out = Valid(UInt(8.W))          //valid = Output,  bits = Output
    })
  io.out := RegNext(io.in)
}
println(chisel3.Driver.emitVerilog(new Valid_Interf))
