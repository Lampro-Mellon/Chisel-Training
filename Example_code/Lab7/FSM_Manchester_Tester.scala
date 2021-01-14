import chisel3._
import chisel3.util._
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}
import chisel3.experimental.ChiselEnum
import chisel3.experimental.{withClock, withReset, withClockAndReset}
import chisel3.experimental.BundleLiterals._

class Tester(c: Manchester_Encoding) extends PeekPokeTester(c) {
   poke(c.io.start,false.B)
    step(1)
    poke(c.io.start,true.B)
    step(1)
    
    poke(c.io.in,1.U)  //1   
    step(1)
    poke(c.io.in,0.U)   
    step(1)
    
    
    poke(c.io.in,1.U)  //1
    step(1)
    poke(c.io.in,0.U)  
    step(1)
    
    
    poke(c.io.in,0.U)  //0
    step(1)
    poke(c.io.in,1.U)
    step(1)
    
    
    poke(c.io.in,0.U)  //0
    step(1)
    poke(c.io.in,1.U)
    step(1)
    
    poke(c.io.in,1.U)  //1
    step(1)
    poke(c.io.in,0.U)
    step(1)
    
    
    poke(c.io.in,1.U)  //1
    step(1)
    poke(c.io.in,0.U)
    step(1)
    

    poke(c.io.in,0.U)  //0
    step(1)
    poke(c.io.in,1.U)
    step(1)
    
    
    poke(c.io.in,1.U)  //1
    step(1)
    poke(c.io.in,0.U)
    //step(1)
    
    expect(c.io.out,205.U)
    expect(c.io.flag,1.U)
  
}
assert(Driver(() => new Manchester_Encoding) {c => new Tester(c)})
println("SUCCESS!!")
