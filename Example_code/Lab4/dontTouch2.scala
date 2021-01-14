module DontTouch(
  input         clock,
  input         reset,
  input  [31:0] io_a,
  output [31:0] io_b
);
  assign io_b = io_a; //@[main.scala 12:8]
endmodule