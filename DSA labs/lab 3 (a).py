def BIN_SEARCH(DATA, ITEM):
    BEG = 0
    END = len(DATA)-1
    MID = int((BEG+END)/2)
    while BEG <= END and DATA[MID] != ITEM:
        if ITEM < DATA[MID]:
            END = MID - 1
        else:
            BEG = MID + 1
        MID = int((BEG+END)/2)
    if DATA[MID] == ITEM:
        LOC = MID
    else:
        LOC = None
    print(LOC)


a = [44, 77, 88, 99]
BIN_SEARCH(a, 99)
