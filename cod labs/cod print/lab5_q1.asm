.data
	msg1: .asciiz "Enter the Integer : "
	msg2: .asciiz "The Number is :"
	msg3: .asciiz " Even"
	msg4: .asciiz " Odd"
.text
.globl main
.ent main
main:
	li $v0,4
	la $a0, msg1
	syscall

	li $v0, 5
	syscall
	move $t0, $v0

	addi $t3, $0, 2

	div $t0, $t3
	mflo $t1
	mfhi $t2

	li $v0,4
	la $a0, msg2
	syscall
	
	beq $t2, $0, even
	li $v0,4
	la $a0, msg4
	syscall

	j end_if

	even:  	li $v0,4
			la $a0, msg3
			syscall

	end_if:

	jr $ra

.end main