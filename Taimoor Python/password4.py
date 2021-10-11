s=input('Enter the Password between 7 to 15 and must incudes atleast one Numeric Digit and a Special character : ')
n=0
c=0
if 7<len(s)<15:
    if '0' in s or '1 ' in s or '2' in s or '3' in s or '4' in s or '5' in s or '6'in s or '7' in s or '8'in s or '9'in s :
        n=1
    if '!' in s or '@' in s or '#' in s or '$' in s or '%' in s or '^' in s or '&' in s or '*' in s or '(' in s or ')' in s or '_' in s or '|' in s:
        c=1
    elif '[' in s or ']' in s or '{' in s or '}' in s or '+' in s or '-' in s or';' in s or ':' in s or '?' in s or '~' in s or '.' in s or ',' in s :
        c=1
    if n==1 and c==1:
        print('Password is Valid')
    if n==0 and c==1:
        print('Enter atleast one Number in Password')
    if n==1 and c==0:
        print('Enter atleast a Special Charcter in Password')
    if n==0 and c==0:
        print('Enter atleast one Number and a Special Character in Password')
else:
    print('Enter Password in Length')
