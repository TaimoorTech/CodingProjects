class Variable:
    def __init__(self, v=0):
        self.modifyvariable = v
        print(self.modifyvariable)

v1 = Variable()
v2 = Variable(8)