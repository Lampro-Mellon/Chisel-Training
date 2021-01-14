// CSR register file
  val csrFile = Seq(
    BitPat(CSR.CYCLE)     -> cycle,
    BitPat(CSR.TIME)      -> time,
    BitPat(CSR.INSTRET)   -> instret,
    BitPat(CSR.CYCLEH)    -> cycleh,
    BitPat(CSR.TIMEH)     -> timeh,
    BitPat(CSR.INSTRETH)  -> instreth,
    BitPat(CSR.MTVEC)     -> mtvec,
    BitPat(CSR.MIE)       -> mie.asUInt,
    BitPat(CSR.MSCRATCH)  -> mscratch,
    BitPat(CSR.MEPC)      -> mepc,
    BitPat(CSR.MCAUSE)    -> mcause,
    BitPat(CSR.MTVAL)     -> mtval,
    BitPat(CSR.MIP)       -> mip.asUInt,
    BitPat(CSR.MSTATUS)   -> mstatus.asUInt,
    BitPat(CSR.MISA)      -> misa
  )

  // reading CSR,  
  io.out := Lookup(csr_addr, 0.U, csrFile).asUInt