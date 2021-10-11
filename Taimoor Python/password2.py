x=input('ENTER YOUR PASSWORD')
a=0
y=0
z=0
if 7<len(x)<15:
    for i in range(0,len(x)):
        if 'A'<=x[i]<='Z' or 'a'<=x[i]<='z' or '0'<=x[i]<='9' or '!'<=x[i]<='+':
            a=1
        if '!'<=x[i]<='+':
            y=1
        if '0'<=x[i]<='9':
            z=1
        
    if y==1 and z==1:
        print('hi')
    else:
        print('invalid')
else:
    print('no')
 
