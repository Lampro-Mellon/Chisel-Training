// constant/literal definitions

val x1 = 23.S(32.W)     // x1 = 0x0000 0017 
//.W with a constant value is used to define with of x1. If round backets are left empty then width will be inferred 
    
val y1 = (23.U).asSInt  // y1 = 23, width inferred //.asSInt is used to convert into signed integer.
