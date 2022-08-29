.data
	msg1: .asciiz "Enter Integer : "
	msg2: .asciiz "The number "
	msg3: .asciiz " is Composite." 
	msg4: .asciiz " is Prime."
.text
.globl main
.ent main
main:
	li $v0, 4			#String Display
	la $a0, msg1 
	syscall

	li $v0, 5			#Integer Input
	syscall
	move $t0,$v0

	addi $t1, $0, 1		#Initializing t1 to 1 to divide the integer by each number
	
	addi $t2, $0, 0		#Initializing t2 to 0 to store remainder
	
	addi $t3, $0, 0		#Initializing t3 to 0 
	
	addi $t4, $0, 3		#Initializing t4 to 3 
	
	addi $t5, $t0, 1		#Initializing t5 to 1
	
	li $v0, 4			#String Display
	la $a0, msg2
	syscall

	li $v0, 1			#Integer Display
	move $a0, $t0
	syscall


	loop: 	beq $t1, $t5, end
			div $t0, $t1
			mfhi $t2
			beq $t2, $0, cal_no_of_rem
			addi $t1, $t1,1
			j loop

			cal_no_of_rem:  	addi $t3, $t3, 1
						beq $t3, $t4, Composite	
 			addi $t1, $t1,1
			j loop

	end:

	bne $t3, $t4, Prime
	j Composite

	Prime: 	li $v0, 4 		#String Display
			la $a0, msg4
			syscall
			j end_if 
	
	Composite:	li $v0, 4 		#String Display
			la $a0, msg3
			syscall

	end_if:

	jr $ra
.end main