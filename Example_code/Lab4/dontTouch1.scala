module DontTouch(
  input         clock,
  input         reset,
  input  [31:0] io_a,
  output [31:0] io_b
);
  wire [31:0] unused; // @[main.scala 14:21]
  assign unused = io_a + 32`h12;  
  assign io_b = io_a; // @[main.scala 12:8]
endmodule