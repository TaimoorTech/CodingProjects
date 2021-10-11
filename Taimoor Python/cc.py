#count=0
#sums=0
#print('enter non-negative integers; enter negative integer to terminate.')
#while True:
 #   value=int(input('enter the value : '))
  #  if value<0 :
   #     break
    #sums+=value
    #count+=1
#kl
#print('no of values entered',count)
#print('average is :', round(sums/count))

##paas=input('enter your password :')
##sums=0
##i=len(paas)
##if 'a'<=paas[0:i]<='z':
##        sums+=1
##if '0'<=paas[0:i]<='9':
##        sums+=1
##if ('%' in paas) or ('$' in paas) or ('^' in paas) or ('!' in paas) or ('.' in paas) or (',' in paas) or ('&' in paas) or ('-' in paas) or ('+' in paas) or (';' in paas) or (':' in paas) or ('@' in paas):
##        sums+=1
##
##if sums==3:
##        print('passwprd is valid')
##else:
##        print('wrong!!!!!')
##        
##																							       

##def prime(n):
##        count=0
##        for i in range(1,n+1):
##                if n%i==0:
##                        count+=1
##        return count==2
##
##def digit_check(n):
##        return '2' in str(n) or '3' in str(n)
##
##for i in range(1,1000):
##        if prime(i) and digit_check(i):
##                print(i)        
def unique(secret_word):
        count=0
        s=secret_word.split()
        for i in range(len(s)):
                if i==s[i]:
                        count-=1
                count+=1
        print(count)


secret_word='examination'
unique(secret_word)
