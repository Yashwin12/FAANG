class Program {
// 1) T: O(n^2) | S: O(1)
//   public static int kadanesAlgorithm(int[] array) {   
// 		int possibleMax = Integer.MIN_VALUE;
// 		int[] arr = new int[2];

// 		for (int left = 0; left < array.length; left++){
// 			arr[1] = array[left];
// 			for (int right = left + 1; right < array.length; right++){

// 				arr[0] = array[right] + arr[1];
// 				possibleMax = Math.max(arr[0], Math.max( possibleMax, array[left] ) );
// 				arr[1] = arr[0];
// 			}
// 		}
// 		return possibleMax;
//   }
 
// 2) T: O(n^2) | S: O(1)
// public static int kadanesAlgorithm(int[] array) {   
// 		int possibleMax = Integer.MIN_VALUE;
// 		for (int left = 0; left < array.length; left++){
// 		  int runningWindowSum = 0;
// 			for (int right = left; right < array.length; right++){
				
// 				runningWindowSum += array[right];
// 				possibleMax = Math.max(possibleMax, runningWindowSum);

// 			}
// 		}
// 		return possibleMax;
//   }

// 3) USING DP: T: O(n) | S: O(1) 
public static int kadanesAlgorithm(int[] array) {   
		int maxEndingHere = array[0];
		int maxSoFar = array[0];
		for (int i = 1; i < array.length; i++){
		  
			maxEndingHere = Math.max( array[i], maxEndingHere + array[i] );
			maxSoFar = Math.max( maxSoFar, maxEndingHere );
			
		}
		return maxSoFar;
  }
}
