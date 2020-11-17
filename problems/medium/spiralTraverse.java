// import java.util.*;

// class Program {
// 	// 1)  T: O(n) | S: O(n)
// 	// HACK: https://www.youtube.com/watch?v=BdQ2AkaTgOAf
//   public static List<Integer> spiralTraverse(int[][] array) {
// 		List<Integer> nums = new ArrayList<>();
		
// 		if( array == null || array.length == 0  ) {
// 			return nums;
// 		}
		
// 		int top = 0;
// 		int bottom = array.length - 1;
// 		int left = 0;
// 		int right = array[0].length - 1;
// 		int arraySize = (right + 1)* (bottom + 1);
			
// 		while( nums.size() < arraySize){

// // Input: [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// // Output: [1,2,3,4,8,12,11,10,9,5,6,7,6]
// // Expected: [1,2,3,4,8,12,11,10,9,5,6,7]
// // If  "&& nums.size() < arraySize" not added then above test case in leetcode fails
// 			for ( int i = left; i <= right && nums.size() < arraySize ; i++) {
// 				nums.add( array[top][i] );
// 			}
// 			top++;
			
// 			for ( int i = top; i <= bottom && nums.size() < arraySize; i++) {
// 				nums.add( array[i][right] );
// 			}
// 			right--;
			
// 			for ( int i = right; i >= left && nums.size() < arraySize; i--) {
// 				nums.add( array[bottom][i] );
// 			}
// 			bottom--;
			
// 			for ( int i = bottom; i >= top && nums.size() < arraySize; i--) {
// 				nums.add( array[i][left] );
// 			}
// 			left++;
			
// 		}
			
//     return nums;
//   }
// }

import java.util.*;

class Program {
	// HACK: https://leetcode.com/problems/spiral-matrix/solution/
	// 2) T: O(n) | S: O(n)
  public static List<Integer> spiralTraverse(int[][] array) {
  	
		List<Integer> nums = new ArrayList<>();
		int totalRows = array.length;
		int totalCols = array[0].length;
		int[][] visited = new int[totalRows][totalCols];
		
		int row = 0;
		int col = 0;
		
		// Right, down, left, up : This has to be in this fix direction, because of spiral nature. 
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		int currentDir = 0;
		
		for ( int i = 0; i < totalRows * totalCols; i++){
			nums.add( array[row][col] );
			visited[row][col] = 1;
			int newRow = row + dr[currentDir];
			int newCol = col + dc[currentDir];
			
			if( 0 <= newRow && newRow < totalRows && 0 <= newCol && newCol < totalCols && visited[newRow][newCol] != 1 ){
				// Everthing is safe then update row and col value with newRow and newCol respectively 
				row = newRow;
				col = newCol;
			}
			else{
				currentDir = (currentDir + 1) % 4;
				row = row + dr[currentDir];
				col = col + dc[currentDir];
			}
		}
		return nums;
  }
}

