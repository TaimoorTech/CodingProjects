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