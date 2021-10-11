f=open('lab 13.txt')
content=f.read()
l=content.split()
##for i in range(len(l)):
##    if i==(len(l)-1):
##        print(l[i])
##    else:
##        print(l[i],end=' , ')
large=l[0]
for i in l:
    if len(large)<len(i):
        large=i
print(large)
f.close()
#content=f.read()
##for i in f:
##    print(i,end=' ' )
