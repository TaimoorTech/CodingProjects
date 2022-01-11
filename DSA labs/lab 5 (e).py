def RETRIEVE_TRIDIAGONAL(U):
    B = []
    n = int((len(U)+2)/3)
    for i in range(n):
        new_lst = []
        for z in range(n):
            new_lst.append(0)
        B.append(new_lst)

    for j in range(len(B)):
        for k in range(len(B)):
            if k >= j+2 and j <= int(len(B)/2):
                B[j][k] = 0
            elif k <= j-2 and j >= int(len(B)/2):
                B[j][k] = 0
            else:
                B[j][k] = U[2*j + k]
    return B


print(RETRIEVE_TRIDIAGONAL([5, -7, 1, 4, 3, 9, -3, 6, 2, 4]))
