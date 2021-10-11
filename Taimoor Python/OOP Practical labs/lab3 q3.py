class Person:
    def __init__(self):
        self.age = 0

    @classmethod
    def calculating_age(cls):
        birth_year = int(input("Enter your Birth Year : "))
        current_year = int(input("Enter the Current Year : "))
        cls.age = current_year - birth_year
        return cls.age

    @staticmethod
    def check(age):
        if age > 18:
            return True
        else:
            return False


p1 = Person()
age1 = p1.calculating_age()
print(age1)
print(p1.check(age1))


