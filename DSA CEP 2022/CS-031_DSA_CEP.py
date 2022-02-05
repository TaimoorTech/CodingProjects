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
        checking_email.seek(0)
        contents = checking_email.read()
        email_content = list(contents.split(','))
        checking_email.close()
        try:
            for i in range(len(email_content)):
                already_registered_emails.append(email_content[4])
        except Exception:
            pass
        while True:
            self.email = input("Enter Email ID : ")
            if self.email in already_registered_emails:
                print("This Email ID is already registered")
                continue
            else:
                break
        self.password = input("Enter password : ")
        registering = open('Registered_Accounts.txt', 'a')
        registering.write(f"{time.strftime('%d/%m/%Y')},{time.strftime('%H:%M:%S')},{self.user_name},{self.age},"
                          f"{self.email},{self.password},\n")
        registering.close()
        print("Your Account has been Registered!")

    def Cancel_Membership(self, email):
        account_details = []
        f = open('Registered_Accounts.txt', 'a+')
        f.seek(0)
        registered_emails = f.readlines()
        for i in range(len(registered_emails)):
            displaying = list(registered_emails[i].split(","))
            account_details.append(displaying)
        f.close()

        check_EmailID = input('Enter Email ID: ')
        self.check_pwd = input('Enter password: ')
        confirm = input("Press Y to confirm : ")
        y = 0
        e = 0
        if confirm == "Y":
            for i in range(len(registered_emails)):
                if check_EmailID == account_details[i][4] and self.check_pwd == account_details[i][5]:
                    account_details.pop(i)
                    print("Membership is cancelled...")
                    y = 1
                    if email == check_EmailID:
                        e = 1
                    break

        if y == 1:
            if len(account_details) > 0:
                for i in range(len(account_details)):
                    registering = open('Registered_Accounts.txt', 'w')
                    registering.write(f"{account_details[i][0]},{account_details[i][1]},{account_details[i][2]},"
                                          f"{account_details[i][3]},{account_details[i][4]},{account_details[i][5]},\n")
                    registering.close()
            else:
                registering1 = open('Registered_Accounts.txt', 'w')
                registering1.close()
        if e == 1:
            return ""
        elif y == 0:
            print("Membership Cancelling Failed...")

    def Login_Account(self):
        self.count = 0
        f = open('Registered_Accounts.txt', 'a+')
        f.seek(0)
        convert = f.readlines()
        f.close()
        check_EmailID = input('Enter Email ID: ')
        self.check_pwd = input('Enter password: ')
        for i in convert:
            check = i.split(",")
            if check_EmailID == check[4] and self.check_pwd == check[5]:
                print('You are logged in!')
                self.count = 1
                self.username = check[2]
                self.email = check_EmailID
                break
        if self.count == 0:
            print('Incorrect ID or password...Try again!')
            return "",""
        else:
            return self.username, self.email

    def See_Whole_Collection_Of_Books(self):
        self.details = []

        f = open("List_of_books.txt", "r")
        content = f.readlines()
        for i in range(len(content)):
            displaying = list(content[i].split(","))
            self.details.append(displaying)
        f.close()

        headings = ["Book Title", "Author Name", "Subject", "Publication Date"]
        print("-" * 158)
        print(f"| {headings[0]:^55} | {headings[1]:^30} | {headings[2]:^35} | {headings[3]:^25} |")
        print("-" * 158)
        for i in range(len(self.details)):
            print(f"| {self.details[i][0]:<55} | {self.details[i][1]:<30} | {self.details[i][2]:<35} | "
                  f"{self.details[i][3]:<25} |")
        print("-" * 158)

    def Add_Book(self, cart=[]):
        cart_of_user = cart
        self.book_names = []
        self.details = []

        f = open("List_of_books.txt", "r")
        content = f.readlines()
        for i in range(len(content)):
            displaying = list(content[i].split(","))
            self.details.append(displaying)
        for i in range(len(self.details)):
            self.book_names.append(self.details[i][0])
        f.close()

        check = 0
        self.adding_book = input("Enter Book Name you want to add: ")
        for i in range(len(self.book_names)):
            if self.adding_book == self.book_names[i]:
                cart_of_user.append(self.adding_book)
                print(f"The Book {self.adding_book} is being issued...")
                check = 1
        if check == 0:
            print(f"The Book {self.adding_book} is not present in the library...")

        return cart_of_user

    def Delete_Book(self, cart=[]):
        if len(cart) == 0:
            print("Your cart is empty...")
            return []

        cart_of_user = cart
        self.book_names = []
        self.details = []

        f = open("List_of_books.txt", "r")
        content = f.readlines()
        for i in range(len(content)):
            displaying = list(content[i].split(","))
            self.details.append(displaying)
        for i in range(len(self.details)):
            self.book_names.append(self.details[i][0])
        f.close()

        check = 0
        self.deleting_book = input("Enter Book Name you want to delete : ")
        for i in range(len(self.book_names)):
            if self.deleting_book == self.book_names[i]:
                cart_of_user.remove(self.deleting_book)
                print(f"The Book {self.deleting_book} is being removed...")
                check = 1
        if check == 0:
            print(f"The Book {self.deleting_book} is already not present in your cart...")

        return cart_of_user

    def Modify_Book(self, cart=[]):
        if len(cart) == 0:
            print("Your cart is empty...")
            return []

        cart_of_user = cart
        self.book_names = []
        self.details = []

        f = open("List_of_books.txt", "r")
        content = f.readlines()
        for i in range(len(content)):
            displaying = list(content[i].split(","))
            self.details.append(displaying)
        for i in range(len(self.details)):
            self.book_names.append(self.details[i][0])
        f.close()

        check = 0
        self.modify_book = input("Enter Book Name you want to modify : ")
        for i in range(len(self.book_names)):
            if self.modify_book == self.book_names[i] and self.modify_book in cart_of_user:
                self.new_book = input(f"Enter the Book Name you want to add in replace of Book {self.modify_book}: ")
                try:
                    cart_of_user.remove(self.modify_book)
                    cart_of_user.append(self.new_book)
                except Exception:
                    pass
                print(f"The Book {self.new_book} is being modified with the Book {self.modify_book}...")
                check = 1
        if check == 0:
            print(f"The Book {self.modify_book} is already not present in your cart...")

        return cart_of_user

    def Check_out_book(self, cart=[]):
        if len(cart) == 0:
            print("Your cart is empty...")
            return

        cart_of_user = cart

        headings = ["S.No", "Title of the Book", "Issue Date", "Issue Time"]
        print("-" * 145)
        print(f"| {headings[0]:^10} | {headings[1]:^62} | {headings[2]:^30} | {headings[3]:^30} |")
        print("-" * 145)
        count = 0
        for i in range(len(cart_of_user)):
            count += 1
            print(f"| {count:^10} |   {cart_of_user[i]:<60} | {time.strftime('%d/%m/%Y'):^30} | "
                  f"{time.strftime('%H:%M:%S'):^30} |")
        print("-" * 145)

        while True:
            confirm = input("Do you want to Checkout ?\nPress:\n(1) Yes\n(2) No\nEnter Key : ")
            if confirm == "1":
                opening = open(f"{self.email}_Books_Issue.txt", "a+")
                for i in range(len(cart_of_user)):
                    opening.write(f"{cart_of_user[i]},")
                opening.close()
                return "end"
            elif confirm == "2":
                return "not end"
            else:
                print("Kindly Enter Suitable Key...")

    def Search(self):
        self.details = []
        f = open("List_of_books.txt", "r")
        content = f.readlines()
        for i in range(len(content)):
            displaying = list(content[i].split(","))
            self.details.append(displaying)
        f.close()
        print("Press:\n(1) Search by Title\n(2) Search by Author Name\n(3) Search by Subject\n"
              "(4) Search by Publication Date")
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
                print("-" * 167)
                print(f"| {headings[0]:^6} | {headings[1]:^55} | {headings[2]:^30} | {headings[3]:^35} | "
                      f"{headings[4]:^25} |")
                print("-" * 167)
                for i in range(len(successful_search)):
                    print(f"| {str(i + 1):^6} | {successful_search[i][0]:<55} | {successful_search[i][1]:<30} "
                          f"| {successful_search[i][2]:<35} | {successful_search[i][3]:<25} |")
                print("-" * 167)
            else:
                print("No data Found...")

        elif key == '2':
            count = 0
            successful_search = []
            author = input("Enter Author Name : ")
            for i in range(len(self.details)):
                if author in self.details[i][1]:
                    count += 1
                    successful_search.append(self.details[i])
            if count != 0:
                print(f"Total Searches on basis of Title {author} : {count}.")
                headings = ["S.No", "Author Name", "Title of the Book", "Subject", "Publication Date"]
                print("-" * 167)
                print(f"| {headings[0]:^6} | {headings[1]:^30} | {headings[2]:^55} | {headings[3]:^35} | "
                      f"{headings[4]:^25} |")
                print("-" * 167)
                for i in range(len(successful_search)):
                    print(f"| {str(i + 1):^6} | {successful_search[i][1]:<30} | {successful_search[i][0]:<55} "
                          f"| {successful_search[i][2]:<35} | {successful_search[i][3]:<25} |")
                print("-" * 167)
            else:
                print("No data Found...")

        elif key == '3':
            count = 0
            successful_search = []
            subject = input("Enter Subject : ")
            for i in range(len(self.details)):
                if subject in self.details[i][2]:
                    count += 1
                    successful_search.append(self.details[i])
            if count != 0:
                print(f"Total Searches on basis of Title {subject} : {count}.")
                headings = ["S.No", "Subject", "Title of the Book", "Author Name", "Publication Date"]
                print("-" * 167)
                print(f"| {headings[0]:^6} | {headings[1]:^35} | {headings[2]:^55} | {headings[3]:^30} | "
                      f"{headings[4]:^25} |")
                print("-" * 167)
                for i in range(len(successful_search)):
                    print(f"| {str(i + 1):^6} | {successful_search[i][2]:<35} | {successful_search[i][0]:<55} "
                          f"| {successful_search[i][1]:<30} | {successful_search[i][3]:<25} |")
                print("-" * 167)
            else:
                print("No data Found...")

        elif key == '4':
            count = 0
            successful_search = []
            publication_date = input("Enter Date of publication in format (DD/MM/YYYY) : ")
            for i in range(len(self.details)):
                if publication_date in self.details[i][3]:
                    count += 1
                    successful_search.append(self.details[i])
            if count != 0:
                print(f"Total Searches on basis of Title {publication_date} : {count}.")
                headings = ["S.No", "Publication Date", "Title of the Book", "Author Name", "Subject"]
                print("-" * 167)
                print(f"| {headings[0]:^6} | {headings[1]:^25} | {headings[2]:^55} | {headings[3]:^30} | "
                      f"{headings[4]:^35} |")
                print("-" * 167)
                for i in range(len(successful_search)):
                    print(f"| {str(i + 1):^6} | {successful_search[i][3]:<25} | {successful_search[i][0]:<55} "
                          f"| {successful_search[i][1]:<30} | {successful_search[i][2]:<35} |")
                print("-" * 167)
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
        opening.seek(0)
        getting_details = opening.read()
        issued_books = list(getting_details.split(","))
        opening.close()

        check = 0
        for k in range(len(issued_books)):
            if returned_book == issued_books[k]:
                print(f"The Book {returned_book} is returned to the library...")
                check = 1
        if check == 1:
            issued_books.remove(returned_book)
            new_opening = open(f"{self.email}_Books_Issue.txt", "w")
            if len(issued_books) > 0:
                for j in range(len(issued_books)):
                    if len(issued_books[j]) > 1:
                        new_opening.write(issued_books[j] + ",")
                new_opening.close()
        elif check == 0:
            print(f"You did not issue this Book {returned_book}...")

    def Renew_Book(self):
        renew_book = input("Enter the Book you want to Renew to the Library : ")

        opening = open(f"{self.email}_Books_Issue.txt", "a+")
        opening.seek(0)
        getting_details = opening.read()
        issued_books = list(getting_details.split(","))
        opening.close()

        if renew_book in issued_books:
            print(f"The Book {renew_book} is renewed...")
        else:
            print(f"The Book {renew_book} is not present in your Issued_books list...")

    def Merge_sort(self, details):
        if len(details) <= 1:
            return details

        mid = int(len(details) / 2)
        left, right = self.Merge_sort(details[:mid]), self.Merge_sort(details[mid:])

        return self.merging(left, right)

    def merging(self, left, right):
        sorted = []
        left_p = 0
        right_p = 0

        while left_p < len(left) and right_p < len(right):

            if left[left_p] < right[right_p]:
                sorted.append(left[left_p])
                left_p += 1

            else:
                sorted.append(right[right_p])
                right_p += 1

        sorted.extend(left[left_p:])
        sorted.extend(right[right_p:])

        return sorted

    def sorted_books(self, s_books):
        self.details = []
        self.details = s_books
        headings = ["Book Title", "Author Name", "Subject", "Publication Date"]
        print("-" * 158)
        print(f"| {headings[0]:^55} | {headings[1]:^30} | {headings[2]:^35} | {headings[3]:^25} |")
        print("-" * 158)
        for i in range(len(self.details)):
            print(f"| {self.details[i][0]:<55} | {self.details[i][1]:<30} | {self.details[i][2]:<35} | "
                  f"{self.details[i][3]:<25} |")
        print("-" * 158)


