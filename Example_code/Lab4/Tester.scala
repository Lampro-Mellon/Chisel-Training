class Tester_Mux(c: Mux_for_tester) extends PeekPokeTester(c) {
  poke(c.io.in(0),0)   
  poke(c.io.in(1),1)
  poke(c.io.sel,0)
  expect(c.io.out,0)
// + operator concatenates both the strings
  println("The output is:" + peek(c.io.out))
  
  poke(c.io.in(0),0)   
  poke(c.io.in(1),1)
  poke(c.io.sel,1)
  expect(c.io.out,1)
// Another way of printing data
  println(s"The output is: ${peek(c.io.out)}")
}
