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
