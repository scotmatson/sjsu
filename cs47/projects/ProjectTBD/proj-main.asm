.include "./cs47_proj_macro.asm"
.include "./cs47_proj_procs.asm"

###################################################################
# ------------------- RANDOM ACCESS MEMORY ---------------------- #
###################################################################
.data 
instructions:	.asciiz "Enter two integers and an arithmetic operation to see the its result.\n"
firstInt:	.asciiz "Enter the first integer: "
secondInt:	.asciiz "Enter the second integer: "
operation:	.asciiz "Enter a mathematical operation to be performed ('+', '-', '*', '/'): "
output:		.asciiz "\nResult: "

###################################################################
# --------------------- INSTRUCTION SET ------------------------- #
###################################################################
.text
.globl main
main:
	# Prompt the user for input and store result.
	print_str(instructions)
	print_str(firstInt)
	read_int($s0)
	print_str(secondInt)
	read_int($s1)
	print_str(operation)
	read_char($s2)
	
	# Set argument values and call au_normal procedure.
	move	$a0, $s0
	move	$a1, $s1
	move	$a2, $s2
	jal au_normal
	
	# Store the result of au_normal and output the result.
	move	$t0, $v0
	print_str(output)
	print_reg_int($t0)
	
	# Set argument values and call au_logic.
	move	$a0, $s0
	move	$a1, $s1
	move	$a2, $s2
	jal au_logical
	
	# Store the result of au_logic and output the result.
	move	$t0, $v0
	print_str(output)
	print_reg_int($t0)
	
	# Signal the OS to exit the application.
	exit
#*****************************************************************#
# ---------------------- END OF FILE ---------------------------- #
#*****************************************************************#
