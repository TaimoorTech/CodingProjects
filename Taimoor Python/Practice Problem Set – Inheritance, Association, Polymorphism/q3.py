class Publication:
    title = ' '
    price = 0.00

    def getdata(self):
        self.title = input("Enter the title of the publication : ")
        self.price = float(input("Enter the price of publication : "))

    def putdata(self):
        return f"The title of book is {self.title} and the price is {self.price}"


class Sales:
    def getdata(self):
        self.sales1 = float(input("Enter sales 1 :"))
        self.sales2 = float(input("Enter sales 2 :"))
        self.sales3 = float(input("Enter sales 3 :"))

    def putdata(self):
        return f"\nThe sale 1 is {self.sales1}.\nThe sale 2 is {self.sales2}.\nThe sale 3 is {self.sales3}."


class Book(Publication, Sales):
    pageCount = 0

    def getdata(self):
        Publication.getdata(self)
        Sales.getdata(self)
        self.pageCount = int(input("Enter the pages of the book : "))

    def putdata(self):
        return f"\nThe Title of Book is {self.title}.\nThe Price is Rs.{self.price}." \
               f"\nThe Pages are {self.pageCount}.\nThe sale 1 is {self.sales1}.\nThe sale 2 is {self.sales2}." \
               f"\nThe sale 3 is {self.sales3}."


class Tape(Publication, Sales):
    playingTime = 0.00

    def getdata(self):
        Publication.getdata(self)
        Sales.getdata(self)
        self.playingTime = float(input("Enter the Playing Time of the Tape : "))

    def putdata(self):
        return f"\nThe Title of Tape is {self.title}.\nThe Price is Rs.{self.price}.\nThe Playing time of the Tape " \
               f"is {self.playingTime}.\nThe sale 1 is {self.sales1}.\nThe sale 2 is {self.sales2}." \
               f"\nThe sale 3 is {self.sales3}."


# Driver Code

# The Instance of class Book
b1 = Book()
b1.getdata()
print(b1.putdata())

# The Instance of class Tape
t1 = Tape()
t1.getdata()
print(t1.putdata())

