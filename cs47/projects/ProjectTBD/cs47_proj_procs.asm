.include "./cs47_proj_macro.asm"
.text
###################################################################
# C style signature 'printf(<format string>,<arg1>,		  #
#			 <arg2>, ... , <argn>)'			  #
#								  #
# This routine supports %s and %d only				  #
#								  #
# Argument: $a0, address to the format string			  #
#	    All other addresses / values goes into stack	  #
###################################################################
printf:
	#store RTE - 5 * 4 = 20 bytes
	addi	$sp, $sp, -24
	sw	$fp, 24($sp)
	sw	$ra, 20($sp)
	sw	$a0, 16($sp)
	sw	$s0, 12($sp)
	sw	$s1,  8($sp)
	addi	$fp, $sp, 24
	# body
	move 	$s0, $a0 #save the argument
	add     $s1, $zero, $zero # store argument index
printf_loop:
	lbu	$a0, 0($s0)
	beqz	$a0, printf_ret
	beq     $a0, '%', printf_format
	# print the character
	li	$v0, 11
	syscall
	j 	printf_last
printf_format:
	addi	$s1, $s1, 1 # increase argument index
	mul	$t0, $s1, 4
	add	$t0, $t0, $fp # all print type assumes 
			      # the latest argument pointer at $t0
	addi	$s0, $s0, 1
	lbu	$a0, 0($s0)
	beq 	$a0, 'd', printf_int
	beq	$a0, 's', printf_str
	beq	$a0, 'c', printf_char
printf_int: 
	lw	$a0, 0($t0) # printf_int
	li	$v0, 1
	syscall
	j 	printf_last
printf_str:
	lw	$a0, 0($t0) # printf_str
	li	$v0, 4
	syscall
	j 	printf_last
printf_char:
	lbu	$a0, 0($t0)
	li	$v0, 11
	syscall
	j 	printf_last
printf_last:
	addi	$s0, $s0, 1 # move to next character
	j	printf_loop
printf_ret:
	#restore RTE
	lw	$fp, 24($sp)
	lw	$ra, 20($sp)
	lw	$a0, 16($sp)
	lw	$s0, 12($sp)
	lw	$s1,  8($sp)
	addi	$sp, $sp, 24
	jr $ra

###################################################################
# Implement au_logical						  #
# Argument:							  #
# 	$a0: First number					  #
#	$a1: Second number					  #
#	$a2: operation code ('+':add, '-':sub, '*':mul, '/':div)  #
# Return:							  #
#	$v0: ($a0+$a1) | ($a0-$a1) | ($a0*$a1):LO | ($a0 / $a1)   #
# 	$v1: ($a0 * $a1):HI | ($a0 % $a1)			  #
# Notes:							  #
###################################################################
au_logical:
	# Push the stack.
	addi	$sp, $sp, -48
	sw	$fp, 48($sp)
	sw	$ra, 44($sp)
	sw	$a0, 40($sp)
	sw	$a1, 36($sp)
	sw	$a2, 32($sp)
	sw	$s0, 28($sp)
	sw	$s1, 24($sp)
	sw	$s2, 20($sp)
	sw	$s3, 16($sp)
	sw	$s4, 12($sp)
	sw	$s5, 8($sp)
	addi	$fp, $sp, 48
	
	# Store the arguments
	move	$s0, $a0
	move	$s1, $a1
	move	$s2, $a2

au_logic_operation:
	beq	$a2, '+', add_logic
	beq	$a2, '-', sub_logic
	beq	$a2, '*', mul_logic
	beq	$a2, '/', div_logic

add_logic:
	addi	$a1, $a1, -1	# Hack to compensate for subtraction logic.
	addi	$t2, $zero, 0x00000000
	j	add_sub_logic
	
sub_logic:
	addi	$t2, $zero, 0xFFFFFFFF
	j	add_sub_logic

