import chisel3._

class AHBXbar(nMasters: Int, nSlaves: Int) extends Module {
  val io = IO(new Bundle {
    val masters = Flipped(Vec(new AHBMasterIO, nMasters))
    val slaves = Flipped(Vec(new AHBSlaveIO, nSlaves))
  })

  val buses = List.fill(nMasters) { Module(new AHBBus(nSlaves)) }
  val muxes = List.fill(nSlaves) { Module(new AHBSlaveMux(nMasters)) }

  // master and slave external IO connections
  (buses.map(b => b.io.master) zip io.masters) foreach { case (b, m) => b <> m }
  (muxes.map(m => m.io.out) zip io.slaves) foreach { case (x, s)     => x <> s }

  // internal wiring of the Xbar
  for (m <- 0 until nMasters; s <- 0 until nSlaves) yield {
    buses(m).io.slaves(s) <> muxes(s).io.ins(m)
  }
}