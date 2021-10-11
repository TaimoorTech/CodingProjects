# class Date:
#     format = 1
#     month_name = {1: "January", 2: "February", 3: "March", 4: "April", 5: "May", 6: "June", 7: "July", 8: "August",
#                   9: "September", 10: "October", 11: "November", 12: "December"}
#
#     def set_day(self, d=1):
#         self.day = d
#
#     def get_day(self):
#         return self.day
#
#     def set_month(self, m):
#         self.month = m
#
#     def get_month(self):
#         return self.month
#
#     def set_year(self, y):
#         self.year = y
#
#     def get_year(self):
#         return self.year
#
#     def __str__(self):
#         if self.format > 3 or self.format < 0:
#             self.format = 1
#         if self.format == 1:
#             return f"{self.day}-{self.month}-{self.year}"
#         elif self.format == 2:
#             return f"{self.month}/{self.day}/{self.year}"
#         elif self.format == 3:
#             return f"{self.month_name.get(self.month)} {self.day}, {self.year}"
#
#
# d1 = Date()
# d1.format = 3
# d1.set_day(30)
# d1.set_month(4)
# d1.set_year(2003)
# print(d1)

class O:
    pass
    #def method(self):
     #   print('O')


class W:
    pass
    #def method(self):
     #   print('W')


class X(O):
    pass
    #def method(self):
     #   print('X')


class Y(O):
    pass
    #def method(self):
     #   print('Y')


class Z:
    pass
    #def method(self):
     #   print('Z')


class A(W, X):
    pass
    #def method(self):
     #   print('A')


class B(Y, Z):
    pass
    #def method(self):
     #   print('B')


class C(A, B):
    pass
    #def method(self):
    #    print('C')


x = C()
x.method()