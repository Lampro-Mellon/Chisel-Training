class MyManager(implicit p: Parameters) extends LazyModule {
  val node = TLHelper.makeManagerNode(beatBytes, TLManagerParameters())
  lazy val module = new LazyModuleImp(this) {
    val (tl, edge) = node.in(0)
	//Reset of the code goes here
  }
}
