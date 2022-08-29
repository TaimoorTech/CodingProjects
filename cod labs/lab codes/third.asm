 .data
	msg1:	.asciiz "Enter some integer value for x followed by enter: "
	msg2:	.asciiz "\n Enter some integer value for Y followed by enter: "
	msg3:	.asciiz "\n Enter some integer value for Z followed by enter: "
	msg4:	.asciiz "\n YOUR ROLL NO: "
	msg5:	.asciiz	"\n RESULT is: " 

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

	li $v0,4			#String display
	la $a0,msg3
	syscall
	li $v0,5			#Integer input
	syscall
	move $t3, $v0

	li $v0,4			#String display
	la $a0,msg4
	syscall
	li $v0,5			#Integer input
	syscall
	move $t4, $v0

	sub $t5,$t1,$t2		#sub x-y
	add $t6,$t5,$t3		#add (x-y)+z
	sub $t7,$t6,$t4		#sub(x-y+z)-roll_no

	li $v0,4			#String display
	la $a0,msg5
	syscall
	li $v0,1			#Integer output
	move $a0, $t7
	syscall

	jr $ra
.end main
	



	


