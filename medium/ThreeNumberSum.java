import java.util.*;

class Program {
	// T: O(n^2) | S: O(n)
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

		List<Integer[]> list = new ArrayList<>();
		Arrays.sort(array);
	
		for ( int i = 0; i < array.length - 2; i++){
			int left = i+1;
			int right = array.length - 1;
			
			while (left < right){
				int probableSum = array[left] + array[right] + array[i];
				if( probableSum == targetSum ){
					list.add( new Integer[] {array[i], array[left], array[right]} );
					left++;
					right--;
				}
				
				else if ( probableSum < targetSum){
					left++;
				}
				else{
					right--;
				}		
			}
		}
    return list;
  }
}
