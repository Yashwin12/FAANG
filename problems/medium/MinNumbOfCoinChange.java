// 1) 
// class Program {
//   public static int minNumberOfCoinsForChange(int n, int[] denoms) {
		
// 		int[] minCoins = new int[n +1];

// 		Initializing to 0, as minimum number of coins required to make zero amount is 0.
// 		minCoins[0] = 0;
// 		int max = n +1;
// 		for (int i =1; i< minCoins.length; i++ ){
// 			minCoins[i] = max;
// 		}
		
// 		for (int denom: denoms){
// 			for (int amount = 1; amount<= n; amount++){
// 				if(amount >= denom){
// 					minCoins[amount] = Math.min( minCoins[amount], minCoins[amount - denom] + 1); 
// 				}
// 			}
// 		}
//     return minCoins[n] != max? minCoins[n] : -1;
//   }
// }

// 2) By adding Integer.MAX_VALUE to an array we need to explicit check if the value is equal to infinity or not; If we dont check for it then "minCoins[amount - denom] + 1 " would be equal to Integer.MIN_VALUE
// HACK: https://stackoverflow.com/questions/9397475/why-integer-max-value-1-integer-min-value
// class Program {
//   public static int minNumberOfCoinsForChange(int n, int[] denoms) {
		
// 		int[] minCoins = new int[n +1];
// 		minCoins[0] = 0;
// 		for (int i =1; i< minCoins.length; i++ ){
// 			minCoins[i] = Integer.MAX_VALUE;
// 		}
		
// 		for (int denom: denoms){
// 			for (int amount = 1; amount<= n; amount++){
// 				if(amount >= denom){
//                     if ( minCoins[ amount - denom ] == Integer.MAX_VALUE ){
//     					minCoins[amount] = Math.min( minCoins[amount], minCoins[amount - denom] );                         
//                     }
//                     else{
//     					minCoins[amount] = Math.min( minCoins[amount], minCoins[amount - denom] + 1); 

//                     }
// 				}
// 			}
// 		}
//     return minCoins[n] != Integer.MAX_VALUE ? minCoins[n] : -1;
//   }
// }

// 3) This is implemented using 2-D matrix
// HACK: https://www.youtube.com/watch?v=Y0ZqKpToTic&t=1s 
// HACK: https://www.educative.io/edpresso/coin-change-problem-1-in-javafinding-the-minimum-number-of-coins 

import java.util.*;

class Program {
  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
		
		int[][] minWays = new int[denoms.length + 1][ n + 1];
			
			// We're initializing it to high number so that our formula works! 
			// This would Initialize every value as max. Inner statement could  be replaced by "minWays[0][col] = n + 1;"
			for( int col = 1; col <= n; col++ )
				minWays[0][col] = Integer.MAX_VALUE - 1;  
			
			// This is not required as Java initalizes array element default with 0 value. 
			// for ( int row = 1; row <= denoms.length; row++ )
			// 	minWays[row][0] = 0;  
		
		for ( int row = 1; row <= denoms.length; row++ ){
			for( int col = 1; col <= n; col++ ){
				
				if ( col >= denoms[row - 1] )	
					minWays[row][col] = Math.min( minWays[row - 1][col], 1 + minWays[row][col - denoms[row - 1]] );  		
				else
					minWays[row][col] = minWays[row - 1][col];  
				
			}				
		}
		
    return minWays[denoms.length][n] != Integer.MAX_VALUE - 1 ? minWays[denoms.length][n] :-1;
  }
}d
