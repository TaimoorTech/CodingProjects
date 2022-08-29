.data
	cTemp: .word 31
	fTemp: .word 0
	nine: .word 9
	five: .word 5
	res: .asciiz "The Temperature in Fahrenheit is: "
.text
.globl main
.ent main
main:
	mul $t0, cTemp, nine
	div $t1 , $t0, five
	addi $t2, $t1, 32
	add cTemp, cTemp, $t2

	li $v0, 2
	la $f12, cTemp
	syscall
	