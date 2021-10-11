##def unique(secret):
##    count=[]
##    for i in range(len(secret)):
##        if secret[i] in count:
##            continue
##        else:
##            count.append(secret[i])
##    print(len(count))
##
##
##
##
##secret='examination'
##unique(secret)

##def remove(letter,alphabets):
##    count=alphabets.index(letter)
####    new_alphabets=''
##    new_alphabets=alphabets[:count]
##    new_alphabets+=alphabets[(count+1):]
##    print(new_alphabets)
##
##letter='f'
##alphabets='abcdefg'
##remove(letter,alphabets)

##def fib(n):
##    if n==1:
##        return 0
##    elif n==2:
##        return 1
##    else:
##        return fib(n-2)+fib(n-1)
##
##
##num=int(input('Enter number : '))
##print(fib(num))

##add= lambda a,b : a + b
##
##a=int(input('Enter number : '))
##b=int(input('Enter number : '))
##print(add(a,b))


import os
print(os.path.exists("grade.txt"))
