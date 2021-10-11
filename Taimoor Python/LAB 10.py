L=[1,2,3,4]
def mysum(L):
    if not L:
        return 0
    else:
        return L[0] + mysum(L[1:]) # Call mysum recursively
print(mysum(L))
