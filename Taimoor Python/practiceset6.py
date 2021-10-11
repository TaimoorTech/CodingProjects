##def censor(file):
##    with open(file) as f:
##        content=f.read()
##        with open('censored.txt','w') as a:
##            con=content.split()
##            for i in con:
##                if len(i)==4:
##                    x='xxxx'
##                    a.write(x+' ')
##                else:
##                    a.write(i+' ')
##             
##   
##
##
##file=input('Enter name of file : ')
##censor(file)

def distribution(file):
    with open(file) as f:
        con=f.read()
        c=con.split(' ')
        print('6 students got ',c[0])
        print('2 students got ',c[1])
        print('3 students got ',c[2])
        print('2 students got ',c[3])
        print('2 students got ',c[4])
        print('4 students got ',c[5])
        print('1 student got ',c[6])
        print('2 students got',c[7])
        
file=input('Enter file name :')
distribution(file)

##def duplicate(file1):
##    with open(file1) as f:
##        content=f.read()
##        con=content.split()
##        for i in con:
##            c=con.count(i)
##            if c>1:
##                print('True')
##                return
##        if c==1:
##            print('False')
##            
##
##file1=input('Enter the file name  :')
##duplicate(file1)

