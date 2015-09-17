# SJSU CS47
# exp1.asm
# 09/16/2015

.data
	str: .asciiz "The answer is = "
.text
	li $v0, 4		# System call code for print_str
	la $a0, str		# Address of the string to print
	syscall			# Print the string
	
	li $v0, 1		# System call code for print_int
	li $a0, 5		# Integer to print
	syscall			# Print the integer
	
	li $v0, 10		# Exit call code
	syscall			# Exit from program