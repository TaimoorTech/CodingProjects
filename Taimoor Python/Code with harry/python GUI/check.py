from tkinter import *

root = Tk()
root.title("hello")
root.geometry("1000x1000")

frame = Frame(root)
frame.pack(anchor="nw")

l1 = Label(frame, text="Enter Name")
l1.grid(row=0, column=0, sticky="w")

e1 = Entry(frame)
e1.grid(row=0, column=2)

l2 = Label(frame, text="Enter Age")
l2.grid(row=1, column=0, sticky="w")

e2 = Entry(frame)
e2.grid(row=1, column=2)

l3 = Label(frame, text="Enter Phone Number")
l3.grid(row=2, column=0, sticky="w")

e3 = Entry(frame)
e3.grid(row=2, column=2)

l4 = Label(frame, text="Enter City")
l4.grid(row=3, column=0, sticky="w")

e4 = Entry(frame)
e4.grid(row=3, column=2)

root.mainloop()