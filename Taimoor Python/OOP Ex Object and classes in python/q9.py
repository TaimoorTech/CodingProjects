class TollBooth:
    def __init__(self, tc=0, tm=0):
        TollBooth.totalcars = tc
        TollBooth.totalmoney = tm

    def payingCar(self):
        TollBooth.totalcars += 1
        TollBooth.totalmoney += 50

    def nopayCar(self):
        TollBooth.totalcars += 1

    def display(self):
        print(f"The Total Cars are : {TollBooth.totalcars}.\nThe Total Money collected is Rs.{TollBooth.totalmoney}.")


t = TollBooth()
while True:
    choice = int(input("Enter your choice : \n1)Count a Paying Car\n2)Count a NonPaying Car\n3)Print out\n4)Exit\n"))
    if choice == 1:
        t.payingCar()
    elif choice == 2:
        t.nopayCar()
    elif choice == 3:
        t.display()
    elif choice == 4:
        break
    else:
        print("Kindly Enter Correct Choice..")