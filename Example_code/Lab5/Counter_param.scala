import chisel3._
import chisel3.iotesters.{ChiselFlatSpec,Driver,PeekPokeTester}

class Counter(size:Int, maxValue:UInt) extends Module{
val io = IO(new Bundle{
val result = Output(Bool())
})

def genCounter(n: Int, max :UInt) = {
val count = RegInit(0.U(n.W))

when(count === max){
count := 0.U
}
.otherwise 
{
count := count+1.U
}
count
}

// genCounter instantiation
val counter1 = genCounter(size,maxValue)
io.result := counter1(size-1)
}
println(chisel3.Driver.emitVerilog(new Counter(8,255.U)))
