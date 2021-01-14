class DecoderIO extends Bundle {
  val in  = Input(UInt(2.W))
  val out = Output(UInt(4.W))
}

class Decoder2to4 extends Module {
  val io = IO(new DecoderIO)
  io.out := 0.U
  switch (io.in) {
    is ("b00".U) {io.out := "b0001".U}
    is ("b01".U) {io.out := "b0010".U}
    is ("b10".U) {io.out := "b0100".U}
    is ("b11".U) {io.out := "b1000".U}
  }}

