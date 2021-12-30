import timeit


# A2.1
#
def ins(l, data, pos):
    lst1 = l[0:pos]
    lst2 = l[pos:]
    lst3 = lst1 + data + lst2
    print("Using implemented function : ", lst3)


lst = (88, 55, 6, 33, 10, 36, 99)
start = timeit.default_timer()
ins(lst, (70,), 4)
stop = timeit.default_timer()
s1 = stop - start
print(s1)

start1 = timeit.default_timer()
lst = list(lst)
lst.insert(4, 70)
print("Using built-in function : ", tuple(lst))
stop1 = timeit.default_timer()
s2 = stop1 - start1
print(s2)

print(s2 < s1)

# A2.2
# def dele(l, data):
#     for i in range(len(l)):
#         if data == l[i]:
#             lst1 = l[0:i]
#             lst2 = l[i+1:]
#             print("Using implemented function : ", lst1+lst2)
#
#
# lst = [88, 55, 6, 33, 10, 36, 99]
# start = timeit.default_timer()
# dele(lst, 10)
# stop = timeit.default_timer()
# s1 = stop - start
# print(s1)
#
# start1 = timeit.default_timer()
# lst.remove(10)
# stop1 = timeit.default_timer()
# s2 = stop1 - start1
# print("Using built-in function : ", lst)
# print(s2)
#
# print(s2 < s1)

# A2.3
# def search(l, data):
#     for i in range(len(l)):
#         if data == l[i]:
#             print("Using implemented function : ", l[i])
#
#
# lst = [88, 55, 6, 33, 10, 36, 99]
# start = timeit.default_timer()
# search(lst, 10)
# stop = timeit.default_timer()
# s1 = stop - start
# print(s1)
#
# start1 = timeit.default_timer()
# print("Using built-in function, the number is at index in the list : ", lst.index(10))
# stop1 = timeit.default_timer()
# s2 = stop1 - start1
# print(s2)
#
# print(s2 < s1)
