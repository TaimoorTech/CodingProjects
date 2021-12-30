# q1
# x = int((input("Enter the number : ")))
# for n in range(0, x):
#     print(id(n))
#     n += 1
#     print("*"*(0+n))
# for n in range(-x, 0):
#     print(id(n))
#     n += 1
#     print("*"*(0-n+1))

# q2
dict1 = {1: 10, 2: 20}
dict2 = {3: 30, 4: 40}
dict3 = {5: 50, 6: 60}
concatenated_dictionary = {}
concatenated_dictionary.update(dict1)
concatenated_dictionary.update(dict2)
concatenated_dictionary.update(dict3)
print("ID of Dict1 : ", id(dict1))
print("ID of Dict2 : ", id(dict2))
print("ID of Dict3 : ", id(dict3))
print("ID of Concatenated Dictionary : ", id(concatenated_dictionary))
j = 1
for i in concatenated_dictionary.items():
    print(f"ID of Key {j}:", id(i[0]))
    print(f"ID of Value {j}:", id(i[1]))
    j+=1
# q4
# lst = [57, 83, 94, 40, (8, 9), 78, 56]
# id_tuple = 0
# count = 0
# for i in lst:
#     if type(i) == tuple:
#         id_tuple = id(i)
#         break
#     count += 1
#
# print("Total number of element(s) in the list until the tuple is/are :", count)
# print("ID of List :", id(lst))
# print("ID of Tuple :", id_tuple)

# q3
# lst1 = [57, 83, 94, 40, 78, 94, 36, 57, 79]
# print("ID before removal of duplicates :", id(lst1))
# for i in lst1:
#     if lst1.count(i) > 1:
#         lst1.remove(i)
# print("ID after removal of duplicates :", id(lst1))