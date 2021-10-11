###Q5
##num=int(input('Enter a number to which limit you want to print even numbers : '))
##for i in range(1,num+1):
##    if i%2==0:
##        print(i,end=' ')

##Q6
num=0
id1=input('Enter your id :')
id2=id1
while True:
    print('Welcome to Bank\nMain menu\n**********\nSelect the below choices\n(1)Deposit money\n(2)Withdraw Amount\n(3)Login as Different User')
    ch=int(input('Enter your choice :'))
    if id2!=id1:
        num=0
        id1=id2
    if ch==1:
        print('Your current balance is :',num)
        add=int(input('Enter money you want ot deposit :'))
        num+=add
        print('Your money is deposited in id',id1)
    elif ch==2:
        print('Your current balance is :',num)
        draw=int(input('Enter price you want to with draw :'))
        num-=draw
        print('Your money is withdrawn in id',id1)
    elif ch==3:
        print('Loging as Different user')
        id2=input('Enter new id :')
    cont=input('Do you want to continue or not\nIf yes press\'y\' or \'Y\', otherwise \'Enter\' ')
    if cont=='y'or cont=='Y':
        continue
    else:
        break
        

