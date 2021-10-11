class Student:
##    x=44
    def __init__(self,subject,role):
        self.subject=subject
        self.role=role
        #print('hi')
    
    def printdetails(self):
        print(f"this is taimoor perfectionist role {self.role}")

##    @property
##    def printdetails(self):
##        print(f"this is taimoor perfectionist role {self.role}")


    ##
##    @classmethod
##    def num(var,n):
##        var.x=n
##
##    @classmethod
##    def name(string,nam):
##        return string(*nam.split("-"))

class programmer(Student):
    def __init__(self,subject,role,code,weight):
        self.code=code
##        self.subject=subject
##        self.role=role
        super().__init__(subject,role)
        self.weight=weight

class player(Student,programmer):
    def __init__(self,subject,role,code,weight):
        Student.__init__(self,subject,role)

        programmer.__init__(self,code,weight)
    def printdetails(self):
        print(f"this is taimoor perfectionist role {self.role}")

    
##def func():
####    print('HI')
####
####func1=func
####del func
####func1()
####
        
harry=programmer("maths","programmer","python",55)
print(harry.subject)
##harry.num(33)
###print(harry.x)

##hussain=Student.name("programming-coming Engineer")
#print("hussain role",hussain.role)
##hussain=player("computer","coming Engineer",["javacss","python"],44)
#hussain.code="c++"
##hussain.printdetails()
##print(hussain.code)

##harry.subject="maths"
##harry.role="Engineer"
#print(harry.subject)
####print(harry.x)
##harry.x=22
####print(harry.x)

taimoor=Student("physics","Enginneer")
##taimoor.num(55)
#print(taimoor.x)
####print(harry.__dict__)
###harry.printdetails()
##
##print(harry.role)
##classmethod

##def dec2(func1):
##    def nowexec():
##        print('************')
##        def exe():
##            print("Executing now")
##            func1()
##            print("Executed")
##        return exe 
##    return nowexec

##@dec2
##def who_is_harry():
##    print("Harry is a good boy")
##@dec2
##def who():
##    print("who is a good boy")

##who_is_harry= dec2(who_is_harry)
##who=who_is_harry()
#who_is_harry()
##who()
  

