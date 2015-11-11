.include "./cs47_proj_macro.asm"
.data
delimiter:	.asciiz " "	# TEMP VAL
newline:	.asciiz "\n"	# TEMP VAL

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
	addi	$sp, $sp, -40
	sw	$fp, 40($sp)
	sw	$ra, 36($sp)
	sw	$a0, 32($sp)
	sw	$a1, 28($sp)
	sw	$a2, 24($sp)
	sw	$s0, 20($sp)
	sw	$s1, 16($sp)
	sw	$s2, 12($sp)
	sw	$s3, 8($sp)
	addi	$fp, $sp, 40
	
	# Store the arguments.
	move	$s0, $a0
	move	$s1, $a1
	move	$s2, $a2

au_logic_operation:
	beq	$s2, '+', add_logic
	beq	$s2, '-', sub_logic
	beq	$s2, '*', mul_logic
	beq	$s2, '/', div_logic

add_logic:
	addi	$s1, $s1, -1	# Hack to compensate for subtraction logic.
	addi	$s2, $zero, 0x00000000
	j	add_sub_logic
	
sub_logic:
	addi	$s2, $zero, 0xFFFFFFFF
	j	add_sub_logic

add_sub_logic:
	# Initialize variables.s
	xor	$s1, $s1, $s2	# Invert bits if subtraction.
	addi	$s1, $s1, 1	# Add 1 if inverted / Replace 1 if addition.
	addi	$s3, $zero, 0	# Counter.
	addi	$t4, $zero, 0	# Carry out/in
	addi	$v0, $zero, 0	# Clear out the return value.
	add_sub_while:
		# Break condition.
		beq	$s3, 32, au_logic_ret
		# Get the LSB position.
		extract_nth_bit($t1, $s0, $s3)
		extract_nth_bit($t2, $s1, $s3)
		# Sum the bits
		xor	$t3, $t1, $t2	# A XOR B
		xor	$t5, $t3, $t4	# CI XOR (A XOR B)
		# Carry out/in.
		and	$t4, $t4, $t3	# CI AND (A XOR B)
		and	$t6, $t1, $t2	# A AND B
		or	$t4, $t4, $t6	# (A XOR B) OR (A AND B)
		# Build solution
		addi	$t9, $zero, 0x01
		insert_to_nth_bit($v0, $s3, $t5, $t9)
		# Increment counter.
		addi	$s3, $s3, 0x01
		# Continue loop.
		j	add_sub_while
	
mul_logic:
	j	au_logic_ret
	
div_logic:
	j	au_logic_ret

au_logic_ret:
	# Pop the stack.
	lw	$fp, 40($sp)
	lw	$ra, 36($sp)
	lw	$a0, 32($sp)
	lw	$a1, 28($sp)
	lw	$a2, 24($sp)
	lw	$s0, 20($sp)
	lw	$s1, 16($sp)
	lw	$s2, 12($sp)
	lw	$s3, 8($sp)
	addi	$sp, $sp, 40
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
	addi	$sp, $sp, -36
	sw	$fp, 36($sp)
	sw	$ra, 32($sp)
	sw	$a0, 28($sp)
	sw	$a1, 24($sp)
	sw	$a2, 20($sp)
	sw	$s0, 16($sp)
	sw	$s1, 12($sp)
	sw	$s2, 8($sp)
	addi	$fp, $sp, 36
	
	# Store the arguments
	move	$s0, $a0
	move	$s1, $a1
	move	$s2, $a2
	
au_normal_operation:
	beq	$s2, '+', add_normal
	beq	$s2, '-', sub_normal
	beq	$s2, '*', mul_normal
	beq	$s2, '/', div_normal

add_normal:
	add	$v0, $s0, $s1
	j	au_normal_ret
	
sub_normal:
	sub	$v0, $s0, $s1
	j	au_normal_ret
	
mul_normal:
	mult	$s0, $s1
	mflo	$v0
	mfhi	$v1
	j	au_normal_ret
	
div_normal:
	div	$s0, $s1
	mflo	$v0
	mfhi	$v1
	j	au_normal_ret
	
au_normal_ret:
	# Pop the stack.
	lw	$fp, 36($sp)
	lw	$ra, 32($sp)
	lw	$a0, 28($sp)
	lw	$a1, 24($sp)
	lw	$a2, 20($sp)
	lw	$s0, 16($sp)
	lw	$s1, 12($sp)
	lw	$s2, 8($sp)
	addi	$sp, $sp, 36
	jr	$ra
#*****************************************************************#
# ---------------------- END OF FILE ---------------------------- #
#*****************************************************************#