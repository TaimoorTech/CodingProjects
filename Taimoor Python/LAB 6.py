#q3
gadgets=["Mobile","Laptop",100,"Camera", 310.28,"Speakers",27.00,"Television",1000,"Laptop Case","Camera Lens"]
strings=[];numbers=[]
for i in gadgets:
    if type(i)==str:
        strings.append(i)
    else:
        numbers.append(i)
print(strings);print(numbers)
strings.sort()
print(strings);print(strings[::-1])
numbers.sort()
print(numbers);print(numbers[::-1])

##Q4
##l=[86,85,85,85,83,23,45,84,1,2,0]
##first=l[0];second=0
##for i in l:
##    if first<i:
##        first=i
##print('The first best score is :',first)
##x=l.count(first)
##if x>1:
##    print('The second best score is :',first)
##else:
##    l.pop(l.index(first))
##    for i in l:
##        if second<i:
##            second=i
##    print('The second best score is :',second)

#Q1
#l=['This','is','simple','computer','programming','using','python']
#print(l[0:2]+l[3:5])
