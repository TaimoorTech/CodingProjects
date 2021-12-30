def creatingmatrix(row, column, n):
    matrix = list()
    print()
    for i in range(row):
        print('Enter', column, 'values for row', i + 1, 'of the Matrix', n, 'separated by commas : ', end='')
        values = input()
        lvalues = values.split(',')
        matrix.append(lvalues)
        if len(matrix[i]) > column or len(matrix[i]) < column:
            print()
            print('Kindly Enter Correct Number of Values in Matrix', n, 'row', i + 1)
            return
    return matrix  


def matrixMULT():
    print('Important Point : Make sure that for Multiplication of '
          '2 Matrices that Column of Matrix 1 and Row of Matrix 2 must be same \n')
    row1 = int(input('Enter number of rows for matrix 1 : '))
    column1 = int(input('Enter number of column for matrix 1: '))
    matrix1 = creatingmatrix(row1, column1, 1)
    while matrix1 is None:
        matrix1 = creatingmatrix(row1, column1, 1)
    print()
    row2 = int(input('Enter number of rows for matrix 2 : '))
    column2 = int(input('Enter number of column for matrix 2 : '))
    matrix2 = creatingmatrix(row2, column2, 2)
    while matrix2 is None:
        matrix2 = creatingmatrix(row2, column2, 2)
    if column1 == row2:
        f_row = row1
        f_column = column2
        final_matrix = []
        for i in range(f_row):
            lst = []
            for j in range(f_column):
                lst.append(0)
            final_matrix.append(lst)

        for i in range(f_row):
            for j in range(f_column):
                for k in range(row2):
                    final_matrix[i][j] = int(final_matrix[i][j]) + (int(matrix1[i][k]) * int(matrix2[k][j]))
        print()
        print("Matrix C : \n")
        for i in range(f_row):
            for j in range(f_column):
                print(final_matrix[i][j], end=' ')
            print()
        print()
    else:
        if column1 != row2:
            print()
            print('The order of Matrix1', '(', row1, 'x', column1, ')', 'and Matrix2', '(', row2, 'x', column2, ')',
                  'does not support Multiplication \n')
            return


matrixMULT()