#name='xyz'
#def change_name(new_name):
#    global name
#    name=new_name

#print(name)
#change_name('abc')
#print(name)

#Q4
def out_circle(rad):
    print('The area of outer circle with radius',rad,'is :',3.14*(rad**2))
    def in_circle(srad):
        print('The circumference of inner circle with smaller radius',srad,'is :',2*3.14*srad)
    srad=int(input('Enter the radius of the inner circle :'))
    in_circle(srad)
        

rad=int(input('Enter radius for outer circle : '))
out_circle(rad)
