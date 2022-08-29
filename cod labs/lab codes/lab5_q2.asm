.data
	msg1: .asciiz "Enter Temperature of the day: "
	msg2: .asciiz "It is hot today."
	msg3: .asciiz "Pleasant weather."
	msg4: .asciiz "It is cold today."
.text
.globl main
.ent main
main:
	li $v0, 4						#String Display	
	la $a0, msg1
	syscall

	li $v0, 5						#Integer Input
	syscall
	move $t0, $v0

	addi $t1, $0, 30					#Initializing t1 to 30

	bgt $t0, $t1, hot_weather			#temp>30

	slti $t2, $t0, 20  				#temp>20

	beq $t2, $0, Pleasant_weather_cond			
	
	li $v0,4						#String Display
	la $a0, msg4
	syscall
	
	j end_if

	Pleasant_weather_cond:	ble $t0, $t1, Pleasant_weather	#temp<=30

	
	Pleasant_weather:		li $v0,4		#String Display
					la $a0, msg3
					syscall
	j end_if


	hot_weather: 		li $v0,4		#String Display
					la $a0, msg2
					syscall

	end_if:

	jr $ra

.end main