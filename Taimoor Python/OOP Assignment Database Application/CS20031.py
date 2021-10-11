record = []


def input_records():
    same = 0
    content = load_records()
    while True:
        name = input("Enter Student name : ")
        id_card = input("Enter the Entry Test id  : ")
        for i in content:
            con = i.split(',')
            if id_card == con[1]:
                print("This ID is already in the records.")
                same = 1
                break
            else:
                same = 0
        if same == 1:
            continue
        while True:
            ssc = input("Enter SSC % : ")
            if 0 <= int(ssc) <= 100:
                break
            else:
                print("Kindly Enter % in range 0 to 100.")
                continue
        while True:
            hssc = input("Enter HSSC % : ")
            if 0 <= int(hssc) <= 100:
                break
            else:
                print("Kindly Enter % in range 0 to 100.")
                continue
        while True:
            entrymarks = input("Enter University Entry Test marks : ")
            if 0 <= int(entrymarks) <= 100:
                break
            else:
                print("Kindly Enter Entry Marks in range 0 to 100.")
                continue
        record.append([name, id_card, ssc, hssc, entrymarks])
        cont = input("Do you want to input records more?\nIf Yes press Y or y\nIf No press any button\nDo you want "
                     "to continue : ")
        if cont == 'Y' or cont == 'y':
            continue
        else:
            safe = input("Do you want to save records in file?\nIf Yes press Y or y\nIf No press any button\nDo you "
                         "want to save now : ")
            if safe == 'Y' or safe == 'y':
                empty = []
                save_records()
                return empty
            else:
                return record


def save_records():
    with open("universitydatabase.txt", "a") as f:
        for i in record:
            f.write(f"{i[0]},{i[1]},{i[2]},{i[3]},{i[4]},\n")
    print("The Records have been saved.")


def load_records():
    with open("universitydatabase.txt", "a+") as f:
        f.seek(0)
        content = f.readlines()
    return content


def display_records():
    serial = 0
    content = load_records()
    for i in content:
        serial += 1
        con = i.split(',')
        aggregate = (10 * (float(con[2])) / 100) + (40 * (float(con[3])) / 100) + (float(con[4]) / 2)
        if aggregate > 50:
            status = "Pass"
        else:
            status = "Fail"
        txt = "*{:^10}*{:<40}*{:<25}*{:^15}*{:^15}*{:^35}*{:<20}*{:^15}*"
        print(txt.format(str(serial)+')',"   "+con[0], "        "+con[1], str(round(float(con[2]),2))+" %", str(round(float(con[3]),2))+" %",
                         round(float(con[4]), 2), "        "+str(round(float(aggregate), 3)), status))

def search():
    no_of_ids = 0
    miss = 0
    print('-' * 40)
    ids = input("Enter the Student ID : ")
    content = load_records()
    for i in content:
        no_of_ids += 1
        con = i.split(",")
        if con[1] == ids:
            aggregate = (10 * (float(con[2])) / 100) + (40 * (float(con[3])) / 100) + (float(con[4]) / 2)
            if aggregate > 50:
                status = "Pass"
            else:
                status = "Fail"
            print('-' * 40)
            print("Student name : ", con[0])
            print("Student ID : ", con[1])
            print("SSC % : ", con[2]+" %")
            print("HSSC % : ", con[3]+" %")
            print("University Entry Test Marks : ", con[4])
            print("Aggregrate : ", round(aggregate, 3))
            print("Status : ", status)
        else:
            miss += 1
    if miss == no_of_ids:
        print(f"This ID No. {ids} is not in the record.")


while True:
    print('*' * 49)
    print("Welcome to National University Admission Database")
    print('*' * 49)
    print("Let us know what you want to do.\nPress :\n(1) Input Records.\n(2) Display the Records.\n"
          "(3) Save Records to file.\n(4) Search in Records.\n(5) Exit.")
    print('*' * 49)
    print("Enter your choice : ", end=" ")
    choice = input()
    if choice == '1':
        record = input_records()
    elif choice == '2':
        print("-"*184)
        text = "*{:^10}*{:^40}*{:^25}*{:^15}*{:^15}*{:^35}*{:^20}*{:^15}*"
        print(text.format("S.No", "Student Name", "Student ID", "SSC %", "HSSC %", "University Entry Test Marks",
                          "Aggregate", "Status"))
        print("-"*184)
        display_records()
        print("-"*184)
    elif choice == '3':
        save_records()
        record = []
    elif choice == '4':
        search()
    elif choice == "5":
        print("Thanks for visiting.")
        break
    else:
        print("Kindly Enter Correct choice from given choices.")
