abstract trait CoreParams {
implicit val p: Parameters
val xlen = p(XLEN)
}
