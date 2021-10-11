def matrix(n):
    print('Press 1 for Addition')
    print('Press 2 for SUBTRACTION')
    print()
    print('Enter your choice :')
    num=int(input())
# Creating result matrix depends on rows entered by the user 
    final_matrix=list()
    for i in range(n):
        values='0 0 0'
        lvalues=values.split()
        final_matrix.append(lvalues)
    for i in range(n):
        for j in range(n):
            final_matrix[i][j]=int(final_matrix[i][j])
# Creating matrix 1
    matrix1=list()
    for i in range(n):
        print('Enter values for row',i+1,'of the Matrix1 separated by commas : ',end='')
        values=input()
        lvalues=values.split(',')
        matrix1.append(lvalues)
    for i in range(n):
        for j in range(n):
            matrix1[i][j]=int(matrix1[i][j])
# Creating matrix 2
    matrix2=list()
    for i in range(n):
        print('Enter values for row',i+1,'of the table, separated by commas : ',end='')
        values=input()
        lvalues=values.split(',')
        matrix2.append(lvalues)
    for i in range(n):
        for j in range(n):
            matrix2[i][j]=int(matrix2[i][j])
# PERFORMING ADDITION
    if num==1:
        for i in range(n):
            for j in range(n) :
                final_matrix[i][j]=matrix1[i][j]+matrix2[i][j]
        for i in range(n):
            for j in range(n):
                print(final_matrix[i][j],end=' ')
            print()
# PERFORMING SUBTRACTION
    elif num==2:
        for i in range(n):
            for j in range(n) :
                final_matrix[i][j]=matrix1[i][j]-matrix2[i][j]
        for i in range(n):
            for j in range(n):
                print(final_matrix[i][j],end=' ')
            print()

print('Welcome to Matrix Calculator')
num=int(input('Enter number of rows : '))
matrix(num)

