import chisel3._
import chisel3.util._

class Multiply_Acc(gen: UInt) extends Module {
  val io = IO(new Bundle {
    val out = Output(gen)
    val in1 = Input(gen)
    val in2 = Input(gen)
    val in3 = Input(gen)
  })

  io.out := multiply_add(io.in1, io.in2, io.in3)

  def multiply_add[T <: UInt](in_1: T, in_2: T, in_3: T) = {
    in_1 * in_2 + in_3
  }
}

println(chisel3.Driver.emitVerilog(new Multiply_Acc(UInt(2.W))))