def matrix_ADD_SUBT_MULT(num):
    print()
    if num==1 or num==2:
        print('Make sure that while adding or subtracting two matrices, the order of both matrices must be same')
        print()
# Creating matrix 1
    matrix1=list()
    row1=int(input('Enter number of rows for Matrix1 : '))
    column1=int(input('Enter number of column for Matrix1 : '))
    print()
    for i in range(row1):
        print('Enter values',column1,'for row',i+1,'of the Matrix1, separated by commas : ',end='')
        values=input()
        lvalues=values.split(',')
        matrix1.append(lvalues)
        if len(matrix1[i])>column1 or len(matrix1[i])<column1:
            print('Kindly Enter Correct Number of Values in Matrix1,row',i)
            return
    for i in range(row1):
        for j in range(column1):
            matrix1[i][j]=int(matrix1[i][j])
    print()
# Creating matrix 2
    matrix2=list()
    row2=int(input('Enter number of rows for Matrix2 : '))
    column2=int(input('Enter number of column for Matrix2 : '))
    print()
    for i in range(row2):
        print('Enter values',column2,'for row',i+1,'of the Matrix, separated by commas : ',end='')
        values=input()
        lvalues=values.split(',')
        matrix2.append(lvalues)
        if len(matrix2[i])>column2 or len(matrix2[i])<column2:
            print('Kindly Enter Correct Number of Values in Matrix2,row',i)
            return
    for i in range(row2):
        for j in range(column2):
            matrix2[i][j]=int(matrix2[i][j])
    print()
    if num==1 or num==2:
#condition for resultant matrix for addition and subtraction
        if row1==row2 and column1==column2:
    # Creating result matrix depends on rows and column entered by the user 
            final_matrix=list()
            for i in range(row1):
                values='0 '*column1 #this is creating a n number of 0s to make a row
                val=''
                for j in range(column1):
                    val+=values                #this is creating a row in final_matrix
                lvalues=val.split()
                final_matrix.append(lvalues)
            for i in range(row1):
                for j in range(column1):
                    final_matrix[i][j]=int(final_matrix[i][j])
# PERFORMING ADDITION
            if num==1:
                for i in range(row1):
                    for j in range(column1) :
                        final_matrix[i][j]=matrix1[i][j]+matrix2[i][j]
                print()
                for i in range(row1):
                    for j in range(column1):
                        print(final_matrix[i][j],end=' ')
                    print()
                print()
# PERFORMING SUBTRACTION
            elif num==2:
                for i in range(row1):
                    for j in range(column1) :
                        final_matrix[i][j]=matrix1[i][j]-matrix2[i][j]
                print()
                for i in range(row1):
                    for j in range(column1):
                        print(final_matrix[i][j],end=' ')
                    print()
                print()
        else:
            print()
            if row1!=row2 and column1!=column2:
                print('Please Enter equal number of row and column for addition/subtraction for both matrices')
            elif row1!=row2:
                print('Please Enter equal number of rows for addition/subtraction for both matrices ')
            elif column1!=column2:
                print('Please Enter equal number of column for addition/subtraction for both matrices')
# performing multiplication
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
        else :
            if column1 != row2:
                print()
                print('The order of Matrix1','(',row1,'x',column1,')','and Matrix2','(',row2,'x',column2,')','doesnot support Multiplication')
                print()
                return
# Performing Multiplication
        for i in range(frow):
            for j in range(fcolumn):
                for k in range(row2):
                    final_matrix[i][j] += matrix1[i][k] * matrix2[k][j]
        for i in range(frow):
            for j in range(fcolumn):
                print(final_matrix[i][j],end=' ')
            print()
        print()


print('Welcome to Matrix Calculator')
print()
while True:
    print('Press 1 for ADDITION for matrices')
    print('Press 2 for SUBTRACTION for matrices ')
    print('Press 3 for MULTIPLICATION for matrices ')
    print('Press 4 for EXIT')
    print()
    num=int(input('Enter your choice : '))
    if num==4:
        print('Thanks for visiting my MATRIX CALCULATOR')
        break
    matrix_ADD_SUBT_MULT(num)
