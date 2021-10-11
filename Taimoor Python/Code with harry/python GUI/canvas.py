from tkinter import *
from PIL import Image, ImageTk

root = Tk()
root.geometry("800x800")
root.title("Canvas")

can = Canvas(root, bg="powder blue", width=800, height=800)
can.pack(anchor="nw")

can.create_rectangle(100, 8, 200, 400, fill="yellow", outline="blue", width=10, activefill="black")  # dash=(2, 8, 6, 8)

can.create_oval(50, 15, 100, 180, fill="red")

f = Image.open("1.png")
filename = ImageTk.PhotoImage(f)
can.create_image(200, 200, anchor="ne", image=filename)
root.mainloop()
