class complex_number:
    real=0
    imaginary=0
    def representation(self,real,imaginary):
        self.real=real
        self.imaginary=imaginary
        print(f"{self.real}+{self.imaginary}i")
c1=complex_number()
c1.representation(44,55)
c2=complex_number()
c2.representation(62,31)
c3=complex_number()
c3.representation(21,53)
c4=complex_number()
c4.representation(14,35)
c5=complex_number()
c5.representation(49,45)

