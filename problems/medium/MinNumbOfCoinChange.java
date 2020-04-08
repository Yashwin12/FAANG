// class Program {
//   public static int minNumberOfCoinsForChange(int n, int[] denoms) {
		
// 		int[] minCoins = new int[n +1];
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

// By adding Integer.MAX_VALUE to an array we need to explicit check if the value is equal to infinity or not; If we dont check for it then "minCoins[amount - denom] + 1 " would be equal to Integer.MIN_VALUE
// HACK: https://stackoverflow.com/questions/9397475/why-integer-max-value-1-integer-min-value
class Program {
  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
		
		int[] minCoins = new int[n +1];
		minCoins[0] = 0;
		for (int i =1; i< minCoins.length; i++ ){
			minCoins[i] = Integer.MAX_VALUE;
		}
		
		for (int denom: denoms){
			for (int amount = 1; amount<= n; amount++){
				if(amount >= denom){
                    if ( minCoins[ amount - denom ] == Integer.MAX_VALUE ){
    					minCoins[amount] = Math.min( minCoins[amount], minCoins[amount - denom] );                         
                    }
                    else{
    					minCoins[amount] = Math.min( minCoins[amount], minCoins[amount - denom] + 1); 

                    }
				}
			}
		}
    return minCoins[n] != Integer.MAX_VALUE ? minCoins[n] : -1;
  }
}

