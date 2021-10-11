from tkinter import *


#
def clear():
    e_city.delete(0, "end")
    e_phone.delete(0, "end")
    e_age.delete(0, "end")
    e_name.delete(0, "end")
    e_name.focus()


def write():
    with open("Entry widget exercise.txt", "a") as f:
         f.write(f"{e_name.get()},{e_age.get()},{e_phone.get()},{e_city.get()}\n")
    clear()

#def write():
    # v = e_age.get()
 #   w.set(e_age.get())


window = Tk()
window.title("Dance Class")
window.geometry("700x700")

# f1 = Frame(window, width=300, height=300)
f1 = Frame(window, bg="purple", highlightbackground="purple")
f1.pack(anchor="nw")

name = Label(f1, text="Enter Name", bg="purple")
name.grid(row=0, column=0, sticky="w")
# name.place(x=0, y=0)
e_name = Entry(f1)
# e_name.place(x=150, y=0)
e_name.grid(row=0, column=1)

age = Label(f1, text="Enter Age", bg="purple")
# age.place(x=0, y=25)
age.grid(row=1, column=0, sticky="w")
e_age = Entry(f1)
# e_age.place(x=150, y=25)
e_age.grid(row=1, column=1)

phone = Label(f1, text="Enter  Phone", bg="purple")
# phone.place(x=0, y=50)
phone.grid(row=2, column=0, sticky="w")
e_phone = Entry(f1, show="*")
# e_phone.place(x=150, y=50)
e_phone.grid(row=2, column=1)

city = Label(f1, text="Enter  City", bg="purple")
# city.place(x=0, y=75)
city.grid(row=3, column=0, sticky="w")
e_city = Entry(f1)
# e_city.place(x=150, y=75)
e_city.grid(row=3, column=1)

confirm = Label(f1, text="Do you want to Submit :", bg="purple")
# confirm.place(x=70, y=100)
confirm.grid(row=4, column=0)

yes = Button(f1, text="YES", command=write)
# yes.place(x=70, y=125)
yes.grid(row=5, column=0, sticky="w")

no = Button(f1, text="NO")
# # no.place(x=170, y=125)
no.grid(row=5, column=0, sticky="e")

# w = StringVar()
# c = Entry(f1, textvariable=w, justify="right")
# # confirm.place(x=70, y=100)
# c.grid(row=7, column=1)

#
#var = IntVar()
# check = Checkbutton(f1, text="Do you satisfy?", variable=var)
# check.grid(row=8, column=0, sticky="w")
#
# var1 = IntVar()
# check = Checkbutton(f1, text="Do you not satisfy?", variable=var1, relief="raised", bd=6, fg="red", bg="powder blue")
# check.grid(row=9, column=0)
window.mainloop()