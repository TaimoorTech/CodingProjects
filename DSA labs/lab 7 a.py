# A7.1
class STACK:
    def __init__(self):
        self.stack = []
        self.TOS = 0
        self.MAXSTK = 100

    def PUSH(self, ITEM):
        if self.TOS == self.MAXSTK - 1:
            print("OVERFLOW")
            return
        self.TOS = self.TOS + 1
        self.stack.append(ITEM)
        return

    # A7.2
    def POP(self):
        if self.TOS == -1:
            print("UNDERFLOW")
            return
        self.TOS = self.TOS - 1
        self.Item = self.stack[self.TOS]
        self.stack.remove(self.Item)
        return self.Item

    def empty(self):
        if len(self.stack) == 0:
            return True
        else:
            return False

    def ClearStack(self):
        X = 4
        Z = 0
        Y = X + 1
        self.PUSH(Y)
        self.PUSH(Y+1)
        self.PUSH(X)
        self.POP(Y)
        X = Y + 1
        self.PUSH(X)
        self.PUSH(Z)
        while (self.empty()):
            self.POP(Z)
            print(Z)

        print("X = ", X)
        print("Y = ", Y)
        print("Z = ", Z)

