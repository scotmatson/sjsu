.include "../cs47_macro.asm"

.data
var_a: .byte 0x10          # Type: char  (8-bit)
var_b: .half 0x3210        # Type: short (16-bit)
var_c: .word 0x76543210    # Type: int   (32-bit)

.text
.globl main
main:
	# these are all pseudo instruction
	# MIPS natively supports only relative
	# address translation (e.g. lb $s0, 0x2345($gp))
	lb	$s0, var_a	
	lh	$s1, var_b
	lw 	$s2, var_c
	
	exit