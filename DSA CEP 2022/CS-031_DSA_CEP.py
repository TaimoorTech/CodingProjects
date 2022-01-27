import time


class Library_management_System:

    def __init__(self, name="", author="", subject="", publication_date=""):
        self.name = name
        self.author_name = author
        self.subject = subject
        self.date = publication_date

    def register_account(self):
        already_registered_emails = []
        self.user_name = input("Enter user name: ")
        self.age = int(input("Enter user age: "))
        checking_email = open("Registered Accounts.txt", "a+")
        contents = checking_email.read()
        email_content = list(contents.split(','))
        for i in range(len(email_content)):
            already_registered_emails.append(contents[4])
        while True:
            self.email = input("Enter Email ID : ")
            if self.email in already_registered_emails:
                print("This Email ID is already registered")
                continue
            else:
                break
        self.password = input("Enter password : ")
        registering = open('User Registration.txt', 'a')
        registering.write(f"{time.strftime('%d/%m/%Y')},{time.strftime('%H:%M:%S')},{self.user_name},{self.age},"
                          f"{self.email}, {self.password},\n")
        registering.close()
        print("Your Account has been Registered!")

    def login_account(self):
        self.count = 0
        f = open('Registered Accounts.txt', 'a+')
        f.seek(0)
        convert = f.readlines()
        f.close()
        self.check_EmailID = input('Enter Email ID: ')
        self.check_pwd = input('Enter password: ')
        for i in convert:
            check = i.split(",")
            if self.check_EmailID == check[4] and self.check_pwd == check[5]:
                print('You are logged in!')
                self.count = 1
                self.username = check[2]
                break
        if self.count == 0:
            print('Incorrect ID or password...Try again!')
            return "", ""
        else:
            return self.username, self.check_EmailID

    def display_books(self):
        self.details = []

        f = open("books_information.txt", "r")
        content = f.readlines()
        for i in range(len(content)):
            displaying = list(content[i].split(","))
            self.details.append(displaying)
        f.close()

        headings = ["Book Name", "Author Name", "Subject", "Publication Date"]
        print("-"*143)
        print(f"| {headings[0]:^50} | {headings[1]:^30} | {headings[2]:^25} | {headings[3]:^25} |")
        print("-"*143)
        for i in range(len(self.details)):
            print(f"| {self.details[i][0]:^50} | {self.details[i][1]:^30} | {self.details[i][2]:^25} | "
                  f"{self.details[i][3]:^25} |")
        print("-" * 143)

    def add_book(self, cart=[]):
        if len(cart) == 0:
            print("Your cart is empty...")
            return

        cart_of_user = cart
        self.book_names = []
        self.details = []

        f = open("books_information.txt", "r")
        content = f.readlines()
        for i in range(len(content)):
            displaying = list(content[i].split(","))
            self.details.append(displaying)
        for i in range(len(self.details)):
            self.book_names.append(self.details[i][0])
        f.close()

        self.addingbook = input("Enter Book Name you want to add: ")
        if self.addingbook in self.book_names:
            cart_of_user.append(self.addingbook)
            print(f"The Book {self.addingbook} is being issued...")
        else:
            print(f"The Book {self.addingbook} is not present in the library...")

        return cart_of_user

    def delete_book(self, cart=[]):
        if len(cart) == 0:
            print("Your cart is empty...")
            return

        cart_of_user = cart
        self.book_names = []
        self.details = []

        f = open("books_information.txt", "r")
        content = f.readlines()
        for i in range(len(content)):
            displaying = list(content[i].split(","))
            self.details.append(displaying)
        for i in range(len(self.details)):
            self.book_names.append(self.details[i][0])
        f.close()

        self.deletingbook = input("Enter Book Name you want to delete : ")
        if self.deletingbook in self.book_names:
            cart_of_user.remove(self.deletingbook)
            print(f"The Book {self.deletingbook} is being removed...")
        else:
            print(f"The Book {self.deletingbook} is already not present in your cart...")

        return cart_of_user

    def modify_book(self, cart=[]):
        if len(cart) == 0:
            print("Your cart is empty...")
            return

        cart_of_user = cart
        self.book_names = []
        self.details = []

        f = open("books_information.txt", "r")
        content = f.readlines()
        for i in range(len(content)):
            displaying = list(content[i].split(","))
            self.details.append(displaying)
        for i in range(len(self.details)):
            self.book_names.append(self.details[i][0])
        f.close()

        self.modifybook = input("Enter Book Name you want to modify : ")
        if self.modifybook in self.book_names:
            self.new_book = input(f"Enter the Book Name you want to add in replace of Book {self.modifybook}: ")
            cart_of_user.remove(self.modifybook)
            cart_of_user.append(self.new_book)
            print(f"The Book {self.new_book} is being modified with the Book {self.modifybook}...")
        else:
            print(f"The Book {self.modifybook} is already not present in your cart...")

        return cart_of_user

    def Check_out_book(self, cart=[]):
        if len(cart) == 0:
            print("Your cart is empty...")
            return

        cart_of_user = cart

        headings = ["S.No", "Name of the Book", "Issue Date", "Issue Time"]
        print("-" * 133)
        print(f"| {headings[0]:^10} | {headings[1]:^50} | {headings[2]:^30} | {headings[3]:^30}")
        print("-" * 133)
        count = 0
        for i in range(len(cart_of_user)):
            count += 1
            print(f"| {count} | {cart_of_user[i]} | {time.strftime('%d/%m/%Y')} | {time.strftime('%H:%M:%S')}")

        print("Thanks for visiting...")
        return "end"



d = Library_management_System()
d.display_books()
d.add_book()