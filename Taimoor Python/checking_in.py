 #s='irjfgxh4'
#if chr(48) in s or chr(49) in s or chr(50) in s or chr(51) in s or chr(52) in s or chr(53) in s or chr(54) in s or chr(55) in s or chr(56) in s or chr(57) in s :
 #   print('hi')
#else:
 #   print('bye')

#tupA=1,2,'cat'
#tupB=7.5,445
#tupA+=tupB
#tupA+=7,
#print(tupA)

#tu=1,2,3,5,7,11,13,19,23,29
#print(tu[1:3])
#print(tu[1:3:-1])
#print(tu[-1:3:-1])
#print(max(tu))

#vals=0,9,10,-458,-900,25
#minm=vals[0]
#for i in range(0,len(vals)):
    #if vals[i]<minm:
         #minm=vals[i]
#print('The smallest value is:',minm)

#print( sum(3,4,7) )

#tu3=2,3,(4,5)
#print(tu3[2][0])

#values=-5,0,-595,-56
#mini=values[0]
#for item in values:
 #   if mini < item:
  #      mini=item
#print('The largest value is ',mini, sep=': ')

#values=()
#for i in range(5):
 #   val=int(input('enter any integer : '))
  #  values+=val,
#print('the values are :', values)

#pets=['~cat','dog','mouse','fish']
#morepets=['Turtle', 'Chick']
#pets+=morepets
#print(max(pets))

#table=list()
#for i in range(4):
 #   print('enter values for row', i , 'of the tabel, seperated by space:',end='')
  #  values=input()
  #  lvalues=values.split()
  #  table.append(lvalues)
#print(table)

 #area = 3*3.14
#circumference = 3*8*6
#circle=(area,circumference)
#print(circle[0])
#k=1
#v='cp'
#d={k:v}
#print(len(d))

#courses={1:'CP',2:'FCE',3:'CAL',4:'FUNCENG',5:'PSTD',6:'BEE '}
#items=courses.items()
#print(courses.items())
#print(courses.keys())
#print(courses.values())
#courses.pop(3)
#courses.update({3:'calc'})
#print(courses)
#i=1
#print(len(courses))
#for i in items:
  #  #print(i)
 #   print(i[2])

#print(id(5))
#a=77
#print()
#print(id(a))
#m=5
#print()
#print(id(m))

#mystring=['computar']
#mystring[1]='e'
#print(mystring)
#ist=[1,2,4,4,5]
#ist[2]=3
#print(ist)

#done=False
#n,m=0,100
#while not done and n!=m:
 #   n=int(input())
  #  if n < 0:
   #     done=True
   # print('n=',n)

#n,m=0,100
#while n!=m:
#    n=int(input())
#    print('n=',n)
#    if n<0:
#        break
##i=1
##n=int(input())
##while i<=n:
##    if n<1:
##        break
##    print('*'*n)
##    i+=1

def add_question():
    ques=input('Enter question :')
    o1=input('option 1: ')
    o2=input('option 2: ')
    o3=input('option 3: ')
    c=int(input('Correct answer number '))
    return ques,o1,o2,o3,c
    

ch=input('Ebter ')
if ch=='A':
    w=add_question()
    with open('questionDB.txt','a') as f:
        content=str(w)
        con=content.split()
        l=[]
        for i in con:
            l.append(i)
        for i in l:
            f.write(i)
        f.write(' ')
    with open('questionDB.txt') as f:
        d={}
        c=f.read()
        c=c.split()
        print(c)
        