#-----------------------------------------------------------------#
#------------------- ADDITION / SUBTRACTION ----------------------#
#-----------------------------------------------------------------#
add_sub_logic:
	# Initialize variables
	xor	$a1, $a1, $t2	# Invert bits if subtraction.
	addi	$a1, $a1, 1	# Add 1 if inverted / Replace 1 if addition.
	addi	$s3, $zero, 0	# Counter.
	addi	$v1, $zero, 0	# Carry out/in
	addi	$v0, $zero, 0	# Clear out the return value.
	add_sub_while:
		# Break condition.
		beq	$s3, 32, add_sub_exit
		# Get the LSB position.
		extract_nth_bit($t1, $a0, $s3)
		extract_nth_bit($t2, $a1, $s3)
		# Sum the bits
		xor	$t3, $t1, $t2	# A XOR B
		xor	$t5, $t3, $v1	# CI XOR (A XOR B)
		# Carry out/in.
		and	$v1, $v1, $t3	# CI AND (A XOR B)
		and	$t6, $t1, $t2	# A AND B
		or	$v1, $v1, $t6	# (A XOR B) OR (A AND B)
		# Build solution
		addi	$t9, $zero, 0x01
		insert_to_nth_bit($v0, $s3, $t5, $t9)
		# Increment counter.
		addi	$s3, $s3, 0x01
		# Continue loop.
		j	add_sub_while
	add_sub_exit:
		# If add_sub_logic was being used as a helper procedure, return to the callee.
		beq	$s2, '+', au_logic_ret
		beq	$s2, '-', au_logic_ret
		jr	$ra
#-----------------------------------------------------------------#
#---------------------- MULTIPLICATION ---------------------------#
#-----------------------------------------------------------------#
mul_logic:
	# Set values to positive integers.
	jal	twos_complement_if_neg
	move	$s7, $v0
	
	move	$a0, $a1
	jal	twos_complement_if_neg
	move	$a1, $v0
	move	$a0, $s7
	
	# Initialize variables.
	addi	$s3, $zero, 0	# Counter
	addi	$v0, $zero, 0	# Product (lo)
	addi	$v1, $zero, 0	# Product (hi)
	addi	$s4, $zero, 0 	# Multiplicand 64-bit extension.
	mul_while:
		beq	$s3, 32, mul_while_exit			# Break condition.
		extract_nth_bit($t0, $a1, $s3) 			# Get the multiplier.
		beq	$t0, $zero, mul_while_afterthought	# Skip the next part of the bit is zero.
		
		# Push the stack
		addi	$sp, $sp, -28
		sw	$fp, 28($sp)	
		sw	$ra, 24($sp)	
		sw	$a0, 20($sp)	# Multiplicand (lo)
		sw	$a1, 16($sp)	# Multiplier
		sw	$s3, 12($sp)	# Counter
		sw	$s4, 8($sp)	# Multiplicand (hi)
		addi	$fp, $sp, 28
	
		jal	add_lo
		jal	add_hi
		
		# Pop the stack
		lw	$fp, 28($sp)
		lw	$ra, 24($sp)
		lw	$a0, 20($sp)	# Multiplicand (lo)
		lw	$a1, 16($sp)	# Multiplier
		lw	$s3, 12($sp)	# Counter
		lw	$s4, 8($sp)	# Multiplicand (hi)
		addi	$sp, $sp, 28

		# Housekeeping.
		mul_while_afterthought:
			sra	$v1, $a0, 31	# Copy bit, lo to hi.
			sll	$a0, $a0, 1	# Pad multiplicand (lo) right with zero.
			sll	$s4, $s4, 1	# Pad multiplicand (hi) right with zero.
			addi	$s3, $s3, 1	# Increment the counter.
			j	mul_while	# Continue the loop.
			
		add_lo:
		# Push the stack
			addi	$sp, $sp, -32
			sw	$fp, 32($sp)	
			sw	$ra, 28($sp)	
			sw	$a0, 24($sp)	# Multplicand (lo)
			sw	$a1, 20($sp)	# Multiplier
			sw	$s3, 16($sp)	# Counter
			sw	$s4, 12($sp)	# Multiplicand (hi)
			sw	$v1, 8($sp)	# Product (hi)
			addi	$fp, $sp, 32
			
			# product = multiplicand + product.
			# $a0 = multiplicand
			move	$a1, $v0	# Product (lo)
			jal	add_logic
			
			# Pop the stack
			lw	$fp, 32($sp)
			lw	$ra, 28($sp)
			lw	$a0, 24($sp)	# Multiplicand (lo)
			lw	$a1, 20($sp)	# Multiplier
			lw	$s3, 16($sp)	# Counter
			lw	$s4, 12($sp)	# Multiplicand (hi)
			lw	$v1, 8($sp)	# Product (hi)
			addi	$sp, $sp, 32
			jr	$ra
							
		add_hi:
		# Push the stack
			addi	$sp, $sp, -32
			sw	$fp, 32($sp)	
			sw	$ra, 28($sp)	
			sw	$a0, 24($sp)	# Multplicand (lo)
			sw	$a1, 20($sp)	# Multiplier
			sw	$s3, 16($sp)	# Counter
			sw	$s4, 12($sp)	# Multiplicand (hi)
			sw	$v0, 8($sp)	# Product (lo)
			addi	$fp, $sp, 32
			
			# Set the arguments (+multiplicand hi)
			move	$a0, $v1
			move	$a1, $s4
			jal	add_logic
			move	$v1, $v0
			
			# Pop the stack
			lw	$fp, 32($sp)
			lw	$ra, 28($sp)
			lw	$a0, 24($sp)	# Multiplicand (lo)
			lw	$a1, 20($sp)	# Multiplier
			lw	$s3, 16($sp)	# Counter
			lw	$s4, 12($sp)	# Multiplicand (hi)
			lw	$v0, 8($sp)	# Product (lo)
			addi	$sp, $sp, 32
			jr	$ra
			
	mul_while_exit:
		slti	$t0, $s0, 0
		slti	$t1, $s1, 0
		bne	$t0, $t1, product_cardinality
		j	au_logic_ret
		
	product_cardinality:
		move	$a0, $v0
		move	$a1, $v1
		jal twos_complement_64bit

		j	au_logic_ret
