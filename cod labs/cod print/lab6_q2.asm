.data
	msg1: .asciiz "Enter Integer : "
	msg2: .asciiz "Factorial :"
.text
.globl main
.ent main
main:

	addi $t0, $0, 1			

	li $v0,4				
	la $a0, msg1
	syscall

	li $v0, 5				
	syscall
	move $t1, $v0

	addi $t2, $0, 1

	loop:		beq $t0, $t1, End_loop
			addi $t3, $t0, 1 
			mul $t2, $t2, $t3 
			addi $t0, $t0, 1
			j loop

	End_loop:

	li $v0, 4				
	la $a0, msg2 
	syscall
	
	li $v0, 1				
	move $a0, $t2 
	syscall

	jr $ra

.end main