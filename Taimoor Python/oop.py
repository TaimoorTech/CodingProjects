#with open('myfile.txt') as f:
 #   for i in f:
  #      print(i)

#generating fibocanni series
def fib():
    a=0
    b=1
    c=0
    yield a
    yield b
    while True:
        c=a+b
        yield c
        a=b
        b=c

num=fib()
print(num.__next__())
print(num.__next__())
print(num.__next__())
print(num.__next__())
print(num.__next__())


#python comprehension
# num=input("How many items you want to enter in the list : ")
# item=input(f"Enter {num} items seperated by commas : ")
# ch=input("Which Comprehension you want: \nPress 1 for List comprehension \nPress 2 for Dictionary comprehension : \n")
# items = item.split(",")
# if ch=='1':
#     ls=[items[i] for i in range(len(items))]
#     print(ls)
# elif ch=='2':
#     ds={f"Item no.{i+1}":items[i] for i in range(len(items))}
#     print(ds)

