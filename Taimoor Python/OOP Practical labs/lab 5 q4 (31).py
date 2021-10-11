class Hospital_Personal:
    def __init__(self, name, address):
        self.name = name
        self.address = address

    def print_info(self):
        print(f"Name : {self.name}\nAddress : {self.address}")


class Doctor(Hospital_Personal):
    def __init__(self, name, address, specialization):
        super().__init__(name, address)
        self.specialization = specialization

    def print_doc(self):
        super().print_info()
        print("Specialization : ", self.specialization)


class Patient(Hospital_Personal):
    def __init__(self, name, address, disease):
        super().__init__(name, address)
        self.disease = disease

    def print_patient(self):
        super().print_info()
        print("Disease : ", self.disease)


class Medical_test:
    def __init__(self, doc_name, doc_address, specialization, pat_name, pat_address, disease):
        self.d = Doctor(doc_name, doc_address, specialization)
        self.p = Patient(pat_name, pat_address, disease)

    def printing(self):
        self.d.print_doc()
        self.p.print_patient()


m = Medical_test("Ahsan", "Nazimabad", "Therapy Specialist", "Ali", "North Karachi", "Heart Disease")
m.printing()
