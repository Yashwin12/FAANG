// import java.util.*;

// 1) S: O(N) | T: O(N)
// class Program {

//   public int firstDuplicateValue(int[] array) {
//     Set<Integer> set = new HashSet<>();

// 		for( int ele: array ){

// 			if( set.contains(ele) )
// 				return ele;

// 			set.add(ele);			
// 		}

//     return -1;
//   }
// }

import java.util.*;

// 2) S: O(1) | T: O(N)
class Program {

    public int firstDuplicateValue(int[] array) {
        int absValue = 0;

        for (int ele : array) {
            absValue = Math.abs(ele);

            if ( array[absValue - 1] < 0)
                return absValue;

            array[absValue - 1] *= -1;
        }

        return -1;
    }
}