def Evaluating_Postfix_Expression(stack, PostfixExpression=""):
    i = 0
    for operating in range(len(PostfixExpression)):
        if PostfixExpression[operating] != "":
            if PostfixExpression[operating].isnumeric():
                stack.PUSH(PostfixExpression[operating])
                i += 1
        if PostfixExpression[operating] == "+" or PostfixExpression[operating] == "-" or \
                PostfixExpression[operating] == "*" or PostfixExpression[operating] == "/" or PostfixExpression[
            operating] == "^":
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


def convert_infix_into_postfix(stack, infix=""):
    operator = ""
    j = 1
    infix += ")"
    postfix = ""
    stack.PUSH("(")
    for i in range(len(infix)):
        if infix[i] == "(":
            stack.PUSH(infix[i])
        elif infix[i].isnumeric() or infix[i].isalpha():
            postfix += infix[i]
        elif infix[i] == ")":
            while True:
                num = stack.POP()
                if num == "(":
                    break
                postfix += num
        elif infix[i] == "+" or infix[i] == "-" or \
                infix[i] == "*" or infix[i] == "/" or infix[i] == "^":
            if j == 2:
                postfix += operator
                j = 1
            operator = infix[i]
            j += 1
        if i == len(infix) - 1:
            postfix += operator
    return postfix


def Operator(operand_stack, operator_stack):
    ans = 0
    for i in range(len(operator_stack.stack)):
        a = operand_stack.POP()
        b = operand_stack.POP()
        c = operator_stack.POP()
        if c == "+":
            ans = int(b) + int(a)
            operand_stack.PUSH(ans)
        elif c == "-":
            ans = int(b) - int(a)
            operand_stack.PUSH(ans)
        elif c == "*":
            ans = int(b) * int(a)
            operand_stack.PUSH(ans)
        elif c == "/":
            ans = int(b) / int(a)
            operand_stack.PUSH(ans)
        elif c == "^":
            ans = int(b) ** int(a)
            operand_stack.PUSH(ans)
    return ans


def Evaluating_Infix_Expression(InfixExpression=""):
    operand_stack = STACK()
    operator_stack = STACK()
    for operating in range(len(InfixExpression)):
        if InfixExpression[operating].isnumeric():
            operand_stack.PUSH(InfixExpression[operating])
    for operating in range(len(InfixExpression)):
        if InfixExpression[operating] == "+" or InfixExpression[operating] == "-" or \
                InfixExpression[operating] == "*" or InfixExpression[operating] == "/" or InfixExpression[operating] == "^":
            operator_stack.PUSH(InfixExpression[operating])
    val = Operator(operand_stack, operator_stack)
    return val


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
        Item = self.stack[self.TOS]
        del self.stack[self.TOS]
        return Item


##stack1 = STACK()
##stack1.PUSH(4)
##stack1.PUSH(8)
##print(stack1.stack)
##stack1.POP()
##print(stack1.stack)


##postfix_stack = STACK()
##post = "11+48+-"
##print("Postfix expression evaluation : ", Evaluating_Postfix_Expression(postfix_stack, post))
#

inf = "1-2+3-4"
# inf1 = "A-B+C-D"
#
# converting_inf_to_post = STACK()
# converting_inf_to_post1 = STACK()
#
# print("Converting Infix to Postfix : ", convert_infix_into_postfix(converting_inf_to_post, inf))
# print("Converting Infix to Postfix : ", convert_infix_into_postfix(converting_inf_to_post1, inf1))


#
inf = "1-2+3-4"
Infix_stack = STACK()
print("Infix expression evaluation : ", Evaluating_Infix_Expression(inf))
