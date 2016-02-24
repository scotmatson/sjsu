.include "cs47_macro.asm"

# Application program
# Data segment definition
.data
	str:	.asciiz "The answer is = "

# Code segment definition
.text
.globl main
main:	print_str(str)
	print_int(5)
	exit