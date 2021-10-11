# Practice Problem 3(Code with Harry)
lis = [4, 5, 8, 9, 88]
j = len(lis)
for i in range(j//2):
    lis[i], lis[j-(i+1)] = lis[j-(i+1)], lis[i]

print(lis)



