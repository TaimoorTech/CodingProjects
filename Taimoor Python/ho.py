st1=input('Enter string 1 : ')
st2=input('Enter string 2 : ')

for i in st1:
    if i in st2:
        print('Common Characters :',i)
    else:
        print('Uncommon Characters : ',i)
