# from tkinter import *
# from PIL import Image, ImageTk
from tkinter import Tk, Label, Button, Frame


def printing():
    # la = Label(var, text="Taimoor is best", fg='red', bg='black', borderwidth=5, relief="groove",
    #            anchor="e", width=20)
    # la.pack(side="left")
    # l = Frame(var, bg='black', borderwidth=5, relief="groove")
    # l.pack(side="top")
    # L1 = Label(l, text="taimoor is best", height=10)
    # L1.pack()
    l2.configure(text="HI")


var = Tk()
var.title("First GUI")
l2 = Label(var, text="Hello")
l2.pack()
var.geometry("600x400")
# var.maxsize(700, 800)
# var.minsize(700, 500)
v = Button(var, text="click the button", command=printing)
v.pack()
var.mainloop()
