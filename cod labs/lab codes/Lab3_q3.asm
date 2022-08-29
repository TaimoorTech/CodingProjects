.data
	msg1: .asciiz "Enter First number: "
	msg2: .asciiz "\nResult: "
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

	nor $t2,$t1,$t1		#Converting into 1's complement

	addi $t3,$t2,1		#Adding 1 to convert into 2's Complement

	li $v0,4			#String display
	la $a0,msg2
	syscall
	li $v0,1			#Integer output
	move $a0, $t3
	syscall
	
	jr $ra
.end main