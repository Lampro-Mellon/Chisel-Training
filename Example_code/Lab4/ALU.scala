
 package LM_Chisel

import chisel3._
import chisel3.util._
import ALUOP._

trait Config {
  // global config parameters
  val WLEN           = 32
  val XLEN           = 32

  // control signal's width
  val ALU_SRC_SIG_LEN       = 1
  val ALUOP_SIG_LEN         = 4  
}

object ALUOP {
  // ALU Operations, may expand/modify in future 
  val ALU_ADD    = 0.U(4.W)
  val ALU_SUB    = 1.U(4.W)
  val ALU_AND    = 2.U(4.W)
  val ALU_OR     = 3.U(4.W)
  val ALU_XOR    = 4.U(4.W)
  val ALU_SLT    = 5.U(4.W)
  val ALU_SLL    = 6.U(4.W)
  val ALU_SLTU   = 7.U(4.W)
  val ALU_SRL    = 8.U(4.W)
  val ALU_SRA    = 9.U(4.W)
  val ALU_COPY_A = 10.U(4.W)
  val ALU_COPY_B = 11.U(4.W)
  val ALU_XXX    = 15.U(4.W)
}

class ALUio extends Bundle with Config {
  val in_A      = Input(UInt(WLEN.W))
  val in_B      = Input(UInt(WLEN.W))
  val alu_Op    = Input(UInt(ALUOP_SIG_LEN.W))
  val out       = Output(UInt(WLEN.W))
  val sum       = Output(UInt(WLEN.W))
}

class ALU extends Module with Config {
  val io = IO(new ALUio)

  val sum    = io.in_A + Mux(io.alu_Op(0), -io.in_B, io.in_B)
  val cmp    = Mux(io.in_A (XLEN-1) === io.in_B(XLEN-1), sum(XLEN-1),
                   Mux(io.alu_Op(1), io.in_B(XLEN-1), io.in_A(XLEN-1)))
  val shamt  = io.in_B(4,0).asUInt
  val shin   = Mux(io.alu_Op(3), io.in_A, Reverse(io.in_A))
  val shiftr = (Cat(io.alu_Op(0) && shin(XLEN-1), shin).asSInt >> shamt)(XLEN-1, 0)
  val shiftl = Reverse(shiftr)

  val out = 
    Mux(io.alu_Op === ALU_ADD || io.alu_Op === ALU_SUB, sum,
    Mux(io.alu_Op === ALU_SLT || io.alu_Op === ALU_SLTU, cmp,
    Mux(io.alu_Op === ALU_SRA || io.alu_Op === ALU_SRL, shiftr,
    Mux(io.alu_Op === ALU_SLL, shiftl,
    Mux(io.alu_Op === ALU_AND, (io.in_A & io.in_B),
    Mux(io.alu_Op === ALU_OR,  (io.in_A | io.in_B),
    Mux(io.alu_Op === ALU_XOR, (io.in_A ^ io.in_B), 
    Mux(io.alu_Op === ALU_COPY_A, io.in_A, io.in_B))))))))

  io.out := out
  io.sum := sum
}

 object ALU_generate extends App {
  chisel3.Driver.execute(args, () => new ALU)
} 
