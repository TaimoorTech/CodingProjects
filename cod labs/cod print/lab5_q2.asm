.data
	msg1: .asciiz "Enter Temperature of the day: "
	msg2: .asciiz "It is hot today."
	msg3: .asciiz "Pleasant weather."
	msg4: .asciiz "It is cold today."
.text
.globl main
.ent main
main:
	li $v0, 4						
	la $a0, msg1
	syscall

	li $v0, 5						
	syscall
	move $t0, $v0

	addi $t1, $0, 30					
	bgt $t0, $t1, hot		

	slti $t2, $t0, 20  				

	beq $t2, $0, cond			
	
	li $v0,4						
	la $a0, msg4
	syscall
	
	j end_if

	cond:	ble $t0, $t1, plst

	
	plst:		li $v0,4		
			la $a0, msg3
			syscall
	j end


	hot: 		li $v0,4		
			la $a0, msg2
			syscall

	end:

	jr $ra

.end main