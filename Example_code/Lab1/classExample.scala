import chisel3._

class AdderWithOffset extends Module {
val io = IO(new Bundle {
val x   = Input(SInt(16.W))
val y   = Input(UInt(16.W))
val z   = Output(UInt(16.W))
})

// Initialized as UInt and casted to SInt
val y1 = (23.U).asSInt     
val in1 = io.x + y1
io.z := in1.asUInt + io.y  // Typecast SInt to UInt
}

println((new chisel3.stage.ChiselStage).emitVerilog(new AdderWithOffset))

// The generated Verilog code 
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
