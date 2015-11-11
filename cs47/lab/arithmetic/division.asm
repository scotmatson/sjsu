.include "../cs47_macro.asm"

.data
	# Input block.
	msg0:		.asciiz "Enter two integers to divide.\n"
	msg1:		.asciiz "First integer: "
	msg2:		.asciiz "Second integer: "
	
	# Output block.
	msg3:		.asciiz "The quotient of two integers:\n"
	divSign:	.asciiz " / "
	eqlSign:	.asciiz " = "
	hiVal:		.asciiz "hi: "
	loVal:		.asciiz "lo: "
	comma:		.asciiz ", "
	newLn:		.asciiz "\n"

.text
.globl main
main:
	# Application instruction.
	print_str(msg0)
	
	# First integer.
	print_str(msg1)
	read_int($t1)
	
	# Second integer.
	print_str(msg2)
	read_int($t2)
	print_str(newLn)
	
	# Divide the integers.
	div	$t1, $t2
	
	# Print the quotient of two integers.
	print_str(msg3)
	print_reg_int($t1)
	print_str(divSign)
	print_reg_int($t2)
	print_str(eqlSign)
	
	print_str(hiVal)
	mfhi	$t1
	print_reg_int($t1)
	print_str(comma)
	print_str(loVal)
	mflo	$t1
	print_reg_int($t1)
	
	# System exit
	exit