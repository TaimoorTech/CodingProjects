row=int(input('Enter number of rows for both matrices : '))
column=int(input('Enter number of column for both matrices : '))
final_matrix=list()
for i in range(row):
    values='0 ' *column     # This is creating a n number of 0s to make a row
    val=''
    val+=values  # This is creating a row in final_matrix
    lvalues=val.split()
    final_matrix.append(lvalues)
for i in range(row):
    for j in range(column):
        final_matrix[i][j]=int(final_matrix[i][j])
for i in range(row):
    for j in range(column):
        print(final_matrix[i][j],end=' ')
    print()
