from tkinter import *

c = " "


def write(event):
    try:
        if int(event.char):
            global c
            c = c + str(event.char)
            w.set(c)
    except:
        pass

def writebut(number):
    global c
    c = c + str(number)
    w.set(c)

root = Tk()
root.title("Events")
root.geometry("500x500")

w = StringVar()
entries = Entry(root, textvariable=w)
entries.grid(row=0, column=0)

b7 = Button(root, text="7", command= lambda: writebut(7))
root.bind('<Key>', write)
b7.grid(row=1, column=0, sticky="w")
root.mainloop()