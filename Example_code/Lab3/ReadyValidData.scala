class ReadyValidIO[T <: Data](gen: T) extends Bundle {
val ready = Input(Bool())
val valid = Output(Bool())
val bits = Output(gen)
}
