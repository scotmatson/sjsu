.data
sysMsg:	.asciiz "\nFinding the GCD and LCM of the set: "
gcdMsg:		.asciiz "\nThe GCD: "
lcmMsg:		.asciiz "\nThe LCM: "
exitMsg:	.asciiz "\nTerminating application."
delimiter:	.asciiz " "
var_a:		.word 91, 130, 143, 234, 104, 156, 195, 247
var_m:		.word 8

.text
main:
	# Print the current data set.
	li	$v0, 4
	la	$a0, sysMsg
	syscall
	jal printSet
	# Retrieve the GCD and LCM of the integer array.
	la	$a0, var_a
	lw	$a1, var_m
	jal	gcd_lcm_set
	# Store the results.
	move	$t0, $v0
	move	$t1, $v1
	# Print the results of GCD.
	li	$v0, 4
	la	$a0, gcdMsg
	syscall
	li	$v0, 1
	move	$a0, $t0
	syscall
	# Print the results of LCM.
	li	$v0, 4
	la	$a0, lcmMsg
	syscall
	li	$v0, 1
	move	$a0, $t1
	syscall
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
# GREATEST COMMON DIVISOR - Uses Euclidian Algorithm.
# Usage: gcd(a, b)
# Register assignment
	# $a0: Dividend
	# $a1: Divisor
	# $v0: GCD
################################################################################
gcd:
	# If the dividend is less than the divisor we need to perform a swap.
	blt	$a0, $a1, gcdSwap
	# Initialize hi/lo by performing our first calculation.
	div	$a0, $a1
	gcdLoop:
		move	$a0, $a1	# Divisor becomes next dividend.	
		mfhi	$a1		# Remainder becomes next divisor.
		# Exit condition.
		beq	$a1, 0, gcdEnd
		# Else... perform next calculation and loop.
		div	$a0, $a1
		j gcdLoop
		
	gcdEnd:		
		move	$v0, $a0	# When the remainder is zero, the divisor is our GCD.
		jr	$ra
		
	gcdSwap:
		move	$t0, $a0
		move	$a0, $a1
		move	$a1, $t0
		j	gcd
	
################################################################################
# LEAST COMMON MULTIPLE - Utilizes the Eucldian Algorithm.
# Usage: LCM(a, b)
	# Formula: ($a0 * $a1) / GCD(a, b)
	# v0: LCM
################################################################################
lcm:
	# Calculate the numerator.
	mul	$t0, $a0, $a1 # The numerator
	# Push the stack.
	addi	$sp, $sp, -12
	sw	$ra, 0($sp)	# The return address
	sw	$t0, 4($sp)	# The numerator
	# Calculate the denominator.
	jal	gcd
	# Pop the stack.
	lw	$ra, 0($sp)
	lw	$t0, 4($sp)
	addi	$sp, $sp, 12
	# Store the denominator
	move	$t1, $v0
	# Calculate the LCM
	div	$t0, $t1
	mflo	$v0
	jr	$ra

################################################################################	
# GCD/LCM SET Calculator - Returns the GCD and LCM of an integer array.
# Usage: gcd_lcm_set(a, b)
	# $a0: The address of the first index in the array.
	# $a1: The number of elements in the array.
	# $v0: The GCD.
	# $v1: The LCM.
################################################################################
gcd_lcm_set:
	# Initialize counter, break conditions, and free up $a* registers.
	addi	$s0, $zero, 4
	mul	$s1, $a1, 4
	# Store the array address
	move	$s2, $a0
	# Initalize our A values for LCM and GCD.
	lw	$s6, 0($s2)
	lw	$s7, 0($s2)
	addi	$s2, $s2, 4
	while:
		# Exit condition.
		beq	$s0, $s1, exit
		
		# Get our B
		lw	$a1, ($s2)
		
		# Push the stack
		addi	$sp, $sp, -24
		sw	$ra, 0($sp)	# Return address.
		sw	$s0, 4($sp)	# Counter.
		sw	$s1, 8($sp)	# Break condition.
		sw	$s2, 12($sp)	# Array address.
		sw	$s7, 16($sp)	# LCM's A value.
		sw	$a1, 20($sp)	# B value.

		# Set the A value.
		move	$a0, $s6
		# Get the GCD
		jal	gcd
		# Store the result.
		move	$s6, $v0
		
		# Pop
		lw	$ra, 0($sp)
		lw	$s0, 4($sp)
		lw	$s1, 8($sp)
		lw	$s2, 12($sp)
		lw	$s7, 16($sp)
		lw	$a1, 20($sp)
		addi	$sp, $sp, 24
		
		# Push
		addi	$sp, $sp, -20
		sw	$ra, 0($sp)	# Return address.
		sw	$s0, 4($sp)	# Counter.
		sw	$s1, 8($sp)	# Break condition.
		sw	$s2, 12($sp)	# Array address.
		sw	$s6, 16($sp)	# GCD's A value.
		
		# Set the A value.
		move	$a0, $s7
		# Get the LCM
		jal	lcm
		# Store the result.
		move	$s7, $v0
		
		# Pop the stack.
		lw	$ra, 0($sp)
		lw	$s0, 4($sp)
		lw	$s1, 8($sp)
		lw	$s2, 12($sp)
		lw	$s6, 16($sp)
		addi	$sp, $sp, 20, 
		
		# Advance the array pointer and counter.
		addi	$s2, $s2, 4
		addi	$s0, $s0, 4
		
		j	while
	
	exit:
		# Return the GCD and LCM of the set.
		move	$v0, $s6
		move	$v1, $s7
		jr	$ra

#*******************************************************************************
# EOF
#*******************************************************************************
