class Node:

    def __init__(self, item, nexts=None):
        self.item = item
        self.next = nexts

    def getItem(self):
        return self.item

    def getNext(self):
        return self.next

    def setItem(self, item):
        self.item = item

    def setNext(self, nexts):
        self.next = nexts