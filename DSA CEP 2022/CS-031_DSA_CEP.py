import time


class Library_Management_System:

    def __init__(self, name="", author="", subject="", publication_date=""):
        self.name = name
        self.author_name = author
        self.subject = subject
        self.date = publication_date

    def Register_Account(self):
        already_registered_emails = []
        self.user_name = input("Enter user name: ")
        self.age = int(input("Enter user age: "))
        checking_email = open("Registered_Accounts.txt", "a+")
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

    def Cancel_Membership(self):
        f = open('Registered_Accounts.txt', 'a+')
        f.seek(0)
        registered_emails = f.readlines()
        f.close()
        self.check_EmailID = input('Enter Email ID: ')
        self.check_pwd = input('Enter password: ')
        confirm = input("Press Y to confirm : ")
        if confirm == "Y":
            for i in range(len(registered_emails)):
                check = registered_emails[i].split(",")
                if self.check_EmailID == check[4] and self.check_pwd == check[5]:
                    registered_emails.pop(i)
                    print("Membership is cancelled...")

    def Login_Account(self):
        self.count = 0
        f = open('Registered_Accounts.txt', 'a+')
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

    def Display_Whole_Collection_Of_Books(self):
        self.details = []

        f = open("books_information.txt", "r")
        content = f.readlines()
        for i in range(len(content)):
            displaying = list(content[i].split(","))
            self.details.append(displaying)
        f.close()

        headings = ["Book Title", "Author Name", "Subject", "Publication Date"]
        print("-"*143)
        print(f"| {headings[0]:^50} | {headings[1]:^30} | {headings[2]:^25} | {headings[3]:^25} |")
        print("-"*143)
        for i in range(len(self.details)):
            print(f"| {self.details[i][0]:^50} | {self.details[i][1]:^30} | {self.details[i][2]:^25} | "
                  f"{self.details[i][3]:^25} |")
        print("-" * 143)

    def Add_Book(self, cart=[]):
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

        self.adding_book = input("Enter Book Name you want to add: ")
        if self.adding_book in self.book_names:
            cart_of_user.append(self.adding_book)
            print(f"The Book {self.adding_book} is being issued...")
        else:
            print(f"The Book {self.adding_book} is not present in the library...")

        return cart_of_user

    def Delete_Book(self, cart=[]):
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

        self.deleting_book = input("Enter Book Name you want to delete : ")
        if self.deleting_book in self.book_names:
            cart_of_user.remove(self.deleting_book)
            print(f"The Book {self.deleting_book} is being removed...")
        else:
            print(f"The Book {self.deleting_book} is already not present in your cart...")

        return cart_of_user

    def Modify_Book(self, cart=[]):
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

        self.modify_book = input("Enter Book Name you want to modify : ")
        if self.modifybook in self.book_names:
            self.new_book = input(f"Enter the Book Name you want to add in replace of Book {self.modify_book}: ")
            cart_of_user.remove(self.modify_book)
            cart_of_user.append(self.new_book)
            print(f"The Book {self.new_book} is being modified with the Book {self.modify_book}...")
        else:
            print(f"The Book {self.modify_book} is already not present in your cart...")

        return cart_of_user

    def check_out_book(self, cart=[]):
        if len(cart) == 0:
            print("Your cart is empty...")
            return

        cart_of_user = cart

        headings = ["S.No", "Title of the Book", "Issue Date", "Issue Time"]
        print("-" * 133)
        print(f"| {headings[0]:^10} | {headings[1]:^50} | {headings[2]:^30} | {headings[3]:^30}")
        print("-" * 133)
        count = 0
        for i in range(len(cart_of_user)):
            count += 1
            print(f"| {count} | {cart_of_user[i]} | {time.strftime('%d/%m/%Y')} | {time.strftime('%H:%M:%S')}")

        opening = open(f"{self.email}_Books_Issue.txt", "a+")
        for i in range(len(cart_of_user)):
            opening.write(f"{cart_of_user},")
        opening.close()

        print("Thanks for visiting...")
        return "end"

    def Search(self):
        self.details = []
        f = open("books_information.txt", "r")
        content = f.readlines()
        for i in range(len(content)):
            displaying = list(content[i].split(","))
            self.details.append(displaying)
        f.close()

        print("\nPress:\n(1)Search by Title\n(2)Search by Author Name\n(3)Search by Subject\n"
              "(4)Search by Publication Date")
        key = input("Enter Key : ")
        if key == '1':
            count = 0
            successful_search = []
            title = input("Enter part of Title of Book : ")
            for i in range(len(self.details)):
                if title in self.details[i][0]:
                    count += 1
                    successful_search.append(self.details[i])
            if count != 0:
                print(f"Total Searches on basis of Title {title} : {count}.")
                headings = ["S.No", "Title of the Book", "Author Name", "Subject", "Publication Date"]
                print("-" * 156)
                print(f"| {headings[0]:^10} | {headings[1]:^50} | {headings[2]:^30} | {headings[3]:^20} | "
                      f"{headings[4]:^30} |")
                print("-" * 156)
                for i in range(len(successful_search)):
                    print(f"| {str(i+1):^10} | {successful_search[i][0]:^50} | {successful_search[i][1]:^30} "
                          f"| {successful_search[i][2]:^20} | {successful_search[i][3]:^30} |")
                print("-" * 156)
            else:
                print("No data Found...")

        elif key == '2':
            count = 0
            successful_search = []
            author = input("Enter Author Name : ")
            for i in range(len(self.details)):
                if author == self.details[i][1]:
                    count += 1
                    successful_search.append(self.details[i])
            if count != 0:
                print(f"Total Searches on basis of Title {author} : {count}.")
                headings = ["S.No", "Author Name", "Title of the Book", "Subject", "Publication Date"]
                print("-" * 156)
                print(f"| {headings[0]:^10} | {headings[1]:^30} | {headings[2]:^50} | {headings[3]:^20} | "
                      f"{headings[4]:^30} |")
                print("-" * 156)
                for i in range(len(successful_search)):
                    print(f"| {str(i+1):^10} | {successful_search[i][1]:^30} | {successful_search[i][0]:^50} "
                          f"| {successful_search[i][2]:^20} | {successful_search[i][3]:^30} |")
                print("-" * 156)
            else:
                print("No data Found...")

        elif key == '3':
            count = 0
            successful_search = []
            subject = input("Enter Subject : ")
            for i in range(len(self.details)):
                if subject == self.details[i][2]:
                    count += 1
                    successful_search.append(self.details[i])
            if count != 0:
                print(f"Total Searches on basis of Title {subject} : {count}.")
                headings = ["S.No", "Subject", "Title of the Book", "Author Name", "Publication Date"]
                print("-" * 156)
                print(f"| {headings[0]:^10} | {headings[1]:^20} | {headings[2]:^50} | {headings[3]:^30} | "
                      f"{headings[4]:^30} |")
                print("-" * 156)
                for i in range(len(successful_search)):
                    print(f"| {str(i+1):^10} | {successful_search[i][2]:^20} | {successful_search[i][0]:^50} "
                          f"| {successful_search[i][1]:^30} | {successful_search[i][3]:^30} |")
                print("-" * 156)
            else:
                print("No data Found...")

        elif key == '4':
            count = 0
            successful_search = []
            publication_date = input("Enter Date of publication in format (DD/MM/YYYY) : ")
            for i in range(len(self.details)):
                if publication_date == self.details[i][3]:
                    count += 1
                    successful_search.append(self.details[i])
            if count != 0:
                print(f"Total Searches on basis of Title {publication_date} : {count}.")
                headings = ["S.No", "Publication Date", "Title of the Book", "Author Name", "Subject"]
                print("-" * 156)
                print(f"| {headings[0]:^10} | {headings[1]:^30} | {headings[2]:^50} | {headings[3]:^30} | "
                      f"{headings[4]:^20} |")
                print("-" * 156)
                for i in range(len(successful_search)):
                    print(f"| {str(i+1):^10} | {successful_search[i][3]:^30} | {successful_search[i][0]:^50} "
                          f"| {successful_search[i][1]:^30} | {successful_search[i][2]:^20} |")
                print("-" * 156)
            else:
                print("No data Found...")

        else:
            print('Kindly Enter Suitable Key...')
            return

    def Reserve_Book(self):
        book_for_reservation = input("Enter the Book you want to be Reserved : ")
        opening = open(f"{self.email}_Reservation.txt", "a+")
        opening.write(book_for_reservation + ",")
        opening.close()
        print(f"The Book {book_for_reservation} is  being reserved...")

    def Return_Book(self):
        returned_book = input("Enter the Book you want to Return to the Library : ")

        opening = open(f"{self.email}_Books_Issue.txt", "a+")
        getting_details = opening.read()
        issued_books = list(getting_details.split(","))
        opening.close()

        if returned_book in issued_books:
            issued_books.remove(returned_book)
            print(f"The Book {returned_book} is returned to the library...")
        else:
            print(f"You did not issue this Book {returned_book}...")

        new_opening = open(f"{self.email}_Books_Issue.txt", "w")
        for i in range(len(issued_books)):
            new_opening.write(issued_books[i] + ",")
        new_opening.close()

    def Renew_Book(self):
        renew_book = input("Enter the Book you want to Renew to the Library : ")

        opening = open(f"{self.email}_Books_Issue.txt", "a+")
        getting_details = opening.read()
        issued_books = list(getting_details.split(","))
        opening.close()

        if renew_book in issued_books:
            print(f"The Book {renew_book} is renewed...")
        else:
            print(f"The Book {renew_book} is not present in your Issued_books list...")

    def Merge_sort(self):
        self.details = []
        merge_list = []

if __name__ == "__main__":
    username=""
    while True:
        print("*" * 35)
        print("Welcome to Dream Online Shopping Store {}!!!".format((username)))
        print("Here are the options : \n(1) Display Products\n(2) Add the Products to the Cart\n"
              "(3) Remove the Products from the Cart\n(4) View the Cart\n(5) View Shopping History"
              "\n(6) Checkout\n(7) Register to your Account\n(8) Login into your account\n"
              "(9) Login to your Another Account\n(10) Login as Administrator\n(11) Exit")


Library = Library_Management_System()
Library.Display_Whole_Collection_Of_Books()
Library.Search()
