class BranchControl extends Module {
  val io = IO(new LM_IO_Interface)

  io.br_taken := DontCare
  val cond_true = Wire(Bool())
  cond_true := DontCare

  switch(io.fnct3) {
    is("b000".U) {cond_true := (io.arg_x === io.arg_y)}              //beq
    is("b001".U) {cond_true := (io.arg_x =/= io.arg_y)}              //bne
    is("b100".U) {cond_true := (io.arg_x.asSInt < io.arg_y.asSInt)}  //blt
    is("b101".U) {cond_true := (io.arg_x.asSInt >= io.arg_y.asSInt)} //bge
    is("b110".U) {cond_true := (io.arg_x < io.arg_y)}                //bltu
    is("b111".U) {cond_true := (io.arg_x >= io.arg_y)}               //bgeu
  }
  io.br_taken := cond_true & io.branch
}
class LM_IO_Interface extends Bundle {
    val fnct3     = Input(UInt(3.W))
    val branch    = Input(Bool())
    val arg_x     = Input(UInt(32.W))
    val arg_y     = Input(UInt(32.W))
    val br_taken  = Output(Bool())
}
