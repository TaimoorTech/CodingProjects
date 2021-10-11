class Rectangle:
    def __init__(self, width, height):
        self.width = width
        self.height = height
        self.area = self.width * self.height
        print("Area : ", self.area)


class Square(Rectangle):
    def __init__(self, length):
        self.length = length
        super().__init__(self.length, self.length)


s = Square(4)
