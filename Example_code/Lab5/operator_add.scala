// Implement addition operation
object UserOperator1 extends App {
println((new chisel3.stage.ChiselStage).emitVerilog(new Operator(2, UInt(16.W))(_ + _)))
}

