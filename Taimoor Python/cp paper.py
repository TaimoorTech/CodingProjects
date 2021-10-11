##def powers(num):
##    for i in range(1,num+1):
##        print(2**i,end=' ')
##
##num=int(input('Enter the number to which you want answer of powers of 2 : '))
##powers(num)

##def func():
##    while a<100:
##        if a%5==0:
##            print('*')
##        a+=1
##a=70
##func()

##def min_max(l):
##    print(max(l))
##    print(min(l))
##    with open('values.txt','w') as f:
##        for i in l:
##            f.write(i+' ')
##
##l=[]
##num=input('Enter values seperated by commas :')
##n=num.split(',')
##for i in n:
##    l.append(i)
##min_max(l)

def input_rec(nu,rec_lst):
    for i in range(nu):
        print('Enter name,roll no,marks seperated by commas for student',i+1,': ',end='')
        np=input()
        val=np.split(',')
        rec_lst.append(val)
    with open('studentDB.txt','w') as f:
        for i in rec_lst:
            for j in i:
                f.write(j+' ')
            f.write('\n')

    return rec_lst
def marks(file):
    l=[]
    avg=0
    with open('studentDB.txt','r') as f:
        con=f.readlines()
        for i in con:
            m=i.split(' ')
            l.append(m)
    for i in  range(len(l)):
        avg+=int(l[i][2])
    print('The average is :',avg/nu)
    for i in range(len(l)):
        std=((int(l[i][2])-avg)**2/(nu-1))**0.5
        print('The standard deviation of student',l[i][0],'is :',std)
       


rec_lst=[]
nu=int(input('Enter no of students for records: '))
input_rec(nu,rec_lst)
file=input('enter filename')
marks(file)
