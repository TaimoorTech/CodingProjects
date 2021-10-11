class Engine:
    def __init__(self, engno="", dom=""):
        self.__engineNo = engno
        self.__dateOfManufacture = dom

    def set_engineNo(self, engno):
        self.__engineNo = engno

    def get_engineNo(self):
        return self.__engineNo

    def set_dateOfManufacture(self, dom):
        self.__dateOfManufacture = dom

    def get_dateOfManufacture(self):
        return self.__dateOfManufacture