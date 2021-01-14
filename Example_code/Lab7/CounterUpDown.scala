// up-down counter implementation

package LM_Chisel

import chisel3._
import chisel3.util._

class CounterUpDown(n: Int) extends Module {
val io = IO(new Bundle {
val data_in = Input(UInt(n.W))
val out = Output(Bool())})

val counter = RegInit(0.U(n.W))
val max_count = RegInit(6.U(n.W))

val init :: up :: down :: Nil = Enum(3)   // Enumeration type 
val state = RegInit(init)                 // state = init
val up_flag = (counter === max_count)
val down_flag = (counter === 0.U)

switch (state) {  
   is (init) {
      state := up                         // on reset
   }

   is (up) {
      when (up_flag) { 
        state := down
        // start count down immediately on up_flag
        counter := counter - 1.U  
      }.otherwise {
        counter := counter + 1.U   
      }   
    }

  is (down) {
      when (down_flag) { 
        state := up
        counter := counter + 1.U  
        max_count := io.data_in    // load the counter
      }.otherwise {
        counter := counter - 1.U  
      } 
    }
  }
  io.out := up_flag | down_flag
}
object CounterUpDown_generate extends App {
  chisel3.Driver.execute(args, () => new CounterUpDown(8))
} 

