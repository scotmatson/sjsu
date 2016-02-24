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
	# Perform selection sort.
	jal selectionSort
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
# SELECTION SORT ALGORITHM
################################################################################
selectionSort:
	# Outer counter and break condition.
	addi	$t0, $zero, 0
	lw	$s0, var_m
	mul	$s0, $s0, 4
	outerLoop:
		# Break condition.
		beq	$t0, $s0, outerEnd
		# Set the minimum value.
		lw	$t1, var_a($t0)
		# Store the return address.
		addi	$sp, $sp, -8
		sw	$ra, 0($sp)
		sw	$t1, 4($sp)
		# Inner loop counter initialization and enter innerLoop
		addi	$t2, $t0, 4
		jal innerLoop
		# Restore the return address.
		lw	$ra, 0($sp)
		lw	$t1, 4($sp)
		addi	$sp, $sp, 8
		# If stored value doesn't equal min value, perform a swap.
		bne	$t1, $t5, swap
		# Else... just increment and loop.
		addi	$t0, $t0, 4
		j outerLoop
		
			swap:
				# Store values in new position.
				sw	$t5, var_a($t0)
				sw	$t1, var_a($t4)
				# Increment and loop.
				addi	$t0, $t0, 4
				j outerLoop
		
		innerLoop:
			# Break condition
			beq	$t2, $s0, innerEnd
			# Get value to compare against.
			lw	$t3, var_a($t2)
			# If the new value is less than the old value...
			blt	$t3, $t1, setMin
			# Else... just increment the counter and loop.
			addi	$t2, $t2, 4
			j innerLoop
			
			setMin:
				# Set the new min.
				move	$t1, $t3			
				# Set the position of the min for swapping.
				move	$t4, $t2
				# Increment counter and loop.
				addi	$t2, $t2, 4
				j innerLoop
		
		innerEnd:
			# Return the min.
			move	$t5, $t1
			jr	$ra
	
	outerEnd:
		jr	$ra

################################################################################	
