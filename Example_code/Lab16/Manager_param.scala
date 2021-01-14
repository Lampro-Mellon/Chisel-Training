case class TLManagerParameters(
  address:           Seq[AddressSet],
  resources:         Seq[Resource] = Seq(),
  regionType:        RegionType.T  = RegionType.GET_EFFECTS,
  executable:        Boolean       = false,
  nodePath:          Seq[BaseNode] = Seq(),
  supportsAcquireT:  TransferSizes = TransferSizes.none,
  supportsAcquireB:  TransferSizes = TransferSizes.none,
  supportsArithmetic:TransferSizes = TransferSizes.none,
  supportsLogical:   TransferSizes = TransferSizes.none,
  supportsGet:       TransferSizes = TransferSizes.none,
  supportsPutFull:   TransferSizes = TransferSizes.none,
  supportsPutPartial:TransferSizes = TransferSizes.none,
  supportsHint:      TransferSizes = TransferSizes.none,
  mayDenyGet:        Boolean = false, // applies to: AccessAckData, GrantData
  mayDenyPut:        Boolean = false, // applies to: AccessAck,     Grant,    HintAck
  alwaysGrantsT:     Boolean = false, // typically only true for CacheCork'd read-write devices
  fifoId:            Option[Int] = None,
  device: Option[Device] = None){...}
