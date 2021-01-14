// The set of states
val s0 :: s1 :: s2 :: s3 :: s4 :: Nil = Enum(5)
  
// The state register
val state = RegInit(s0)
  
// Next state logic
switch (state) {
  is (s0){
    // state transition logic for s0
    // corresponds to outgoing arrows from s0
  }
  
  is (s1) {
    
  }
  
   ...

  is (s4) {
    // state transition logic for s4
  }
}