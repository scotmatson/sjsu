# Macro Definitions

# ------------------------ INPUT MACROS ------------------------ #
# Macro: read_int
# Usage: read_int(<reg>)
.macro read_int($arg)
	li	$v0, 5		#	System Call for read_int
	syscall			#	Call OS to perform operation
	move	$arg, $v0	#	Move value into register
.end_macro

# Macro: read_float
# Usage: read_float(<reg>)
.macro read_float($arg)
	li	$v0, 6
	syscall
	mov.s	$arg, $f0
.end_macro

# Macro: read_double
# Usage: read_double(<reg>)
.macro read_double($arg)
	li	$v0, 7
	syscall
	mov.d	$arg, $f0
.end_macro

# Macro: buffered_reader
# Usage: buffered_reader(<address of the string>)
.macro buffered_reader($arg, $buffer)
	li	$v0, 8
	la	$a0, $buffer
	li	$a1, 20
	move	$arg, $a0	# This line probably isn't necessary. $buffer picks up the string.
	syscall
.end_macro

# ------------------------ OUTPUT MACROS ------------------------ #
# Macro: print_int
# Usage: print_int(<val>)
.macro print_int($arg)
	li	$v0, 1
	li	$a0, $arg
	syscall
.end_macro

# Macro: print_reg_int
# Usage: print_reg_int(<reg>)
.macro print_reg_int($arg)
	li	$v0, 1
	move	$a0, $arg
	syscall
.end_macro

# Macro: print_float
# Macro: print_float(<reg>)
.macro print_reg_float($arg)
	li	$v0, 2
	mov.s	$f12, $arg
	syscall
.end_macro

# Macro: print_double
# Macro: print_double(<reg>)
.macro print_reg_double($arg)
	li	$v0, 3
	mov.d	$f12, $arg
	syscall
.end_macro

# Macro: print_str
# Usage: print_str(<address of the string>)
.macro print_str($arg)
	li	$v0, 4
	la	$a0, $arg
	syscall
.end_macro

# Macro: buffered_print_str
# Usage: buffered_print_str(<address of the string>, <buffer>)
.macro buffered_print_str($arg, $buffer)
	li	$v0, 4
	la	$a0, $buffer
	move	$a0, $arg
	syscall	
.end_macro

# ------------------------ SYSTEM MACROS ------------------------ #
# Macro: exit
# Usage: exit
.macro exit
	li	$v0, 10
	syscall
.end_macro

# Macro: lwi
# Usage: lwi(<reg>, <upper imm>, <lower imm>)
.macro lwi($reg, $ui, $li)
	lui	$reg, $ui		# Load Upper Immediate, xxxx0000
	ori	$reg, $reg, $li		# OR, will retain existing bits
.end_macro

# Macro: push
# Usage: push(<reg>)
.macro push($arg)
	sw 	$arg, 0x0($sp)
	addi	$sp, $sp, -4
.end_macro

# Macro: pop
# Usage: pop(<reg>)
.macro pop($arg)
	addi	$sp, $sp, +4
	lw	$arg, 0x0($sp)
.end_macro
