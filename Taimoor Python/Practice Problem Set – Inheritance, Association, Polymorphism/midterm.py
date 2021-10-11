# --------------- q2 -------------------
class Speedy:
    def __init__(self, cr=1):
        self.clockRateGHz = int(cr)

    def setNoOfCycles(self, n):
        self.noOfCycles = int(n)

    def findTime(self):
        return f"{self.noOfCycles / self.clockRateGHz} nsec"


# --------------- q3 ------------------
class Memorized:
    def __init__(self, ty="Semiconductor", size=0):
        self.type = ty
        self.sizeKB = size

    def sizeMB(self):
        self.MB = self.sizeKB / 1024
        return f"{self.MB}MB"

    def printMemory(self):
        print(f"Memory Type : {self.type}\nCapacity :\n{self.sizeKB}KB\n{self.MB}MB")


# --------------- q4 -------------------
# class Computer(Speedy, Memorized):
#     def __init__(self, cr=1, type="", size=0, man="", io=0):
#         self.manufacturer = man
#         self.noOfIOPorts = int(io)
#         Speedy.__init__(self, cr)
#         Memorized.__init__(self, type, size)
#
#     def printConfig(self):
#         print(f"Manufacturer : {self.manufacturer}\nNumber of IO ports : {self.noOfIOPorts}\nMemory :\n"
#               f"Memory type : {self.type}\nCapacity :\n{self.sizeKB}KBs\n{self.sizeMB()}\nSpeed :\n"
#               f"Takes {self.findTime()} to execute {self.noOfCycles} Cycles")


# --------------- q5 -------------------
# c = Computer(5, "RAM", 55, "Taimoor", 6)
# c.setNoOfCycles(50)
# c.printConfig()

# --------------- q6 -------------------
class Computer(Speedy):
    comp = 0
    memory_element = []

    def __init__(self, cr=1, man="", io=0):
        self.manufacturer = man
        self.noOfIOPorts = int(io)
        super().__init__(cr)
        Computer.comp += 1

    def input_elements(self):
        ch = int(input("How many times tou want to enter memory elements : "))
        for i in range(ch):
            t = input("Enter Type of Memory : ")
            s = int(input("Enter size of memory in KBs : "))
            m = Memorized(t, s)
            x = m.sizeMB()
            self.memory_element.append([m.type, m.sizeKB, x])

    def printConfig(self):
        print(f"Manufacturer : {self.manufacturer}\nNumber of IO ports : {self.noOfIOPorts}\n")
        for i in self.memory_element:
            print(f"Memory :\nMemory type : {i[0]}\nCapacity :\n{i[1]}KBs\n"
                  f"{i[2]}MBs\nSpeed :\nTakes {self.findTime()} to execute {self.noOfCycles} Cycles")

    def computer_instances(self):
        return Computer.comp

    def counting_elements(self):
        return len(self.memory_element)


# c = Computer(55, "DELL", 6)
# c.setNoOfCycles(50)
# c.input_elements()
# c.printConfig()
# print(c.counting_elements())
# print(c.computer_instances())
# print("\n")
# d = Computer(44, "ffd", 5)
# print(d.computer_instances())

# --------------- q5 -------------------
class CellPhone(Computer):
    def __init__(self, cr=1, man="", io=0, net="", br=""):
        self.network = net
        self.brand = br
        super().__init__(cr, man, io)

    def printConfig(self):
        Computer.printConfig(self)
        print(f"Network : {self.network}\nBrand : {self.brand}")


ce = CellPhone(55, "DELL", 6, "Mobilink", "Samsung")
ce.setNoOfCycles(40)
ce.input_elements()
ce.printConfig()