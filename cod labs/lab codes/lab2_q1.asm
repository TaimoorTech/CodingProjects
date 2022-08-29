.data
	msg1: .asciiz "Enter your name : "
	msg2: .asciiz "Enter your age : "
	msg3: .asciiz "****Welcome "
	msg4: .asciiz " !"
	msg5: .asciiz "You are "
	msg6: .asciiz " years old now. Stay blessed****"
.text
.globl main
.ent main
main:
	li $v0,4			#String Display
	la $a0,msg1
	syscall

	li $v0,8			#String Input
	syscall
	move $t1, $a0

	li $v0,4			#String Display
	la $a0,msg2
	syscall
	
	li $v0,5			#Integer Input
	syscall
	move $t2,$v0
	
	li $v0,4			#String Display
	la $a0,msg3
	syscall
	
	li $v0,4			#String Display
	move $a0, $t1
	syscall

	li $v0,4			#String Display
	la $a0,msg4
	syscall

	li $v0,4			#String Display
	la $a0,msg5
	syscall

	li $v0,1			#Integer Output
	move $a0,$t2
	syscall

	li $v0,4			#String Display
	la $a0,msg6
	syscall

	jr $ra
.end main