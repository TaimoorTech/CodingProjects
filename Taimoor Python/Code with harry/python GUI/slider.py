from tkinter import *
import tkinter.messagebox as tmsg


def display():
        tmsg.showinfo("Dollars!!!", f"You have got ${slider_value.get()}.....")


root = Tk()
root.title("Slider")
root.geometry("300x500")
slider_value = IntVar()
frame1 = Frame(master=root, height=400, width=400)
frame1.place(x=15, y=0)
Scale(master=frame1, variable=slider_value, from_=1, to=100, orient=HORIZONTAL).place(x=0, y=100)
Button(master=frame1, text="Get Dollars", command=display).place(x=0, y=200)
root.mainloop()
