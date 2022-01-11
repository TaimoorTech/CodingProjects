def STORE_TRIDIAGONAL(B):
    i = 0
    m = 0
    U = []
    size = 4 + 3*(len(B)-2)
    for entry in range(size):
        U.append(0)
    for j in range(len(B)):
        if j < int(len(B)/2):
            for k in range(j+2):
                U[i] = B[j][k]
                i += 1
        if j >= int(len(B)/2):
            gaps = j - int(len(B)/2)
            if j == (len(B) - 1):
                for k in range(2):
                    U[i] = B[j][gaps+k+1]
                    i += 1
            else:
                for k in range(3):
                    U[i] = B[j][gaps+k+1]
                    i += 1
    return U


lst = [[5, -7, 0, 0], [1, 4, 3, 0], [0, 9, -3, 6], [0, 0, 2, 4]]
print(STORE_TRIDIAGONAL(lst))
