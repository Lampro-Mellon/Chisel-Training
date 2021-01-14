import chisel3._
import chisel3.stage.ChiselStage

class Adder extends Module {
val io = IO(new Bundle {
val x   = Input(SInt(16.W))
val y   = Input(UInt(16.W))
val z   = Output(UInt(16.W))
})

val in1 = Wire(SInt())
in1 := io.x + 1.S
io.z := in1.asUInt + io.y  // Typecast SInt to UInt
}

println((new ChiselStage).emitVerilog(new Adder))