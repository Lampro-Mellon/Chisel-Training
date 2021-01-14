import chisel3._

class Counter(counterBits: UInt) extends Module {
val max = (1.U << counterBits) - 1.U
val count = RegInit(0.U(16.W))

when(count === max) {
count := 0.U
}.otherwise{
count := count + 1.U
}
println(s"counter created with max value $max")
}