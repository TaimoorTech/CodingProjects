from tkinter import *
import tkinter.messagebox as tmsg


def display():
    if var.get() == 1:
        tmsg.showinfo("Dollars $", "Congrats!!! You have got 1 Million Dollars.....")
    elif var.get() == 2:
        tmsg.showinfo("Rupees Rs", "Congrats!!! You have got 1 Million Rupees.....")
    elif var.get() == 3:
        tmsg.showinfo("Gold", "Congrats!!! You have got 10 Kilo Gold.....")
    elif var.get() == 4:
        tmsg.showinfo("Dinar", "Congrats!!! You have got 1 Million Dinar.....")


root = Tk()
root.title("Radio Button")
width = root.winfo_screenwidth()
height = root.winfo_screenheight()
root.geometry(f'{width}x{height}+0+0')
# root.attributes("-toolwindow", True)
# root.attributes("-topmost", True)

var = IntVar()
var.set(0)
radio1 = Radiobutton(root, text="Get Dollars", variable=var, value=1, command=display)
radio1.place(x=5, y=5)
radio2 = Radiobutton(root, text="Get Rupees", variable=var, value=2, command=display)
radio2.place(x=5, y=25)
radio3 = Radiobutton(root, text="Get Gold", variable=var, value=3, command=display)
radio3.place(x=5, y=45)
radio4 = Radiobutton(root, text="Get Indian Rupees", variable=var, value=4, command=display)
radio4.place(x=5, y=65)
root.mainloop()

# def display():
#     print(var.get())


# root = Tk()
# var = IntVar()
# var.set(2)
# print(var.get())
# Button(master=root, text="print", command=display).place(x=0, y=10)
# root.mainloop()
# from tkinter import *
# import tkinter
#
# top = tkinter.Tk()
#
# B1 = tkinter.Button(top, text="circle", relief=RAISED, cursor="circle")
# B2 = tkinter.Button(top, text="plus", relief=RAISED, cursor="plus")
# B1.pack()
# B2.pack()
# top.mainloop()

# import tkinter
# parent_widget = tkinter.Tk()
# control_variable = tkinter.StringVar(parent_widget)
# OPTION_TUPLE = ("Option 1", "Option 2", "Option 3")
# optionmenu_widget = tkinter.OptionMenu(parent_widget, control_variable, *OPTION_TUPLE)
# optionmenu_widget.pack()
# tkinter.mainloop()
