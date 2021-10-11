class Student:
    def __init__(self, name="Ali", batch="2020", year="F.E"):
        self.name = name
        self.batch = batch
        self.year = year

s1 = Student("Taimoor", "2020", "F.E")
print(s1.name, s1.batch, s1.year)