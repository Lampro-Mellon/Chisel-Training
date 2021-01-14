class MyClient(implicit p: Parameters) extends LazyModule {
  val node = TLHelper.makeClientNode(TLClientParameters())
  lazy val module = new LazyModuleImp(this) {
    val (tl, edge) = node.out(0)
    // Rest of code here
  }
}

