// Seq and MuxLookup for indexing load opeartion
val raw_data = io.dmem.rdata
val ld_data = MuxLookup(ld_type, 0.U, 
                      Seq(LD_LW  -> raw_data.zext,
                          LD_LH  -> raw_data(15, 0).asSInt, 
                          LD_LB  -> raw_data(7, 0).asSInt,
                          LD_LHU -> raw_data(15, 0).zext,   
                          LD_LBU -> raw_data(7, 0).zext))