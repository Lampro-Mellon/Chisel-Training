class TestALU(c: ALU) extends PeekPokeTester(c) {
// ALU operations
val array_op = Array(ALU_ADD , ALU_SUB, ALU_AND, ALU_OR, ALU_XOR,      ALU_SLT, ALU_SLL, ALU_SLTU, ALU_SRL, ALU_SRA, ALU_COPY_A, ALU_COPY_B, ALU_XXX)

for (i <- 0 until 100) {

    val src_a = Random.nextLong()& 0xFFFFFFFFL
    val src_b = Random.nextLong()& 0xFFFFFFFFL
    val opr   = Random.nextInt(12)
    val aluop = array_op(opr)

// ALU functional implementation using Scala match 
    val result = aluop match {
      case ALU_ADD  => src_a + src_b
      case ALU_SUB  => src_a - src_b
      case ALU_AND  => src_a & src_b
      case ALU_OR   => src_a | src_b
      case ALU_XOR  => src_a ^ src_b
      case ALU_SLT  => (src_a.toInt < src_b.toInt).toInt 
      case ALU_SLL  => src_a  << (src_b & 0x1F)
      case ALU_SLTU => (src_a < src_b).toInt
      case ALU_SRL  => src_a >> (src_b & 0x1F)
      case ALU_SRA  => src_a.toInt >> (src_b & 0x1F)
      case ALU_COPY_A => src_a 
      case ALU_COPY_B => src_b 
      case _        => 0
    }
  
  