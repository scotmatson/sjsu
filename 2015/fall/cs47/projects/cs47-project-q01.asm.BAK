#################################################################
# RANDOM ACCESS MEMORY						#
#################################################################
.data
instructions:	.asciiz "Enter two integers and an arithmetic operation to see the its result.\n"
firstInt:	.asciiz "Enter the first integer: "
secondInt:	.asciiz "Enter the second integer: "
operation:	.asciiz "Enter a mathematical operation to be performed ('+', '-', '*', '/'): "
outMsg:		.asciiz "\nResult of "
strBuffer:	.space	4
addOp:		.byte	'+'
subOp:		.byte	'-'
mulOp:		.byte	'*'
divOp:		.byte	'/'
eqlOp:		.asciiz	" = "
remOp:		.asciiz " r: "
delimiter:	.asciiz " "

exitMsg:	.asciiz	"\n\nTerminating application."
badInput:	.asciiz "\nAn unreadable input was received. Unable to process your request."
dbzErr:		.asciiz	"\nDivide by zero error."

# TESTING MESSAGES
addMsg:		.asciiz "This was addition."
subMsg:		.asciiz "This was subtraction."
mulMsg:		.asciiz "This was multiplication."
divMsg:		.asciiz "This was division."

#################################################################
# APPLICATION INSTRUCTION SET					#
#################################################################
.text
main:
	# Print the application instructions.
	li	$v0, 4
	la	$a0, instructions
	syscall
	
	# Prompt the user for the first integer.
	li	$v0, 4
	la	$a0, firstInt
	syscall
	li	$v0, 5
	syscall
	move	$s0, $v0
	
	# Prompt the user for the second integer
	li	$v0, 4
	la	$a0, secondInt
	syscall
	li	$v0, 5
	syscall
	move	$s1, $v0
	
	# Prompt the user for an arithmetic operation.
	li	$v0, 4
	la	$a0, operation
	syscall
	li	$v0, 12
	syscall

	# Parse the character input and carry out the command.
	addi	$a0, $v0, 0
	jal parseOp
	
	# Notify user of application termination.
	li	$v0, 4
	la	$a0, exitMsg
	syscall
	
	# Signal the OS to exit the application.
	li	$v0, 10
	syscall
	
#################################################################
#	ARITHMETIC OPERATIONS					#
#################################################################
parseOp:
	# Read known arithmetic operations.
	lb	$t0, addOp
	lb	$t1, subOp
	lb	$t2, mulOp
	lb	$t3, divOp
	
	# Compare user input against known operations.
	beq	$a0, $t0, add_normal
	beq	$a0, $t1, sub_normal
	beq	$a0, $t2, mul_normal
	beq	$a0, $t3, div_normal
	
	# Notify user if an invalid input was received.
	j	invalidInputException
	
#---------------------------------------------------------------#
add_normal:
	# Find the sum of two integers.
	add	$s2, $s0, $s1
	# Print the results.
	li	$v0, 4
	la	$a0, outMsg
	syscall
	li	$v0, 1
	move	$a0, $s0
	syscall
	li	$v0, 4
	la	$a0, delimiter
	syscall
	li	$v0, 11
	lb	$a0, addOp
	syscall
	li	$v0, 4
	la	$a0, delimiter
	syscall
	li	$v0, 1
	move	$a0, $s1
	syscall
	li	$v0, 4
	la	$a0, eqlOp
	syscall
	li	$v0, 1
	move	$a0, $s2
	syscall
	jr	$ra

#---------------------------------------------------------------#
sub_normal:
	# Find the difference of two integers.
	sub	$s2, $s0, $s1
	# Print the results.
	li	$v0, 4
	la	$a0, outMsg
	syscall
	li	$v0, 1
	move	$a0, $s0
	syscall
	li	$v0, 4
	la	$a0, delimiter
	syscall
	li	$v0, 11
	lb	$a0, subOp
	syscall
	li	$v0, 4
	la	$a0, delimiter
	syscall
	li	$v0, 1
	move	$a0, $s1
	syscall
	li	$v0, 4
	la	$a0, eqlOp
	syscall
	li	$v0, 1
	move	$a0, $s2
	syscall
	jr	$ra

#---------------------------------------------------------------#
mul_normal:
	# Find the product of two integers.
	mult	$s0, $s1
	mflo	$s2
	# Print the results.
	li	$v0, 4
	la	$a0, outMsg
	syscall
	li	$v0, 1
	move	$a0, $s0
	syscall
	li	$v0, 4
	la	$a0, delimiter
	syscall
	li	$v0, 11
	lb	$a0, mulOp
	syscall
	li	$v0, 4
	la	$a0, delimiter
	syscall
	li	$v0, 1
	move	$a0, $s1
	syscall
	li	$v0, 4
	la	$a0, eqlOp
	syscall
	li	$v0, 1
	move	$a0, $s2
	syscall
	jr	$ra

#---------------------------------------------------------------#
div_normal:
	# Handle divide by zero.
	beq	$s1, 0, divideByZero
	
	# Find the quotient of two integers.
	div	$s0, $s1
	mflo	$s2
	mfhi	$s3
	# Print the results.
	li	$v0, 4
	la	$a0, outMsg
	syscall
	li	$v0, 1
	move	$a0, $s0
	syscall
	li	$v0, 4
	la	$a0, delimiter
	syscall
	li	$v0, 11
	lb	$a0, divOp
	syscall
	li	$v0, 4
	la	$a0, delimiter
	syscall
	li	$v0, 1
	move	$a0, $s1
	syscall
	li	$v0, 4
	la	$a0, eqlOp
	syscall
	li	$v0, 1
	move	$a0, $s2
	syscall
	li	$v0, 4
	la	$a0, remOp
	syscall
	li	$v0, 1
	move	$a0, $s3
	syscall
	jr	$ra

#################################################################
#	ERROR HANDLING						#
#################################################################
invalidInputException:
	li	$v0, 4
	la	$a0, badInput
	syscall
	jr	$ra

#---------------------------------------------------------------#
divideByZero:
	li	$v0, 4
	la	$a0, dbzErr
	syscall
	jr	$ra
#***************************************************************#
#	END OF FILE						#
#***************************************************************#
