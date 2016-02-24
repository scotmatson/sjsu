# Macro: print_str
# Usage: print_str(<address of the string>)
.macro print_str($arg)
	li	$v0, 4
	la	$a0, $arg
	syscall
.end_macro

# Macro: read_int
# Usage: read_int(<reg>)
.macro read_int($arg)
	li	$v0, 5		#	System Call for read_int
	syscall			#	Call OS to perform operation
	move	$arg, $v0	#	Move value into register
.end_macro

# Macro: print_reg_int
# Usage: print_reg_int(<reg>)
.macro print_reg_int($arg)
	li	$v0, 1
	move	$a0, $arg
	syscall
.end_macro

.data
	msg0:		.asciiz "Enter two integers to find the product:\n"
	msg1:		.asciiz "Product: "
	exitMsg:		.asciiz "Exiting program."


.text
.globl main
main:
	# Get user input.
	print_str(msg0)
	read_int($a0)		# Integer 1
	read_int($a1)		# Integer 2

	# Caller for multiply proc, handles arithmetic
	jal multiply
	
	print_str(msg1)
	# $v0 is not returning the correct product even when using
	# the mult opcode.
	print_reg_int($v0)	# The returned product
	
	# Exit the application
	j	exit
	
# Should use a loop to add 'X',  'Y' number of times.
multiply:
		
	# DEBUG: Show the input value
	# **These are accessible
	# print_reg_int($a0)
	# print_reg_int($a1)
	
	
	slt	$t0, $zero, $a1 # if second integer > 0
	add	$a0, $a0, $a1
	add	
	
	# Even with Mult 
	mflo	$v0		# Move the result into the return register.
	jr $ra			# Return to exit the program.



exit:
	print_str(exitMsg)
	li	$v0, 10
	syscall