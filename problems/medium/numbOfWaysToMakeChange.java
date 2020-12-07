// HACK: https://www.youtube.com/watch?v=DJ4a7cmjZY0&t=192s

// HACK 2: https://www.youtube.com/watch?v=PafJOaMzstY

// For folks who still don't understand the intuition behind "table[row][col - coins[row-1]" and "table[row-1][col]"

// Amount 5, with coins [1,2].
// There are 3 ways:

// [1+1+1+1+1] 
// [1+1+1+2]
// [2+2+1] 

// Can be broken down as: 

// -> With 2 ( table[row][col - coins[row-1] ):
// Deduct 2 from amount 5, then you have. sub problem which is:
// Amount 3, with coins [1,2]
    // ------> Without 2 [1+1+1] = 3. Now just add 2 to it ==> [1+1+1+2] = 5
    // ------> With 2 [2+1] = 3. Now just add 2 to it ==> [2+1+2] = 5

// -> Without 2 ( table[row-1][col] ):
// [1+1+1+1+1]

// import java.util.*;
// // 1) T: O (denoms * n); S: O(denoms * n)
// class Program {
//   public static int numberOfWaysToMakeChange(int n, int[] denoms) {
//      Matrix of (Denominations, n) (Row, Col)
//   	int[][] matrix = new int[denoms.length + 1][n + 1];
		
// 		// Below loops Initializes first col. We do not need to initialize first row to zero, as by default in java all values are initialized to 0. 
// 		for( int i = 0; i < matrix.length; i++){
// 			matrix[i][0] = 1;
//  		}
				
// 		for( int row = 1; row < matrix.length; row++ ){
// 			for( int col = 1; col < matrix[0].length; col++ ){
				
// 				if( col >= denoms[row - 1]){
// 					matrix[row][col] = matrix[row - 1][col] + matrix[row][col - denoms[row - 1]];	
// 				}
// 				else{
// 					matrix[row][col] = matrix[row - 1][col];
// 				}
				
// 			}
// 		}
		
//     return matrix[matrix.length - 1][matrix[0].length - 1];
//   }
// }


// The below method is similar to algoexperts'
// 2) T: O(denoms * n) | S: O(n); where n = target value.
class Program {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = new int[n + 1];
        ways[0] = 1;

        for (int i = 0; i < denoms.length; i++) {
            for (int amount = 0; amount < ways.length; amount++) {

                if (amount >= denoms[i]) {
                    ways[amount] += ways[amount - denoms[i]];
                }
            }
        } 
        return ways[n];
    }
}
