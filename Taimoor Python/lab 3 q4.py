password=input('Enter your  password :')
if len(password)>7 and len(password)<15:
    if (password.isdigit()and password.isalpha()) not in password :
        print('Password is acceptable')
    else:
        print('Password is ')
