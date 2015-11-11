# Macro Definitions

# Macro: print_str
# Usage: print_str(<string address>)
.macro print_str($arg
	li	$v0, 4			# System call code for print_str
	la	$a0, $arg		# Address of the string to print
	syscall
.end_macro

# Macro: print_int
# Usage: print_int(<val>)
.macro print_int($arg)
	li	$v0, 1			# System call code for print_int
	li	$a0, $arg		# Integer to print
	syscall
.end_macro

# Macro: exit
# Usage: exit
.macro exit
	li	$v0, 10
	syscall
.end_macro

# Application program
# Data segment definition
.data
	str:	.asciiz "The answer is = "

# Code segment definition
.text
.globl main
main:	print_str(str)
	print_int(5)
	exit
	
	