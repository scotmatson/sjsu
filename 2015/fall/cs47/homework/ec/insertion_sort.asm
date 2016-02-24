.data
preSort:	.asciiz "\nValues before sort: "
postSort:	.asciiz "\nValues after sort: "
exitMsg:	.asciiz "\nTerminating application."
delimiter:	.asciiz " "
var_a:		.word 9 4 2 8 6 1 7 0 3 5
var_m:		.word 10

valueis:	.asciiz "\nValue is: "

.text
main:
	# Print the current data set.
	li	$v0, 4
	la	$a0, preSort
	syscall
	jal printSet
	# Perform insertion sort.
	jal insertionSort
	# Print the sorted data set.
	li	$v0, 4
	la	$a0, postSort
	syscall
	jal printSet
	# Notify user, EOF
	li	$v0, 4
	la	$a0, exitMsg
	syscall
	# Signal the OS to exit the application.
	li	$v0, 10
	syscall

################################################################################	
# PRINTING DATA SET
################################################################################
printSet:
	# Set the counters.
	addi	$t0, $zero, 0
	lw	$t1, var_m
	mul	$t1, $t1, 4
	printWhile:
		# Exit condition.
		beq	$t0, $t1, printExit
		# Obtain the current value.
		lw	$a0, var_a($t0)
		# Print the current value
		li	$v0, 1
		syscall
		# Delimit the values.		
		li	$v0, 4
		la	$a0, delimiter
		syscall
		# Increment the counter.
		addi	$t0, $t0, 4
		# Continue the loop.
		j printWhile
		
	printExit:
		jr	$ra

################################################################################
# INSERTION SORT ALGORITHM
################################################################################
insertionSort:
	# Initialize counters and bounds.
	addi	$t0, $zero, 4	# Initialize counter to second index (Position 0 represents our first sorted value).
	lw	$s0, var_m
	mul	$s0, $s0, 4 	# Number of elements => Number of bytes.
	
	# This loop travels FROM the partition TO the last byte position in the array.
	outerWhile:
		# Exit condition (Reaching the end of the array)
		beq	$t0, $s0, outerExit

		# Obtain the value at our current position.
		lw	$t1, var_a($t0)	
		
		# Push values to the stack and enter the innerWhile
		addi	$sp, $sp, -12
		sw	$ra, 0($sp)	# Return address
		sw	$t0, 4($sp)	# Outer counter
		sw	$s0, 8($sp)	# Array byte length.
		
		jal innerWhile
		
		lw	$ra, 0($sp)
		lw	$t0, 4($sp)
		lw	$s0, 8($sp)
		addi	$sp, $sp, 12
		
		# Increment the counter.
		addi	$t0, $t0, 4
		
		# Continue the outerLoop
		j outerWhile
	
		#------------------------------------------------------------------------------#
	
		# This loop travels FROM the partition TO the first byte position in the array.	
		innerWhile:
			# Exit condition
			beq	$t0, 0, innerExit	# If zero is reached, the current value is the smallest.
			
			# Get the value of the previous element.
			addi	$t3, $t0, -4
			lw	$t2, var_a($t3)
			
			# If the current value is less than the previous element perform a swap.
			blt	$t1, $t2, swap
			
			# Otherwise the current value is in its proper place already...
			# Return to the outerLoop.
			j innerExit
			
			swap:
				# Swap the position of the values being compared.
				sw	$t2, var_a($t0)	# Left value shifts right.
				sw	$t1, var_a($t3)	# Right value shifts left.
				
				# Decrement the counter.
				addi	$t0, $t0, -4
				
				# Continue the innerLoop
				j innerWhile
				
		innerExit:
			jr	$ra
		
		#------------------------------------------------------------------------------#	
		
	outerExit:
		jr	$ra

################################################################################	
