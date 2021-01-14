package LM_Chisel
import chisel3._
import chisel3.iotesters.{Driver, PeekPokeTester}

class TestMuxT(c: MuxTree) extends PeekPokeTester(c) {
   val in1  = 0x11111111
   val in2  = 0x22222222
   val in3  = 0x33333333
	
   poke(c.io.in_1, in1.U)
   poke(c.io.in_2, in2.U)
   poke(c.io.in_3, in3.U)
   
   poke(c.io.sel_1, false.B)
   poke(c.io.sel_2, false.B)
   expect(c.io.out, in1.U)
   step(1)
   
   poke(c.io.sel_1, true.B)
   poke(c.io.sel_2, false.B)
   expect(c.io.out, in2.U)
   step(1)

   poke(c.io.sel_1, true.B)
   poke(c.io.sel_2, true.B)
   expect(c.io.out, in3.U)
   step(3)
}