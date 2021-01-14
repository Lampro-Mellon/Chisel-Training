\\Left Or
class LeftOR extends Module {
  val io = IO(new LM_IO_Interface)
  
  def leftOR(x: UInt): UInt = {
    val width = x.getWidth
    val stop = width
    def helper(s: Int, x: UInt): UInt =
      if (s >= stop) x else helper(s+s, x | (x << s)(width-1,0))
    helper(1, x)(width-1, 0)
  }
  
  io.out := leftOR(io.in)
}

class LM_IO_Interface extends Bundle {
  val in  = Input(UInt(8.W))
  val out = Output(UInt())
}
