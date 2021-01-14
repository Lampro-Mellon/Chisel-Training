import chisel3.Module
import freechips.rocketchip.config.{Parameters, Config}
import junctions._

class MiniConfig extends Config((site, here, up) => {
    // Core
  case XLEN => 32
  case Trace => true
  case BuildALU    => (p: Parameters) => Module(new ALUArea()(p))
  case BuildImmGen => (p: Parameters) => Module(new ImmGenWire()(p))
  case BuildBrCond => (p: Parameters) => Module(new BrCondArea()(p))

...