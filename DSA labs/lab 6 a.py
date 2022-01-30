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


class LinkedList:

    def __init__(self, nodes):
        self.linkedL = []
        for i in range(nodes):
            self.linkedL.append(0)

    def insert(self, item, pos):
        self.cursor = 0
        index = pos
        if index < len(self.linkedL):
            self.cursor = index
            self.node = Node(item, self.cursor + 1)
            self.linkedL[self.cursor] = item

    def search(self, item):
        self.item = item
        n = 0
        while n != len(self.linkedL):
            if self.item == self.linkedL[n]:
                return n
            else:
                n += 1
        return None

    def delete(self, n):
        if len(self.linkedL) == 0:
            return None
        else:
            for i in range(len(self.linkedL)):
                if i == n:
                    del self.linkedL[i]

    def __str__(self):
        st = ""
        for i in range(len(self.linkedL)):
            if i == len(self.linkedL) - 1:
                st += f"{(self.linkedL[i], None)}"
            else:
                st += f"{(self.linkedL[i], i)}\n"
        return st


class DoubleLinkedlist:

    def __init__(self, nodes):
        self.doubleLinkedL = []
        for i in range(nodes):
            self.doubleLinkedL.append(0)

    def insert(self, item, pos):
        self.cursor = 0
        index = pos
        if index < len(self.doubleLinkedL):
            self.cursor = index
            self.node = Node(item, self.cursor + 1)
            self.doubleLinkedL[self.cursor] = item

    def search(self, item):
        self.item = item
        n = 0
        while n != len(self.doubleLinkedL):
            if self.item == self.doubleLinkedL[n]:
                return n
            else:
                n += 1
        return None

    def delete(self, n):
        if len(self.doubleLinkedL) == 0:
            return None
        else:
            for i in range(len(self.doubleLinkedL)):
                if i == n:
                    del self.doubleLinkedL[i]

    def __str__(self):
        st = ""
        for i in range(len(self.doubleLinkedL)):
            if i==0:
                st+=f"{None, self.doubleLinkedL[i], i}\n"
            elif i == len(self.doubleLinkedL) - 1:
                st += f"{(i, self.doubleLinkedL[i], None)}"
            else:
                st += f"{(i-1,self.doubleLinkedL[i], i)}\n"
        return st


l = LinkedList(6)
l.insert(14, 0)
l.insert(19, 1)
l.insert(25, 2)
l.insert(35, 3)
l.insert(20, 4)
l.insert(30, 5)
print("Single Linked list : ")
print(l)
print(l.search(25))
print("After Deletion : ")
l.delete(4)
print(l)
print()
d = DoubleLinkedlist(6)
d.insert(10, 0)
d.insert(20, 1)
d.insert(30, 2)
d.insert(40, 3)
d.insert(50, 4)
d.insert(60, 5)
print("Double Linked list : ")
print(d)
print(d.search(50))
print("After Deletion : ")
d.delete(4)
print(d)
