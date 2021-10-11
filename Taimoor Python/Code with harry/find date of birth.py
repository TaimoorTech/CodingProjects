current_date = 7
current_month = 5
current_year = 2021
days = {1: 31, 2: 28, 3: 31, 4: 30, 5: 31, 6: 30, 7: 31, 8: 31, 9: 30, 10: 31, 11: 30, 12: 31}
if current_year % 4 == 0:
    days[2] = 29
print("Enter your age by giving the following information :- ")
given_year = int(input("Enter the years of age to this date : "))
given_month = int(input("Enter the month of age to this date : "))
given_day = int(input("Enter the days of age to this date : "))
find_date = current_date - given_day

if find_date < 0:
    current_month -= 1
    birth_date = days[current_month] + find_date
    given_month += 1
    current_month += 1
elif (find_date > 0 or find_date == 0) and (current_date < given_day or current_date == given_day):
    current_month -= 1
    birth_date = days[current_month] - find_date
    current_month += 1
    given_month += 1
elif (find_date > 0) and (current_date > given_day):
    birth_date = current_date - given_day

if (current_month < given_month) and (given_month < (current_month * 2)):
    month = given_month - current_month
    birth_month = 12 - month
    birth_year = current_year - given_year - 1
elif (current_month < given_month) and (given_month > (current_month * 2)):
    birth_month = given_month - current_month
    birth_year = current_year - given_year - 1
elif current_month == given_month:
    birth_month = 12
    birth_year = current_year - given_year - 1
elif current_month > given_month:
    birth_month = current_month - given_month
    birth_year = current_year - given_year

birth_day = {1: "January", 2: "February", 3: "March", 4: "April", 5: "May", 6: "June", 7: "July", 8: "August",
             9: "September", 10: "October", 11: "November", 12: "December"}
print(f"Your Date Of Birth is {birth_date}/{birth_day[birth_month]}/{birth_year}.")
