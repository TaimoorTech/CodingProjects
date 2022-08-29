.data
 cTemp: .word 49 
 ftemp: .word 0
 res: .asciiz "The temp in Farenheit is:"
.text
.globl main
.ent main
main:
 la $t0,cTemp
 syscall
 move $t0,$v0
 mul $t1,$t0,9
 div $t2,$t1,5
 addi $t3,$t2,32
 li $v0,1
 move $a0,$t3
 syscall
 jr $ra
.end main