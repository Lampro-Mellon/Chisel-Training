// Implement AND operation
object UserOperator2 extends App {
println((new chisel3.stage.ChiselStage).emitVerilog(new Operator(3, UInt(8.W))(_ & _)))
}

