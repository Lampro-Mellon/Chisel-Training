import chisel3._
import chisel3.util._

class Edge_FSM extends Module {
   val io = IO(new Bundle{
   val sin = Input(Bool())
   val edge = Output(Bool())
})

val zero :: one :: Nil = Enum(2) // The two states
val state = RegInit(zero)        // The state register
io.edge := false.B               // default value for output

// Next state and output logic
switch (state) {

	is(zero) {
	   when(io.sin) {
		state := one	
	   }
	}
	
	is(one) {
	   when(!io.sin) {
		state := zero
		io.edge := true.B
	   }
	}
   }
}
