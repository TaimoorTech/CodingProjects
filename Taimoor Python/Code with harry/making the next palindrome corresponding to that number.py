# Practice Problem 4(Code with Harry)
num = int(input("Enter the number of test cases : "))
lis = []

# Taking the input from user one by one
for i in range(num):
    st = int(input("Enter the number : "))
    lis.append(st)

for i in lis:
    n = str(i)[:]
    i += 1
    while True:
        if str(i) == str(i)[::-1]:
            print(f"The Next Palindrome for {n} is {i}.")
            break
        else:
            i += 1