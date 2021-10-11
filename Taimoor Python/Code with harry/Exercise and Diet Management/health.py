def taimoor(name):
    print('Welcome Taimoor')
    while True:
        opt=input('*************\nPress:\n1 for Exercise\n2 for Diet\n3 for Exit\n*************\n')
        if opt=='1':
            exercise(name)
        elif opt=='2':
            diet(name)
        elif opt=='3' :
           break
    return

def hussain(name):
    print('Welcome Hussain')
    while True:
        opt=input('*************\nPress:\n1 for Exercise\n2 for Diet\n3 for Exit\n*************\n')
        if opt=='1':
            exercise(name)
        elif opt=='2':
            diet(name)
        elif opt=='3' :
            break
    return

def minhal(name):
    print('Welcome Minhal')
    while True:
        opt=input('*************\nPress:\n1 for Exercise\n2 for Diet\n3 for Exit\n*************\n')
        if opt=='1':
            exercise(name)
        elif opt=='2':
            diet(name)
        elif opt=='3' :
            break 
    return

def exercise(name):
    if name=='1':
        data=input('*************\nTo lock data press 1\nTo retrieve press 2\n*************\n')  
        if data=='1':
            with open('taimexercise.txt','a') as f:
                exe=input('Add Exercise : ')
                f.write(str(time.strftime('%d/%m/%Y %H:%M:%S')+' '+exe+'\n'))
                print('You have successfully lock data')
            return
        elif data=='2':
            with open('taimexercise.txt') as f:
                content=f.readlines()
                for i in content:
                    print(i)
            return
    elif name=='2':
        data=input('*************\nTo lock data press 1\nTo retrieve press 2\n\*************\n')  
        if data=='1':
            with open('hussexercise.txt','a') as f:
                exe=input('Add Exercise : ')
                f.write(str(time.strftime('%d/%m/%Y %H:%M:%S')+' '+exe+'\n'))
                print('You have successfully lock data')
            return
        if data=='2':
            with open('hussexercise.txt') as f:
                content=f.readlines()
                for i in content:
                    print(i)
            return
    elif name=='3':
        data=input('*************\nTo lock data press 1\nTo retrieve press 2\n*************\n')  
        if data=='1':
            with open('minhalexercise.txt','a') as f:
                exe=input('Add Exercise : ')
                f.write(str(time.strftime('%d/%m/%Y %H:%M:%S')+' '+exe+'\n'))
                print('You have successfully lock data')
            return
        if data=='2':
            with open('minhalexercise.txt') as f:
                content=f.readlines()
                for i in content:
                    print(i)
            return


def diet(name):
    if name=='1':
        data=input('*************\nTo lock data press 1\nTo retrieve press 2\n*************\n')  
        if data=='1':
            with open('taimdiet.txt','a') as f:
                diet=input('Add Diet : ')
                f.write(str(time.strftime('%d/%m/%Y %H:%M:%S')+' '+diet+'\n'))
                print('You have successfully lock data')
            return
        elif data=='2':
            with open('taimdiet.txt') as f:
                content=f.readlines()
                for i in content:
                    print(i)
            return
    elif name=='2':
        data=input('*************\nTo lock data press 1\nTo retrieve press 2\n*************\n')  
        if data=='1':
            with open('hussdiet.txt','a') as f:
                diet=input('Add diet : ')
                f.write(str(time.strftime('%d/%m/%Y %H:%M:%S')+' '+diet+'\n'))
                print('You have successfully lock data')
            return
        elif data=='2':
            with open('hussdiet.txt') as f:
                content=f.readlines()
                for i in content:
                    print(i)
            return
    elif name=='3':
        data=input('*************\nTo lock data press 1\nTo retrieve press 2\n*************n')  
        if data=='1':
            with open('minhaldiet.txt','a') as f:
                diet=input('Add diet : ')
                f.write(str(time.strftime('%d/%m/%Y %H:%M:%S')+' '+diet+'\n'))
                print('You have successfully lock data')
            return
        elif data=='2':
            with open('minhaldiet.txt') as f:
                content=f.readlines()
                for i in content:
                    print(i)
            return

import time
while True:
    name=input('*************\nPress\n1 for Taimoor\n2 for Hussain\n3 for Minhal\nEnter for Exit\n*************\n')
    if name=='1':
        taimoor(name)
    elif name=='2':
        hussain(name)
    elif name=='3':
        minhal(name)
    elif name=='':
        print('Thanks for visiting Health Management System')
        break
    else:
        print('Kindly Enter correct choice')
