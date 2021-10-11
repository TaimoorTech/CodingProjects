class BankAccount:
    money = 0

    def deposit(self):
        self.dep = int(input("Enter the money you want to deposit : "))
        self.money += self.dep

    def balance(self):
        return f"Your Balance in the Account is {self.money}!!"

    def withdraw(self):
        self.wt = int(input("Enter the money you want to withdraw : "))
        if self.money == 0:
             print("Your balance is zero!!")
        elif self.money < self.wt:
            print(f"The money {self.wt} cannot be drawn!!")
        else:
            self.money -= self.wt
            print(f"The money {self.wt} is withdrawn successfully from your account!!")


m = BankAccount()
print(m.balance())
m.deposit()
print(m.balance())
m.withdraw()
print(m.balance())