#-----------------------------------------------------------------#
#------------------------- DIVISION ------------------------------#
#-----------------------------------------------------------------#
div_logic:
	# Set values to positive integers.
	jal	twos_complement_if_neg
	move	$s7, $v0

	move	$a0, $s1
	jal	twos_complement_if_neg
	move	$s4, $v0
	move	$s3, $s7

	# Initialize variables.
	addi	$s5, $zero, 0	# Quotient.
	move	$s6, $s3	# Remainder.
	div_loop:
		#print_reg_int($s3)
		bge	$s3, $s4, div_update
		j	div_loop_exit
		div_update:
			move	$a0, $s3
			move	$a1, $s4
			jal	sub_logic
			move	$s3, $v0
		
			addi	$sp, $sp, -24
			sw	$fp, 24($sp)
			sw	$ra, 20($sp)
			sw	$s3, 16($sp)
			sw	$s4, 12($sp)
			sw	$s6, 8($sp)
			addi	$fp, $sp, 24
		
			addi	$t0, $zero, 1
			move	$a0, $s5
			move	$a1, $t0
			jal	add_logic
			move	$s5, $v0
		
			lw	$fp, 24($sp)
			lw	$ra, 20($sp)
			lw	$s3, 16($sp)
			lw	$s4, 12($sp)
			lw	$s6, 8($sp)
			addi	$sp, $sp, 24		
								
			move	$s6, $s3

			j	div_loop
	
	div_loop_exit:
		move	$v0, $s5
		move	$v1, $s6
		slti	$t0, $s0, 0
		slti	$t1, $s1, 0
		bne	$t0, $t1, quotient_cardinality
		j	au_logic_ret
	
	quotient_cardinality:
		move	$a0, $v0
		jal	twos_complement_if_pos
		j	au_logic_ret

au_logic_ret:
	# Pop the stack.
	lw	$fp, 48($sp)
	lw	$ra, 44($sp)
	lw	$a0, 40($sp)
	lw	$a1, 36($sp)
	lw	$a2, 32($sp)
	lw	$s0, 28($sp)
	lw	$s1, 24($sp)
	lw	$s2, 20($sp)
	lw	$s3, 16($sp)
	lw	$s4, 12($sp)
	lw	$s5, 8($sp)
	addi	$sp, $sp, 48
	jr	$ra
