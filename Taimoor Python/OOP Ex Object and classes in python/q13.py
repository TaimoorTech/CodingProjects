class Ship:
    rep = "\xb0"
    count = 0
    pos = ""

    def __init__(self, degree=0, minute=0.00):
        Ship.count += 1
        self.degree = degree
        self.minute = minute

    def position(self):
        ch = input("Press A)For latitude B)For Longitude : ")
        if ch == "A":
            p = input("Enter N or S : ")
            self.pos += p
        elif ch == "B":
            p = input("Enter E or W : ")
            self.pos += p

    def report(self):
        print(f"The Ship Number is {Ship.count}.\nThe Position is {self.degree}{self.rep}{self.minute}'{self.pos}")


s1 = Ship(55, 44)
s1.position()
s1.report()
s2 = Ship(45, 24)
s2.position()
s2.report()
s3 = Ship(5, 82)
s3.position()
s3.report()
