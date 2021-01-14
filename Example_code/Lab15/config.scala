// An instantiation of MiniConfig
val params = (new MiniConfig).toInstance
val chirrtl = firrtl.Parser.parse(chisel3.Driver.emit(() => new Tile(params)))


// Tile top module
class Tile(tileParams: Parameters) extends Module with TileBase {
  implicit val p = tileParams
  val io     = IO(new TileIO)
  val core   = Module(new Core)
