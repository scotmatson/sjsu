.include "cs47_macro.asm"

# Application Program

# Data segment definition
.data
msg1:		.asciiz "Please enter a number? "
msg2:		.asciiz "You have entered # "
newline:	.asciiz "\n"

# Code segment definition
.text
.globl main
main:	print_str(msg1)
	read_int($t1)
	print_str(msg2)
	print_reg_int($t1)
	print_str(newline)
	exit