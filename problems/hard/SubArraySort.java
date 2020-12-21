import java.util.*;

// 1) T: O( n^2 ) | S: O(1)
// class Program {
//   public static int[] subarraySort(int[] array) {
		
// 		int startingIdx = Integer.MAX_VALUE;
// 		int endingIdx = Integer.MIN_VALUE;
		
// 		for( int i = 0; i < array.length - 1; i++ ){
// 			for( int j = i + 1; j < array.length; j++ ){
// 				if( array[j] >= array[i] ){
// 					continue;	
// 				}
// 				else{
// 					startingIdx = Math.min( startingIdx, i);
// 					endingIdx = Math.max( startingIdx, j);
// 				}				
// 			}			
// 		}
		
// 		if( startingIdx == Integer.MAX_VALUE )
// 			startingIdx = -1;
// 		if( endingIdx == Integer.MIN_VALUE )
// 			endingIdx = -1;
		
// 		return new int[] { startingIdx, endingIdx};
//   }
// }



import java.util.*;

// 2) T: O(n) | S: O(1)
class Program {
  public static int[] subarraySort(int[] array) {
    int minOutOfOrder = Integer.MAX_VALUE;
		int maxOutOfOrder = Integer.MIN_VALUE;
		
		for( int i = 0; i < array.length; i++ ){
			if( isOutOrder( i, array) ){
					minOutOfOrder = Math.min( minOutOfOrder, array[i]);
					maxOutOfOrder = Math.max( maxOutOfOrder, array[i]);				
			}				
		}
		
		if( minOutOfOrder == Integer.MAX_VALUE )
			return new int[] { -1, -1};
 		
		int startingIdx = 0;
		int endingIdx = array.length - 1;
		
		while( array[startingIdx] <= minOutOfOrder )
			startingIdx++;
		
		while( array[endingIdx] >= maxOutOfOrder )
			endingIdx--;
		
    return new int[] {startingIdx, endingIdx};
  }
	
	public static boolean isOutOrder( int i, int[] array ){
		if( i == 0 )
			return array[i] > array[i+1];
		
		if( i == array.length - 1)
			return array[i] < array[i -1];
		
		return array[i] > array[i+1] || array[i] < array[i -1];
	}
}
