.include "../cs47_macro.asm"

.data
	# Input block.
	msg0:		.asciiz "Enter two integer values to be subtracted.\n"
	msg1:		.asciiz "First integer: "
	msg2:		.asciiz "Second integer: "
	
	# Output block.
	msg3:		.asciiz "The difference of two integers:\n"
	subSign:	.asciiz " - "
	eqlSign:	.asciiz " = "
	newLn:		.asciiz "\n"

.text
.globl main
main:
	# Program instruction.
	print_str(msg0)
	
	# First integer.
	print_str(msg1)
	read_int($t0)
	
	# Second integer.
	print_str(msg2)
	read_int($t1)
	print_str(newLn)
	
	# Subtract the integers.
	sub	$t2, $t0, $t1
	
	# Print the difference of integers.
	print_str(msg3)
	print_reg_int($t0)
	print_str(subSign)
	print_reg_int($t1)
	print_str(eqlSign)
	print_reg_int($t2)
	
	# System exit.
	exit
	