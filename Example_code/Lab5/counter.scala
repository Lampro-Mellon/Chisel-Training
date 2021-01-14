import chisel3._
import chisel3.stage.ChiselStage

class Counter(size: Int, maxValue: UInt) extends Module {
val io = IO(new Bundle {
val result = Output(Bool())
})

// 'genCounter' with counter size 'n'
def genCounter(n: Int, max: UInt) = {  
val count = RegInit(0.U(n.W))

when(count === max) {
count := 0.U
}.otherwise { count := count + 1.U }
count
}

// genCounter instantiation
val counter1 = genCounter(size, maxValue)
val counter2 = genCounter(size + size, maxValue)    
io.result := counter1(size-1) & counter2(0)  
}

println((new ChiselStage).emitVerilog(new Counter(8, 255.U)))