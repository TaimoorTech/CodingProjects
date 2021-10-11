class Publication:
    title = ' '
    price = 0.00

    def getdata(self):
        self.title = input("Enter the title of the publication : ")
        self.price = float(input("Enter the price of publication : "))

    def putdata(self):
        return f"The title of book is {self.title} and the price is {self.price}"


class Disk(Publication):
    disk = {"c": "CD", "d": "DVD"}
    disktype = ""

    def getdata(self):
        Publication.getdata(self)
        self.type = input("Press c for CD and d for DVD : ")
        if self.type == "c":
            self.disktype = self.disk.get("c")
        elif self.type == "d":
            self.disktype = self.disk.get("d")

    def putdata(self):
        return f"\nThe Title of Book is {self.title}.\nThe Price is Rs.{self.price}.\nThe Storage Device" \
               f" is {self.disktype}."


class Book(Publication):
    pageCount = 0

    def getdata(self):
        Publication.getdata(self)
        self.pageCount = int(input("Enter the pages of the book : "))

    def putdata(self):
        return f"\nThe Title of Book is {self.title}.\nThe Price is Rs.{self.price}." \
               f"\nThe Pages are {self.pageCount}.\n"


class Tape(Publication):
    playingTime = 0.00

    def getdata(self):
        Publication.getdata(self)
        self.playingTime = float(input("Enter the Playing Time of the Tape : "))

    def putdata(self):
        return f"\nThe Title of Tape is {self.title}.\nThe Price is Rs.{self.price}.\nThe Playing time of the Tape " \
               f"is {self.playingTime}.\n"


# Driver Code

# The Instance of class Book
# b1 = Book()
# b1.getdata()
# print(b1.putdata())
#
# # The Instance of class Tape
# t1 = Tape()
# t1.getdata()
# print(t1.putdata())

d = Disk()
d.getdata()
print(d.putdata())
print(d.__dict__)