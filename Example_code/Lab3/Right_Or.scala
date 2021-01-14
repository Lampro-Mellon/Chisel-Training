\\Right Or
class RightOR extends Module {
  val io = IO(new LM_IO_Interface)
  
  def rightOR(x: UInt): UInt = {
    val width = x.getWidth
    val stop = width
    def helper(s: Int, x: UInt): UInt =
      if (s >= stop) x else helper(s+s, x | (x >> s))
    helper(1, x)(width-1, 0)
  }
  
  io.out := rightOR(io.in)
}

class LM_IO_Interface extends Bundle {
  val in  = Input(UInt(8.W))
  val out = Output(UInt())
}
