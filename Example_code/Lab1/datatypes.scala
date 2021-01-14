	// signal definitions
	val s1 = WireInit(true.B) // Bool, initialized 
	val s2 = Wire(Bool())     // Bool, uninitialized

	val x1 = WireInit(-45.S(8.W)) // SInt, initialized 8-bit
	val x2 = WireInit(-45.S) // SInt, initialized width inferred 
	val x3 = Wire(SInt()) // SInt, uninitialized width inferred 

	val y1 = WireInit(102.U(8.W)) // UInt, initialized 8-bit 
	val y2 = WireInit(102.U) // UInt, initialized width inferred 
	val y3 = Wire(UInt()) // UInt, uninitialized width inferred

	val z1 = Wire(Bits()) // Bits, uninitialized width inferred
	val z2 = Wire(Bits(16.W)) // Bits, uninitialized 16-bit 