##def sum1(n):
##    s = 0
##    while n > 0:
##        s += 1
##        n -= 1
##    return s
##def sum2():
##    global val
##    s = 0
##    while val > 0:
##        s += 1
##        val -= 1
##    return s
##def sum3():
##    s = 0
##    for i in range(val, 0, -1):
##        s += 1
##    return s
##def main():
##    global val
##    val = 5
##    print(sum2())
##    print(sum1(5))
##    print(sum3())
##main() # Call main function

#Q12
##def pytha(side1,side2):
##    hypo=((side1**2)+(side2**2))**0.5
##    return hypo
##
##side1=float(input('Enter first side adjacent to Right angle : '))
##side2=float(input('Enter second side adjacent to Right angle : '))
##print('The length of Hypotenuse is :',pytha(side1,side2))

#Q13
##def options(x1,y1,x2,y2):
##    if x1==x2:
##        print('The slope is infinty and the distance is',(((x2-x1)**2)+((y2-y1)**2))**0.5)
##    else:
##        print('The slope is',(y2-y1)/(x2-x1),'and the distance is',(((x2-x1)**2)+((y2-y1)**2))**0.5)
##
##x1=float(input('Enter the x-coordinate of point 1 : '))
##y1=float(input('Enter the y-coordinate of point 1 : '))
##x2=float(input('Enter the x-coordinate of point 2 : '))
##y2=float(input('Enter the y-coordinate of point 2 : '))
##options(x1,y1,x2,y2)

#Q15
##def lastf(first_name,last_name):
##    print(last_name + ',' + first_name[0]+'.')
##
##lastf('Albert', 'Camus')
##


##def proc(n):
##    if n < 1:
##        return 1
##    else:
##        return proc(n/2)
##print(proc(10))

from random import randrange
def fun1(n):
    result = 0
    while n:
        result += n
        n -= 1
    return result

def fun2(stars):
    for i in range(stars + 1):
        print(end="*")
    print()

def fun3(x, y):
    return 2*x*x + 3*y

def fun4(n):
    return 10 <= n <= 20

def fun5(a, b, c):
    return randrange(0, 2)

print(fun1(fun1(fun1(3))))
