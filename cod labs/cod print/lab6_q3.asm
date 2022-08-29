.data
	msg1: .asciiz "Enter Integer : "
	msg2: .asciiz "The number is "
	msg3: .asciiz "Composite" 
	msg4: .asciiz "Prime"
.text
.globl main
.ent main
main:
	li $v0, 4			
	la $a0, msg1 
	syscall

	li $v0, 5			
	syscall
	move $t0,$v0

	addi $t1, $0, 1		
	addi $t3, $0, 0		
	addi $t4, $0, 0		 
	addi $t5, $0, 3		 
	addi $t6, $t0, 1


	loop: 	beq $t1, $t6, end
			div $t0, $t1
			mfhi $t3
			beq $t3, $0, cal
			addi $t1, $t1,1
			j loop

			cal:  	addi $t4, $t4, 1
					beq $t4, $t5, end	
 			addi $t1, $t1,1
			j loop

	end:

	li $v0, 4			
	la $a0, msg2
	syscall

	beq $t5, $t5, comp
	li $v0, 4 		
	la $a0, msg4
	syscall
	
	j end_if 
	
	comp:	li $v0, 4 		
		la $a0, msg3
		syscall

	end_if:

	jr $ra

.end main