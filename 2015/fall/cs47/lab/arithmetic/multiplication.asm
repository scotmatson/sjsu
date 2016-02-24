.include "../cs47_macro.asm"

.data
	# Input block.
	msg0:		.asciiz "Enter two integers to be multiplied.\n"
	msg1:		.asciiz "First integer: "
	msg2:		.asciiz "Second integer: "
	
	# Output block.
	msg3:		.asciiz "The product of two integers is:\n"
	multSign:	.asciiz " * "
	eqlSign:	.asciiz " = "
	hiVal:		.asciiz "hi: "
	loVal:		.asciiz "lo: "
	comma:		.asciiz ", "
	newLn:		.asciiz "\n"

.text
.globl main
main:
	# Program instruction.
	print_str(msg0)
	
	# First integer
	print_str(msg1)
	read_int($t1)
	
	# Second integer
	print_str(msg2)
	read_int($t2)
	
	# Multiply two integers.
	mult	$t1, $t2
	
	# Print the product of two integers.
	print_str(msg3)
	print_reg_int($t1)
	print_str(multSign)
	print_reg_int($t2)
	print_str(eqlSign)
	
	print_str(hiVal)
	mfhi $t1
	print_reg_int($t1)
	print_str(comma)
	print_str(loVal)
	mflo $t2
	print_reg_int($t2)
	
	# System exit.
	exit