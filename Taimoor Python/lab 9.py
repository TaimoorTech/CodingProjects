#Q1 calculator
def add(num1,num2):
    add=num1+num2
    return add

def subt(num1,num2):
    subt=num1-num2
    return subt

def mult(num1,num2):
    return num1*num2
 

def divi(num1,num2):
    divi=num1/num2
    return divi

print('================The Calculator================')
print('Provide two numbers to Calculator and selects operation number from menu\n(1)ADDITION\n(2)SUBTRACTION\n(3)MULTIPLICATION\n(4)DIVISION\nIf you want to terminate press 0 in choice')
while True:
    n=int(input('Enter your choice :'))
    if n==0:
        print('Thanks')
        break
    num1=float(input('Enter number 1 : '))
    num2=float(input('Enter number 2 : '))
    if n==1:
        print('The addition of',num1,'and',num2,'is :',add(num1,num2))
    elif n==2:
        print('The subtraction of',num1,'and',num2,'is :',subt(num1,num2))
    elif n==3:
        print('The multiplication of',num1,'and',num2,'is :',mult(num1,num2))
    elif n==4:
        print('The division of',num1,'and',num2,'is :',divi(num1,num2))
    else:
        print('Enter correct choice')
