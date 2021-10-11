##count=0
##num=int(input('enter any number : '))
##print('Its factors are :',end=' ')
##for i in range(1,num+1):
##    if i==num:
##        count+=1
##        print(i)
##        break
##    if num%i==0:
##        print(i,end=',')
##        count+=1
##elif num==1:
##    print('neither prime nor composite')
##elif count>2:
##    print('It is Composite number')
##else:
##    print('It is Prime number')

from num1 import increment 
print(increment(4))
