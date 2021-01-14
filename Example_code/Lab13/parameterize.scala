import chisel3._
import chisel3.util._
import chisel3.experimental.{BaseModule}

// Define IO interface as a Trait
trait ModuleIO {
    def in1: UInt
    def in2: UInt
    def out: UInt
}

class Add extends RawModule with ModuleIO {
    val in1 = IO(Input(UInt(8.W)))
    val in2 = IO(Input(UInt(8.W)))
    val out = IO(Output(UInt(8.W)))
    out := in1 + in2
}

class Sub extends RawModule with ModuleIO {
    val in1 = IO(Input(UInt(8.W)))
    val in2 = IO(Input(UInt(8.W)))
    val out = IO(Output(UInt(8.W)))
    out := in1 - in2
}

class Top [T <: BaseModule with ModuleIO] (genT: => T) extends Module {
    val io = IO(new Bundle {
        val in1 = Input(UInt(8.W))
        val in2 = Input(UInt(8.W))
        val out = Output(UInt(8.W))
    })
    val sub_Module = Module(genT)
    io.out := sub_Module.out
    sub_Module.in1 := io.in1
    sub_Module.in2 := io.in2
}

// Generate verilog for two modules, one for addition, second for subtraction
println((new chisel3.stage.ChiselStage).emitVerilog(new Top(new Add)))
println((new chisel3.stage.ChiselStage).emitVerilog(new Top(new Sub)))