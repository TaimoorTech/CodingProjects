class Angle:
    def __init__(self, degree=0, minute=0.00, direction="N"):
        self.degree = degree
        self.minute = minute
        self.direction = direction

    def valueinput(self, deg, minu, dire):
        self.degree = deg
        self.minute = minu
        self.direction = dire

    def display(self):
        print(f"{self.degree}{rep}{self.minute}' {self.direction}")


rep = '\xb0'
d = Angle()
while True:
    deg = int(input("Enter degree : "))
    minu = float(input("Enter minutes : "))
    while True:
        dire = input("Enter direction : N or S for Latitude and E or W for Longitude :")
        if len(dire) == 1 and (dire == "N" or dire == "E" or dire == "W" or dire == "S"):
            break
    d.valueinput(deg, minu, dire)
    d.display()
    ch = input("Press 3 to exit : ")
    if ch == "3":
        break
