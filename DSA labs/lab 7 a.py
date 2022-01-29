# A7.1
class STACK:
    def __init__(self):
        self.stack = []

    def PUSH(self, stack, TOS, MAXSTK, ITEM):
        if TOS == MAXSTK-1:
            print("OVERFLOW")
            return
        TOS = TOS + 1
        self.stack[TOS] = ITEM
        return

    # A7.2
    def POP(self, stack, TOS, ITEM):
        if TOS == -1:
            print("UNDERFLOW")
            return

        ITEM = self.stack[TOS]
        TOS = TOS - 1
        return

    def empty(self):
        if len(self.stack) == 0:
            return True
        else:
            return False

    def ClearStack(self, stack=[]):
        X = 4
        Z = 0
        Y = X + 1
        self.PUSH(self.stack, Y)
        self.PUSH(self.stack, Y+1)
        self.PUSH(self.stack, X)
        self.POP(self.stack, Y)
        X = Y + 1
        self.PUSH(self.stack, X)
        self.PUSH(self.stack, Z)
        while (self.empty()):
            self.POP(self.stack, Z)
            print(Z)

        print("X = ", X)
        print("Y = ", Y)
        print("Z = ", Z)

