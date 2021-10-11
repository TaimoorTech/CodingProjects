##D={'CP':'COMPUTER PROGRAMMING','FCE':'FUNDAMENTALS OF COMPUTER ENGINEERING','PST':'PAKISTAN STUDIES','BEE':'BASICS OF ELECTRICAL ENGINEERING'}
###Q2
##D.update({'F.ENG':'FUNCTIONAL ENGLISH'})
###Q3
##print('Chinese' in D)
###Q4
##print(D['CP'])
###Q5
##ans=[]
##ques=int(input('Total no of questions :'))
##for i in range(1,ques+1):
##    print('Enter your answer of Question',i,': ')
##    num=input()
##    ans.append(num)
##QR={}
##for i in range(1,ques+1):
##    QR.update({'Q'+ str(i):ans[i-1]})
##print(QR)    

#Q6

print('Welcome to the restaurant\nOur today restaurant\'s specials are:\n(1)KABAB\n(2)BIRYANI\n(3)PIZZA')
menu={'KABAB': '110 (6 PIECES)', 'BIRYANI': '70(1 PLATE)', 'PIZZA' : '550 FOR MEDIUM PIZZA(ANY FLAVOR)'}
while True:
    want=input('Do you want to check on the menu/nIf YES press \'Y\' or if NO press \'Enter\' : ')
    if want=='':
        print('Thanks for visiting our Restaurant menu')
        break
    if want=='Y':
        item=input('Enter name of dish of which price do you want to know : ')
        if item in menu:
            print('Price is :',menu.get(item))
        else:
            print('This is not in menu')
            
