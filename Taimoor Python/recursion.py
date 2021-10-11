#Write Python Program to Find the Binary Equivalent of a Number Recursively
##def bina(num):
##    if num<1:
##        return 
##    else:
##        v=num%2
##        a=num//2
##        bina(a)
##        print(v,end='')
##def bina(num):
##  if num > 1:
##     bina(num//2)
##  print(num % 2,end = '')
##
##num=int(input('Enter your number : '))
##bina(num)

##def l(st,count):
##    if st=='':
##        print('The length of the string is :',count)
##        return
##    else:
##        count+=1
##        return l(st[1::],count)
##
##
##
##st=input('Enter string : ')
##count=0
##l(st,count)
##

def prime(num,i,count):
    if i==0:
        return
    else:
        if num%i==0:
            count+=1
        i-=1
        prime(num,i,count)
    if count>2:
        print('This is not prime')
    else:
        print('This is prime')
    


num=int(input('Enter your number : '))
i=num
count=0
prime(num,i,count)
