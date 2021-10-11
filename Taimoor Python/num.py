#x=input('enter a number ')
#if '0'<=x<='9' in x :
#    print('your suggest number is', x)

from tkinter import Tk,Label
r=Tk()
r.title('My Window')
r.geometry('200x200+400+400')
lab1=Label(r,text='Hello World',
fg='red',bg='#AFB42B',
borderwidth=6,relief='groove')
lab1.pack()
lab2=Label(r,text='Hello World',
fg='red',bg='#F0F4C3',
borderwidth=6,relief='sunken')
lab2.pack()
lab3=Label(r,text='Hello World',
fg='#C2185B',bg='#00BCD4',padx=50,pady=10)
lab3.pack()
r.mainloop()
