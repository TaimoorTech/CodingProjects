def creatingmatrix(row,column,n):
    matrix=list()
    print()
    for i in range(row):
        print('Enter values',column,'for row',i+1,'of the Matrix',n,'separated by commas : ',end='')
        values=input()
        lvalues=values.split(',')
        matrix.append(lvalues)
        if len(matrix[i])>column or len(matrix[i])<column:
           print()
           print('Kindly Enter Correct Number of Values in Matrix',n,'row',i+1)
           return # Return None value 
    for i in range(row):
        for j in range(column):
            matrix[i][j]=int(matrix[i][j])
    return matrix # Return Created Matrix
   
def matrixADDSUBT():
    print('Important Point : The order of 2 Matrices which are being Added or Subtracted must be same \n')
    row=int(input('Enter number of rows for both matrices : '))
    column=int(input('Enter number of column for both matrices : '))
    matrix1=creatingmatrix(row,column,1)
    while matrix1==None:
        matrix1=creatingmatrix(row,column,1)
    matrix2=creatingmatrix(row,column,2)
    while matrix2==None:
        matrix2=creatingmatrix(row,column,2)
# Creating result matrix depends on rows and column entered by the user 
    final_matrix=list()
    for i in range(row):
        values='0 '*column     # This is creating a n number of 0s to make a row
        val=''
        val+=values                # This is creating a row in final_matrix
        lvalues=val.split()
        final_matrix.append(lvalues)
    for i in range(row):
        for j in range(column):
            final_matrix[i][j]=int(final_matrix[i][j])
# PERFORMING ADDITION
    if num==1:
        for i in range(row):
            for j in range(column) :
                final_matrix[i][j]=matrix1[i][j]+matrix2[i][j]
        print()
        for i in range(row):
            for j in range(column):
                print(final_matrix[i][j],end=' ')
            print()
        print()
# PERFORMING SUBTRACTION
    elif num==2:
        for i in range(row):
            for j in range(column) :
                final_matrix[i][j]=matrix1[i][j]-matrix2[i][j]
        print()
        for i in range(row):
            for j in range(column):
                print(final_matrix[i][j],end=' ')
            print()
        print()    

def matrixMULT():
    print('Important Point : Make sure that for Multiplication of 2 Matrices that Column of Matrix 1 and Row of Matrix 2 \n')
    row1=int(input('Enter number of rows for matrix 1 : '))
    column1=int(input('Enter number of column for matrix 1: '))
    matrix1=creatingmatrix(row1,column1,1)
    while matrix1==None:
        matrix1=creatingmatrix(row1,column1,1)
    print()
    row2=int(input('Enter number of rows for matrix 2 : '))
    column2=int(input('Enter number of column for matrix 2 : '))
    matrix2=creatingmatrix(row2,column2,2)
    while matrix2==None:
        matrix2=creatingmatrix(row2,column2,2)
# CREATING FINAL MATRIX
    if column1==row2:
        frow=row1
        fcolumn=column2
        final_matrix=list()
        for i in range(frow):
            values='0 '*column1    # This is creating a n number of 0s to make a row
            val=''
            val+=values                # This is creating a row in final_matrix
            lvalues=val.split()
            final_matrix.append(lvalues)
        for i in range(frow):
            for j in range(fcolumn):
                final_matrix[i][j]=int(final_matrix[i][j])
    else :
        if column1 != row2:
            print()
            print('The order of Matrix1','(',row1,'x',column1,')','and Matrix2','(',row2,'x',column2,')','doesnot support Multiplication \n')
            return
# PERFORM MULTIPLICATION
    for i in range(frow):
        for j in range(fcolumn):
            for k in range(row2): # In Multiplcation, this third loop is used for multiplying order of same row element of Matrix1 with column element of Matrix2
                final_matrix[i][j] += matrix1[i][k] * matrix2[k][j]
    print()
    for i in range(frow):
        for j in range(fcolumn):
            print(final_matrix[i][j],end=' ')
        print()
    print()

print('Welcome to Matrix Calculator \n')
while True:
    print('Press 1 for ADDITION for matrices')
    print('Press 2 for SUBTRACTION for matrices')
    print('Press 3 for MULTIPLICATION for matrices')
    print('Press 4 for EXIT \n')
    num=int(input('Enter your choice : '))
    print()
    if num==4:
        print('Thanks for visiting my MATRIX CALCULATOR')
        break
    elif num==1 or num==2:
        matrixADDSUBT()
    elif num==3:
        matrixMULT()       
    else:
        print('Kindly Enter choices within 1 - 4 \n')
        
