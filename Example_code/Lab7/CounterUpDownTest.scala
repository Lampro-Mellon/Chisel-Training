package LM_Chisel
import chisel3._
import chisel3.iotesters.{Driver, PeekPokeTester}

class TestCounterUpDown(c: CounterUpDown) extends PeekPokeTester(c) {
   var data_in = 6
   poke(c.io.data_in, data_in.U)
   step(40)
   data_in = 10
   poke(c.io.data_in, data_in.U)
   step(50)
}

// object for tester class 
object CounterUpDown_Main extends App {
    iotesters.Driver.execute(Array("--is-verbose", 
    "--generate-vcd-output","on", "--backend-name", "firrtl"),                 
    () => new CounterUpDown(8)) {c => new TestCounterUpDown(c)} 
}
