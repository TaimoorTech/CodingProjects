##import tkinter
##r=tkinter.Tk()
##r.title('hi')
##r.geometry('200x200')
##lab1=tkinter.Label(r,text='hello')
##lab1.pack()

##from tkinter import Tk,Label,Frame
##r=Tk()
##r.title('Keypad')
##value=0
##f=Frame(r)
##for i in range(3):
##    for j in range(3):
##        lab=Label(f,text=value,border=5,bg='#FFC107',relief='groove')
##        lab.grid(row=i,column=j)
##        value+=1
##f.pack()
##r.mainloop()

##from tkinter import Tk,Button,Label
##from tkinter.messagebox import showinfo
##
##def func():
##    showinfo(message='Hello!!')
##    
##r=Tk()
##b=Button(r,text='Click it!',command=func)
##b.pack()
#r.mainloop()

from tkinter import *


def bmi():
    print(l2.get(), l4.get())
    height = int(l2.get())
    weight = int(l4.get())
    BMI = (weight * 703) / (height ** 2)
    val = round(BMI, 2)
    if BMI < 18.5:
        x = Label(r, text='Your BMI value is : ' + str(val) + '(Underweight)')
        x.grid(row=3, column=0)
    elif (BMI >= 18.5) and (BMI < 25):
        x = Label(r, text='Your BMI value is : ' + str(val) + '(Normal)')
        x.grid(row=3, column=0)
    elif BMI > 25:
        x = Label(r, text='Your BMI value is : ' + str(val) + '(Overweight)')
        x.grid(row=3, column=0)


r = Tk()
r.title('BMI App')
r.geometry('1000x400')
l1 = Label(r, text='Enter your height(inches)', border=5, relief='groove')
l1.grid(row=0, column=0)
# l2=Entry(r)
l2 = Entry(r, textvariable=IntVar())
l2.grid(row=0, column=2)
l3 = Label(r, text='Enter your weight(pounds)')
l3.grid(row=1, column=0)
# l4=Entry(r)
l4 = Entry(r, textvariable=IntVar())
l4.grid(row=1, column=2)
b = Button(r, text='find BMI', command=bmi)
b.grid(row=2, column=0)
r.mainloop()
