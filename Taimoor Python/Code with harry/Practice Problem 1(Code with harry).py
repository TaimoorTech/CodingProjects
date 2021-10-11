while True:
    number = input("Enter Age or Year of Birth : ")
    current = 2021
    if len(number) < 4:
        age = int(number)
        birth_year = current - age
        print(f"\nYou will turn 100 years old in {birth_year + 100}.")
        if 100 <= age <= 250:
            print("You seem to be the oldest person alive.")
        while True:
            find = input("\nDo you want to find out your Age up to a particular year?\n"
                         "If Yes Press Y \nIf No Press N\n")
            if find == 'Y':
                particular_year = int(input("Enter the year to which you want to find your age : "))
                if particular_year < birth_year:
                    print("\nYou cannot find age behind your Birth.")
                else:
                    print(f"\nYour age in {particular_year} is, {particular_year - birth_year}.")
            elif find == 'N':
                break
            else:
                print("\nKindly Enter Correct Choice.")
    elif len(number) == 4:
        year_of_birth = int(number)
        if year_of_birth > current:
            print("\nYou are not yet born.")
            exit()
        else:
            print(f"\nYou will turn 100 years old in {year_of_birth + 100}.")
        while True:
            find = input("\nDo you want to find out your Age up to a particular year?\n"
                         "If Yes Press Y\nIf No Press N\n")
            if find == "Y":
                particular_year = int(input("Enter the year to which you want to find your age : "))
                if particular_year < year_of_birth:
                    print("\nYou cannot find age behind your Birth.")
                else:
                    print(f"\nYour age in {particular_year} is, {particular_year - year_of_birth}.")
            elif find == 'N':
                break
            else:
                print("\nKindly Enter Correct Choice.")

    choice = input("\nDo you want to Continue or Not?\nIf Continue, Press Y\nIf Not, Press any Button\n")
    if choice == "Y":
        continue
    else:
        print("\nThanks for operating this functionality. Hope you Enjoy!")
        break
