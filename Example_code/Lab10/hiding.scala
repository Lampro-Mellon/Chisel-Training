import chisel3.util.{MuxCase => _ , _}

io.out := MuxCase(false.B, Array(
	  (io.sel === 0.U)  ->   io.in0,
	  (io.sel === 1.U)  ->   io.in1,
	  (io.sel === 2.U)  ->   io.in2,
	  (io.sel === 3.U)  ->   io.in3 )
)
