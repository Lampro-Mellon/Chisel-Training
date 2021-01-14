
riscv64-unknown-elf-gcc -c -o build/main.o src/main.c -march=rv32i -mabi=ilp32

riscv64-unknown-elf-as -c -o build/startup.o src/startup.s -march=rv32i -mabi=ilp32

riscv64-unknown-elf-as -c -o build/isr.o src/isr.s -march=rv32i -mabi=ilp32

riscv64-unknown-elf-gcc -o build/program.elf build/startup.o build/isr.o build/main.o -T linker.ld -nostdlib -march=rv32i -mabi=ilp32

riscv64-unknown-elf-objcopy -O binary --only-section=.data* --only-section=.text* build/program.elf build/main.bin

hexdump build/main.bin > build/main.hex

python maketxt.py build/main.bin > build/main.txt

riscv64-unknown-elf-objdump -S -s build/program.elf > build/program.dump



