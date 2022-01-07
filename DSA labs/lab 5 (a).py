def STORETRIANGULAR(A):
    i = 0
    U = []
    size_of_lst = int(0.5 * len(A) * (len(A) + 1))

    for size in range(size_of_lst):
        U.append(0)

    for j in range(len(A)):
        for k in range(j + 1):
            U[i] = A[j][k]
            i += 1

    return U


triangular_matrix = [[-4, 0, 0, 0], [65, -88, 0, 0], [-24, -41, 59, 0], [-7, -32, -14, -99]]
print("Triangular Matrix  : ", triangular_matrix)

unidimensional_array = STORETRIANGULAR(triangular_matrix)
print("After Storing Triangular Matrix into Unidimensional : ", unidimensional_array)

length = len(triangular_matrix)


def RETRIEVETRIANGULAR(U, n):
    A = []

    for i in range(n):
        new_lst = []
        for z in range(n):
            new_lst.append(0)
        A.append(new_lst)

    for j in range(n):
        for k in range(n):
            if k > j:
                A[j][k] = 0
            else:
                A[j][k] = U[int(0.5*j*(j+1)+k)]

    return A


print("Unidimensional array : ", unidimensional_array)

converted_triangular_matrix = RETRIEVETRIANGULAR(unidimensional_array, length)
print("Retrieving Triangular Matrix from Unidimensional array: ", converted_triangular_matrix)

