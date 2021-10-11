class BankAccount:
    __money = 0

    def deposit(self):
        self.__dep = int(input("Enter the money you want to deposit : "))
        self.__money += self.__dep

    def balance(self):
        return f"Your Balance in the Account is {self.__money}!!"

    def withdraw(self):
        self.__wt = int(input("Enter the money you want to withdraw : "))
        if self.__money == 0:
             print("Your balance is zero!!")
        elif self.__money < self.__wt:
            print(f"The money {self.__wt} cannot be drawn!!")
        else:
            self.__money -= self.__wt
            print(f"The money {self.__wt} is withdrawn successfully from your account!!")


m = BankAccount()
print(m.balance())
m.deposit()
print(m.balance())
m.withdraw()
print(m.balance())