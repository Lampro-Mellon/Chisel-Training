object MuxMain extends App {
  iotesters.Driver.execute(args, () => new Mux_for_tester) {
    c => new Tester_Mux(c)
  }
}
