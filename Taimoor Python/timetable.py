n=int(input('enter the number of which timetable you want : '))
x=int(input('enter the number to which number you want to multiply : '))
print('TIMETABLE OF', n) 
for i in range(1,x+1):
      print(n, 'x' ,i, '=' ,n*i)
