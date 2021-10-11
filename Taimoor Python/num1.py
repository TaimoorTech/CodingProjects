##""" Provides the increment function, increment. """
##def increment(x):
##    """ Increments x by 1 and returns the result. """
##    return x + 1

##for i in range(1,51):
##    if i%2!=0 and i%3!=0:
##        print(i)

##n=1235
##w=str(n)
##count=0
##for i in w:
##    count+=1
##
##a=str(count)+w[-1]
##print(int(a))

##l1=[2,3,5,6]
##l2=[5,6,97]
##print('The inresection is ')
##for i in l1:
##    if i in l2:
##        print(i)

##from random import randint
##n=int(input())
##l=[]
##for i in range(n):
##    l.append(randint(0,21))
##print(l)

##l=['my','name','is','syed','muhammad','taimoor']
##m=l[0]
##for i in l:
##    if len(m)<len(i):
##        m=i
##
##print('The length of longest word in the given list : ',len(m))

##st1=input('Enter string 1 : ')
##st2=input('Enter string 2 : ')
##c1=0
##c2=0
##for i in st1:
##    c1+=1
##for i in st2:
##    c2+=1
##if c1>c2:
##    print('The larger string is :',st1)
##elif c2>c1:
##    print('The larger string is :',st2)
##else:
##    print('Both string is equal')

##keys = ['red', 'green', 'blue']
##values = ['#FF0000','#008000', '#0000FF']
##d={}
##for i in range(len(keys)):
##    d[keys[i]]=values[i]
##print(d)

##def sums(n,v):
##    v+=(n%10)
##    if n<10:
##        #v+=n
##        print(v)
##        return 
##    else:
##        return sums(n//10,v)
##
##n=int(input('Enter number : '))
##v=0
##sums(n,v)

def lcm(a,b):
    lcm.multiple=lcm.multiple+b
    if((lcm.multiple % a == 0) and (lcm.multiple % b == 0)):
        return lcm.multiple;
    else:
        lcm(a, b)
    return lcm.multiple
lcm.multiple=0
a=int(input("Enter first number:"))
b=int(input("Enter second number:"))
if(a>b):
    LCM=lcm(b,a)
else:
    LCM=lcm(a,b)
print(LCM)
