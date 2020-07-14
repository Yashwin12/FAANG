import java.util.*;

// 1) S: O(1) | T: O(n^2)
class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
		
		for ( int i = 0; i < array.length; i++ ){
			int subtractedNumb = targetSum - array[i];
			for( int j = i+1; j < array.length; j++ ){
				if( array[j] == subtractedNumb )
					return new int[] {array[i], array[j]};
			}			
		}
    return new int[0];
  }
}


//2)  T: O(n) | S: O(n) 
class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {    
		Set<Integer> set = new HashSet<Integer>(); 
		
		for( int i = 0; i < array.length; i++ ){
			int subtractedNumb = targetSum - array[i];
			if( set.contains(subtractedNumb) ){
				return new int[] {subtractedNumb, array[i]};
			}	
			else{
				set.add(array[i]);
			}
		}
		
    return new int[0];
  }
}

// 3) T: O( log*n ) | S: O(1)
class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {

		Arrays.sort(array);
		int left = 0; 
		int right = array.length - 1;
		
		while( left < right ){
			int curentSum = array[left] + array[right];
			
			if( curentSum > targetSum )
				right--;
			else if ( curentSum < targetSum )
				left++;
			else 
				return new int[] { array[left], array[right] };			
		}
		
    return new int[0];
  }
}

