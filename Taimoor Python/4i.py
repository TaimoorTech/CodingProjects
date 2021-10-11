##print('Welcome To Taimoor Bakery')
##print('We are offering following items')
##print('1.Pastries(Price: Rs.25, serves:1')
##print('2.Samosa(Price: Rs.15, serves:1)')
##print('3.Gulab Jamun(Price: Rs.300, weight:1Kg)')
##print('4.Exit')
##sums=0
##while True:
##    choice=int(input('Enter your Choice : '))
##    if choice==4:
##        break
##    if choice==1:
##        pastries=int(input('how many pastries : '))
##        sums=sums+(pastries*25)
##    if choice==2:
##        samosa=int(input('how many samosa : '))
##        sums=sums+(samosa*15)
##    if choice==3:
##        gulab_jamun=int(input('how many gulab jamun : '))
##        sums=sums+(gulab_jamun*300)
##print('your Total Bill is :',sums)
##print('your food will be delivered in 30 mins')
##print('Thanks for visiting, Come back soon')
##


try:
    f = open("censored.txt")

except IOError as e:
    print("error hai",e)


else:
    print("This will run only if except is not running")

finally:
    print("Run this anyway...")
    #f.close()
 

print("Important stuff")

import time
time.sleep(4)