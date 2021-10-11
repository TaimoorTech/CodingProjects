class car:
    wheels=4
    miles=44
    model="Audi 9"
    year=2012
    sold_on=None
    def sales_price(self):
        if self.sold_on==None:
            return "Sale price is Rs 20 lakh \n"
        else:
            return "Sale price is 0 \n"
    def purchase_price(self):
        if self.sold_on==None:
            return "Purchase price is 0 \n"
        else:
            return "Purchase price is Rs 20 lakh \n"
ahmed=car()
print("Borrower: Ahmed", ahmed.sales_price())

jason=car()
print("Borrower: Jason",jason.purchase_price())

steyn=car()
steyn.sold_on=1
print("Borrower: Steyn",steyn.sales_price())

babar=car()
babar.sold_on=1
print("Borrower: Babar",babar.purchase_price())

sharjeel=car()
sharjeel.sold_on=1
print("Borrower: Sharjeel",sharjeel.sales_price())
print("Borrower: Sharjeel",sharjeel.purchase_price())
                                                                                                                                                                                                                                                                                                                                                               
