class String(str):
    def __init__(self):
        super().__init__()

    def word_count(self, st=""):
        self += st
        self = self.split()
        for i in self:
            if ("!" <= i <= ".") or (":" <= i <= "@"):
                self.remove(i)

        if len(self) > 1:
            print(f"The words in this sentence are {len(self)}.")
        else:
            print(f"The word in this sentence is {len(self)}.")


# Driver Code
s1 = String()
s1.word_count("Islam is the Best , Peaceful and Blessing Religion in the world.")

