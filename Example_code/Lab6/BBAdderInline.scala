class BlackBoxAdder extends BlackBox with HasBlackBoxInline {
val io = IO(new Bundle() {
val in1 = Input(UInt(32.W))
val in2 = Input(UInt(32.W))
val out = Output(UInt(33.W))
})
setInline("BlackBoxAdder.v",
  s"""
  |module BlackBoxAdder(
    | input [32:0] in1,
    | input [32:0] in2,
    | output [33:0] out
  |);
  |always @* begin
  | out <= ((in1) + (in2));
  |end
  |endmodule
  """.stripMargin)
}
