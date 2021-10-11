import time
a = time.time()
print(a)
num = 96
txt = ""
for i in range(1, 27):
    num += 1
    txt += f"{chr(num)} "
    print(txt)
b = time.time()
print(b)
c = b-a
print(c)
