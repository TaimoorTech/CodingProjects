class bank:
    loan_taken_previously=False
    def application_for_loan(self):
        if self.loan_taken_previously==True:
            print("Loan is not granted")
        elif self.loan_taken_previously==False:
            print("Loan granted")
            self.loan_taken_previously=True
sam=bank()
sam.application_for_loan()
ali=bank()
ali.application_for_loan()
ahmed=bank()
ahmed.application_for_loan()
ahmed.application_for_loan()
assam=bank()
assam.application_for_loan()
waheed=bank()
waheed.application_for_loan()
waheed.application_for_loan()
