def matrixADD_SUBT(num):
# Creating matrix 1 and 2
    for i in range(1,3):
        matrix=list()
        row=int(input('Enter number of rows for Matrix1 : '))
        column=int(input('Enter number of column for Matrix1 : '))
        print()
        for j in range(row):
            print('Enter values',column,'for row',j+1,'of the Matrix',i,'separated by commas : ',end='')
            values=input()
            lvalues=values.split(',')
            matrix.append(lvalues)
##        for i in range(row):
##            for j in range(column):
##                matrix1[i][j]=int(matrix1[i][j])
        for i in range(len(matrix)):
            matrix[i]=list(map(int, matrix[i]))
        print(matrix)



def matrixmulti(num):
    if num==3:
        if column1==row2:
            frow=row1
        fcolumn=column2
    final_matrix=list()
    for i in range(frow):
        values='0 '*column1 #this is creating a n number of 0s to make a row
        val=''
        for j in range(column1):
            val+=values                #this is creating a row in final_matrix
        lvalues=val.split()
        final_matrix.append(lvalues)
    for i in range(frow):
        for j in range(fcolumn):
            final_matrix[i][j]=int(final_matrix[i][j])
# Performing Multiplication
    for i in range(frow):
        for j in range(fcolumn):
            for k in range(row2):
                final_matrix[i][j] += matrix1[i][k] * matrix2[k][j]
    for i in range(frow):
        for j in range(fcolumn):
            print(final_matrix[i][j],end=' ')
        print()
                
print('Welcome to Matrix Calculator')
print('Press 1 for Addition')
print('Press 2 for SUBTRACTION')
print('press 3 for multiplicaton')
print()
print('Enter your choice :')
num=int(input())
if num==1:
    matrixADD_SUBT(num)
    




