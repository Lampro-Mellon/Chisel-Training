
// Different parameters defined as case objects in core.scala  
case object XLEN extends Field[Int]
case object Trace extends Field[Boolean]
case object BuildALU extends Field[Parameters => ALU]
case object BuildImmGen extends Field[Parameters => ImmGen]
case object BuildBrCond extends Field[Parameters => BrCond]
