def decode(inst: UInt, table: Iterable[(BitPat, List[BitPat])]) = {

val decoder = DecodeLogic(inst, default, table)
val sigs = Seq(legal, fp, rocc, branch, jal, jalr, rxs2, rxs1, scie, 
               sel_alu2, sel_alu1, sel_imm, alu_dw, alu_fn, mem, mem_cmd, rfs1, 
               rfs2, rfs3, wfd, mul, div, wxd, csr, fence_i, fence, amo, dp)

    sigs zip decoder map {case(s, d) => s := d}
    this
}
