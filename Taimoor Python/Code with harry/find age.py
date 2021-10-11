current_date = 6
current_month = 5
current_year = 2021
days = {1: 31, 2: 28, 3: 31, 4: 30, 5: 31, 6: 30, 7: 31, 8: 31, 9: 30, 10: 31, 11: 30, 12: 31}
if current_year % 4 == 0:
    days[2] = 29
date_of_birth = input("Enter date of birth : ")
date_of_birth = date_of_birth.split("-")
birth_date = int(date_of_birth[0])
birth_month = int(date_of_birth[1])
birth_year = int(date_of_birth[2])
if birth_month < current_month:
    age_year = current_year - birth_year
    current_month -= 1
    if current_month == birth_month:
        age_month = 0
