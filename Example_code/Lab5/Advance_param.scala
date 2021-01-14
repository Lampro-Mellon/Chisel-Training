import chisel3._

class Operator [T <: Data](n:Int,generic:T)(op:(T,T) =>T) extends Module {
  
require (n > 0) // " reduce only works on non - empty Vecs "

val io  = IO(new Bundle {
val in  = Input(Vec(n,generic))
val out = Output(generic)
})
io.out := io.in.reduce(op)
}

println(chisel3.Driver.emitVerilog(new Operator(3,UInt(8.W))(_&_)))

