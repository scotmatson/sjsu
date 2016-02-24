.include "cs47_macro.asm"

.data
	buffer:		.space	20		# Reserve # bytes in data segment for string input
	anInt:		.word	5		# A word is 4 bytes
	aFloat: 	.float	5.5		# A float is 4 bytes
	aDouble:	.double 3.14		# A double is 8 bytes
	aString:	.asciiz "Printing string to the console"
	inside:		.asciiz "I'm inside myProc."
	outside:	.asciiz "I'm back, system exit!!!"
	newLn:		.asciiz "\n"

.globl main

.text
main:	
### INTEGER READ TEST ###
	#read_int($t0)
	#print_reg_int($t0)		# Output result.

### SINGLE PRECISION READ TEST ###
	#read_float($f0)
	#print_reg_float($f0)		# Output result.
	
### DOUBLE PRECISION READ TEST ###
	#read_double($f0)
	#print_reg_double($f0)		# Output result.
	
### STRING READ TEST ###
	#buffered_reader($t0, buffer)
	#buffered_print_str($t0, buffer)

### INTEGER PRINT TEST ###
	#lw	$t0, anInt		# Load RAM source into register.
	#print_reg_int($t0)		# Prints an integer from a register.	
	
### FLOATING POINT PRINT TEST ###
	# l.s	$f1, aFloat		# lwc1(l.s) Load single precision into register.
	# print_reg_float($f1)		# Prints single precision from register.
	
### DOUBLE PRINT TEST ###
	# l.d	$f2, aDouble		# ldc1(l.d) Load double precision into register.
	# print_reg_double($f2)		# Prints double precision from register.
	
### PRINT STRING TEST ###
	#print_str(aString)
	
	
### EXIT THE APPLICATION ###
	jal	myProc
	print_str(outside) # <-- this location is stored at $ra
	exit
	
myProc:
	print_str(inside)
	jr	$ra
