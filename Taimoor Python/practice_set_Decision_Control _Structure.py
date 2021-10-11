 # Q1 and Q2
#num=int(input('Enter a integer between 1 and 100 : '))
#if 1<num<100 :
#    print('ok')
#else :
#    print('Out of Range')

count=0
a = 0
while a < 100:
    b = 0
    while b < 55:
        #print('*')
        b += 1
        count+=1
    a += 1
print(count)

# Q3
#i=7
#j=5
#k=3
#if i < j:
#    if j < k:
#        i = j
#    else:
#        j = k
#else:
#    if j > k:
#       j = i
#    else:
#        i = k
#print("i =", i, " j =", j, " k =", k)

# Q6
#alp=input('Enter ONE Alphabet : ')
#if len(alp)==1:
#    if 'A'<=alp<='Z':
#        print('UpperCase Alphabet')
#    elif 'a'<=alp<='z':
#        print('LowerCase Alphabet')
#    else :
#        print('Error ; Please Enter any Alphabet')
#else :
#    print('Error ; Enter in range')

# Q10
#numb=[]
#for i in range(5):
#    num=int(input('Enter value'))
#    numb.append(num)
#for i in range(5):
#    print(numb[i])

    
# Q4  
#val = int(input())
#if val < 10:
#    if val != 5:
#        print("wow ", end='')
#    else:
#        val += 1
#else:
#    if val == 17:
#        val += 10
#    else:
#        print("whoa ", end='')
#print(val)

# Q9
#n1=int(input('enter number 1 : '))
#maxs=n1
#mins=n1
#for i in range(2,6):
#    print('Enter number', i , ': ', end='')
#    num=int(input())
#    if maxs < num:
#        maxs = num
#    elif mins > num:
#        mins = num

#print('max =',maxs)
#print('min =',mins)

# Q10
#count=0
#print('enter five integers , if any integer is same it prints DUPLICATES, if all integer are different it prints ALL UNIQUR')
#num1=int(input('enter number 1 : '))
#for i in range(2,6):
#    print('enter number',i,': ',end='')
#    num=int(input())
#    if num1==num:
#        count=1
#if count==1:
#    print('DUPLICATES')
#else:
#    print('ALL UNIQUE')

# Q14
#units=int(input('Enter your units consumed on on your meter : '))
#if units in range(1,51):
#    bill=units*0.50
#elif units in range(51,151):
#    bill=units*0.75
#elif units in range(151,251):
#    bill=units*1.20
#else :
#    bill=units*1.50
#print('Your Total Electricity Bill : ',bill)                    

    


