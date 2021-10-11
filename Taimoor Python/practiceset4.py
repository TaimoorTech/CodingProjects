#Q2
#lst = [3, 0, 1, 5, 2]
#x = 2
#print(lst[lst[lst[x]]])

#Q3
#lst = [20, 1, -34, 40, -8, 60, 1, 3]
#print(len(lst))

#Q5
#print(3 * ([1, 2] + [4, 2]))

#print([(x, y) for x in range(3) for y in range(4)])

#Q7
#lst=[3,6,-8,-5]
#sums=0
#if len(lst)>0:
#    for i in lst:
#        if i>0:
#            print(i)
#            sums+=i
#else :
#    print(0)
#if len(lst)>0:
#    print('The sum of all positive numbers in the list is : ',sums)

#Q8
#lst=[3,5,4,-1,0]
#count=0
#if len(lst)>0:
#    for i in lst:
#        if i%2==0:
#            print(i)
#            count+=1
#else:
#    print(0)
#if len(lst)>0:
#    print('The Even numbers in the list is/are :',count)

#Q11
#print('for x enter x and for 0 enter 0 and for nothing leave that')
#lst=[]
#for i in range(3):
#    val=input('Enter 3 values seperated by space :')
#    lvalues=val.split()
#    lst.append(lvalues)

#d = {3:0, 5:1, 10:1, 8:2, 15:4}   
#for x in d.values():
#    print(x)

##def proc(x):
##    return x + 2
##def proc(n):
##    return 2*n + 1
##def main():
##    x = proc(5)
##main()

#Q9
##num=int(input('Enter number x :'))
##l=[]
##n=int(input('How many numbers you want to enter in the list : '))
##for i in range(n):
##    print('Enter number',i+1,': ',end=' ')
##    val=float(input())
##    if val>num:
##        l.append(val)
##
##print('The numbers which are greater than number',num,'is/are :',l)

##d = {3:0, 5:1, 10:1, 8:2, 15:4}
##d[4]=55
##print(d)

#Q12
##mat1=[]
##row1=int(input('Enter row 1 : '))
##col1=int(input('Enter column 1 : '))
##for i in range(row1):
##    print('Enter',col1,'values in row',i+1,'seperateed by commas : ',end=' ')
##    val=input()
##    lvalues=val.split(',')
##    mat1.append(lvalues)
##for i in range(row1):
##    for j in range(col1):
##        mat1[i][j]=int(mat1[i][j])
##
##mat2=[]
##row2=int(input('Enter row 2 : '))
##col2=int(input('Enter column 2 : '))
##for i in range(row2):
##    print('Enter',col2,'values in row',i+1,'seperateed by commas : ',end=' ')
##    val=input()
##    lvalues=val.split(',')
##    mat2.append(lvalues)
##for i in range(row2):
##    for j in range(col2):
##        mat2[i][j]=int(mat2[i][j])
##ch=int(input('Select 1 for addition and 2 for multiplication : '))
##f=[]
##if ch==1:
##    if row1==row2 and col1==col2:
##        for i in range(row1):
##            for j in range(col1):
##                val=mat1[i][j]+mat2[i][j]
##                f.append(val)
##
##print(f)
l=[]
for i in range(3):
    n=input('Enter three values by commas ')
    val=n.split(',')
    l.append(val)

if l[0][0]=='o' and l[0][1]=='o' and l[0][2]=='o':
    print('0 wins')
elif l[0][0]=='x' and l[0][1]=='x' and l[0][2]=='x':
    print('x wins')
elif l[0][0]=='o' and l[1][0]=='o' and l[1][0]=='o':
    print('o wins')
elif l[0][0]=='x' and l[1][0]=='x' and l[2][0]=='x':
    print('x wins')
elif l[1][0]=='o' and l[1][1]=='o' and l[1][2]=='o':
    print('o wins')
elif l[1][0]=='x' and l[1][1]=='x' and l[1][2]=='x':
    print('x wins')
elif l[0][1]=='o' and l[1][1]=='o' and l[2][1]=='o':
    print('o wins')
elif l[0][1]=='x' and l[1][1]=='x' and l[2][1]=='x':
    print('x wins')    
elif l[2][0]=='o' and l[2][1]=='o' and l[2][2]=='o':
    print('o wins')
elif l[2][0]=='x' and l[2][1]=='x' and l[2][2]=='x':
    print('x wins')
elif l[0][2]=='o' and l[1][2]=='o' and l[2][2]=='o':
    print('o wins')    
elif l[0][2]=='x' and l[1][2]=='x' and l[2][2]=='x':
    print('x wins')
elif l[0][0]=='o' and l[1][1]=='o' and l[2][2]=='o':
    print('o wins')
elif l[0][0]=='x' and l[1][1]=='x' and l[2][2]=='x':
    print('x wins')
elif l[0][1]=='o' and l[1][1]=='o' and l[2][1]=='o':
    print('o wins')
elif l[0][1]=='x' and l[1][1]=='x' and l[2][1]=='x':
    print('x wins')
else:
    print('No wins')
