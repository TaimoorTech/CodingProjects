##f=open('words.txt','a')
##word_list=f.read()
##word_list=word_list.split()
##

##import numpy as np
##
##arr = np.array([1, 2, 3, 4, 5])
##
##print(arr)


##from scipy import constants
##print(constants.pi)
##from scipy import constants
##
##print(constants.kibi)    #1024
##print(constants.mebi)    #1048576
##print(constants.gibi)    #1073741824
##print(constants.tebi)    #1099511627776
##print(constants.pebi)    #1125899906842624
##print(constants.exbi)    #1152921504606846976
##print(constants.zebi)    #1180591620717411303424
##print(constants.yobi)
##


##for i in range(100):
##    if i%2 is not 0:
##        print(i)
##from functools import reduce
##
##def add(x, y):
##    return x + y
##
##list = [2, 4, 7, 3]
##print(reduce(add, list))
def starts_with_A(s):
    if s[0] == "A":
        return 2*2

fruit = ["Apple", "Banana", "Pear", "Apricot", "Orange"]
map_object = list(map(starts_with_A, fruit))

print(map_object)


