class Int:
    def __init__(self, n=0):
        self.num = n

    def Change(self, k):
        self.num = k

    def display(self):
        print(self.num)

    def add(self, y):
        self.num += y


a = Int(17)
b = Int(55)
b.display()
b.Change(100)
b.display()
a.display()
a.add(b.num)
a.display()

