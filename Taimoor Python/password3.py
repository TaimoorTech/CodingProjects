p=input('enter your password ')
n=0;c=0
if 7<len(p)<15:
    if '0'<=p[0]<='9':
        n=1
    if '!'<=p[0]<='+':
        c=1
    if '0'<=p[1]<='9':
        n=1
    if '!'<=p[1]<='+':
        c=1
    if '0'<=p[2]<='9':
        n=1
    if '!'<=p[2]<='+':
        c=1
    if '0'<=p[3]<='9':
        n=1
    if '!'<=p[3]<='+':
        c=1
    if '0'<=p[4]<='9':
        n=1
    if '!'<=p[4]<='+':
        c=1
    if '0'<=p[5]<='9':
        n=1
    if '!'<=p[5]<='+':
        c=1
    if '0'<=p[6]<='9':
        n=1
    if '!'<=p[6]<='+':
         c=1
    if len(p)>=8:
        if '0'<=p[7]<='9':
            n=1
        if '!'<=p[7]<='+':
            c=1
    if len(p)>=9:
        if '0'<=p[8]<='9':
            n=1
        if '!'<=p[8]<='+':
            c=1
    if len(p)>=10:
        if '0'<=p[9]<='9':
            n=1
        if '!'<=p[9]<='+':
            c=1
    if len(p)>=11:
        if '0'<=p[10]<='9':
            n=1
        if '!'<=p[10]<='+':
            c=1
    if len(p)>=12:
        if '0'<=p[11]<='9':
            n=1
        if '!'<=p[11]<='+':
            c=1
    if len(p)>=13:
        if '0'<=p[12]<='9':
            n=1
        if '!'<=p[12]<='+':
            c=1
    if len(p)>=14:
        if '0'<=p[13]<='9':
            n=1
        if '!'<=p[13]<='+':
            c=1
    if len(p)>=15:
        if '0'<=p[14]<='9':
            n=1
        if '!'<=p[14]<='+':
            c=1
    if n==1 and c==1:
        print('password is valid')
    elif n==1 and c==0:
        print('add special character in password')
    elif n==0 and c==1:
            print('add number in password')
    elif n==0 and c==0:
        print('add number and special character both in password')
else:
    print('enter password in length')
