.data
var_a:		.word 2 3 5 5 8 10 11 17 18 20 
var_b:		.word 5 6 7 8 14 15 17
var_m:		.word 10
var_n:		.word 7

exitMsg:	.asciiz "Merge completed.\n"
spacer:		.asciiz " "

# Expected sequence in this location - 2 3 5 5 5 6 7 8 8 10 11 14 15 17 17 18 20
var_c: .word 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0

.text
main:
	# Initialize the indices.
	# var_a head.
	addi	$s0, $zero, 0
	# var_b head.
	addi	$s1, $zero, 0
	# var_c head
	addi	$s2, $zero, 0
	
	# Store lengths
	lw	$s3, var_m
	lw	$s4, var_n
	mul	$s3, $s3, 4
	mul	$s4, $s4, 4
	
	jal merge
	
	# Notify user of completion.
	li	$v0, 4
	la	$a0, exitMsg
	syscall
	
	jal printMerge
	
	# Send OS exit signal.
	li	$v0, 10
	syscall
	
#-----------------------------------------------------------------------#
	
merge:
	# When either case is exhausted of values, append all that remain.
	beq	$s0, $s3, appendB
	beq	$s1, $s4, appendA
	
	# Get values
	lw	$t0, var_a($s0)
	lw	$t1, var_b($s1)
	
	# Find the smallest value
	sle	$a0, $t0, $t1
	beq	$a0, 1, atoc
	
	# Else...
	j btoc
	
#----------------------------------------------------------#
	
atoc:
	# Store the value
	sw	$t0, var_c($s2)
	
	#Advance the pointers.
	addi	$s0, $s0, 4
	addi	$s2, $s2, 4
			
	j merge
btoc:
	# Store the value
	sw	$t1, var_c($s2)
	
	# Advance the pointers
	addi	$s1, $s1, 4
	addi	$s2, $s2, 4
	
	j merge
	
#---------------------------------------------------------------#
	
appendA:
	# Append all remaining values of A to C.
	appendLoopA:
		beq	$s0, $s3, exitB
		lw	$t0, var_a($s0)
		
		# Store the value
		sw	$t0, var_c($s2)
	
		#Advance the pointers.
		addi	$s0, $s0, 4
		addi	$s2, $s2, 4
		
		j appendLoopA
	exitA:
		jr	$ra
	
appendB:
	# Append all remaining values of B to C.
	appendLoopB:
		beq	$s1, $s4, exitB
		lw	$t1, var_b($s1)
		
		# Store the value
		sw	$t1, var_c($s2)
	
		# Advance the pointers
		addi	$s1, $s1, 4
		addi	$s2, $s2, 4
	exitB:
		jr	$ra

#---------------------------------------------------------------#

printMerge:
	# Set index
	addi	$t0, $zero, 0
	
	# Set condition
	add	$t1, $s3, $s4
	
	while:
		beq	$t0, $t1, exit
		lw	$a0, var_c($t0)
		
		# Print the value
		li	$v0, 1
		syscall
		
		li	$v0, 4
		la	$a0, spacer
		syscall
		
		# Increment the index
		addi	$t0, $t0, 4
		
		j while
		
	exit:
		jr	$ra