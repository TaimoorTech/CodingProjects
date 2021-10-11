class person:
    def __init__(self, name):
        self.name = name

    def print_display(self):
        print("Name : ", self.name)

class student(person):
    def __init__(self, name, department, year):
        super().__init__(name)
        self.department = department
        self.year = year

    def print_display(self):
        super().print_display()
        print("Department : ", self.department)
        print("Year : ", self.year)


class teacher(person):
    def __init__(self, name, course):
        super().__init__(name)
        self.course = course

    def print_display(self):
        super().print_display()
        print("Course : ", self.course)


p = person("Taimoor")
p.print_display()
print()
s = student("Sami", "CIS", "F.E")
s.print_display()
print()
t = teacher("Danish", "ENG")
t.print_display()

