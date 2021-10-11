import re
print('*'*18)
print('Enter the password is within given length of 7 to 15 and contain atleast one digit and special character')
print('*'*18)
x=input("Enter your password : ")
print('*'*18)
if 7<len(x)<15:
    if(re.search('[0-9]',x)):
         if((re.search("[@_!#$%^'&*.,;()<>?/\|}{~:]",x)) or chr(91) in x or chr(93) in x ):
            print('Your password is valid and acceptable')
            print('*'*18)
         else:
                print('Enter character in password')
                print('*'*18)
    else:
        print('Enter number please')
        print('*'*18)
else:
    print('Enter password in length')
    print('*'*18)

