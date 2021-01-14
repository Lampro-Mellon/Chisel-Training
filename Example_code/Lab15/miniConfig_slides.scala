import chisel3.Module
import freechips.rocketchip.config.{Parameters, Config}

class MiniConfig extends Config((site, here, up) => {
  case XLEN => 32
  case Trace => true
  case BuildALU    => (p: Parameters) => Module(new ALUArea()(p))
...
}

// Different parameters defined as case objects in core.scala  
case object XLEN extends Field[Int]
case object Trace extends Field[Boolean]
case object BuildALU extends Field[Parameters => ALU]
