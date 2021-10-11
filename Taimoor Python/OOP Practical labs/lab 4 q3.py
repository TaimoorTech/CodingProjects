class Employee:
    def __init__(self, Employee_id, Employee_name, designation):
        self.Employee_id = Employee_id
        self.Employee_name = Employee_name
        self.Designation = designation

    def print_info(self):
        print('Employee ID : ', self.Employee_id)
        print('Name : ', self.Employee_name)
        print('Designation : ', self.Designation)


class Manager(Employee):
    manager_salary = 500000

    def __init__(self, Employee_id, Employee_name, designation):
        super().__init__(Employee_id, Employee_name, designation)

    def print_info(self):
        super().print_info()
        print("Manager Salary : ", Manager.manager_salary)


class Team_lead(Employee):
    team_leader_name = "Ahsan"
    team_project = "Assign a Database Application"

    def __init__(self, Employee_id, Employee_name, designation):
        super().__init__(Employee_id, Employee_name, designation)

    def print_info(self):
        super().print_info()
        print("Name of Leader : ", Team_lead.team_leader_name)
        print("Project of Team : ", Team_lead.team_project)


class Clerk(Employee):
    clerk_grade = 16

    def __init__(self, Employee_id, Employee_name, designation):
        super().__init__(Employee_id, Employee_name, designation)

    def print_info(self):
        super().print_info()
        print('Grade Of Clerk :', Clerk.clerk_grade)


e = Employee("000045", "Ali", "Engineer")
e.print_info()
print()
m = Manager("000055", "Bilal", "General Manager")
m.print_info()
print()
t = Team_lead("000078", "Ahmed", "Assistant Director")
t.print_info()
print()
c = Clerk("000089", "Rehmat", "Senior Clerk")
c.print_info()