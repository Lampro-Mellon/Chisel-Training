module AdderWithOffset(
  input         clock,
  input         reset,
  input  [15:0] io_x,
  input  [15:0] io_y,
  output [15:0] io_z
);
  wire [15:0] _T_2; 
  assign _T_2 = $signed(io_x) - 16'sh9; 
  assign io_z = _T_2 + io_y; 
endmodule
