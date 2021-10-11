class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def print_name(self):
        print("Name : ", self.name)

    def print_age(self):
        print("Age : ", self.age)


class Student(Person):
    def __init__(self, name, age, student_id, roll_number):
        super().__init__(name, age)
        self.student_id = student_id
        self.roll_number = roll_number

    def printing(self):
        super().print_name()
        super().print_age()
        print(f"student ID : , {self.student_id}\nRoll Number : {self.roll_number}")


class Resident(Student):
    def __init__(self, name, age, student_id, roll_number, room_no, city):
        super().__init__(name, age, student_id, roll_number)
        self.room_no = room_no
        self.city = city

    def printing(self):
        super().printing()
        print(f"Room No : {self.room_no}\nCity : {self.city}")


r = Resident("Ali", "25", "CS-180005", "CS-005", "225", "Karachi")
r.printing()
