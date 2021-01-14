
import chisel3._
import chisel3.util._
import chisel3.iotesters.{ChiselFlatSpec,Driver,PeekPokeTester}

class Pipe extends Module{
      val io  = IO(new Bundle {
      val in  = Flipped(Valid(UInt(8.W))) //valid = Input,   bits = Input 
      val out = Valid(UInt(8.W))          //valid = Output,  bits = Output
    })
  io.out := Pipe(io.in,5)
}
println(chisel3.Driver.emitVerilog(new Pipe))
