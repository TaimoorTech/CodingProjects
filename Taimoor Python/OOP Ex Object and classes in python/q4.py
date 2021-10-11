class Worker:
    __hoursWorked = 0
    __wageRate = 10.00

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