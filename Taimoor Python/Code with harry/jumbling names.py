# Practice Problem 9(Code with Harry)
import random

num = int(input("Enter the number of names you want to enter : "))
name = []
first_name = []
last_name = []
jumble = []
real_check = []

for i in range(num):
    word = input("Enter the name : ")
    name.append(word)

for i in range(len(name)):
    partition = name[i].split(maxsplit=1)
    first_name.append(partition[0])
    last_name.append(partition[1])

for i in range(len(first_name)):
    while True:
        last_choice = random.randrange(0, len(last_name))
        if (i != last_choice) and (last_choice not in real_check):
            strg = f"{first_name[i]} {last_name[last_choice]}"
            jumble.append(strg)
            real_check.append(last_choice)
            break

for i in range(len(jumble)):
    print(jumble[i])
