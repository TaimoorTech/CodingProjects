.data
	msg1: .asciiz "Enter First Integer : "
	msg2: .asciiz "\nEnter Second Integer : "
	msg3: .asciiz "\nProduct is: "
.text
.globl main
.ent main
main:
	li $v0,4			#String display
 	la $a0,msg1
	syscall
 	li $v0,5			#Integer input
	syscall
	move $t1, $v0

	li $v0,4			#String display
 	la $a0,msg2
	syscall
 	li $v0,5			#Integer input
	syscall
	move $t2, $v0

	mul $t3,$t1,$t2

	li $v0,4			#String display
	la $a0,msg3
	syscall
	li $v0,1			#Integer Output
	move $a0, $t3
	syscall

	jr $ra
.end main