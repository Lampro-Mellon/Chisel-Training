object Control {
 
  val default =
    //                                                            kill                        wb_en  illegal?  en_rs2
    //            pc_sel  A_sel  B_sel  imm_sel   alu_op   br_type |  st_type ld_type wb_sel  | csr_cmd | en_rs1 |
    //              |       |      |     |          |          |   |     |       |       |    |  |      |  |    |
             List(PC_4,  A_XXX, B_XXX, IMM_X, ALU_XXX   , BR_XXX, N, ST_XXX, LD_XXX, WB_ALU, N, CSR.Z, Y, N,   N)
  val map = Array(
    LUI   -> List(PC_4  , A_PC, B_IMM, IMM_U, ALU_COPY_B, BR_XXX, N, ST_XXX, LD_XXX, WB_ALU, Y, CSR.Z, N, N,   N),
    AUIPC -> List(PC_4  , A_PC, B_IMM, IMM_U, ALU_ADD   , BR_XXX, N, ST_XXX, LD_XXX, WB_ALU, Y, CSR.Z, N, N,   N),
    JAL   -> List(PC_ALU, A_PC, B_IMM, IMM_J, ALU_ADD   , BR_XXX, Y, ST_XXX, LD_XXX, WB_PC4, Y, CSR.Z, N, N,   N),
    JALR  -> List(PC_ALU, A_RS1,B_IMM, IMM_I, ALU_ADD   , BR_XXX, Y, ST_XXX, LD_XXX, WB_PC4, Y, CSR.Z, N, Y,   N),