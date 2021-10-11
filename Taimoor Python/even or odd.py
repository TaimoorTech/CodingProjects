# a=int(input("enter the value : "))
# if a<0:
#    print('error:enter the positive integer')
# elif a%2==0:
#    print(a,"is even")
# else:
#    print(a,"is odd")
#
# #def my_func(**kwargs):
# #    for key,value in kwargs.items():
# #        print('key :',key,'and value :',value)
# #
# #my_func(first='computer',last='programming')
#
# import scipy
# print(help(scipy))

a = input("enter any num : ")
try:
    if a.isnumeric():
        print(a)

except a:
    if int(a):
        raise ValueError('You did not enter number')
