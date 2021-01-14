.equ CSR_MSTATUS, 0x300
.equ MSTATUS_MIE, 0x00000008
.equ CSR_MTVEC,   0x305

 # Main interrupt vector table entries
.global vtable
.type vtable, %object
.section .text.vector_table,"a",%progbits
 
# this entry is to align reset_handler at address 0x04
  .word    0x00000013        
  j        reset_handler
  .align   2
vtable:
  j        default_interrupt_handler
  .word    0
  .word    0
  j        msip_handler
  .word    0
  .word    0
  .word    0
  j        mtip_handler
  .word    0
  .word    0
  .word    0
  .word    0
  .word    0
  .word    0
  .word    0
  .word    0
  j        user_handler
  .word    0
  .word    0
  
# Weak aliases to point each exception handler to the
# 'default_interrupt_handler', unless the application defines
# a function with the same name to override the reference.

  .weak msip_handler
  .set  msip_handler, default_interrupt_handler
  .weak mtip_handler
  .set  mtip_handler, default_interrupt_handler
  .weak user_handler
  .set  user_handler, default_interrupt_handler

# Assembly 'reset handler' function to initialize core CPU registers.
.section .text.default_interrupt_handler,"ax",%progbits

.global reset_handler
.type reset_handler,@function

reset_handler:
# Set mstatus bit MIE = 1 (enable M mode interrupts)
  li      t0, 8
  csrrs   zero, CSR_MSTATUS, t0

# Load the initial stack pointer value.
  la   sp, _sp

# Set the vector table's base address.
  la   a0, vtable
  addi a0, a0, 1
  csrw CSR_MTVEC, a0

# Call user 'main(0,0)' (.data/.bss sections initialized there)
  li   a0, 0
  li   a1, 0
  call main

# A 'default' handler, in case an interrupt triggers without its handler defined
default_interrupt_handler:
  j default_interrupt_handler