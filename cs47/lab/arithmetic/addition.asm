.include "../cs47_macro.asm"

.data
	# Input block.
	msg0:		.asciiz "Enter two integers to find their sum.\n"
	msg1:		.asciiz "First integer: "
	msg2:		.asciiz "Second integer: "
	
	# Output block.
	msg3:		.asciiz "Addition of two integers:\n"
	addSign:	.asciiz " + "	
	eqlSign:	.asciiz " = "
	newLn:		.asciiz "\n"

.text
.globl main
main:
	# Instructions.
	print_str(msg0)
	
	# First integer.
	print_str(msg1)
	read_int($t0)
	
	# Second integer.
	print_str(msg2)
	read_int($t1)
	print_str(newLn)
	
	# Sum the integers. 
	add $t3, $t0, $t1
	
	# Output the summation.
	print_str(msg3)
	print_reg_int($t0)
	print_str(addSign)
	print_reg_int($t1)
	print_str(eqlSign)
	print_reg_int($t3)
	
	# System exit.
	exit