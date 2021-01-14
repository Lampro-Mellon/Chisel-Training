import chisel3._
import chisel3.util._
import chisel3.iotesters.{ChiselFlatSpec,Driver,PeekPokeTester}

class My_Queue extends Module{
      val io  = IO(new Bundle {
      val in  = Flipped(Decoupled(UInt(8.W))) //valid = Input,  ready = Output, bits = Input 
      val out = Decoupled(UInt(8.W))          //valid = Output, ready = Input , bits = Output
    })
    val queue  = Queue(io.in, 5)                          // 5-element queue
    val w1     = Wire(Flipped(Decoupled(UInt(8.W))))      //valid = Input,  ready = Output, bits = Input   
    w1 <> queue
    val queue1 = Queue(w1, 5)                             // 5-element queue
    io.out <> queue1
}
