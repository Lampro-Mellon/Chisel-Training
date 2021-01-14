val arb_noPriority = Module(new RRArbiter(UInt(), 3))

// connect the inputs to different producers
arb_noPriority.io.in(0) <> producer0.io.out
arb_noPriority.io.in(1) <> producer1.io.out
arb_noPriority.io.in(2) <> producer2.io.out

// connect the output to consumer
consumer.io.in <> arb_noPriority.io.out