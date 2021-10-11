from tkinter import *

def recizer():
    r.geometry(f"{e1.get()}x{e2.get()}")


r = Tk()
l1 = Label(r, text="Enter Height")
l1.grid(row=0, column=0)
e1 = Entry(r)
e1.grid(row=0, column=1)
l2 = Label(r, text="Enter Width")
l2.grid(row=1, column=0)
e2 = Entry(r)
e2.grid(row=1, column=1)
b1 = Button(r, text="APPLY", command=recizer)
b1.grid(row=2, column=0)
r.mainloop()