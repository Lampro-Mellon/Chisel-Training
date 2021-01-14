// one shot timer implementation
val timer_count = RegInit(0.U(8.W))
val done = timer_count === 0.U
val next = WireInit(0.U)

when (reload){
next := din                // load the data from input
} 
.elsewhen (!done){
next := timer_count - 1.U  // decrement the timer
}
timer_count := next           // update the timer
