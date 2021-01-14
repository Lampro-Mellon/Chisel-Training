import ALUOP._

trait Config {
  // global config parameters
  val WLEN             = 32
  val XLEN             = 32
  val ALUOP_SIG_LEN    = 4  // control signal's width
}

class AluIO extends Bundle with Config {
  val in_A      = Input(UInt(WLEN.W))
  val in_B      = Input(UInt(WLEN.W))
  val alu_Op    = Input(UInt(ALUOP_SIG_LEN.W))
  val out       = Output(UInt(WLEN.W))
}