if __name__ == "__main__":
    em = ""
    username = ""
    cart = []
    Library = Library_Management_System()
    while True:
        print("-" * 100)
        print(f"Welcome to Classic Library {username}!!!")
        print("Here are the options : \n(1) See the Whole Collection Of Books\n(2) Register Account\n"
              "(3) Login Account\n(4) Cancel Membership\n(5) See Sorted Collection Of Books\n(6) Search the Book\n"
              "(7) Add Book\n(8) Delete Book\n(9) Modify Book\n(10) Reserve a Book\n(11) Return a Book\n"
              "(12) Renew a Book\n(13) Checkout\n(14) Exit")
        print("-" * 100)
        option = input("Enter Key : ")
        print("-" * 100)
        if option == "1":
            Library.See_Whole_Collection_Of_Books()
        elif option == "2":
            Library.Register_Account()
        elif option == "3":
            s = Library.Login_Account()
            username = s[0]
            em = s[1]
        elif option == "4":
            s1 = Library.Cancel_Membership(em)
            if s1 == "":
                username = s1
        elif option == "5":
            details = []
            f = open("List_of_books.txt", "r")
            content = f.readlines()
            for i in range(len(content)):
                displaying = list(content[i].split(","))
                details.append(displaying)
            f.close()
            Library.sorted_books(Library.Merge_sort(details))
        elif option == "6":
            Library.Search()
        elif option == "7":
            if username == "":
                print("Login first to Proceed...")
            else:
                c1 = Library.Add_Book(cart)
                cart = c1
        elif option == "8":
            if username == "":
                print("Login first to Proceed...")
            else:
                c2 = Library.Delete_Book(cart)
                cart = c2
        elif option == "9":
            if username == "":
                print("Login first to Proceed...")
            else:
                c3 = Library.Modify_Book(cart)
                cart = c3
        elif option == "10":
            if username == "":
                print("Login first to Proceed...")
            else:
                Library.Reserve_Book()
        elif option == "11":
            if username == "":
                print("Login first to Proceed...")
            else:
                Library.Return_Book()
        elif option == "12":
            if username == "":
                print("Login first to Proceed...")
            else:
                Library.Renew_Book()
        elif option == "13":
            if username == "":
                print("Login first to Proceed...")
            else:
                e = Library.Check_out_book(cart)
                if e == "end":
                    print("Thanks for visiting the Classic Library!!!")
                    break
                elif e == "not end":
                    continue
        elif option == "14":
            print("Thanks for visiting the Classic Library!!!")
            break
        
