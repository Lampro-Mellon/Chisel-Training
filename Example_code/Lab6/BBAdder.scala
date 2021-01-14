class BlackBoxAdder extends BlackBox with HasBlackBoxResource {
val io = IO(new Bundle() {
val in1 = Input(UInt(32.W))
val in2 = Input(UInt(32.W))
val out = Output(UInt(33.W))
})
setResource("/Adder.v")
}