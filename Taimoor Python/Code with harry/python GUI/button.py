from tkinter import *

root = Tk()

f1 = Frame(root)
f1.pack()


def hi():
    print("HI")


def classes():
    print(10)


b1 = Button(f1, text="click", command=hi)
b1.pack()

b2 = Button(f1, text="clicking", command=classes)
b2.pack()

root.mainloop()