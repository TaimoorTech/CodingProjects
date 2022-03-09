class Phonebook:
    def __init__(self):
        self.Records = []

    def additems(self, n, pn, e):
        self.Name = n
        self.PhoneNumbers = pn
        self.Email = e
        self.Records.append([self.Name, self.PhoneNumbers, self.Email])

    def __str__(self):
        gap = " "
        decor = "-"
        strg = ["Name", "Phone Numbers", "Email"]
        if len(self.Records) != 0:
            txt = f"{decor * 111}\n*{strg[0]:^40}*{strg[1]:^32}*{strg[2]:^35}*\n{decor * 111}"
            for i in self.Records:
                txt += f"\n*{gap * 4 + i[0]:<40}*{i[1]:^32}*{i[2]:^35}*"
            txt += f"\n{decor * 111}"
            return txt
        else:
            return "NO RECORD FOUND!"

    def sort_Phonebook(self):
        self.Records.sort()
        print("All the items are sorted by the name.")

    def search(self):
        self.field = []
        self.count = 0
        choice = input("Select from given choices :\n1)Name\n2)Phone Numbers\n3)Email\nEnter your choice : ")
        if choice == '1':
            which = input("Enter the First name or Last name  : ")
            for i in self.Records:
                if which in i[0]:
                    self.count += 1
                    self.field.append([i[0], i[1], i[2]])
            if self.count == 0:
                print("No Record Found")
            else:
                print("Search Results are : \n", self.field)

        elif choice == '2':
            which = input("Enter the part of Phone Number : ")
            for i in self.Records:
                if which in i[1]:
                    self.count += 1
                    self.field.append([i[1], i[0], i[2]])
            if self.count == 0:
                print("No Record Found")
            else:
                print("Search Results are : \n", self.field)

        elif choice == '3':
            which = input("Enter the part of Email : ")
            for i in self.Records:
                if which in i[2]:
                    self.count += 1
                    self.field.append([i[2], i[0], i[1]])
            if self.count == 0:
                print("No Record Found")
            else:
                print("Search Results are : \n", self.field)

        else:
            print("Kindly Enter Correct Choice.")


# Driver Code
p1 = Phonebook()
p1.additems("Hanzala Tariq", "0333-6985742", "hamza89756@gmail.com")
p1.additems("Ahmad Ali", "0295-5968472", "ali44784@yahoo.com")
p1.additems("Tariq Siddiqui", "0356-2568554", "tariq78896@yahoo.com")
p1.additems("Bilal Ahmad", "0356-2568974", "bilal11156@gmail.com")
print(p1)
p1.sort_Phonebook()
print(p1)
p1.search()
