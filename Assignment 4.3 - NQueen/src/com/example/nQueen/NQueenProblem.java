package com.example.nQueen;

public class NQueenProblem {
	
	static boolean nQueen(int[][] board, int startRow, int dimensionOfMatrix){
		if(startRow == dimensionOfMatrix){
			return true;
		}
		
		for(int j = 0; j < dimensionOfMatrix; j++){
			
			if(board[startRow][j] == 0 && isSafePlace(board, startRow, j)){
				
				board[startRow][j] = 1;
				
				if(nQueen(board, startRow + 1, dimensionOfMatrix))
					return true;
				
				board[startRow][j] = 0;
				
			}
			
		}
		
		return false;
	}
	
	static boolean isSafePlace(int[][] board, int row, int col){
		
		for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
			if(board[i][j] == 1)
				return false;
		}
		
		for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++){
			if(board[i][j] == 1)
				return false;
		}
		
		for(int i = row - 1, j = col; i >= 0; i--){
			if(board[i][j] == 1)
				return false;
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][] board = new int [][] {
	              { 0,  0,  0,  0},
	              { 0,  0,  0,  0},
	              { 0,  0,  0,  0},
	              { 0,  0,  0,  0} 
				};
		
		nQueen(board , 0, 4);

		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
