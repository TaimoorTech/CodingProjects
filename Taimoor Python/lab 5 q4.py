##st1=input('Enter string 1 : ')
##st2=input('Enter string 2 : ')
##for i in st1:
##    if i in st2:
##        print('Common Characters :',i)
##for i in st1:
##    if i not in st2:
##        print('Uncommon Characters : ',i)

##n=int(input('Enter no of lines : '))
##for i in range(1,n+1):
##    print('*'*i)
##for i in range(n,0,-1):
##    print('*'*i)

##num=int(input('Enter the number of which Table you want : '))
##print('Table of ',num)
##for i in range(1,11):
##    print(num,'x',i,'=',num*i)

num=int(input('Enter a number to which even numbers will be printed : '))
for i in range(0,num+1):
    if i%2==0:
        print(i,end=' ')
