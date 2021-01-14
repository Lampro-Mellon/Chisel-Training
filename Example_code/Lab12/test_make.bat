
riscv64-unknown-elf-gcc -c -o main.o main.c -march=rv32i -mabi=ilp32

riscv64-unknown-elf-gcc -o program.elf main.o -T linker.ld -nostdlib -march=rv32i -mabi=ilp32

riscv64-unknown-elf-objcopy -O binary --only-section=.data* --only-section=.text* program.elf main.bin

hexdump main.bin > main.hex

python maketxt.py >> main.txt

riscv64-unknown-elf-objdump -S -s program.elf > program.dump



