.data
     cTemp:     .word 31 
     
     fTemp:     .word 0

     res:       .asciiz "The temperature in Fahrenheit is: "

.text
.globl main
.ent main
main:
     lw $t1, cTemp

     addi $t2, $t2, 9
     
     mul $t3, $t1, $t2

     addi $t4, $t4, 5

     div $t5, $t3, $t4

     addi $t6, $t5, 32

     li $v0, 4			#String Display
     la $a0, res
     syscall

     li $v0, 1			#Integer Display
     sw $t6, fTemp
     lw $t7, fTemp
     move $a0, $t7
     syscall

    
     jr $ra
.end main 