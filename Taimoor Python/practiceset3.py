#for i in range(5):
 #   print(i)

#count=0
#i=-100
#while i < 100:
 #   print('*')
  #  i+=10
   # count+=1
#print(count)

#a=0
#while a>100:
 #   print(a)
 #   a+=1

#for i in range(100,100):
 #   print(i)

#count=0
#a = 0
#while a < 100:
 #   if a%5==0:
  #      print( '*' )
   #     count+=1
     #a += 1
#print(count)

#count=0
#a = 0
#while a < 100:
 #   b = 0
  #  while b < 55:
        #print('*')
   #     b += 1
    #    count+=1
   # a += 1
#print(count)

#Q3(a)
#count=0
# n=int(input('enter no of lines :'))
#for i in range(1,n+1):
 #   for j in range(i):
  #     count+=1
   #     print(count,end=' ')
   # print()

#Q10
#n=int(input('Enter number of lines for printing (*) in nxn box form; please donot enter value less than 1 : '))
#for i in range(n):
#    if n<1:
#        break
#    print('*'* n)


#Q15
#print('In this program, you have to input 4 values . If the average of first three values equals to fourth , it prints equal')
#first=float(input('Enter the first value : '))
#second=float(input('Enter the second value: '))
#third=float(input('Enter the third value : '))
#last=float(input('Enter the last value : '))
#avg=(first+second+third)/3
#if avg==last:
#    print('Equal')

#Q16
#num=int(input('Enter n : '))
#m = num//1000
#c = (num%1000 - num%100)//100
#d = (num%100 - num%10)//10
#u = num%10
#print(m)
#print(c)
#print(d)
#print(u)

# Q13(a)
#count=0
#line=int(input('Enter number of lines : '))
#for i in range(1,line+1):
#    for j in range(i):
#        count+=1
#        print(count,end=' ')
#    print()

# Q13(b)
#count=1
#line=int(input('enter nuber of lines : '))
#n=line-1
#for i in range(1,line+1):
#    if  i == line:
#        print('*'*count)
#    else:
#        print(' '*(n),end='')
#        print('*'*count)
#        count+=2
#    n-=1 

# Q14
#fact=1
#num=int(input('Enter the number of which you want to find the factorial : '))
#if num == 0:
#    print('The factorial of 0 is 1')
#elif num>0:
#    for i in range(1,num+1):
#            fact=fact*i
#    print('The factorial of',num,'is',fact)

# Q11
##n1=float(input('Enter value 1 : '))
##sums=n1
##maxs=n1
##mins=n1
##for i in range(2,21):
##    print('Enter value',i,': ',end='')
##    num=float(input())
##    sums = sums + num
##    if maxs < num:
##        maxs = num
##    if mins > num:
##        mins = num
##avg=sums/20
##print('The sum is :',sums)
##print('The max no is :',maxs)
##print('The min no is :',mins)
##print('The average is :',avg)

from tkinter import Tk,Label,Frame
r=Tk()
r.title('Keypad')
value=1
f=Frame(r)
for i in range(3):
    for j in range(3):
        lab=Label(f,text=value,border=5,bg='#FFC107',relief='groove')
        lab.grid(row=i,column=j)
        value+=1
lab1=Label(f,text=0,bg='#FFC107',relief='groove')
lab1.grid(row=3,column=1)
f.pack()
r.mainloop()
