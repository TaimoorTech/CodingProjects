.data
	msg1: .asciiz "Enter Dividend : "
	msg2: .asciiz "\nEnter Divisor : "
	msg3: .asciiz "\nQuotient is: "
	msg4: .asciiz " and Remainder is: "
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

	div $t1,$t2			#Performing Division
	mflo $t3
	mfhi $t4

	li $v0,4			#String display
	la $a0,msg3
	syscall
	li $v0,1			#Integer output
	move $a0, $t3
	syscall

	li $v0,4			#String display
	la $a0,msg4
	syscall
	li $v0,1			#Integer output
	move $a0, $t4
	syscall

	jr $ra
.end main