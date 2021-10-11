t=int(input('How many numbers you want to enter from which you want max :'))
num1=int(input('Enter your number 1 : '))
for i in range(2,t+1):
    print('Enter your number',i,': ',end=' ')
    num2=int(input())
    if num1<num2:
        num1=num2

print('The maximum value among the numbers you entered is :',num1)