###################################################################
# Implement au_normal						  #
# Argument:							  #
# 	$a0: First number					  #
#	$a1: Second number					  #
#	$a2: operation code ('+':add, '-':sub, '*':mul, '/':div)  #
# Return:							  #
#	$v0: ($a0+$a1) | ($a0-$a1) | ($a0*$a1):LO | ($a0 / $a1)   #
# 	$v1: ($a0 * $a1):HI | ($a0 % $a1)			  #
# Notes:							  #
###################################################################
au_normal:
	# Push the stack.
	addi	$sp, $sp, -12
	sw	$fp, 12($sp)
	sw	$ra, 8($sp)
	addi	$fp, $sp, 12
	
au_normal_operation:
	beq	$a2, '+', add_normal
	beq	$a2, '-', sub_normal
	beq	$a2, '*', mul_normal
	beq	$a2, '/', div_normal

add_normal:
	add	$v0, $a0, $a1
	j	au_normal_ret
	
sub_normal:
	sub	$v0, $a0, $a1
	j	au_normal_ret
	
mul_normal:
	mult	$a0, $a1
	mflo	$v0
	mfhi	$v1
	j	au_normal_ret
	
div_normal:
	div	$a0, $a1
	mflo	$v0
	mfhi	$v1
	j	au_normal_ret

au_normal_ret:
	# Pop the stack.
	lw	$fp, 12($sp)
	lw	$ra, 8($sp)
	addi	$sp, $sp, 12
	jr	$ra
###################################################################
# ------------------- UTILITY PROCEDURES ------------------------ #
###################################################################
###################################################################
# Implement twos_complement_*					  #
# Argument:							  #
# 	$a0: Integer input.					  #
# Return:							  #
#	$v0: Complement						  #
# Notes:							  #	
###################################################################
twos_complement_if_neg:
	addi	$a3, $zero, 1
	bltz	$a0, twos_complement_to_pos
	move	$v0, $a0
	jr	$ra
	
twos_complement_if_pos:
	addi	$a3, $zero, -1
	bgtz	$a0, twos_complement_to_neg
	move	$v0, $a0
	jr	$ra

twos_complement_64bit:
	addi	$sp, $sp, -16
	sw	$fp, 16($sp)
	sw	$ra, 12($sp)
	sw	$a1, 8($sp)
	addi	$fp, $sp, 16
	
	addi	$a1, $zero, -1
	jal	add_logic
	not	$v0, $v0
	
	lw	$fp, 16($sp)
	lw	$ra, 12($sp)
	lw	$a1, 8($sp)
	addi	$sp, $sp, 16
	
	addi	$sp, $sp, -16
	sw	$fp, 16($sp)
	sw	$ra, 12($sp)
	sw	$v0, 8($sp)
	addi	$fp, $sp, 16
	
	move	$a0, $a1
	addi	$a1, $zero, -1
	jal	add_logic
	move	$a1, $v0
	
	move	$a0, $a1
	move	$a1, $v1	
	jal	add_logic
	move	$v1, $v0
	
	lw	$fp, 16($sp)
	lw	$ra, 12($sp)
	lw	$v0, 8($sp)
	addi	$sp, $sp, 16
	jr	$ra

twos_complement_to_pos:
	addi	$sp, $sp, -20
	sw	$fp, 20($sp)
	sw	$ra, 16($sp)
	sw	$a1, 12($sp)
	sw	$v1, 8($sp)
	addi	$fp, $sp, 20
	
	not	$a0, $a0
	move	$a1, $a3
	jal	add_logic
	
	lw	$fp, 20($sp)
	lw	$ra, 16($sp)
	lw	$a1, 12($sp)
	lw	$v1, 8($sp)
	addi	$sp, $sp, 20
	jr	$ra
	
twos_complement_to_neg:
	addi	$sp, $sp, -20
	sw	$fp, 20($sp)
	sw	$ra, 16($sp)
	sw	$a1, 12($sp)
	sw	$v1, 8($sp)
	addi	$fp, $sp, 20
	
	move	$a1, $a3
	jal	add_logic
	not	$v0, $v0
	
	lw	$fp, 20($sp)
	lw	$ra, 16($sp)
	lw	$a1, 12($sp)
	lw	$v1, 8($sp)
	addi	$sp, $sp, 20
	jr	$ra
#*****************************************************************#
# ---------------------- END OF FILE ---------------------------- #
#*****************************************************************#