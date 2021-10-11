from tkinter import *


if __name__ == "__main__":
    window1 = Tk()
    window1.geometry("1300x800")

    title_frame = Frame(window1, bg="dark green", height=100, width=1500)
    title_frame.place (x=0, y=0)

    title_label = Label(title_frame, text="Welcome to Dream Online Shopping Store", bg="dark green", fg="blue", font="algerian 30")
    title_label.place(x=300, y=30)

    option_frame = Frame(window1, bg="powder blue", height=800, width=700)
    option_frame.place(x=0, y=100)

    button1 = Button(option_frame, text="Display Products", foreground="purple", background="powder blue", anchor="w",font="50")
    button1.pack(fill=X)
    button2 = Button(option_frame, text="Add the Products to the Cart", foreground="purple", background="powder blue",anchor="w", font="50")
    button2.pack(fill=X)
    button3 = Button(option_frame, text="Remove the Products to the Cart", foreground="purple", background="powder blue", anchor="w", font="50")
    button3.pack(fill=X)
    button4 = Button(option_frame, text="View the Cart", foreground="purple", background="powder blue", anchor="w", font="50")
    button4.pack(fill=X)
    button5 = Button(option_frame, text="View Shopping History", foreground="purple", background="powder blue", anchor="w", font="50")
    button5.pack(fill=X)
    button6 = Button(option_frame, text="Checkout", foreground="purple", background="powder blue", anchor="w", font="50")
    button6.pack(fill=X)
    button7 = Button(option_frame, text="Register to your Account", foreground="purple", background="powder blue", anchor="w", font="50")
    button7.pack(fill=X)
    button8 = Button(option_frame, text="Login into your account", foreground="purple", background="powder blue", anchor="w", font="50")
    button8.pack(fill=X)
    button9 = Button(option_frame, text="Login to your Another Account", foreground="purple", background="powder blue", anchor="w", font="50")
    button9.pack(fill=X)
    button10 = Button(option_frame, text="Login as Administrator", foreground="purple", background="powder blue", anchor="w", font="50")
    button10.pack(fill=X)
    button11 = Button(option_frame, text="Exit", foreground="purple", background="powder blue", anchor="w", font="50")
    button11.pack(fill=X)

    window1.mainloop()
