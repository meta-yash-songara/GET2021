package com.example.SparseMatrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class SparseMatrixTest {
	
	@Test
	public void testGetTransposeFunction(){
		int[][] testMatrix = new int[][]{
				{0, 10, 0, 12},
				{0, 0, 0, 0},
				{0, 0, 5, 0},
				{15, 12, 0, 0}
		};
		SparseMatrix resMatrix = new SparseMatrix(testMatrix, 4, 4);
		SparseMatrix res = resMatrix.getTranspose();
		
		int[][] expectedResult = new int[][]{
				{0, 3, 15},
				{1, 0, 10},
				{1, 3, 12},
				{2, 2, 5},
				{3, 0, 12}
		};
		
		assertArrayEquals(expectedResult, res.getMatrix());
	}
	
	@Test
	public void testIsSymmetricFunction(){
		int[][] testMatrix = new int[][]{
				{0, 0, 3, 0, 4},
				{0, 0, 5, 7, 0},
				{0, 0, 0, 0, 0},
				{0, 2, 6, 0, 0}
		};
		SparseMatrix resMatrix = new SparseMatrix(testMatrix, 4, 4);
		boolean res = resMatrix.isSymmetric();
		
		assertEquals(false, res);
	}
	
	@Test
	public void testAddMethod(){
		
		SparseMatrix matrix1 = new SparseMatrix(new int[][]{
				{2, 1},
				{0, 1}
		}, 2, 2);
		
		SparseMatrix matrix2 = new SparseMatrix(new int[][]{
				{1, 1},
				{0, 1}
		}, 2, 2);
		
		SparseMatrix res = matrix1.addMatrix(matrix2);
		
		assertArrayEquals(new int[][]{
				{0, 0, 3},
				{0, 1, 2},
				{1, 1, 2},
		}, res.getMatrix());
		
	}
	
	@Test
	public void testMultiplyMethod(){
		
		SparseMatrix matrix1 = new SparseMatrix(new int[][]{
				{0, 10, 0, 12},
				{0, 0, 0, 0},
				{0, 0 ,5, 0},
				{15, 12, 0, 0}
		}, 4, 4);
		
		SparseMatrix matrix2 = new SparseMatrix(new int[][]{
				{0, 0, 8, 0},
				{0, 0, 0, 23},
				{0, 0, 9, 0},
				{20, 25, 0, 0}
		}, 4, 4);
		
		SparseMatrix res = matrix1.multiplyMatrix(matrix2);
		
		assertArrayEquals(new int[][]{
				{0, 0, 240},
				{0, 1, 300},
				{0, 3, 230},
				{2, 2, 45},
				{3, 2, 120},
				{3, 3, 276}
		}, res.getMatrix());
		
	}

}
