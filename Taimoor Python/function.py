def circle (r):
    '''returns the circumference of the circle'''
 #   print('circumference =',3.14*r**2)
  #  print('area =',r*3.14)
    #return r*3.14,3.14*r**2
    #area=r*3.14
    #circumference=3.14*r**2
    #return area,circumference
print(circle.__doc__)

#print(circle(3))
#res=circle(5)
#print(res[0])
#x=5
#print(circle(x))

#def neg(lists):
    
 #   count=0
 #   for i in lists:
        
  #      if i<0:
   #          count+=1
    #return count

#mylist=[3,2,-33,4,-60,0,1,-92]
#negative_count=neg(mylist)
#print(negative_count)
#print(neg(mylist))

#def g(x):
 #   x==5
 #   print(x)

#a=3
#g(a)
#print(a)

def pows(x,y):
    return x**y

a=2
b=2
c=3
pow1=pows(b,c)
pow2=pows(a,pow1)
print(pow2)
