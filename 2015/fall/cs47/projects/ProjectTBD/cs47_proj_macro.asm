##################################################################
# ------------------------ INPUT MACROS ------------------------ #
##################################################################
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
	move	$arg, $a0
	syscall
.end_macro

# Macro: read_char
# Usage: read_char(char<reg>)
.macro read_char($arg)
	li	$v0, 12
	syscall
	move	$arg, $v0
.end_macro
###################################################################
# ------------------------ OUTPUT MACROS ------------------------ #
###################################################################
# Macro: print_two_int
# Usage: print_two_int(<reg>, <delimiter>, <reg>)
.macro	print_two_int($a, $d, $b)
	print_reg_int($a)
	print_str($d)
	print_reg_int($b)
.end_macro

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

# Macro: print_char
# Usage: print_char(<reg>)
.macro print_char($arg)
	li	$v0, 11
	move	$a0, $arg
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

# Macro: call_printf
# Usage call_printf(<format>)
.macro call_printf($format)
	la	$a0, $format
	jal	printf
.end_macro
###################################################################
# -------------------- SYSTEM / MISC MACROS --------------------- #
###################################################################
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

# Macro: push_var_value
.macro push_var_value($varName)
	lw	$t0, $varName
	push($t0)
.end_macro

# Macro: push_var_address	
.macro push_var_address($varName)
	la	$t0, $varName
	push($t0)
.end_macro

# Macro: extract_nth_bit
# Usage: extract_nth_bit(<mask>, <source>, <bit position>)
.macro extract_nth_bit($D, $S, $T)
	srlv	$t0, $S, $T
	and	$D, $t0, 0x01
.end_macro

# Macro: insert_to_nth_bit
# Usage: insert_to_nth_bit()
.macro insert_to_nth_bit($D, $S, $T, $mask)
	sllv	$mask, $mask, $S
	addi	$t0, $zero, 0xFFFFFFFF
	xor	$mask, $mask, $t0
	and	$D, $D, $mask
	sllv	$T, $T, $S
	or	$D, $D, $T
.end_macro
#*****************************************************************#
# ---------------------- END OF FILE ---------------------------- #
#*****************************************************************#
