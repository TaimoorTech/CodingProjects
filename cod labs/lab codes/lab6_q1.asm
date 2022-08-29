.data
	msg1: .asciiz "Enter Integer of which calculate the sum of : "
	msg2: .asciiz "The sum is : "
.text
.globl main
.ent main
main: 
	li $v0, 4			#String Display
	la $a0, msg1
	syscall

	li $v0, 5			#Integer Input
	syscall
	move $t0, $v0

	addi $t1, $0, 0		#Initializing t1 to 0
	addi $t2, $t0, 1		#Initializing t2 to t0+1
	addi $t3, $0, 0		#Initializing t3 to 0


	loop: beq $t1, $t2, end_loop
		add $t3, $t3, $t1
		addi $t1, $t1, 1
		j loop
	
	end_loop:
	
	li $v0, 4			#String Display
	la $a0, msg2
	syscall
	
	li $v0, 1			#Integer Display
	move $a0, $t3
	syscall

	jr $ra

.end main