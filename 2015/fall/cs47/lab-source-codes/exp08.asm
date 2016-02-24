.include "../cs47_macro.asm"

.text
.globl main
main: 
	# lui overrides the lower word
	li $s1, 0xa5a5
	lui $s1, 0x5a5a
	
	# Macro to load complete word
	lwi ($s1, 0x5a5a, 0xa5a5)
	exit
