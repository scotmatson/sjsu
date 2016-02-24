# Macro: print_str
# Usage: print_str(<string address)
.macro print_str($arg)
	li	$v0, 4
	la	$a0, $arg
	syscall
.end_macro

# Macro: read_int
# Usage: read_int(<reg>)
.macro read_int($arg)
	li	$v0, 5
	syscall
	move	$arg, $v0
.end_macro

# Macro: print_reg_int
# Usage: print_reg_int(<reg>)
.macro print_reg_int($arg)
	li	$v0, 1
	move	$a0, $arg
	syscall
.end_macro

# Macro: print_hi_lo
# Usage: print_hi_lo(<strHi>, <strComma>, <strLo>, <strEqual>)
.macro print_hi_lo($strHi, $strComma, $strLo, $strEqual)
	print_str($strHi)
	print_str($strEqual)	
	mfhi	$t1
	print_reg_int($t1)
	
	print_str($strComma)
	
	print_str($strLo)
	print_str($strEqual)
	mflo	$t1
	print_reg_int($t1)
.end_macro

# Macro: exit
# Usage: exit
.macro exit
	li	$v0, 10
	syscall
.end_macro

.data
	msg1:		.asciiz "Enter number for Hi ? "
	msg2:		.asciiz "Enter number for Lo ? "
	beforeSwap:	.asciiz "Before swapping "
	afterSwap:	.asciiz "After swapping "
	strHi:		.asciiz "Hi"
	strLo:		.asciiz "Lo"
	strComma:	.asciiz ", "
	strEqual:	.asciiz " = "
	newline:	.asciiz "\n"

.text
.globl main
main:	# Receive integer for Hi
	print_str(msg1)
	read_int($t1)
	mthi	$t1
	
	# Receive integer for Lo
	print_str(msg2)
	read_int($t1)
	mtlo	$t1
	
	# Pre-swap Hi/Lo values
	print_str(beforeSwap)
	print_hi_lo(strHi, strComma, strLo, strEqual)
	print_str(newline)
	
	# Perform Swap
	mfhi	$t1
	mflo	$t2
	mthi	$t2
	mtlo	$t1
			
	# Post-swap Hi/Lo values
	print_str(afterSwap)
	print_hi_lo(strHi, strComma, strLo, strEqual)
