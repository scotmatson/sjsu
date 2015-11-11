.data
prompt:		.asciiz "Enter a positive integer to indicate how many Fibonacci numbers to store in the stack..\n"
cursor:		.asciiz ">> "
endMsg:		.asciiz	"Sequence Completed.\n"
error:		.asciiz "A Fibonacci sequence must have at least 1 value. No numbers were pushed to the stack."
result:		.asciiz "\n**Printing Fibonacci sequence from the stack.**\n"
delimit:	.asciiz " "

.text
main:
	# User prompt.
	li	$v0, 4
	la	$a0, prompt
	syscall
	
	li	$v0, 4
	la	$a0, cursor
	syscall
	
	# Get user input.
	li	$v0, 5
	syscall
	
	# Start fibonacci procedure
	move	$s0, $v0
	jal fibonacci
	
	# Notify user of completed sequence.
	li	$v0, 4
	la	$a0, result
	syscall
	
	# Display the sequence.
	#sw	$a1, index
	jal	stackReader
	
	# Exit the application
	li	$v0, 10
	syscall

#------------------------------------------------------------------------------------------------#

fibonacci:
	ble	$s0, 0, fibZero
	
	# Initialize first position.
	addi	$a1, $zero, 1
	
	beq	$s0, 1, fibOne
	
	# Initialize second position.
	addi	$a2, $zero, 1
	
	# Push the stack.
	sw	$a1, ($sp)
	addi	$sp, $sp, -4
	sw	$a2, ($sp)
	
	# Initialize a loop counter (2 positions already stored)
	addi	$a1, $zero, 2
	fibLoop:
		beq	$s0, $a1, fibExit
		
		# Get the first two fibonacci values
		addi	$sp, $sp, 4
		lw	$t0, ($sp)
		addi	$sp, $sp, -4
		lw	$t1, ($sp)
		addi	$sp, $sp, -4
		
		# Add them together
		add	$t2, $t0, $t1
		
		# Store the new value
		sw	$t2, ($sp)
		
		# Increment the loop counter and re-enter the loop.
		addi	$a1, $a1, 1
		
		j fibLoop
	
	fibExit:
		jr	$ra
	
fibZero:
	# Check value
	li	$v0, 4
	la	$a0, error
	syscall
	
	jr	$ra

fibOne:
	# Push the stack.
	addi	$sp, $sp, -4
	sw	$a1, 0($sp)
	
	jr	$ra
	
#------------------------------------------------------------------------------------------------#

stackReader:
	# Set the counter.
	addi	$a1, $zero, 0
	stackLoop:
		# Exit upon completion.
		beq	$s0, $a1, stackExit
		
		# Print the current index.
		lw	$t0, ($sp)
		addi	$sp, $sp, 4
		
		li	$v0, 1
		move	$a0, $t0
		syscall
		
		li	$v0, 4
		la	$a0, delimit
		syscall
		
		addi	$a1, $a1, 1
		
		j stackLoop
		
	stackExit:
		li	$v0, 4
		la	$a0, endMsg
		syscall
		
		jr	$ra