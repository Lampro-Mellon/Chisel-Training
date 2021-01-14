class EncoderIO extends Bundle {
  val in  = Input(UInt(4.W))
  val out = Output(UInt(2.W))
}

class Encoder4to2 extends Module {
  val io = IO(new EncoderIO)
    
  when (io.in === "b0001".U) {
    io.out := "b00".U
  } .elsewhen(io.in === "b0010".U) {
    io.out := "b01".U
  } .elsewhen(io.in === "b0100".U) {
    io.out := "b10".U
  } .otherwise {
    io.out := "b11".U
  }}

