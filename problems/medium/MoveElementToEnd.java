import java.util.*;

class Program {
  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    // T: O(n) | S: O(1)
		int left = 0; 
		int right = array.size() - 1;
		
		while ( left < right ){
			if( array.get(right) == toMove ){
				right--;
				continue;
			}
			if( array.get(left) == toMove){
				int c = array.get(left);
				array.set(left, array.get(right));
				
				array.set(right, c );
				right--;
			}
			left++;			
		}
    return array;
  }
}
