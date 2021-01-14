package LM_Chisel

import chisel3._
import chisel3.iotesters.{Driver, PeekPokeTester}
import chisel3.util
import scala.util.Random

import ALUOP._

class TestALU(c: ALU) extends PeekPokeTester(c) {
// ALU operations
val array_op = Array(ALU_ADD , ALU_SUB, ALU_AND, ALU_OR, ALU_XOR,      ALU_SLT, ALU_SLL, ALU_SLTU, ALU_SRL, ALU_SRA, ALU_COPY_A, ALU_COPY_B, ALU_XXX)

for (i <- 0 until 102) {

    val src_a  = Random.nextLong()& 0xFFFFFFFFL
    val src_b = Random.nextLong()& 0xFFFFFFFFL
    val opr = Random.nextInt(12)
    val aluop  = array_op(opr)

// ALU functional implementation using Scala match 
    val result = aluop match {
      case ALU_ADD  => src_a + src_b
      case ALU_SUB  => src_a - src_b
      case ALU_AND  => src_a & src_b
      case ALU_OR   => src_a | src_b
      case ALU_XOR  => src_a ^ src_b
      case ALU_SLT  => (src_a.toInt < src_b.toInt).toInt 
      case ALU_SLL  => src_a  << (src_b & 0x1F)
      case ALU_SLTU => (src_a < src_b).toInt
      case ALU_SRL  => src_a >> (src_b & 0x1F)
      case ALU_SRA  => src_a.toInt >> (src_b & 0x1F)
      case ALU_COPY_A => src_a 
      case ALU_COPY_B => src_b 
      case _        => 0
    }
  
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
