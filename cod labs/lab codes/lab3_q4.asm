.data
	msg1: .asciiz "Enter lowercase alphabet followed by enter : "
	msg2: .asciiz "\n You entered: "
.text
.globl main
.ent main
main:
	li $v0,4					#String display
 	la $a0,msg1
	syscall
 	li $v0,12					#char input
	syscall
	move $t1, $v0

	addi $t2,$t1,32				#converting into lower alphabets

	
	li $v0,4					#String display
	la $a0,msg2
	syscall
	li $v0,11					#char display
	move $a0, $t2
	syscall

	jr $ra
.end main