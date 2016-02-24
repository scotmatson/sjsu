.include "cs47_macro.asm"

.data 0x10000000
	var_a:	.byte 0x10		# Type: char	(8-bit)
	var_b:	.half 0x3210		# Type: short	(16-bit)
	var_c:	.byte 0x20		# Type: char	(8-bit)
	var_d:	.word 0x76543210	# Type: int	(32-bit)
	
.text
.globl main
main:	# These are all pseudo instructions.
	# MIPS natively supports only relative
	# address translation (e.g., lb $s0, 0x2345($gp)).
	lb	$s0, var_a		# R[$s0] = M[var_a](7:0)
	lh	$s1, var_b		# R[$s1] = M[var_b](15:0)
	lb	$s2, var_c		# R[$s2] = M[var_c](7:0)
	lw	$s3, var_d		# R[$s3] = M[var_d](15:0)
	
	# Push the $s0...4 to stack
	push($s0)
	push($s1)
	push($s2)
	push($s3)
	
	# Pop the $t0...4 to stack
	pop($t0)
	pop($t1)
	pop($t2)
	pop($t3)
	
	# System exit
	exit	