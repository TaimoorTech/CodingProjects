class Bank_Account:
    def __init__(self, account_number):
        self.account_number = account_number

    def printing(self):
        print("Account Number : ", self.account_number)


class Saving_Account(Bank_Account):
    def __init__(self, account_number, minimum_balance, interest_rate):
        super().__init__(account_number)
        self.minimum_balance = minimum_balance
        self.interest_rate=interest_rate

    def printing(self):
        super().printing()
        print(f"Minimum Balance : {self.minimum_balance}\nInterest Rate : {self.interest_rate}")


class Current_Account(Bank_Account):
    def __init__(self, account_number, withdrawal_limit):
        super().__init__(account_number)
        self.withdrawal_limit = withdrawal_limit

    def printing(self):
        super().printing()
        print(f"Withdrawal Limit : {self.withdrawal_limit}")


b = Bank_Account("cA456")
b.printing()
print()
s = Saving_Account("cb5556", 40000, "10 %")
s.printing()
print()
c = Current_Account("Da777", 15000)
c.printing()
