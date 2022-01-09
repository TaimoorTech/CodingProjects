import numpy as np
from scipy.sparse import csr_matrix

matrix_3x6 = [[44, -859, 0, 0, 0, 0], [77, -668, 549, 0, 0, 0], [0, -123, 46, -85, 0, 0]]

converting_into_dense_Array = np.array(matrix_3x6)
print("Matrix of (3 x 6) into Dense Array : ")
print(converting_into_dense_Array)
print()

CSR_Sparse_Representation = csr_matrix(converting_into_dense_Array)
print("CSR Sparse Representation of Dense Array : ")
print(CSR_Sparse_Representation)
print()

retrieve_dense_Array = csr_matrix.todense(CSR_Sparse_Representation)
print("Retrieving Dense Array from CSR Sparse Representation : ")
print(retrieve_dense_Array)
print()