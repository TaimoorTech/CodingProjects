from tkinter import *
from PIL import Image, ImageTk

root = Tk()
root.title("Menus")
root.geometry("500x500")

mainmenu = Menu(root, background="red")
menu1 = Menu(mainmenu, tearoff=0, relief=GROOVE, background="red")
menu1.add_command(label="Cut")
root.config(menu=mainmenu)
mainmenu.add_cascade(label="File", menu=menu1)

root.mainloop()


##class GUI(Tk):
##    def __init__(self):
##        super().__init__()
##        self.geometry("900x600")
##        self.mainloop()
##
##    def favicon(self, filename):
##        self.wm_iconbitmap(filename)
##
##    def menu(self, *args):
##        menu = Menu(self)
##        for menu_name in args:
##            menu.add_command(label=f"{menu_name}")
##        self.config(menu=menu)
##
##    def heading(self, text):
##        Label(self, text=text, bg="grey", fg="white", font="lucida 18 bold", pady=8).pack(side=TOP, fill=X)
##
##    def radiobuttons(self, *args):
##        var = StringVar()
##        var.set("r")
##        for radio in args:
##            Radiobutton(self, text=f"{radio}", variable=var, value=f"{radio}", font="lucida 9").pack()
##
##    def button(self, text):
##        Button(self, text=text, bg="grey", fg="white", pady=5, padx=5).pack()
##
##    def statusbar(self, text):
##        var = StringVar()
##        var.set(text)
##        Label(self, textvariable=var, relief=SUNKEN, pady=10, font="lucida 12", bg="grey", fg="white").pack(side=BOTTOM,
##                                                                                                            fill=X)
##
##g = GUI()
##g.statusbar("Hussain")
