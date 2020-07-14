import java.util.*;

// T: O(n) | S:O(1)
class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {

		int idx = 0;
		
		for ( int i = 0; i < array.size(); i++ ){
			if( idx > sequence.size() - 1 )
				return true;
			if( array.get(i) == sequence.get(idx) )
				idx++;
		}
		
    return idx > sequence.size() - 1 ? true: false;
  }
}
