def matrix_ADD_SUBT_MULT(num):
    if num==1 or num==2:
        print('Make sure that while adding or subtracting two matrices, the order of both matrices must be same')
# Creating matrix
        row=int(input('Enter number of rows for both Matrix : '))
        column=int(input('Enter number of column for both Matrix : '))
        print()
        for i in range(1,3):
            matrix=list()
            for j in range(row):
                print('Enter values',column,'for row',j+1,'of the Matrix',i,'separated by commas : ',end='')
                values=input()
                lvalues=values.split(',')
                matrix.append(lvalues)
                #if len(matrix[i])>column or len(matrix[i])<column:
                 #   print('Kindly Enter Correct Number of Values in Matrix1,row',i)
                  #  return
        for i in range(1,3):
            for j in range(row):
                for k in range(column):
                    matrix[j][k]=int(matrix[j][k])
        print()
        
#condition for resultant matrix for addition and subtraction
        
    # Creating result matrix depends on rows and column entered by the user 
        final_matrix=list()
        for i in range(row):
            values='0 '*column #this is creating a n number of 0s to make a row
            val=''
            for j in range(column):
                val+=values                #this is creating a row in final_matrix
            lvalues=val.split()
            final_matrix.append(lvalues)
        for i in range(row):
            for j in range(column):
               final_matrix[i][j]=int(final_matrix[i][j])
# PERFORMING ADDITION
        if num==1:
            for i in range(1,3):
                for j in range(row):
                    for k in range(column) :
                        final_matrix[j][k] += matrix[j][k]
                print()
            for i in range(row):
                    for j in range(column):
                        print(final_matrix[i][j],end=' ')
                    print()
            print()
# PERFORMING SUBTRACTION
        elif num==2:
            for i in range(1,3):
                if i==1:
                    for j in range(row):
                        for k in range(column) :
                            final_matrix[j][k] += matrix[j][k]
            for i in range(1,3):
                if i==2:
                    for j in range(row):
                        for k in range(column) :
                            final_matrix[j][k] -= matrix[j][k]
                               
                print()
            for i in range(row):
                for j in range(column):
                    print(final_matrix[i][j],end=' ')
                print()
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
