import chisel3._
import chisel3.stage.ChiselStage

class Adder_Inputs(x: Int, y: Int) extends Bundle {
  val in1 = UInt(x.W)
  val in2 = UInt(y.W)
  
  // creating a custom cloneType method
  override def cloneType = (new Adder_Inputs(x, y)).asInstanceOf[this.type]
}

class Adder(inBundle: Adder_Inputs, outSize: Int) extends Module {
  val io = IO(new Bundle {
    val out = Output(UInt(outSize.W))
    
    // chiselTypeOf returns the chisel type of the object
    val in_bundle = Input(chiselTypeOf(inBundle))
  })
  io.out := io.in_bundle.in1 + io.in_bundle.in2
}

class Top(in1Size: Int, in2Size: Int, outSize: Int) extends Module {
  val io = IO(new Bundle {
    val out = Output(UInt(outSize.W))
    val in = Input(UInt(in1Size.W))
  })
  
  // input bundle instance
  val inBundle = Wire(new Adder_Inputs(in1Size, in2Size))
  inBundle := DontCare
  
  // module instance
  val m = Module(new Adder(inBundle, outSize))
  m.io.in_bundle.in1 := io.in
  m.io.in_bundle.in2 := io.in
  io.out := m.io.out
}

println((new ChiselStage).emitVerilog(new Top(18, 30, 32)))