// eMux illustration
val in_t = Wire(new ComplexData)
in_t.data := 3442.U
in_t.addr := 120.U
in_t.flag := true.B

val in_f = Wire(new ComplexData)
in_f.data := 45367.U
in_f.addr := 170.U
in_f.flag := false.B

// The mulitplexer with complex data type
val result = eMux(sel , in_t, in_f)