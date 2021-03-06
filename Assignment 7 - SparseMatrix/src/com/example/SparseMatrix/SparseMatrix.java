package com.example.SparseMatrix;

public class SparseMatrix {

	private final int SIZE = 100;

	private int matrix[][] = new int[SIZE][3];
	private int row, column;
	private int pos = 0;

	public SparseMatrix() {
	}

	public SparseMatrix(int r, int c) {
		row = r;
		column = c;
	}

	public SparseMatrix(int[][] matrix, int r, int c) {
		row = r;
		column = c;

		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				if (matrix[i][j] != 0) {
					insertElement(matrix[i][j], i, j);
				}
	}

	public void insertElement(int ele, int r, int c) {
		if(r < row && c < column){
			matrix[pos][0] = r;
			matrix[pos][1] = c;
			matrix[pos][2] = ele;
			pos++;
		}
	}

	public SparseMatrix getTranspose() {

		SparseMatrix result = new SparseMatrix(row, column);
		result.pos = pos;

		int[] count = new int[column + 1];

		for (int i = 0; i <= column; i++)
			count[i] = 0;

		for (int i = 0; i < pos; i++)
			count[matrix[i][1]]++;

		int[] position = new int[column + 1];

		position[0] = 0;

		for (int i = 1; i < column; i++)
			position[i] = position[i - 1] + count[i - 1];

		for (int i = 0; i < pos; i++) {

			int tempPos = position[matrix[i][1]]++;
			result.matrix[tempPos][0] = matrix[i][1];
			result.matrix[tempPos][1] = matrix[i][0];
			result.matrix[tempPos][2] = matrix[i][2];

		}

		return result;

	}

	public boolean isSymmetric() {

		SparseMatrix res = new SparseMatrix(row, column);
		res = getTranspose();

		for (int i = 0; i < pos; i++)
			if (matrix[i][0] != res.matrix[i][0]
					|| matrix[i][1] != res.matrix[i][1]
					|| matrix[i][2] != res.matrix[i][2])
				return false;

		return true;

	}

	public SparseMatrix addMatrix(SparseMatrix matrixToAdd) {

		SparseMatrix result = new SparseMatrix(row, column);

		int p = 0, q = 0, r = 0;

		while (p < pos && q < matrixToAdd.pos) {

			if (matrix[p][0] > matrixToAdd.matrix[q][0]
					|| matrix[p][0] == matrixToAdd.matrix[q][0]
					&& matrix[p][1] > matrixToAdd.matrix[q][1]) {

				result.insertElement(matrixToAdd.matrix[q][2],
						matrixToAdd.matrix[q][0], matrixToAdd.matrix[q][1]);
				q++;
				r++;

			} else if (matrix[p][0] < matrixToAdd.matrix[q][0]
					|| matrix[p][0] == matrixToAdd.matrix[q][0]
					&& matrix[p][1] < matrixToAdd.matrix[q][1]) {

				result.insertElement(matrix[p][2], matrix[p][0], matrix[p][1]);
				p++;
				r++;

			} else {
				int temp = matrix[p][2] + matrixToAdd.matrix[q][2];

				if (temp != 0)
					result.insertElement(temp, matrix[p][0], matrix[p][1]);

				p++;
				q++;
				r++;
			}
		}

		while (p < pos) {
			result.insertElement(matrix[p++][2], matrix[p][0], matrix[p][1]);
			r++;
		}

		while (q < matrixToAdd.pos) {
			result.insertElement(matrixToAdd.matrix[q++][2],
					matrixToAdd.matrix[q][0], matrixToAdd.matrix[q][1]);
			r++;
		}

		result.pos = r;
		
		return result;
	}

	public SparseMatrix multiplyMatrix(SparseMatrix matrixToMultiply) {

		matrixToMultiply = matrixToMultiply.getTranspose();

		int i, j;
		SparseMatrix result = new SparseMatrix(row, matrixToMultiply.row);

		for (i = 0; i < pos;) {

			System.out.println("First for loop");
			
			int r = matrix[i][0];

			for (j = 0; j < matrixToMultiply.pos;) {

				int c = matrixToMultiply.matrix[j][0];
				int sum = 0;
				
				int tempi = i;
				int tempj = j;

				while (tempi < pos 
						&& matrix[tempi][0] == r
						&& tempj < matrixToMultiply.pos
						&& matrixToMultiply.matrix[tempj][0] == c) {
					
					System.out.println("Third while loop");

					if (matrix[tempi][1] < matrixToMultiply.matrix[tempj][1]) {
						tempi++;
						System.out.println("i increamented");
					} else if (matrix[tempi][1] > matrixToMultiply.matrix[tempj][1]) {
						tempj++;
						System.out.println("j increamented");
					} else {
						sum += matrix[tempi++][2] * matrixToMultiply.matrix[tempj++][2];
						System.out.println("nothing increamented");
					}

				}
				
				if (sum != 0)
					result.insertElement(sum, r, c);
				
				while(j < matrixToMultiply.pos && matrixToMultiply.matrix[j][0] == c)
					j++;

			}
			
			while(i < pos && matrix[i][0] == r)
				i++;

		}

		return result;

	}

	public int[][] getMatrix() {
		int[][] res = new int[pos][3];

		for (int i = 0; i < pos; i++){
			System.out.println(matrix[i][0] + " " + matrix[i][1] + " " + matrix[i][2] + " ");
			for (int j = 0; j < 3; j++){
				res[i][j] = matrix[i][j];
			}
		}
		
		return res;
	}
	
	

}