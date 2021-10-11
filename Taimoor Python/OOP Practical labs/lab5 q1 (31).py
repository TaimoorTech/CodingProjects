class Rectangle:
    def __init__(self, width, height):
        self.width = width
        self.height = height
        self.area = self.width * self.height
        print("Area : ", self.area)

r = Rectangle(4, 5)
