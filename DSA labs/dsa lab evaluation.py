def STORE_UPPER_TRIANGULAR(A):
    U = []
    pos = 0
    size = int(0.5 * len(A) * (len(A) + 1))
    for i in range(size):
        U.append(0)
    n = len(A)
    for j in range(len(A)):
        for k in range(n):
            if j == 0:
                U[pos] = A[j][k]
                pos += 1
            else:
                gaps = abs(j - int(len(A)/2))
                if j < int(len(A)/2):
                    U[pos] = A[j][gaps+k]
                    pos += 1
                else:
                    U[pos] = A[j][gaps+k+2]
                    pos += 1
        n -= 1
    print(U)


lst = [[1, 4, 5, 6], [0, 7, 8, 9], [0, 0, 2, 3], [0, 0, 0, 1]]
STORE_UPPER_TRIANGULAR(lst)
# 1 4 5 6
# 0 7 8 9
# 0 0 2 3
# 0 0 0 1


def RETRIEVE_UPPER_TRIANGULAR(U):
    pass

