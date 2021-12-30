def MATMUL(A, B):
    C = []
    for i in range(len(A)):
        lst = []
        for j in range(len(B)):
            lst.append(0)
        C.append(lst)
    for i in range(len(A)):
        for j in range(len(A)):
            for k in range(len(A)):
                C[i][j] = C[i][j] + (int(A[i][k]) * int(B[k][j]))
    print("Matrix C : ")
    for i in range(len(A)):
        for j in range(len(A)):
            print(C[i][j], end=' ')
        print()
    print()


n = int(input("Enter the order of matrices : "))
matA = []
matB = []
print()
for i in range(n):
    lst = []
    num = input(f"Enter {n} numbers for row {i+1} separated by commas for matA : ")
    lst = num.split(",")
    matA.append(lst)
print()
for i in range(n):
    lst = []
    num = input(f"Enter {n} numbers for row {i+1} separated by commas for matB : ")
    lst = num.split(",")
    matB.append(lst)
print()

MATMUL(matA, matB)