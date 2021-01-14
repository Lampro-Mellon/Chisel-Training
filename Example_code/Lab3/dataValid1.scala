// data bits without valid signal
class DataWithoutValid extends Bundle {
  val data_bits = Output(UInt(8.W))
}

// data bits with valid signal
val DataWithValid = Valid(new DataWithoutValid)