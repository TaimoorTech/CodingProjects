from tkinter import *

r = Tk()
r.title("Hello")
r.geometry("500x500")
f1 = Frame(r)
f1.pack(side=LEFT, anchor="sw", expand=100)
l1 = Label(f1, text="Taimoor is best", fg="black", borderwidth=5)
# l1.grid(row=0, column=0, sticky="w")
l1.pack(side=LEFT, expand=10)
l2 = Label(f1, text="higjfjgfjgfdjgfdjvjgfjgvfdjgjfjjdfgjfjgfjg", fg="black", bg="red", borderwidth=5, wraplength=50)
# l2.grid(row=1, column=0, sticky="w")
l2.pack(side=LEFT, expand=10)
r.mainloop()
