# Q13
##num=int(input('Enter the number of lines : '))
##for i in range(1,num+1):
##    for j in range(1,i+1):
##        print(j,end=' ')
##    print()

# Q1(a)
#num=int(input('Enter the number of lines : '))
#for i in range(1,num+1):
#        print(str(i)*i)

# Q1(b)
#num=int(input('Enter the number of lines : '))
#for i in range(1,num+1):
#       print('*'*i)

# Q7
#sums=0
#num=int(input('Enter the number to which term you want to have Harmonic series : '))
#for i in range(1,num+1):
#    sums=sums+(1/i)
#    if i<num:
#        print('1/',i,' + ',end='',sep='')
#    else:
#        print('1/',i,sep='')
#print('sum upto',num,'is',sums)

# Q9
#sums=0
#num=int(input('Enter the number of terms you wanted : '))
#for i in range(1,num+1):
#    term='9'*i
#    sums=sums+int(term)
#    print(term,end=' ')
#print()
#print('The sum of the series :',sums)

# Q10
#num=int(input('Enter the number of employees for gross and net salaries : '))
#for i in range(1,num+1):
#    print('Enter the Basic Salary of an Employee',i,': ',end='')
#    Basic_salary=int(input())
#    if Basic_salary<=10000:
#        House_Rent_Allowance = Basic_salary * 0.2
#        Dearness_Allowance = Basic_salary * 0.8
#        Deductions = Basic_salary * 0.02
#    elif Basic_salary<=20000:
#        House_Rent_Allowance = Basic_salary * 0.25
#        Dearness_Allowance = Basic_salary * 0.9
#        Deductions = Basic_salary * 0.04
#    elif Basic_salary>20000:
#        House_Rent_Allowance = Basic_salary * 0.3
#        Dearness_Allowance = Basic_salary * 0.95
#        Deductions = Basic_salary * 0.1
#    Gross_Salary = Basic_salary + House_Rent_Allowance + Dearness_Allowance
#    Net_Salary = Gross_Salary - Deductions
#    print('The Gross Salary of employee',i,': ',Gross_Salary)
#    print('The Net Salary of employee',i,': ',Net_Salary)
#    print()

# Program to Convert Decimal to Binary
binary=str()
num=int(input('Enter a Decimal number to know its Binary Equivalent : '))
while True:
    if num>1:
        bina=num%2
        binary=binary+str(bina)
        num=num//2
    if num==1:
        binary=binary+'1'
        break
print(binary[::-1],)

# To print factors
#num=int(input('Enter the number for finding factors of it : '))
#print('the factors of',num,'are')
#fact=int(num/2)

# Fibonacci series
#num=int(input('Enter number of terms : '))
#a = 0
#b = 1
#print(a,b,end=' ')
#for i in range(3,num+1):
#    c = a + b
#    print(c,end=' ')
#    a = b
#    b = c

#for i in range(1,fact+1):
#    if num % i == 0:
#        print(i)
#print(num)

#south=float(input('Enter Boolean value of south : '))
#north=float(input('Enter Boolean value of north : '))
#west=float(input('Enter Boolean value of west : '))
#east=float(input('Enter Boolean value of east : '))
#if north!=0 or south!=0 or west!=0 or east!=0:
#   print('I can escape')

##x=int(input())
##if x!=2:
##    print('True')
##
