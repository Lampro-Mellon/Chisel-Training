// process the ALU result for -ve values  
  val result1: BigInt = if (result < 0) 
                             (BigInt(0xFFFFFFFF)+result+1) & 0xFFFFFFFFL
                        else result & 0xFFFFFFFFL
	
    poke(c.io.in_A, src_a.U)
    poke(c.io.in_B, src_b.U)
    poke(c.io.alu_Op, aluop)
    step(1)
    expect(c.io.out, result1.asUInt)
 }
  step(1)
  step(1)
}

// object for tester class 
object ALU_Main extends App {
 iotesters.Driver.execute(Array("--is-verbose", "--generate-vcd-output",  
   "on", "--backend-name", "firrtl"), () => new ALU) {
    c => new TestALU(c)
  } 
}

