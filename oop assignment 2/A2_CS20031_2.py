class Shape:
    def __init__(self, noOfSides=1):
        self.noOfSides = noOfSides


class Rectangle(Shape):  # Inheriting the Shape class
    def __init__(self, length=0.00, width=0.00):
        self.length = length
        self.width = width
        super().__init__(4)

    def __str__(self):
        return f"Sides : {self.noOfSides}\nLength : {self.length}\nWidth : {self.width}" \
               f"\nPerimeter : {self.Perimeter()}\nArea : {self.Area()}"

    def Area(self):
        return self.length * self.width

    def Perimeter(self):
        return 2 * (self.length + self.width)


# Driver Code
width = float(input("Enter the width of Rectangle : "))
length = float(input("Enter the length of Rectangle : "))
R1 = Rectangle(length, width)
print("The Area of the Rectangle is : ", R1.Area())
print("The Perimeter is Rectangle is :", R1.Perimeter())
print(R1)
