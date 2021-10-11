###Q1
def fib(add,n,num):
    if num<1:
        return num
    else:
        print(add,end=' ')
        m=add
        add+=n
        n=m
        return fib(add,n,num-1)
    
add=0
n=1
num=int(input('Enter the limit to which you want fibocanni series : '))
fib(add,n,num)


###Q2
##def sums(num):
##    if num<=1:
##        return num
##    else:
##        return num + sums(num-1)
##    
##num=int(input('Enter limit : '))
##print(sums(num))

#Q3
##def fact(num):
##    if num==1 or num==0:
##        return 1
##    elif num>1:
##        return num*fact(num-1)
##
##
##num=int(input('Enter the number fo which factorial you want :'))
##print(fact(num))
