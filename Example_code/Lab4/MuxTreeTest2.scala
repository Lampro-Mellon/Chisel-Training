// object for tester class 
object MuxT_Main extends App {
 iotesters.Driver.execute(Array("--is-verbose", "--generate-vcd-output",  
   "on"), () => new MuxTree) {
    c => new TestMuxT(c)
  } 
}
