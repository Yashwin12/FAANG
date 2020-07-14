class Program {
// 	//T : O(n) | S: O(n)
//   public static int maxSubsetSumNoAdjacent(int[] array) {
// 		if ( array.length == 0){
// 			return 0;
// 		}
// 		else if ( array.length == 1 ){
// 			return array[0];
// 		}
// 		int[] maxSums = new int[array.length];
		
// 		maxSums[0] = array[0];
// 		maxSums[1] = Math.max( array[0], array[1] );
		
// 		for ( int i = 2; i < array.length; i++ ){
// 			maxSums[i] = Math.max( maxSums[i-1], maxSums[i-2] + array[i]);
// 		}
    
// 		return maxSums[array.length - 1 ];
//   }
	
	//T : O(n) | S: O(1)
  public static int maxSubsetSumNoAdjacent(int[] array) {
		if ( array.length == 0){
			return 0;
		}
		else if ( array.length == 1 ){
			return array[0];
		}
		
		int first = array[0];
		int second = Math.max( array[0], array[1] );
		
		for ( int i = 2; i < array.length; i++ ){
			int current = Math.max( second, first + array[i]);
			first = second;
			second = current;
		}
    
		return second;
  }
}
