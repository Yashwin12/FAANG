// class Program {
//   // T: O(row * col) | S: O(1)
// 	public static int[] searchInSortedMatrix(int[][] matrix, int target) {
// 		// Method to count total rows and columns in 2 dimensional arrays.
// 		int row = matrix.length;
// 		int col = matrix[0].length;

// 		for (int r = 0; r < row; r++){
// 			for (int c = 0; c < col; c++ ){
// 				if( matrix[r][c] == target){
// 					return new int[]{r,c};
// 				}
// 			}
// 		}
//     return new int[]{-1,-1};
//   }
// }

// 2) The search starts from "top-right" corner!
// If we stand on the top-right corner of the matrix and look diagonally, it's kind of like a BST, we can go through this matrix to find the target like how we traverse the BST.

class Program {
	// T: O(rowLen + colLen) | S: O(1) 
  public static int[] searchInSortedMatrix(int[][] matrix, int target) {
		// The below two lines are written in order to satisfy leetcode's test case [] for matrix. 
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
    	return new int[]{-1, -1};
		
		int row = 0;
		int col = matrix[row].length - 1;
		
		while ( row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length ){
			int temp = matrix[row][col];
			if(temp == target){
				return new int[]{row, col};
			}
			else if( temp < target ){
				row++;
			}
			else{
				col--;
			}
			
		}
		return new int[]{-1, -1};
  }
}


// 3) The search starts from "bottom-left" corner!
// T: O(rowLen + colLen) | S: O(1) 
// import java.util.*;

// class Program {
//   public static int[] searchInSortedMatrix(int[][] matrix, int target) {
    
// 		int row = matrix.length - 1;;
// 		int col = 0;
		
// 		while( row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length ){
// 			if( matrix[row][col] > target )
// 				row--;
// 			else if( matrix[row][col] < target )
// 				col++;
// 			else
// 				return new int[] {row, col};		
// 		}
		
//     return new int[] {-1, -1};
//   }
// }

