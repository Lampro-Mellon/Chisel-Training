// data bits without valid signal
class DataWithoutValid extends Bundle {
  val data_bits = Output(UInt(8.W))
}

class DataWithValid extends Bundle {
  val valid  = Output(Bool())
  val data   = Output(new DataWithoutValid)
}