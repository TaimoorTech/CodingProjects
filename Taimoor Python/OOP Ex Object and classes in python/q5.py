class Worker:
    def __init__(self, hour=0, rate=10.00):
        self.__hoursWorked = hour
        self.__wageRate = rate

    def setHoursWorked(self, h):
        self.__hoursWorked = h

    def changeRate(self, r):
        self.__wageRate = r

    def pay(self):
        return self.__hoursWorked * self.__wageRate


w1 = Worker()
w1.setHoursWorked(8)
w1.changeRate(15)
print(w1.pay())