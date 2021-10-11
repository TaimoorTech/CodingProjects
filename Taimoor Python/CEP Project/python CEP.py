import time
from abc import ABC, abstractmethod


# ---------------- Daniyal ----------------------------
class User:
    """This Class allows User to Login or Register to his /her Account with necessary details and it keeps data of all
    users which are registered........................"""

    def __init__(self, name="", EmailID="", pwd="", age=0, gender=""):
        self.name = name
        self.age = age
        self.gender = gender
        self.EmailID = EmailID
        self.pwd = pwd

    def register(self):
        self.name = input('Enter user name: ')
        self.age = int(input('Enter user age: '))
        print('''Enter User Gender
                 Press 1 if Male
                 Press 2 if Female
                 Press 3 otherwise''')
        g = int(input('Enter user gender : '))
        if g == 1:
            self.gender = 'Male'
            print('User gender: Male')
        if g == 2:
            self.gender = 'Female'
            print('User gender: Female')
        if g == 3:
            self.gender = 'Other'
            print('User Gender: Other')
        self.EmailID = input('Enter Email ID: ')
        self.pwd = input('Enter password: ')
        f = open('User Registration.txt', 'a')
        f.write(f"{time.strftime('%d/%m/%Y')},{time.strftime('%H:%M:%S')},{self.name},{self.age},"
                f"{self.gender},{self.EmailID},{self.pwd},\n")
        f.close()
        print("Your Account has been Registered!")

    def login(self):
        self.count = 0
        f = open('User Registration.txt', 'a+')
        f.seek(0)
        convert = f.readlines()
        f.close()
        self.check_EmailID = input('Enter Email ID: ')
        self.check_pwd = input('Enter password: ')
        for i in convert:
            check = i.split(",")
            if self.check_EmailID == check[5] or self.check_pwd == check[6]:
                print('You are logged in!')
                self.count = 1
                self.username = check[2]
                break
        if self.count == 0:
            print('Incorrect ID or password...Try again!')
            return "", ""
        else:
            return self.username, self.check_EmailID


# ----------------- Sami ----------------------------
class Product(ABC):  # Abstract Class
    """This Class is an Abstract Class and it keeps data of all Products Per kg/ Per Unit and prints them............"""
    # Reading file contents of name of products per kg.........
    f1 = open("name_of_product_per_kg.txt", "r")
    name_of_product_per_kg = f1.read()
    name_of_product_per_kg = list(name_of_product_per_kg.split(','))
    del name_of_product_per_kg[-1]
    f1.close()
    # Reading file contents of name of products per unit.........
    f2 = open("name_of_product_per_unit.txt", "r")
    name_of_product_per_unit = f2.read()
    name_of_product_per_unit = list(name_of_product_per_unit.split(','))
    del name_of_product_per_unit[-1]
    f2.close()
    # Reading file contents of price of products per kg.........
    f3 = open("price_of_product_per_kg.txt", "r")
    price_of_product_per_kg = f3.read()
    price_of_product_per_kg = list(price_of_product_per_kg.split(','))
    del price_of_product_per_kg[-1]
    # Reading file contents of price of products per unit.........
    f4 = open("price_of_product_per_unit.txt", "r")
    price_of_product_per_unit = f4.read()
    price_of_product_per_unit = list(price_of_product_per_unit.split(','))
    del name_of_product_per_unit[-1]
    # Reading file contents of stock of products per kg.........
    f5 = open("stock_of_product_per_kg.txt", "r")
    stock_of_product_per_kg = f5.read()
    stock_of_product_per_kg = list(stock_of_product_per_kg.split(','))
    del stock_of_product_per_kg[-1]
    # Reading file contents of stock of products per unit.........
    f6 = open("stock_of_product_per_unit.txt", "r")
    stock_of_product_per_unit = f6.read()
    stock_of_product_per_unit = list(stock_of_product_per_unit.split(','))
    del stock_of_product_per_unit[-1]

    @abstractmethod
    def Display_product(self):
        print(Product.name_of_product_per_kg)
        design = ["Name Of Product", "Price Of Product(Per Kg/ Per unit)"]
        print("+" * 83)
        strg = "*{:^40}*{:^40}*"
        print(strg.format(design[0], design[1]))
        print("+" * 83)
        for i in range(len(Product.name_of_product_per_kg)):
            print(strg.format(Product.name_of_product_per_kg[i], Product.price_of_product_per_kg[i]))
        for i in range(len(Product.name_of_product_per_unit)):
            print(strg.format(Product.name_of_product_per_unit[i], Product.price_of_product_per_unit[i]))
        print("+" * 83)


