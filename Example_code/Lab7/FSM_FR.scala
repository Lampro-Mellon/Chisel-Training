import chisel3._
import chisel3.util._
import chisel3.iotesters.{ChiselFlatSpec,Driver,PeekPokeTester}

class SimpleFsm extends Module {
val io = IO(new Bundle {
  val forward1 = Input (Bool())
  val forward2 = Input (Bool())
  val reverse1 = Input (Bool())
  val reverse2 = Input (Bool())
  val out = Output (UInt())
})
  
  io. out := 0.U
  
  // The six states
  val s0 :: s1 :: s2 :: s3 :: s4 :: s5 :: Nil = Enum (6)
  
  // The state register
  val stateReg = RegInit (s0)
  
  // Next state logic
switch ( stateReg ) {
  is (s0) {
    when(io.forward1)       {stateReg := s1}
    .elsewhen(io.forward2)  {stateReg := s5}
    .otherwise              {stateReg := s0}
  }
  
  is ( s1 ) {
    when(io.forward1)       {stateReg := s2}
    .elsewhen(io.reverse1)  {stateReg := s0}
    .otherwise              {stateReg := s1}
  }
  
  is ( s2 ) {
    when(io.forward1)       {stateReg := s3}
    .elsewhen(io.reverse1)  {stateReg := s1}
    .otherwise              {stateReg := s2}
  }
  
  is ( s3 ) {
    stateReg := s0
  }
  
  is ( s4 ) {
    when(io.forward2)       {stateReg := s3}
    .elsewhen(io.reverse2)  {stateReg := s5}
    .otherwise              {stateReg := s4}
  }
  
  is ( s5 ) {
    when(io.forward2)       {stateReg := s4}
    .elsewhen(io.reverse2)  {stateReg := s0}
    .otherwise              {stateReg := s5}
  }
}
// Output logic
io. out := Mux(stateReg===s2, 3.U, Mux(stateReg===s4, 7.U, 0.U))
}

println(chisel3.Driver.emitVerilog(new SimpleFsm))
