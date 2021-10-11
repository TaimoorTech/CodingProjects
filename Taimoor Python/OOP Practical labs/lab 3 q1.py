class Student:
    count = 5
    y = []
    g = []

    def __init__(self):
        self.name = input("Enter the Name : ")
        self.roll = input("Enter the Roll no : ")
        self.email = input("Enter the Email : ")


    def course(self):
        self.y = []
        self.BEL = int(input("Enter the marks of BEL : "))
        self.CP = int(input("Enter the marks of CP : "))
        self.DS = int(input("Enter the marks of DS : "))
        self.BEE = int(input("Enter the marks of BEE : "))
        self.FCE = int(input("Enter the marks of FCE : "))
        self.y.extend([self.BEL, self.CP, self.DS, self.BEE, self.FCE])

    def calculate_gpa(self):
        self.g = []
        for i in self.y:
            if 94 <= i <= 100:
                self.g.append("4.0")
            elif 85 <= i <= 93:
                self.g.append("4.0")
            elif 80 <= i <= 84:
                self.g.append("3.7")
            elif 75 <= i <= 79:
                self.g.append("3.4")
            elif 70 <= i <= 74:
                self.g.append("3.0")
            elif 67 <= i <= 69:
                self.g.append("2.7")
            elif 64 <= i <= 66:
                self.g.append("2.4")
            elif 60 <= i <= 63:
                self.g.append("2.0")
            elif 57 <= i <= 59:
                self.g.append("1.7")
            elif 54 <= i <= 56:
                self.g.append("1.0")
        print(f"BEL GPA : {self.g[0]}\nCP GPA : {self.g[1]}\nDS GPA : {self.g[2]}\nBEE GPA : "
              f"{self.g[3]}\nFCE GPA : {self.g[4]}")

    def calculate_cgpa(self):
        self.cgpa = 0.0
        self.cgpa = (3 * (float(self.g[0])+float(self.g[1])+float(self.g[2])+float(self.g[3])+float(self.g[4])))/15
        print(self.cgpa)


s = Student()
s.course()
s.calculate_gpa()
s.calculate_cgpa()