# -------------------- Taimoor ----------------------------
class Cart(Product):  # Inheritance
    """This Class Contains records of a Cart of a User.
       * User can add and remove products from the Cart.
       * User can also view the cart....................."""

    def __init__(self, name="", ID=""):
        user_cart = User(name, ID)  # Association
        self.add = {}

    def Display_product(self):
        super().Display_product()

    def add_products_to_cart(self):
        check = 0
        while True:
            self.adding_product = input("Enter the name of Product of you want to add : ")
            for i in range(len(Product.name_of_product_per_kg)):
                if self.adding_product == Product.name_of_product_per_kg[i]:
                    self.quantity = int(input(f"How much {self.adding_product} you want in Kg : "))
                    if self.adding_product in self.add.keys():
                        value_of_product = self.add.get(self.adding_product)
                        change_quantity = value_of_product[0] + self.quantity
                        self.add[self.adding_product] = (change_quantity, value_of_product[1])
                    else:
                        self.add.update({self.adding_product: (self.quantity, int(Product.price_of_product_per_kg[i]))})
                    print(f"The {self.adding_product} item is added to your cart!!")
                    check = 1
            for i in range(len(Product.name_of_product_per_unit)):
                if self.adding_product == Product.name_of_product_per_unit[i]:
                    self.quantity = int(input(f"How much {self.adding_product} you want per unit : "))
                    self.add.update({self.adding_product: (self.quantity, int(Product.price_of_product_per_unit[i]))})
                    print(f"The {self.adding_product} item is added to your cart!!")
                    check = 1
            if check == 0:
                print("Kindly, Enter Product from above list................")

            confirmation = input("Press 1 to Add more products\nPress Any Key to Return to Menu"
                                 "\nEnter your choice : ")
            if confirmation == "1":
                continue
            else:
                break
        return self.add.values()

    def remove_products_to_cart(self):
        while True:
            self.removing_product = input("Enter the name of Product of you want to remove : ")
            key = self.add.keys()
            if self.removing_product in key:
                self.add.pop(self.removing_product)
                print(f"The {self.removing_product} item is removed from your cart!!")
            else:
                print(f"The {self.removing_product} item is not present in your cart!!")
            confirmation = input("Press 1 to Remove more products\nPress Any Key to Return to Menu"
                                 "\nEnter your choice : ")
            if confirmation == "1":
                continue
            else:
                break
        return self.add.values()

    def view_cart(self):
        print("-" * 94)
        print(f"|{'Name Of Product':^40}|{'Quantity':^20}|{'Price(Per Kg/Per Unit)':^30}|")
        print("-" * 94)
        for i in self.add.keys():
            print(f"|{('                ' + i):<40}|{(str(self.add.get(i)[0]) + '        '):>20}"
                  f"|{self.add.get(i)[1]:^30}|")
        print("-" * 94)


class Bill(Cart, ABC):  # Abstract Class, Multiple Inheritance
    """This Class is also an Abstract Class and it calculates Bill.................."""

    def __init__(self):
        super().__init__()
        self.bill = 0
        self.value = []

    # abstractmethod
    def Calculating_Bill(self, c):
        self.value = c
        if len(self.value) > 0:
            for i in range(len(self.value)):
                self.bill += (self.value[i][0] * self.value[i][1])
            print(self.bill)


if __name__ == "__main__":
    username = ""
    userID = ""
    cart1 = Cart(username, userID)
    total_prizes = []
    while True:
        print("*" * 35)
        print(f"Welcome to Dream Online Shopping Store {username}!!!")
        print("Here are the options : \n(1) Display Products\n(2) Add the Products to the Cart\n"
              "(3) Remove the Products from the Cart\n(4) View the Cart\n(5) View Shopping History"
              "\n(6) Checkout\n(7) Register to your Account\n(8) Login into your account\n"
              "(9) Register or Login to your Another Account\n(10)Login as Administrator\n(11) Exit")

        user_choice = input("Enter your choice : ")
        try:  # Exception Handling
            user_choice = int(user_choice)
        except Exception:
            continue
        if user_choice == 1:
            cart1.Display_product()
        elif user_choice == 2:
            total_prizes = list(cart1.add_products_to_cart())
        elif user_choice == 3:
            total_prizes = list(cart1.remove_products_to_cart())
        elif user_choice == 4:
            cart1.view_cart()
        elif user_choice == 6:
            if username == "":
                print("Sir, You have to login first!!")
                bill = Bill()
                bill.Calculating_Bill(total_prizes)
            else:
                bill = Bill()
                bill.Calculating_Bill(total_prizes)
        elif (user_choice == 7) or (user_choice == 9):
            register_user = User()
            register_user.register()
            while True:
                choice = input("Do you want to login now:\nIf YES Press Y\nIf NO Press N\nEnter your choice : ")
                if choice == "Y":
                    value = register_user.login()
                    username = value[0]
                    userID = value[1]
                    break
                elif choice == "N":
                    break
                else:
                    continue
        elif user_choice == 8:
            login_user = User()
            value = login_user.login()
            username = value[0]
            userID = value[1]
        elif user_choice == 10:
            while True:
                administrator_choice = input("What do you want to do:\n(1)Add a new Product\n(2)Remove a Product\n"
                                             "(3)Display Users List\n(4)Log out as Administrator")
        elif user_choice == 11:
            print("Thanks for coming to Dream Online Shopping Store!!!")
            break
        else:
            print("Enter Correct Choice from 1-11!!")
