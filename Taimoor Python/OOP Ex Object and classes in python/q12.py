class Tracker:
    count = 0
    def __init__(self):
        Tracker.count += 1

    def report(self):
         print(f"I am Object number {self.count}")

class ff(Tracker):
    def __init__(self):
        super().__init__()

t1 = Tracker()
t1.report()
t2 = Tracker()
t2.report()
t3 = Tracker()
t3.report()
t4 = ff()
t4.count = 45
t4.report()