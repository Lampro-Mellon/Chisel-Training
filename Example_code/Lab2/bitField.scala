// Bitfield manipulations
val xMSB = x(31)        // when x is 32-bit 
val yLowByte = y(7, 0)  // y is atleat 8-bit  

// concatenates bitfields with first operand on left
val address = Cat(highByte, lowByte)  

// replicate a string multiple times
val duplicate = Fill(2, "b1010".U) // "b10101010".U

// Bitfield reductions
val data = "b00111010".U
val allOnes = data.andR            // performs AND reduction
val anyOne = data.orR	            // performs OR reduction
val parityCheck = data.xorR       // performs XOR reduction