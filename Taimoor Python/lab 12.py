#Q3
##l=[]
##num=input('Enter values of tuple seperated by commas : ')
##l=num.split(',')
##l.reverse()
##t=tuple(l)
##print('The tuple in reverse order is :',t)

#Q1
l1=[(4,5,8,9),(5,9,8,7),(4,5,6,8)]
l2=[]
print('Before change',l1)
for i in range(len(l1)):
    t=list(l1[0])
    t[-1]='taimoor'
    m=tuple(t)
    l2.append(m)
    
print('After change',l2)

##my_tuple=('p','r','o','g','r','a','m','m','i','n','g')
##print(my_tuple[:])
