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

// 2) 
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
