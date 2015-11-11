.include "cs47_macro.asm"

.data 0x10000000
	str:	.asciiz "abcdefgh"
	
.text
.globl main
main:	
# Use of native instruction
# Immediate values are within 16-bit range
lw	$t0, -0x8000($gp)	# Load from (R[$gp] - 0x8000) = 0x1000 0000
sw	$t0, +0x7ffc($gp)	# Store to (R[$gp] + 0x8000 - 0x4) = 0x1000 fffc

# Use of pseudo instruction
# Immediate values are NOT within 16-bit range
# Explain -0x8004 does not work

# lw $t0, -0x8004($gp)		# Load from (R[$gp] - 0x8004) = 0x0fff fffc
				# MARS system is checking for the data boundry
				# and preventing system from happening it, just
				# like OS.

sw	$t0, 0x8000($gp)	# Store to (R[$gp] + 0x8000) = 0x1001 0000

#System exit
exit