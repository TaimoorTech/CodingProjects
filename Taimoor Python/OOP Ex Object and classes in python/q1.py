class Circle:
    radius = 0.0
    color = ""

    def setRadius(self, r):
        self.radius = r

    def getRadius(self):
        return self.radius

    def setColor(self, c):
        self.color = c

    def getColor(self):
        return self.color

    def getCircumference(self):
        return round(2 * 3.14 * self.radius, 3)

    def getArea(self):
        return 3.14 * (self.radius ** 2)


c = Circle()
c.setRadius(5)
c.setColor("red")
print("The Circumference is", c.getCircumference())
print("The Area is ", c.getArea())