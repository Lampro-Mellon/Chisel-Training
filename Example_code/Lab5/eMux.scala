// parametrized Mux
def eMux[T <: Data](select: Bool, in_t: T, in_f: T): T = {
val ret = Wire(in_f.cloneType)
ret := in_f
when (select) {
ret := in_t
}
ret  // retuen value
}