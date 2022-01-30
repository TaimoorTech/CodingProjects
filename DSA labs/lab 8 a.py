def Evaluating_Postfix_Expression(stack, PostfixExpression=""):
    i = 0
    for operating in range(len(PostfixExpression)):
        if PostfixExpression[operating] != "":
            if PostfixExpression[operating].isnumeric():
                stack.PUSH(PostfixExpression[operating])
                i += 1
        if PostfixExpression[operating] == "+" or PostfixExpression[operating] == "-" or \
                PostfixExpression[operating] == "*" or PostfixExpression[operating] == "/" or PostfixExpression[operating] == "^":
            a = stack.POP()
            b = stack.POP()
            if PostfixExpression[operating] == "+":
                c = int(b) + int(a)
                stack.PUSH(c)
            elif PostfixExpression[operating] == "-":
                c = int(b) - int(a)
                stack.PUSH(c)
            elif PostfixExpression[operating] == "/":
                c = int(b) / int(a)
                stack.PUSH(c)
            elif PostfixExpression[operating] == "*":
                c = int(b) * int(a)
                stack.PUSH(c)
            elif PostfixExpression[operating] == "^":
                c = int(b) ** int(a)
                stack.PUSH(c)
    return c

def convert_into_postfix(stack, infix=""):
    operator = ""
    j=1
    infix += ")"
    postfix = ""
    stack.PUSH("(")
    for i in range(len(infix)):
        if infix[i] == "(":
            stack.PUSH(infix[i])
        elif infix[i].isnumeric():
            postfix+=infix[i]
        elif infix[i] == ")":
            while True:
                num = stack.POP()
                if num == "(":
                    break
                postfix+=num
        elif infix[i] == "+" or infix[i] == "-" or \
                infix[i] == "*" or infix[i] == "/" or infix[i] == "^":
            if j==2:
                postfix+=operator
                j=1
            operator = infix[i]
            j+=1
        if i == len(infix) - 1:
            postfix+=operator
    return postfix


def Evaluating_Infix_Expression(stack, InfixExpression=""):
    get_postfix = convert_into_postfix(stack, InfixExpression)
    new = STACK()
    eval_postfix = Evaluating_Postfix_Expression(new, get_postfix)
    return eval_postfix

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


stack1 = STACK()
stack1.PUSH(4)
stack1.PUSH(8)
print(stack1.stack)
stack1.POP()
print(stack1.stack)


# postfix_stack = STACK()
# post = "11+48+-"
# print("Postfix expression evaluation : ", Evaluating_Postfix_Expression(postfix_stack, post))
#
# inf = "1-2+3-1"
# converting_inf_to_post = STACK()
# print("Converting Infix to Postfix : ", convert_into_postfix(converting_inf_to_post, inf))
#
# Infix_stack = STACK()
# print("Infix expression evaluation : ", Evaluating_Infix_Expression(Infix_stack, inf))
