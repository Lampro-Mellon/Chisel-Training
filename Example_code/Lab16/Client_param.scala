case class TLClientParameters(
  name:                String,
  sourceId:            IdRange         = IdRange(0,1),
  nodePath:            Seq[BaseNode]   = Seq(),
  requestFifo:         Boolean         = false,
  visibility:          Seq[AddressSet] = Seq(AddressSet(0, ~0)), // everything
  supportsProbe:       TransferSizes   = TransferSizes.none,
  supportsArithmetic:  TransferSizes   = TransferSizes.none,
  supportsLogical:     TransferSizes   = TransferSizes.none,
  supportsGet:         TransferSizes   = TransferSizes.none,
  supportsPutFull:     TransferSizes   = TransferSizes.none,
  supportsPutPartial:  TransferSizes   = TransferSizes.none,
  supportsHint:        TransferSizes   = TransferSizes.none){...}
